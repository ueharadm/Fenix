import { Typography, Button } from '@mui/material'
import { Container } from '@mui/system'
import { useNavigate } from 'react-router-dom'

function HomePage() {
  let navigate = useNavigate()

  const handleLodgeRegistration = () => {
    navigate('/lodge')
  }
  const handleMemberRegistration = () => {
    navigate('/member')
  }
  const handleMembers = () => {
    navigate('/members')
  }

  const handleMeetingRegistration = () => {
    navigate('/meeting')
  }

  const handleAttendanceRequest = () => {
    navigate('/attendance')
  }

  return (
    <Container>
      <Typography variant='h1' sx={{my: 4, textAlign: "center", color: "primary.main"}}>
      Controle de presença
      </Typography>
      <Container sx={{display: "flex", flexDirection: "column", width: "25rem", gap: 2 }}>
        
      <Button variant="contained" onClick={handleLodgeRegistration}>
          Cadastrar Loja
        </Button>
        <Button variant="contained" onClick={handleMemberRegistration}>
          Cadastrar Membro
        </Button>
        <Button variant="contained" onClick={handleMeetingRegistration}>
          Cadastrar Reunião
        </Button>
        <Button variant="contained" onClick={handleAttendanceRequest}>
          Calcular Presenças
        </Button>
        <Button variant="contained" onClick={handleMembers}>
          Membros
        </Button>
      </Container>
    </Container>
  )
}

export default HomePage
