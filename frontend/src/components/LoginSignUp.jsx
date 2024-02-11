import React, { useState } from "react";
import "./LoginSignUp.css";
import { FaRegUser } from "react-icons/fa";
import { IoMailOutline, IoKeyOutline } from "react-icons/io5";

const LoginSignUp = () => {
  const [action, setAction] = useState("Login");
  return (
    <div className="container_">
      <div className="header">
        <div className="text">{action}</div>
        <div className="underline"></div>
      </div>
      <div className="inputs">
        {action === "Login" ? (
          <div></div>
        ) : (
          <div className="input items-center flex gap-5">
            <div className="ml-4"><FaRegUser /></div>
            <input type="text" placeholder="Name" />
          </div>
        )}

        <div className="input items-center flex gap-5">
          <div className="ml-4"><IoMailOutline /></div>
          <input type="email" placeholder="Email Id" />
        </div>
        <div className="input items-center flex gap-5">
          <div className="ml-4"><IoKeyOutline /></div>
          <input type="password" placeholder="Password" />
        </div>
      </div>
      {action === "Sign Up" ? (
        <div></div>
      ) : (
        <div className="forgot-password">
          Forgot Password? <span>Click Here</span>
        </div>
      )}

      <div className="submit-container">
        <div
          className={action === "Login" ? "submit gray" : "submit"}
          onClick={() => {
            setAction("Sign Up");
          }}
        >
          Sign Up
        </div>
        <div
          className={action === "Sign Up" ? "submit gray" : "submit"}
          onClick={() => {
            setAction("Login");
          }}
        >
          Login
        </div>
      </div>
    </div>
  );
};
export default LoginSignUp;
