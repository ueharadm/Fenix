import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew'
import { useParams } from 'react-router-dom'
import { Container, Typography, Box, Button, IconButton } from '@mui/material'
import { DataGrid } from '@mui/x-data-grid'
import TextField from '@mui/material/TextField'
import Autocomplete from '@mui/material/Autocomplete'
import DeleteIcon from '@mui/icons-material/Delete'
import fileDownload from 'js-file-download'

function MeetingManager() {
  const [meeting, setMeeting] = useState({})
  const [members, setMembers] = useState([])
  const [memberId, setMemberId] = useState('')
  const { number } = useParams()
  let navigate = useNavigate()
  axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*'

  const handleMeetingPage = () => {
    navigate('/meeting')
  }

  useEffect(() => {
    async function fetchMeeting() {
      try {
        const response = await axios.get(
          `../api/v1/meeting/${number}`
        )
        setMeeting(response.data)
      } catch (error) {
        console.error(error)
      }
    }
    fetchMeeting()
  }, [number])

  useEffect(() => {
    async function fetchMembers() {
      try {
        const response = await axios.get('../api/v1/member')
        setMembers(response.data)
      } catch (error) {
        console.log(error)
      }
    }
    fetchMembers()
  }, [])

  const options = members.map(member => ({
    label: member.name,
    id: member.id
  }))

  const [selectedOption, setSelectedOption] = React.useState(null)

  const handleChange = (event, value) => {
    setMemberId(value.id)
  }

  async function checkInMembers(memberIds) {
    try {
      const response = await axios.put(
        `../api/v1/meeting/checkIn/${number}`,
        {
          memberIds
        }
      )
      window.location.reload()
      console.log(response.data)
    } catch (error) {
      console.error(error)
    }
  }

  async function checkOutMember(memberIds) {
    try {
      const response = await axios.put(
        `../api/v1/meeting/checkOut/${number}`,
        {
          memberIds
        }
      )
      window.location.reload()
      console.log(response.data)
    } catch (error) {
      console.error(error)
    }
  }

  async function generateReport() {
    try {
      const response = await axios({
        method: 'get',
        url: `../api/v1/meeting/print/${number}`,
        responseType: 'blob'
      })
      fileDownload(response.data, 'TestMeeting' + number + '.xlsx')
      alert('Relatório gerado com sucesso!')
    } catch (error) {
      console.error(error)
    }
  }

  const renderDetailsButton = params => {
    return (
      <strong>
        <IconButton
          aria-label="delete"
          onClick={() => {
            checkOutMember([params.id])
          }}
        >
          <DeleteIcon />
        </IconButton>
      </strong>
    )
  }

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
    },
    {
      field: 'action',
      headerName: '',
      width: 50,
      renderCell: params => renderDetailsButton(params),
      disableClickEventBubbling: true
    }
  ]

  return (
    <Container>
      <IconButton sx={{ margin: '1px solid' }} onClick={handleMeetingPage}>
        <ArrowBackIosNewIcon />
      </IconButton>
      <Box>
        <Box sx={{ justifyContent: 'center' }}>
          <h1>Reunião {meeting.number}</h1>

          <Button variant="contained" onClick={() => generateReport()}>
            Gerar relatório
          </Button>
        </Box>

        {meeting.worshipfulMaster ? (
          <h2>Venerável Mestre: {meeting.worshipfulMaster.name}</h2>
        ) : (
          <h2>Venerável Mestre:</h2>
        )}
        <h2>Data: {meeting.date}</h2>
      </Box>

      <Autocomplete
        disablePortal
        id="combo-box-demo"
        options={options}
        value={selectedOption}
        sx={{ width: 300, pb: 2 }}
        onChange={handleChange}
        renderInput={params => <TextField {...params} label="Membro" />}
      />

      <Button variant="contained" onClick={() => checkInMembers([memberId])}>
        Check-in
      </Button>
      <Typography
        variant="h1"
        sx={{ my: 4, textAlign: 'center', color: 'primary.main' }}
      >
        Presentes
      </Typography>

      <Box sx={{ height: '40rem', width: '100%' }}>
        <DataGrid
          rows={meeting.attendees ? meeting.attendees : ''}
          columns={columns}
          pageSize={10}
          rowsPerPageOptions={[20]}
          disableSelectionOnClick
          checkboxSelection
          initialState={{
            sorting: {
              sortModel: [{ field: 'name', sort: 'asc' }]
            }
          }}
        />
      </Box>
    </Container>
  )
}

export default MeetingManager
