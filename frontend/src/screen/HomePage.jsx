import React from "react";
import Card from "../components/Card";
import {
  useGetVehiclesQuery,
  useGetTotalNoOfVehiclesQuery,
  useGetLastSevenDayAmountQuery,
} from "../slices/vehicleApiSlice";
import Loader from "../components/Loader";

const HomePage = () => {
  const { data: vehicles, isLoading, error } = useGetVehiclesQuery();

  const {
    data: totalVehicle,
    isLoading: totalLoading,
    error: totalError,
  } = useGetTotalNoOfVehiclesQuery();

  const {
    data: sevenDaysAmount,
    isLoading: amountLoading,
    error: amountError,
  } = useGetLastSevenDayAmountQuery();

  return (
    <div className="">
      <div className="flex flex-wrap gap-y-10 gap-x-20">
        {amountLoading ? (
          <div className="flex justify-center items-center">
            <Loader />
          </div>
        ) : amountError ? (
          <div className="py-2 w-full rounded-md bg-opacity-50 bg-red-500 text-red-500">
            {amountError?.data?.message || amountError.error}
          </div>
        ) : (
          <Card title={"Last 7 Days Amount"} number={sevenDaysAmount.amount} />
        )}
        <Card title={"Last 30 Days Amount"} number={"12"} />
        {totalLoading ? (
          <div className="flex justify-center items-center">
            <Loader />
          </div>
        ) : totalError ? (
          <div className="py-2 w-full rounded-md bg-opacity-50 bg-red-500 text-red-500">
            {totalError?.data?.message || totalError.error}
          </div>
        ) : (
          <Card
            title={"Total Vehicle Entries"}
            number={totalVehicle.noOfVehicles}
          />
        )}
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
