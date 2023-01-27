import React, { useState, useEffect } from 'react'
import axios from 'axios'
import IconButton from '@mui/material/IconButton'
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew'
import { useNavigate } from 'react-router-dom'
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Container,
  Typography
} from '@mui/material'

function Lodges() {
  const [lodges, setLodges] = useState([])

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
  }

  useEffect(() => {
    async function fetchLodges() {
      try {
        const response = await axios.get('http://localhost:8080/api/v1/lodge')
        setLodges(response.data)
      } catch (error) {
        console.log(error)
      }
    }
    fetchLodges()
  }, [])

  return (
    <Container>
      <IconButton sx={{ margin: '1px solid' }} onClick={handleHomePage}>
        <ArrowBackIosNewIcon />
      </IconButton>
      <Typography
        variant="h1"
        sx={{ my: 4, textAlign: 'center', color: 'primary.main' }}
      >
        Lojas
      </Typography>

      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Id</TableCell>
              <TableCell>Nome</TableCell>
              <TableCell>Registro</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {lodges.map(lodge => (
              <TableRow
                key={lodge.name}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell>{lodge.id}</TableCell>
                <TableCell>{lodge.name}</TableCell>
                <TableCell>{lodge.register}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Container>
  )
}

export default Lodges
