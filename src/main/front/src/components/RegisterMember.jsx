import React, { useState } from 'react';
import api from '../services/api';

function RegisterMember() {
  const [name, setName] = useState('');
  const [registration, setRegistration] = useState('');
  const [degree, setDegree] = useState('');
  const [lodge, setLodge] = useState('');
  const [birthDate, setBirthDate] = useState('');
  const [initiationDate, setInitiationDate] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await api.post('/member', {
        name,
        registration,
        degree,
        lodge,
        birthDate,
        initiationDate
      });
      alert('Registration successful!');
    } catch (error) {
      alert('Error registering member: ' + error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input type="text" value={name} onChange={e => setName(e.target.value)} />
      </label>
      <br />
      <label>
        Registration:
        <input type="text" value={registration} onChange={e => setRegistration(e.target.value)} />
      </label>
      <br />
      <label>
        Degree:
        <input type="text" value={degree} onChange={e => setDegree(e.target.value)} />
      </label>
      <br />
      <label>
        Lodge:
        <input type="text" value={lodge} onChange={e => setLodge(e.target.value)} />
      </label>
      <br />
      <label>
        Birth Date:
        <input type="text" value={birthDate} onChange={e => setBirthDate(e.target.value)} />
      </label>
      <br />
      <label>
        Initiation Date:
        <input type="text" value={initiationDate} onChange={e => setInitiationDate(e.target.value)} />
      </label>
      <br />
      <button type="submit">Submit</button>
    </form>
  );
}

export default RegisterMember;
