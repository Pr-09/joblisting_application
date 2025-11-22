import React from "react";
import { Link } from "react-router-dom";

function Home() {
  return (
    <div>
      <h2>Welcome to Job Portal</h2>
      <Link to="/jobs">
        <button>Check Job Posts</button>
      </Link>
      <Link to="/add" style={{ marginLeft: 20 }}>
        <button>Add Job Post</button>
      </Link>
    </div>
  );
}

export default Home;
