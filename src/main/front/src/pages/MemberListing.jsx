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

function Members() {
  const [members, setMembers] = useState([])

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
  }

  useEffect(() => {
    async function fetchMembers() {
      try {
        const response = await axios.get('http://localhost:8080/api/v1/member')
        setMembers(response.data)
      } catch (error) {
        console.log(error)
      }
    }
    fetchMembers()
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
        Membros
      </Typography>

      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Id</TableCell>
              <TableCell>Nome</TableCell>
              <TableCell>Loja</TableCell>
              <TableCell>Matrícula</TableCell>
              <TableCell>Grau</TableCell>
              <TableCell>Regra de cálculo</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {members.map(member => (
              <TableRow
                key={member.name}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell>{member.id ?? ''}</TableCell>
                <TableCell>{member.name ?? ''}</TableCell>
                <TableCell>{member.lodge.id ?? ''}</TableCell>
                <TableCell>{member.registration ?? ''}</TableCell>
                <TableCell>{member.degree ?? ''}</TableCell>
                <TableCell>{member.attendanceRule ?? ''}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Container>
  )
}

export default Members
