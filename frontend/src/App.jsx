import "./App.css";
import Sidebar from "./components/Sidebar";
import HomePage from "./screen/HomePage";
import SearchVehicleScreen from "./screen/SearchVehicleScreen";
import AddVehicleScreen from "./screen/AddVehicleScreen";
import { Routes, Route } from "react-router-dom";
import LoginScreen from "./screen/LoginScreen";

function App() {
  return (
    <>
      <div className="container bg-pallet-5 mx-auto">
        <div className="flex">
          <div className="w-[15rem] h-screen p-5">
            <Sidebar />
          </div>
          <div className="pt-7 px-14 bg-pallet-4 w-full">
            <Routes>
              <Route index={true} path="/" element={<HomePage />} />
              <Route path="/search" element={<SearchVehicleScreen />} />
              <Route path="/addvehicle" element={<AddVehicleScreen />} />
              <Route path="/login" element={<LoginScreen />} />
            </Routes>
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
