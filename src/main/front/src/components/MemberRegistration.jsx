import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew'
import {
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
  const [attendanceRule, setAttandanceRule] = useState('')
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

  const rules = [
    {
      value: 'GERAL',
      label: 'GERAL'
    },
    {
      value: 'REMIDO',
      label: 'REMIDO'
    },
    {
      value: 'OFICIAL',
      label: 'OFICIAL'
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
      initiationDate: initiationDate,
      attendanceRule: attendanceRule
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
        onSubmit={handleSubmit}
      >
        <Grid container rowSpacing={3} columnSpacing={{ xs: 6, sm: 2, md: 3 }}>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              required
              id="outlined-required"
              label="Nome"
              value={name}
              onChange={e => setName(e.target.value)}
            />
          </Grid>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-number"
              label="Matrícula"
              type="number"
              value={registration}
              onChange={e => setRegistration(e.target.value)}
              InputLabelProps={{
                shrink: true
              }}
            />
          </Grid>

          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-select-degree"
              select
              label="Grau"
              defaultValue="APRENDIZ"
              onChange={e => setDegree(e.target.value)}
            >
              {degrees.map(degree => (
                <MenuItem key={degree.value} value={degree.value}>
                  {degree.label}
                </MenuItem>
              ))}
            </TextField>
          </Grid>

          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-select-lodge"
              select
              label="Loja"
              defaultValue="1"
              onChange={e => setLodgeId(e.target.value)}
            >
              {lodges.map(lodge => (
                <MenuItem key={lodge.id} value={lodge.id}>
                  {lodge.name}
                </MenuItem>
              ))}
            </TextField>
          </Grid>

          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-birth-date"
              label="Data de nascimento"
              type="date"
              value={birthDate}
              onChange={e => setBirthDate(e.target.value)}
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
              value={initiationDate}
              onChange={e => setInitiationDate(e.target.value)}
              InputLabelProps={{
                shrink: true
              }}
            />
          </Grid>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-select-rule"
              select
              label="Regra de cálculo"
              defaultValue="GERAL"
              onChange={e => setAttandanceRule(e.target.value)}
            >
              {rules.map(rule => (
                <MenuItem key={rule.value} value={rule.value}>
                  {rule.label}
                </MenuItem>
              ))}
            </TextField>
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
      <Box sx={{ p: 2 }}>
        <Button variant="contained" onClick={handleSubmit}>
          Registrar
        </Button>
      </Box>
    </Container>
  )
}

export default MemberRegistration
