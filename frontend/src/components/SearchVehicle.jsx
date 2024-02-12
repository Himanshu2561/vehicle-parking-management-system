

import React, { useState } from 'react';
import './App2.css';

const vehicles = [
  { vehicleNumber: 'ABC123', inTime: '10:00 AM', parkingSlot: 'A1', ticketNumber: '001' },
  { vehicleNumber: 'XYZ789', inTime: '11:30 AM', parkingSlot: 'B2', ticketNumber: '002' },
  
];

function SearchVehicle() {
  const [searchQuery, setSearchQuery] = useState('');
  const [searchResult, setSearchResult] = useState(null);
  const [error, setError] = useState('');

  const handleSearch = () => {
    const result = vehicles.find(vehicle => vehicle.vehicleNumber === searchQuery);
    if (result) {
      setSearchResult(result);
      setError('');
    } else {
      setSearchResult(null);
      setError('Vehicle not parked here.');
    }
  };

  return (
    <div className="App">
      <h1>Search Vehicle</h1>
      <div className="search-container">
        <input
          type="text"
          placeholder="Enter Vehicle Number"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
        <button onClick={handleSearch}>Search</button>
      </div>
      {error && <p className="error-message">{error}</p>}
      {searchResult && (
        <div className="result-container">
          <h2>Vehicle Details</h2>
          <table>
            <thead>
              <tr>
                <th>Vehicle Number</th>
                <th>In Time</th>
                <th>Parking Slot Number</th>
                <th>Ticket Number</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{searchResult.vehicleNumber}</td>
                <td>{searchResult.inTime}</td>
                <td>{searchResult.parkingSlot}</td>
                <td>{searchResult.ticketNumber}</td>
              </tr>
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default SearchVehicle;
