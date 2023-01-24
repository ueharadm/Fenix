import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

const LodgeRegistration = () => {
  const [name, setName] = useState('')
  const [register, setRegister] = useState('')

  const handleSubmit = async e => {
    e.preventDefault()
    const data = { name, register }
    try {
      await await axios.post('http://localhost:8080/api/v1/lodge', data)
      alert('Lodge registered successfully!')
    } catch (err) {
      console.error(err)
    }
  }

  let navigate = useNavigate()

  const handleHomePage = () => {
    navigate('/')
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
          Nova Loja:
        </h1>
        <label>Nome:</label>
        <input
          type="text"
          value={name}
          onChange={e => setName(e.target.value)}
        />
        <label>Registro:</label>
        <input
          type="text"
          value={register}
          onChange={e => setRegister(e.target.value)}
        />
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  )
}

export default LodgeRegistration
