import React, { useEffect, useState } from "react";
import { useDeleteVehicleMutation } from "../slices/vehicleApiSlice";

const SearchTable = ({ searchResult }) => {
  const [deleteVehicle, { isLoading: loadingDelete, isSuccess }] =
    useDeleteVehicleMutation();

  const [preiceData, setPriceData] = useState();

  const deleteVehicleHandler = async (id) => {
    if (window.confirm("Are you sure?")) {
      try {
        const { data } = await deleteVehicle(id);
        setPriceData(data);
      } catch (err) {
        console.log(err);
      }
    }
  };

  return !isSuccess ? (
    <table>
      <thead>
        <tr>
          <th>Ticket Number</th>
          <th>Vehicle Number</th>
          <th>Parking Slot Number</th>
          <th>In Time</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{searchResult.id}</td>
          <td>{searchResult.vehicleNumber}</td>
          <td>{searchResult.slot.slotNumber}</td>
          <td>{searchResult.ticketDate}</td>
          <td>
            <div>
              <button
                onClick={() => deleteVehicleHandler(searchResult.id)}
                className="bg-red-500 text-white px-2 py-1 rounded-md mx-5"
              >
                Delete
              </button>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  ) : (
    <div className="w-[25rem] capitalize font-semibold px-5 py-5 rounded-md gap-5 bg-pallet-5 flex flex-col justify-center items-center">
      <div className="flex items-center gap-2">
        <p>Payable Amount:</p>
        <p>Rs. {preiceData.amount}/-</p>
      </div>
      <div className="flex items-center gap-2">
        <p>Message:</p>
        <p>{preiceData.message}</p>
      </div>
    </div>
  );
};

export default SearchTable;
