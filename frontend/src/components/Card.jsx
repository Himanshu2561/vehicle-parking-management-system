import React from "react";
import { IoCarSportOutline } from "react-icons/io5";

const Card = ({ title, number }) => {
  return (
    <div className="bg-white shadow-lg rounded-md p-5 w-60 flex items-center gap-5">
      <div className="text-6xl text-pallet-3">
        <IoCarSportOutline />
      </div>
      <div className="font-semibold">
        <p>{number}</p>
        <p className="opacity-70">{title}</p>
      </div>
    </div>
  );
};

export default Card;
