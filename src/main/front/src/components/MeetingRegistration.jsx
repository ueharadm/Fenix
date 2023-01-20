import React, { useState } from 'react';

function MeetingRegistration() {
    const [number, setNumber] = useState('');
    const [worshipfulMasterId, setWorshipfulMasterId] = useState('');
    const [type, setType] = useState('');
    const [date, setDate] = useState('');
    const [attendees, setAttendees] = useState([]);

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = {
            number: number,
            worshipfulMasterId: worshipfulMasterId,
            type: type,
            date: date,
            attendees: attendees
        };
        fetch('http://localhost:8080/api/v1/meeting', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                Number:
                <input type="text" value={number} onChange={e => setNumber(e.target.value)} />
            </label>
            <br />
            <label>
                Worshipful Master ID:
                <input type="text" value={worshipfulMasterId} onChange={e => setWorshipfulMasterId(e.target.value)} />
            </label>
            <br />
            <label>
                Type:
                <input type="text" value={type} onChange={e => setType(e.target.value)} />
            </label>
            <br />
            <label>
                Date:
                <input type="text" value={date} onChange={e => setDate(e.target.value)} />
            </label>
            <br />
            <label>
                Attendees:
                <input type="text" value={attendees} onChange={e => setAttendees(e.target.value)} />
            </label>
            <br />
            <button type="submit">Submit</button>
        </form>
    );
}

export default MeetingRegistration;
