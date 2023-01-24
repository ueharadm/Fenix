import React, { useState, useEffect } from 'react'
import axios from 'axios'
import './Members.css'
import IconButton from '@mui/material/IconButton'
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew';

function Members() {
  const [members, setMembers] = useState([])

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
    <div>
      <IconButton aria-label="delete">
        <ArrowBackIosNewIcon />
      </IconButton>
      <h1>Members</h1>
      <ul className="members-grid">
        {members.map(member => (
          <li key={member.id}>
            <p>Name: {member.name}</p>
            <p>Registration: {member.registration}</p>
            <p>Degree: {member.degree}</p>
            <p>Lodge: {member.lodge.name}</p>
            <p>Birth date: {member.birthDate}</p>
            <p>Initiation date: {member.initiationDate}</p>
            <p>Redeemed: {member.redeemed ? 'Yes' : 'No'}</p>
          </li>
        ))}
      </ul>
    </div>
  )
}

export default Members
