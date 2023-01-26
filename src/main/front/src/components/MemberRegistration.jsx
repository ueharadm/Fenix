import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew'
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Container,
  Typography,
  IconButton,
  TextField,
  Box,
  MenuItem,
  Button,
  Grid
} from '@mui/material'

function MemberRegistration() {
  const [name, setName] = useState('')
  const [registration, setRegistration] = useState('')
  const [degree, setDegree] = useState('')
  const [lodge, setLodge] = useState('')
  const [lodgeId, setLodgeId] = useState('')
  const [birthDate, setBirthDate] = useState('')
  const [initiationDate, setInitiationDate] = useState('')
  const [lodges, setLodges] = useState([])

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
  }

  const degrees = [
    {
      value: 'APRENDIZ',
      label: 'APRENDIZ'
    },
    {
      value: 'COMPANHEIRO',
      label: 'COMPANHEIRO'
    },
    {
      value: 'MESTRE',
      label: 'MESTRE'
    }
  ]

  useEffect(() => {
    async function fetchLodges() {
      axios
        .get('http://localhost:8080/api/v1/lodge')
        .then(function (response) {
          setLodges(response.data)
        })
        .catch(function (error) {
          console.log(error)
        })
    }
    fetchLodges()
  }, [])

  const handleSubmit = event => {
    event.preventDefault()
    const data = {
      name: name,
      registration: registration,
      degree: degree,
      lodgeId: lodgeId,
      birthDate: birthDate,
      initiationDate: initiationDate
    }
    fetch('http://localhost:8080/api/v1/member', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data)
      })
      .catch(error => {
        console.error('Error:', error)
      })
  }

  return (
    <Container maxWidth="lg">
      <IconButton sx={{ margin: '1px solid' }} onClick={handleHomePage}>
        <ArrowBackIosNewIcon />
      </IconButton>
      <Typography
        variant="h1"
        sx={{ my: 4, textAlign: 'center', color: 'primary.main' }}
      >
        Novo membro
      </Typography>
      <Box
        component="form"
        sx={{
          '& .MuiTextField-root': { m: 1, width: '25ch' }
        }}
        noValidate
        autoComplete="off"
      >
        <Grid container rowSpacing={3} columnSpacing={{ xs: 6, sm: 2, md: 3 }}>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField required id="outlined-required" label="Nome" />
          </Grid>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-number"
              label="Matrícula"
              type="number"
              InputLabelProps={{
                shrink: true
              }}
            />
          </Grid>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-select-currency"
              select
              label="Grau"
              defaultValue="APRENDIZ"
            >
              {degrees.map(option => (
                <MenuItem key={option.value} value={option.value}>
                  {option.label}
                </MenuItem>
              ))}
            </TextField>
          </Grid>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField id="outlined-select-currency" select label="Loja">
              {lodges.map(lodge => (
                <MenuItem key={lodge.value} value={lodge.value}>
                  {lodge.label}
                </MenuItem>
              ))}
            </TextField>
          </Grid>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-birth-date"
              label="Data de nascimento"
              type="date"
              InputLabelProps={{
                shrink: true
              }}
            />
          </Grid>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-initiation-date"
              label="Data de iniciação"
              type="date"
              InputLabelProps={{
                shrink: true
              }}
            />
          </Grid>
        </Grid>
      </Box>

      <Box
        component="form"
        sx={{
          '& .MuiTextField-root': { m: 1, width: '25ch' },
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center'
        }}
        noValidate
        autoComplete="off"
      ></Box>
      <Box sx={{p: 2}}>
        <Button variant="contained" onClick={handleSubmit}>
          Registrar
        </Button>
      </Box>

      <div style={{ height: '400px' }}></div>

      <TextField id="outlined-basic" label="Outlined" variant="outlined" />
      <TextField id="filled-basic" label="Filled" variant="filled" />
      <TextField id="standard-basic" label="Standard" variant="standard" />
      <form onSubmit={handleSubmit}>
        <label>Nome completo:</label>
        <input
          type="text"
          value={name}
          onChange={e => setName(e.target.value)}
        />
        <label>Matricula:</label>
        <input
          type="text"
          value={registration}
          onChange={e => setRegistration(e.target.value)}
        />
        <label>Grau:</label>
        <select value={degree} onChange={e => setDegree(e.target.value)}>
          <option key={1} value={'APRENDIZ'}>
            Aprendiz
          </option>
          <option key={2} value={'COMPANHEIRO'}>
            Companheiro
          </option>
          <option key={3} value={'MESTRE'}>
            Mestre
          </option>
        </select>
        <label>Loja:</label>
        <select value={lodgeId} onChange={e => setLodgeId(e.target.value)}>
          {lodges.length === 0 ? (
            <option>Sem Loja cadastrada</option>
          ) : (
            lodges.map(lodge => (
              <option key={lodge.id} value={lodge.id}>
                {lodge.name}
              </option>
            ))
          )}
        </select>
        <label>Data de nascimento:</label>
        <input
          type="date"
          value={birthDate}
          onChange={e => setBirthDate(e.target.value)}
        />
        <label>Data de iniciação:</label>
        <input
          type="date"
          value={initiationDate}
          onChange={e => setInitiationDate(e.target.value)}
        />
        <br />
        <button type="submit">Submit</button>
      </form>
      <br />
    </Container>
  )
}

export default MemberRegistration
