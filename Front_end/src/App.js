import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./components/home";
import AddJob from "./components/addJob";
import JobList from "./components/jobList";

function App() {
  return (
    <Router>
      <div className="p-6 text-center">
        <h1>Job Portal</h1>
        <nav>
          <Link to="/" style={{ marginRight: 20 }}>
            Home
          </Link>
          <Link to="/jobs" style={{ marginRight: 20 }}>
            Check Job Posts
          </Link>
          <Link to="/add">Add Job Post</Link>
        </nav>
        <hr />

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/jobs" element={<JobList />} />
          <Route path="/add" element={<AddJob />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
