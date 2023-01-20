import React, { useState } from 'react';
import axios from 'axios';

const LodgeRegistration = () => {
  const [name, setName] = useState('');
  const [register, setRegister] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const data = { name, register };
    try {
      await axios.post('http://localhost:8080/api/v1/lodge', data);
      alert('Lodge registered successfully!');
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      </label>
      <br />
      <label>
        Register:
        <input type="text" value={register} onChange={(e) => setRegister(e.target.value)} />
      </label>
      <br />
      <button type="submit">Submit</button>
    </form>
  );
};

export default LodgeRegistration;