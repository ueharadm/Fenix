import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import { Box, Container, Typography } from '@mui/material'
import { DataGrid } from '@mui/x-data-grid'

function Members() {
  const [members, setMembers] = useState([])

  let navigate = useNavigate()

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

  const columns = [
    { field: 'id', headerName: 'ID', width: 90 },
    {
      field: 'name',
      headerName: 'Nome',
      width: 400
    },
    {
      field: 'lodge.id',
      headerName: 'Loja',
      type: 'number',
      width: 100,
      valueGetter: params => (params.row.lodge ? params.row.lodge.id : '')
    },
    {
      field: 'registration',
      headerName: 'Matrícula',
      type: 'number',
      width: 150
    },
    {
      field: 'degree',
      headerName: 'Grau',
      width: 140
    },
    {
      field: 'attendanceRule',
      headerName: 'Regra de cálculo',
      width: 130
    }
  ]

  return (
    <Container>
      <Typography
        variant="h1"
        sx={{ my: 4, textAlign: 'center', color: 'primary.main' }}
      >
        Membros
      </Typography>

      <Box sx={{ height: '40rem', width: '100%' }}>
        <DataGrid
          rows={members}
          columns={columns}
          pageSize={10}
          rowsPerPageOptions={[20]}
          checkboxSelection
        />
      </Box>
    </Container>
  )
}

export default Members
