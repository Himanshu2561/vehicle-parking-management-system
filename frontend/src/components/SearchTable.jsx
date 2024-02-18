import React from "react";
import { useDeleteVehicleMutation } from "../slices/vehicleApiSlice";

const SearchTable = ({ searchResult }) => {
  const [deleteVehicle, { isLoading: loadingDelete, isSuccess }] =
    useDeleteVehicleMutation();

  const deleteVehicleHandler = async (id) => {
    if (window.confirm("Are you sure?")) {
      try {
        await deleteVehicle(id);
        window.location.reload();
      } catch (err) {
        console.log(err);
      }
    }
  };

  return (
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
  );
};

export default SearchTable;
