import React, { useState } from "react";
import { useLazyGetVehicleDetailQuery } from "../slices/vehicleApiSlice";
import "./App2.css";
import SearchTable from "./SearchTable";

const SearchVehicle = () => {
  const [searchQuery, setSearchQuery] = useState("");
  const [searchResult, setSearchResult] = useState(null);

  const [getVehicleDetail, { data, isLoading, error }] =
    useLazyGetVehicleDetailQuery(searchQuery);

  const handleSearch = async (e) => {
    e.preventDefault();
    try {
      const vehicle = (await getVehicleDetail(searchQuery)).data;
      console.log(vehicle);
      setSearchResult(vehicle);
    } catch (error) {
      console.log(error.message);
    }
  };

  return (
    <div className="App">
      <p className="text-2xl font-bold mb-5 text-pallet-2">Search Vehicle By ID</p>
      <div className="search-container">
        <form onSubmit={handleSearch}>
          <input
            type="text"
            placeholder="Enter Vehicle ID"
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
          />
          <button
            type="submit"
            className="bg-pallet-3 py-1 px-4 text-lg text-white font-semibold"
          >
            Search
          </button>
        </form>
      </div>
      {searchResult && (
        <div className="result-container">
          <p className="text-lg text-pallet-2 font-semibold mt-20 mb-5">
            Vehicle Details
          </p>
          <div>
            <SearchTable searchResult={searchResult} />
          </div>
        </div>
      )}
    </div>
  );
};

export default SearchVehicle;
