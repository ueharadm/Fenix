import React, { useState } from 'react';

function MemberRegistration() {
    const [name, setName] = useState('');
    const [registration, setRegistration] = useState('');
    const [degree, setDegree] = useState('');
    const [lodge, setLodge] = useState('');
    const [birthDate, setBirthDate] = useState('');
    const [initiationDate, setInitiationDate] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = {
            name: name,
            registration: registration,
            degree: degree,
            lodge: lodge,
            birthDate: birthDate,
            initiationDate: initiationDate
        };
        fetch('http://localhost:8080/api/v1/member', {
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

export default MemberRegistration;
