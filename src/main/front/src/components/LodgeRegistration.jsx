import React, { useState } from 'react'
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

const LodgeRegistration = () => {
  const [name, setName] = useState('')
  const [register, setRegister] = useState('')

  const handleSubmit = async e => {
    e.preventDefault()
    const data = { name, register }
    try {
      await await axios.post('http://localhost:8080/api/v1/lodge', data)
      alert('Lodge registered successfully!')
    } catch (err) {
      console.error(err)
    }
  }

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
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
        Nova Loja
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
              label="Registro"
              type="number"
              value={register}
              onChange={e => setRegister(e.target.value)}
              InputLabelProps={{
                shrink: true
              }}
            />
          </Grid>
        </Grid>
      </Box>
      <Box sx={{ p: 2 }}>
        <Button variant="contained" onClick={handleSubmit}>
          Registrar
        </Button>
      </Box>
    </Container>
  )
}

export default LodgeRegistration
