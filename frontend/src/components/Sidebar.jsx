import React from "react";
import { FaLaptop, FaAddressBook, FaSearch } from "react-icons/fa";
import { Link } from "react-router-dom";

const Sidebar = () => {
  return (
    <div className="flex flex-col gap-10 font-semibold text-pallet-1">
      <div className="flex gap-5 items-center">
        <div>
          <FaLaptop />
        </div>
        <Link to="/">Dashboard</Link>
      </div>
      <div className="flex gap-5 items-center">
        <div>
          <FaAddressBook />
        </div>
        <Link to="/addvehicle">Add Vehicle</Link>
      </div>
      <div className="flex gap-5 items-center">
        <div>
          <FaSearch />
        </div>
        <Link to="/search">Search Vehicle</Link>
      </div>
    </div>
  );
};

export default Sidebar;
