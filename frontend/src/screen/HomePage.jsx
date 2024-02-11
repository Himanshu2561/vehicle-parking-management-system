import React from "react";
import Card from "../components/Card";

const HomePage = () => {
  return (
    <div className="">
      <div className="flex flex-wrap gap-y-10 gap-x-20">
        <Card title={"Todays Vehicle Entries"} number={"69"} />
        <Card title={"Yesterdays Vehicle Entries"} number={"69"} />
        <Card title={"Last 7 Days Vehicle Entries"} number={"69"} />
        <Card title={"Total Vehicle Entries"} number={"69"} />
      </div>
      <div className="bg-white rounded-lg mt-20 h-screen">
        
      </div>
    </div>
  );
};

export default HomePage;
