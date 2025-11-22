import React, { useEffect, useState } from "react";

function JobList() {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    fetch("http://localhost:9090/job_listing")
      .then((res) => res.json())
      .then((data) => setJobs(data))
      .catch((err) => console.error("Error:", err));
  }, []);

  return (
    <div>
      <h2>All Job Posts</h2>
      {jobs.map((job, index) => (
        <div
          key={index}
          style={{ border: "1px solid gray", margin: 10, padding: 10 }}
        >
          <h3>{job.profile}</h3>
          <p>{job.desc}</p>
          <p>
            <strong>Experience:</strong> {job.exp} years
          </p>
          <p>
            <strong>Technologies:</strong> {job.techs.join(", ")}
          </p>
        </div>
      ))}
    </div>
  );
}

export default JobList;
