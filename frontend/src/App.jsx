import "./App.css";
import Sidebar from "./components/Sidebar";
import HomePage from "./screen/HomePage";
import SearchVehicle from "./screen/SearchVehicle";
import AddVehicle from "./screen/AddVehicle";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <div className="container bg-pallet-5 mx-auto">
        <div className="flex">
          <div className="w-[15rem] h-screen p-5">
            <Sidebar />
          </div>
          <div className="py-7 px-14 bg-pallet-4 w-full">
            <Routes>
              <Route index={true} path="/" element={<HomePage />} />
              <Route path="/search" element={<SearchVehicle />} />
              <Route path="/addvehicle" element={<AddVehicle />} />
            </Routes>
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
