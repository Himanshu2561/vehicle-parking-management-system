import React from "react";
import Card from "../components/Card";

const HomePage = () => {
  return (
    <div className="">
      <div className="flex flex-wrap gap-y-10 gap-x-20">
        <Card title={"Todays Vehicle Entries"} number={"12"} />
        <Card title={"Yesterdays Vehicle Entries"} number={"12"} />
        <Card title={"Last 7 Days Vehicle Entries"} number={"12"} />
        <Card title={"Total Vehicle Entries"} number={"12"} />
      </div>
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
                  In Time
                </th>
                <th scope="col" className="px-6 py-3">
                  Out Time
                </th>
              </tr>
            </thead>
            <tbody>
              <tr className="bg-white border-b">
                <td className="px-6 py-4">01</td>
                <td className="px-6 py-4">MP43YZ1234</td>
                <td className="px-6 py-4">Two Wheeler</td>
                <td className="px-6 py-4">14</td>
                <td className="px-6 py-4">DD-MM-YYYY HH:mm:ss</td>
                <td className="px-6 py-4">DD-MM-YYYY HH:mm:ss</td>
              </tr>
              <tr className="bg-white border-b">
                <td className="px-6 py-4">01</td>
                <td className="px-6 py-4">MP43YZ1234</td>
                <td className="px-6 py-4">Two Wheeler</td>
                <td className="px-6 py-4">14</td>
                <td className="px-6 py-4">DD-MM-YYYY HH:mm:ss</td>
                <td className="px-6 py-4">DD-MM-YYYY HH:mm:ss</td>
              </tr>
              <tr className="bg-white border-b">
                <td className="px-6 py-4">01</td>
                <td className="px-6 py-4">MP43YZ1234</td>
                <td className="px-6 py-4">Two Wheeler</td>
                <td className="px-6 py-4">14</td>
                <td className="px-6 py-4">DD-MM-YYYY HH:mm:ss</td>
                <td className="px-6 py-4">DD-MM-YYYY HH:mm:ss</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
