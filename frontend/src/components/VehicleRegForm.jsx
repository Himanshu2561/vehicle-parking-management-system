import React, { useState } from "react";

const VehicleRegForm = () => {
  const [regNo, setRegNo] = useState("");
  const [type, setType] = useState("");

  const signinHandler = (e) => {
    e.preventDefault();
  };

  return (
    <div className="w-full bg-white rounded-lg shadow md:mt-0 sm:max-w-md xl:p-0">
      <div className="p-6 space-y-4 md:space-y-6 sm:p-8">
        <h1 className="text-xl font-bold leading-tight tracking-tight text-center text-gray-900 md:text-2xl">
          Vehicle Registration
        </h1>
        <form onSubmit={signinHandler} className="space-y-4 md:space-y-6">
          <div>
            <label
              htmlFor="VRC"
              className="block mb-2 text-sm font-medium text-gray-900"
            >
              <span className="text-red-500">*</span> Vehicle Registration
              Number
            </label>
            <input
              onChange={(e) => {
                setRegNo(e.target.value);
              }}
              type="text"
              name="VRN"
              className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
              placeholder="AB-00-CD-1234"
              required={true}
              autoComplete="true"
            />
          </div>
          <div>
            <label
              htmlFor="VT"
              className="block mb-2 text-sm font-medium text-gray-900"
            >
              <span className="text-red-500">*</span> Vehicle Type
            </label>
            <select
              onChange={(e) => {
                setType(e.target.value);
              }}
              name="VT"
              className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
              required={true}
              autoComplete="false"
            >
              <option value="Two-Wheeler">Two Wheeler</option>
              <option value="Four-Wheeler">Four Wheeler</option>
            </select>
          </div>
          <button
            type="submit"
            className="w-full bg-ecom-3 text-white bg-pallet-3 transition bg-opacity-70 hover:bg-opacity-100 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center"
          >
            Generate Ticket
          </button>
        </form>
      </div>
    </div>
  );
};

export default VehicleRegForm;
