import React from "react";
import Card from "../components/Card";
import { useGetVehiclesQuery } from "../slices/vehicleApiSlice";
import Loader from "../components/Loader";

const HomePage = () => {
  const { data: vehicles, isLoading, error } = useGetVehiclesQuery();

  console.log(vehicles);

  return (
    <div className="">
      <div className="flex flex-wrap gap-y-10 gap-x-20">
        <Card title={"Todays Vehicle Entries"} number={"12"} />
        <Card title={"Yesterdays Vehicle Entries"} number={"12"} />
        <Card title={"Last 7 Days Vehicle Entries"} number={"12"} />
        <Card title={"Total Vehicle Entries"} number={"12"} />
      </div>
      {isLoading ? (
        <div className="flex justify-center items-center">
          <Loader />
        </div>
      ) : error ? (
        <div className="py-2 w-full rounded-md bg-opacity-50 bg-red-500 text-red-500">
          {error?.data?.message || error.error}
        </div>
      ) : (
        <div className="bg-white rounded-tl-lg rounded-tr-lg mt-20 h-screen">
          <div className="relative overflow-x-auto rounded-lg flex flex-col justify-center items-center mb-10 mt-5">
            <table className="w-full text-sm text-left text-gray-500">
              <thead className="uppercase bg-gray-50 text-indigo-500">
                <tr>
                  <th scope="col" className="px-6 py-3">
                    ID
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Vehicle Number
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Vehicle Type
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Solt Number
                  </th>
                  <th scope="col" className="px-6 py-3">
                    Ticket Date
                  </th>
                </tr>
              </thead>
              <tbody>
                {vehicles.map((vehicle) => (
                  <tr key={vehicle.id} className="bg-white border-b">
                    <td className="px-6 py-4">{vehicle?.id}</td>
                    <td className="px-6 py-4">{vehicle?.vehicleNumber}</td>
                    <td className="px-6 py-4">{vehicle?.vehicleType}</td>
                    <td className="px-6 py-4">{vehicle?.slot?.slotNumber}</td>
                    <td className="px-6 py-4">{vehicle?.ticketDate}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}
    </div>
  );
};

export default HomePage;
