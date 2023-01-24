import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'
import Members from './Member/Members'

function MemberRegistration() {
  const [name, setName] = useState('')
  const [registration, setRegistration] = useState('')
  const [degree, setDegree] = useState('')
  const [lodge, setLodge] = useState('')
  const [lodgeId, setLodgeId] = useState('')
  const [birthDate, setBirthDate] = useState('')
  const [initiationDate, setInitiationDate] = useState('')
  const [lodges, setLodges] = useState([])

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
  }

  useEffect(() => {
    async function fetchLodges() {
      axios
        .get('http://localhost:8080/api/v1/lodge')
        .then(function (response) {
          setLodges(response.data)
        })
        .catch(function (error) {
          console.log(error)
        })
    }
    fetchLodges()
  }, [])

  const handleSubmit = event => {
    event.preventDefault()
    const data = {
      name: name,
      registration: registration,
      degree: degree,
      lodgeId: lodgeId,
      birthDate: birthDate,
      initiationDate: initiationDate
    }
    fetch('http://localhost:8080/api/v1/member', {
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
          Novo membro:
        </h1>
        <label>Nome completo:</label>
        <input
          type="text"
          value={name}
          onChange={e => setName(e.target.value)}
        />
        <label>Matricula:</label>
        <input
          type="text"
          value={registration}
          onChange={e => setRegistration(e.target.value)}
        />
        <label>Grau:</label>
        <select value={degree} onChange={e => setDegree(e.target.value)}>
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
        <label>Loja:</label>
        <select value={lodgeId} onChange={e => setLodgeId(e.target.value)}>
          {lodges.length === 0 ? (
            <option>Sem Loja cadastrada</option>
          ) : (
            lodges.map(lodge => (
              <option key={lodge.id} value={lodge.id}>
                {lodge.name}
              </option>
            ))
          )}
        </select>
        <label>Data de nascimento:</label>
        <input
          type="date"
          value={birthDate}
          onChange={e => setBirthDate(e.target.value)}
        />
        <label>Data de iniciação:</label>
        <input
          type="date"
          value={initiationDate}
          onChange={e => setInitiationDate(e.target.value)}
        />
        <br />
        <button type="submit">Submit</button>
      </form>
      <br />
    </div>
  )
}

export default MemberRegistration
/*
<select value={lodge} onChange={e => setLodge(e.target.value)}>
                <option>ImplementarGetLodge</option>
                <option>Loja 01</option>
                <option>Loja 02</option>
                <option>Loja 03</option>
            </select>*/
