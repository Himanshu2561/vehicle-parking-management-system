import React, { useState } from "react";
import "./App2.css";

const SearchVehicle = () => {
  const [searchQuery, setSearchQuery] = useState("");
  const [searchResult, setSearchResult] = useState(null);
  const [error, setError] = useState("");

  const handleSearch = async () => {
    try {
      
      console.log(vehicle);
    } catch (error) {
      console.log(error.message);
    }
  };

  return (
    <div className="App">
      <p className="text-2xl font-bold mb-5 text-pallet-2">Search Vehicle</p>
      <div className="search-container">
        <input
          type="text"
          placeholder="Enter Vehicle Number"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
        <button
          onClick={handleSearch}
          className="bg-pallet-3 py-1 px-4 text-lg text-white font-semibold"
        >
          Search
        </button>
      </div>
      {error && <p className="error-message">{error}</p>}
      {searchResult && (
        <div className="result-container">
          <p className="text-lg text-pallet-2 font-semibold mt-20 mb-5">
            Vehicle Details
          </p>
          <div>
            <VehicleData/>
          </div>
        </div>
      )}
    </div>
  );
};

export default SearchVehicle;
