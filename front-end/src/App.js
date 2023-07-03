import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import HomePage from './components/HomePage'
import MeetingRegistration from './components/MeetingRegistration'
import MemberRegistration from './components/MemberRegistration'
import LodgeRegistration from './components/LodgeRegistration'
import AttendanceReports from './components/AttendanceReports'
import MemberListing from './components/MemberListing'
import LodgeListing from './components/LodgeListing'
import MeetingListing from './components/MeetingListing'
import MeetingManager from './pages/MeetingManager'

const App = () => {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/meeting/" element={<MeetingRegistration />} />
        <Route path="/member/" element={<MemberRegistration />} />
        <Route path="/lodge/" element={<LodgeRegistration />} />
        <Route path="/attendance/" element={<AttendanceReports />} />
        <Route path="/members/" element={<MemberListing />} />
        <Route path="/lodges/" element={<LodgeListing />} />
        <Route path="/meetings/" element={<MeetingListing />} />
        <Route path="/meeting/:number" element={<MeetingManager />} />
      </Routes>
    </Router>
  )
}

export default App
