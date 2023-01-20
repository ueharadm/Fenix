import React, { useState } from 'react';
import axios from 'axios';

const AttendanceReports = () => {
  const [memberId, setMemberId] = useState('');
  const [initDate, setInitDate] = useState('');
  const [finalDate, setFinalDate] = useState('');
  const [rule, setRule] = useState('GENERAL');
  
  const handleSubmit = async (e) => {
    e.preventDefault();
    const data = { memberId, initDate, finalDate, rule };
    try {
      await axios.post('http://localhost:8080/api/v1/attendance/completeReport', data);
      alert('Report created successfully!');
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Member ID:
        <input type="text" value={memberId} onChange={(e) => setMemberId(e.target.value)} />
      </label>
      <br />
      <label>
        Initial Date:
        <input type="date" value={initDate} onChange={(e) => setInitDate(e.target.value)} />
      </label>
      <br />
      <label>
        Final Date:
        <input type="date" value={finalDate} onChange={(e) => setFinalDate(e.target.value)} />
      </label>
      <br />
      <label>
        Rule:
        <select value={rule} onChange={(e) => setRule(e.target.value)}>
          <option value="GENERAL">GENERAL</option>
          <option value="REDEEMED">REDEEMED</option>
          <option value="OFFICER">OFFICER</option>
        </select>
      </label>
      <br />
      <button type="submit">Submit</button>
    </form>
  );
};

export default AttendanceReports;