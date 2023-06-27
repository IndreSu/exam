import React, { useState } from 'react';
import { Link } from 'react-router-dom';

export function Home() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [isLoading, setIsLoading] = useState(false);

  const handleLogin = () => {
    const credentials = {
      username: 'Linda', // Admin username
      password: 'password123', // Admin password
    };
  
    setIsLoading(true); 
  
    fetch('http://localhost:8080/login', {
      method: 'POST',
      body: JSON.stringify(credentials),
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error('Login failed');
        }
      })
      .then((data) => {
        setIsLoggedIn(data.success);
        setIsLoading(false); 
      })
      .catch((error) => {
        console.error('Error:', error);
        setIsLoggedIn(false); 
        setIsLoading(false); 
      });
  };
  
  const isAdmin = true; 

  return (
    <div className="Home">
      {isLoggedIn && !isAdmin && (
        <div className="admin-message">You need to log in as admin</div>
      )}
      <div className="home-links">
        <Link to="/">Home</Link>
        &nbsp;|&nbsp;
        <Link to="/specialist">Specialists</Link>
        &nbsp;|&nbsp;
        {isAdmin ? (
          <Link to="api/v1/autoservice">Autoservice management (for Admin) </Link>
        ) : (
          <span></span>
        )}
      </div>
      {!isLoggedIn && (
        <div className="login-form">
          <input
            type="text"
            placeholder="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <button onClick={handleLogin} disabled={isLoading}>
            {isLoading ? 'Logging in...' : 'Login'}
          </button>
        </div>
      )}
    </div>
  );
}
