import React, { useState, useEffect } from 'react'
import axios from 'axios'
import IconButton from '@mui/material/IconButton'
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew'
import { useNavigate } from 'react-router-dom'
import { Box, Container, Typography } from '@mui/material'
import { DataGrid, GridEventListener } from '@mui/x-data-grid'

function Meetings() {
  const [meetings, setMeetings] = useState([])

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
  }

  const handleDoubleClick = params => {
    navigate('/meeting/' + params.row.id)
  }

  useEffect(() => {
    async function fetchMeetings() {
      try {
        const response = await axios.get('api/v1/meeting')
        setMeetings(response.data)
      } catch (error) {
        console.log(error)
      }
    }
    fetchMeetings()
  }, [])

  const columns = [
    { field: 'id', headerName: 'ID', width: 50 },
    {
      field: 'number',
      headerName: 'Numero',
      width: 100
    },
    {
      field: 'worshipfulMaster.name',
      headerName: 'Venerável',
      type: 'number',
      width: 400,
      valueGetter: params =>
        params.row.worshipfulMaster ? params.row.worshipfulMaster.name : ''
    },
    {
      field: 'type',
      headerName: 'Tipo',
      width: 150
    },
    {
      field: 'date',
      headerName: 'Data',
      width: 140
    },
    {
      field: 'attendees.lenght',
      headerName: 'Presentes',
      width: 130,
      valueGetter: params =>
        params.row.attendees ? params.row.attendees.length : ''
    }
  ]

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

      <Box sx={{ height: '40rem', width: '100%' }}>
        <DataGrid
          onRowDoubleClick={handleDoubleClick}
          rows={meetings}
          columns={columns}
          pageSize={10}
          checkboxSelection
          disableSelectionOnClick
        />
      </Box>
    </Container>
  )
}

export default Meetings
