import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";

function HomePage() {
    let navigate = useNavigate();

    const handleLodgeRegistration = () => {
      navigate("/lodge");
    }
    const handleMemberRegistration = () => {
      navigate("/member");
    }

    const handleMeetingRegistration = () => {
      navigate("/meeting");
    }

    const handleAttendanceRequest = () => {
      navigate("/attendance");
    }


    return (
        <div>
            <h1 style={{alignItems: "center", display: "flex", flexDirection: "column"}} >Controle de presença</h1>
            <div style={{alignItems: "center", display: "flex", flexDirection: "column"}}>
              <button style={{margin: "5px"}} onClick={handleLodgeRegistration}>Cadastrar Loja</button>
              <button style={{margin: "5px"}} onClick={handleMemberRegistration}>Cadastrar Membro</button>
              <button style={{margin: "5px"}} onClick={handleMeetingRegistration}>Cadastrar Reunião</button>
              <button style={{margin: "5px"}} onClick={handleAttendanceRequest}>Calcular Presenças</button>
            </div>
            
        </div>
    );
}

export default HomePage;
