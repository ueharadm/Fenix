import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import HomePage from './components/HomePage'
import MeetingRegistration from './components/MeetingRegistration'
import MemberRegistration from './components/MemberRegistration'
import RegisterMember from './components/RegisterMember'

const App = () => {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/meeting/" element={<MeetingRegistration />} />
        <Route path="/member/" element={<MemberRegistration />} />
        <Route path="/lodge/" element={<LodgeRegistration />} />
        <Route path="/attendance/" element={<AttendanceReports />} />
        <Route path="*" element={<PageNotFound />} />
      </Routes>
    </Router>
  )
}

export default App
