import React, { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const AttendanceReports = () => {
  const [memberId, setMemberId] = useState('')
  const [initDate, setInitDate] = useState('')
  const [finalDate, setFinalDate] = useState('')
  const [rule, setRule] = useState('GENERAL')

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
  }

  const handleSubmit = async e => {
    e.preventDefault()
    const data = { memberId, initDate, finalDate, rule }
    try {
      await axios.post(
        'api/v1/attendance/completeReport',
        data
      )
      alert('Report created successfully!')
    } catch (err) {
      console.error(err)
    }
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
          Novo membro:
        </h1>
        <label>
          Member ID:
          <input
            type="text"
            value={memberId}
            onChange={e => setMemberId(e.target.value)}
          />
        </label>
        <br />
        <label>
          Initial Date:
          <input
            type="date"
            value={initDate}
            onChange={e => setInitDate(e.target.value)}
          />
        </label>
        <br />
        <label>
          Final Date:
          <input
            type="date"
            value={finalDate}
            onChange={e => setFinalDate(e.target.value)}
          />
        </label>
        <br />
        <label>
          Rule:
          <select value={rule} onChange={e => setRule(e.target.value)}>
            <option value="GENERAL">Geral</option>
            <option value="REDEEMED">Remido</option>
            <option value="OFFICER">Oficial</option>
          </select>
        </label>
        <br />
        <button type="submit">Gerar relatório completo</button>
      </form>
    </div>
  )
}

export default AttendanceReports
