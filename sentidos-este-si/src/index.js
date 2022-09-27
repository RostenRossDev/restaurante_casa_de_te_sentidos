import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
//import ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
  Route,
} from "react-router-dom";


import Login from "./pages/Login"
import Usuario from "./pages/Usuario"
const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>,
  }
  ,
  {
    //path: "login/:contactId",
    path: "/login",
    element: <Login />,
  }, 
  {
    path: "usuario",
    element: <Usuario />,
  },
  
]);

ReactDOM.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
  document.getElementById("root")
);
