import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
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
import Meetings from './MeetingListing'

function MeetingRegistration() {
  const [number, setNumber] = useState('')
  const [worshipfulMasterId, setWorshipfulMasterId] = useState('')
  const [type, setType] = useState('APRENDIZ')
  const [date, setDate] = useState('')
  const [attendees, setAttendees] = useState([])

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
  }

  const types = [
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
  const handleSubmit = event => {
    event.preventDefault()
    const data = {
      number: number,
      worshipfulMasterId: worshipfulMasterId,
      type: type,
      date: date,
      attendees: attendees
    }
    fetch('api/v1/meeting', {
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
        Nova reunião
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
              label="Número"
              type="number"
              value={number}
              onChange={e => setNumber(e.target.value)}
            />
          </Grid>
          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-number"
              label="Id. do Venerável"
              type="number"
              value={worshipfulMasterId}
              onChange={e => setWorshipfulMasterId(e.target.value)}
              InputLabelProps={{
                shrink: true
              }}
            />
          </Grid>

          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-select-degree"
              select
              label="Tipo"
              defaultValue="APRENDIZ"
              onChange={e => setType(e.target.value)}
            >
              {types.map(type => (
                <MenuItem key={type.value} value={type.value}>
                  {type.label}
                </MenuItem>
              ))}
            </TextField>
          </Grid>

          <Grid item xs={12} sm={6} md={4} lg={3}>
            <TextField
              id="outlined-birth-date"
              label="Data da reunião"
              type="date"
              value={date}
              onChange={e => setDate(e.target.value)}
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
      <Box sx={{ p: 2 }}>
        <Button variant="contained" onClick={handleSubmit}>
          Registrar
        </Button>
      </Box>
      <Meetings />
    </Container>
  )
}

export default MeetingRegistration
