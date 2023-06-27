import React, { useState, useEffect } from 'react';

const ViewSpecialistPage = () => {
  const [specialists, setSpecialists] = useState([]);

  useEffect(() => {
    fetchSpecialists();
  }, []);

  const fetchSpecialists = async () => {
    try {
      const response = await fetch('http://localhost:8080/client/api/v1/specialist', {
        headers: {
          'Content-Type': 'application/json',
          Accept: 'application/json',
        },
      });

      if (response.ok) {
        const data = await response.json();
        setSpecialists(data);
      } else {
        throw new Error('Error fetching specialists');
      }
    } catch (error) {
      console.error('Error fetching specialists:', error);
    }
  };

  const rateSpecialist = async (specialistId, rating) => {
    try {
      const response = await fetch(`http://localhost:8080/client/api/v1/specialist/${specialistId}/rating`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(parseInt(rating)),
      });

      if (response.ok) {
        const updatedSpecialists = specialists.map((specialist) => {
          if (specialist.id === specialistId) {
            return { ...specialist, rating };
          }
          return specialist;
        });
        setSpecialists(updatedSpecialists);
      } else {
        throw new Error('Failed to rate specialist');
      }
    } catch (error) {
      console.error('Error rating specialist:', error);
    }
  };

  return (
    <div>
      <h2>All Specialists</h2>
      {specialists.map((specialist) => (
        <div key={specialist.id}>
          <h3>{specialist.name}</h3>
          <p>{specialist.surname}</p>
          <p>{specialist.specialization}</p>
          <p>{specialist.city}</p>
          <p>Rating: {specialist.rating}</p>
          <div>
            <input
              type="number"
              min="1"
              max="5"
              value={specialist.rating || ''}
              disabled={!specialist.rating} // Enable the input field if there is no rating
              onChange={(e) => rateSpecialist(specialist.id, e.target.value)}
            />
            <button onClick={() => rateSpecialist(specialist.id, parseInt(specialist.rating) || 0)}>Rate</button>
          </div>
          <hr />
        </div>
      ))}
    </div>
  );
};

export default ViewSpecialistPage;
