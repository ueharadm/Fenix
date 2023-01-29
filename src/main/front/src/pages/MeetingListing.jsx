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

function Meetings() {
  const [meetings, setMeetings] = useState([])

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
  }

  useEffect(() => {
    async function fetchMeetings() {
      try {
        const response = await axios.get('http://localhost:8080/api/v1/meeting')
        setMeetings(response.data)
      } catch (error) {
        console.log(error)
      }
    }
    fetchMeetings()
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
        Reuniões
      </Typography>

      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Id</TableCell>
              <TableCell>Número</TableCell>
              <TableCell>Venerável</TableCell>
              <TableCell>Tipo</TableCell>
              <TableCell>Data</TableCell>
              <TableCell>Presentes</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {meetings.map(meeting => (
              <TableRow
                key={meeting.name}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell>{meeting.id ?? ''}</TableCell>
                <TableCell>{meeting.number ?? ''}</TableCell>
                <TableCell>{meeting.worshipfulMaster.name ?? ''}</TableCell>
                <TableCell>{meeting.type ?? ''}</TableCell>
                <TableCell>{meeting.date ?? ''}</TableCell>
                <TableCell>{meeting.attendees.length ?? ''}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Container>
  )
}

export default Meetings
