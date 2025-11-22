import React, { useState } from "react";

function AddJob() {
  const [formData, setFormData] = useState({
    profile: "",
    desc: "",
    exp: "",
    techs: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const jobData = {
      profile: formData.profile,
      desc: formData.desc,
      exp: parseInt(formData.exp),
      techs: formData.techs.split(",").map((t) => t.trim()),
    };

    fetch("http://localhost:9090/job_listing", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(jobData),
    })
      .then((res) => res.json())
      .then(() => alert("Job added successfully!"))
      .catch((err) => console.error("Error:", err));
  };

  return (
    <div>
      <h2>Add Job Post</h2>
      <form onSubmit={handleSubmit}>
        <input
          name="profile"
          placeholder="Profile"
          onChange={handleChange}
          required
        />
        <br />
        <input
          name="desc"
          placeholder="Description"
          onChange={handleChange}
          required
        />
        <br />
        <input
          name="exp"
          type="number"
          placeholder="Experience (years)"
          onChange={handleChange}
          required
        />
        <br />
        <input
          name="techs"
          placeholder="Technologies (comma separated)"
          onChange={handleChange}
          required
        />
        <br />
        <button type="submit">Add Job</button>
      </form>
    </div>
  );
}

export default AddJob;
