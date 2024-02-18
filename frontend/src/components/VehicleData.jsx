import React from "react";
import { useGetVehicleDetailsQuery } from "../slices/vehicleApiSlice";

const vehicleData = () => {
  const {
    data: vehicle,
    isLoading,
    error,
  } = useGetVehicleDetailsQuery(searchQuery);

  return (
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
  );
};

export default vehicleData;
