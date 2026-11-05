import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import DashboardCard from './DashboardCard'
import Welcome from './Welcome'
function App() {
  return (
    <div>
      <div className="dashboard-grid">
        <Welcome />
        <DashboardCard
          title="Applications"
          description="Track your internship applications."
          count="5 Applications"
        />

        <DashboardCard
          title="Interviews"
          description="Manage your upcoming interviews."
          count="2 Interviews"
        />

        <DashboardCard
          title="Deadlines"
          description="Never miss an important deadline."
          count="3 Upcoming"
        />
      </div>
    </div>
  )
}

export default App
