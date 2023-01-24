import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

function MeetingRegistration() {
  const [number, setNumber] = useState('')
  const [worshipfulMasterId, setWorshipfulMasterId] = useState('')
  const [type, setType] = useState('')
  const [date, setDate] = useState('')
  const [attendees, setAttendees] = useState([])

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
  }

  const handleSubmit = event => {
    event.preventDefault()
    const data = {
      number: number,
      worshipfulMasterId: worshipfulMasterId,
      type: type,
      date: date,
      attendees: attendees
    }
    fetch('http://localhost:8080/api/v1/meeting', {
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
    <div
      style={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyItems: 'center',
        alignContent: 'center',
        gap: '1px',
        alignSelf: 'center',
        textAlign: 'start',
        minHeight: '200px'
      }}
    >
      <form
        style={{
          display: 'flex',
          flexDirection: 'column',
          padding: '5px',
          border: '2px solid black',
          borderRadius: '10px'
        }}
        onSubmit={handleSubmit}
      >
        <h1 style={{ marginTop: '0px', marginBottom: '5px' }}>
          <button
            onClick={handleHomePage}
            style={{
              display: 'flex',
              maxWidth: '30px',
              maxHeight: '30px',
              border: '1px solid #9A9595',
              opacity: '1',
              boxShadow: '3px 3px 2px black',
              borderRadius: '30px',
              minHeight: '30px',
              minWidth: '30px',
              justifyContent: 'center',
              alignContent: 'center',
              alignItems: 'center'
            }}
          >
            &lt;
          </button>
          Nova Reunião:
        </h1>
        <label>Número:</label>
        <input
          type="text"
          value={number}
          onChange={e => setNumber(e.target.value)}
        />
        <label>Id do Venerável Mestre:</label>
        <input
          type="text"
          value={worshipfulMasterId}
          onChange={e => setWorshipfulMasterId(e.target.value)}
        />
        <label>Tipo:</label>
        <select value={type} onChange={e => setType(e.target.value)}>
          <option key={1} value={'APRENDIZ'}>
            Aprendiz
          </option>
          <option key={2} value={'COMPANHEIRO'}>
            Companheiro
          </option>
          <option key={3} value={'MESTRE'}>
            Mestre
          </option>
        </select>
        <label>Data:</label>
        <input
          type="date"
          value={date}
          onChange={e => setDate(e.target.value)}
        />
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  )
}

export default MeetingRegistration
