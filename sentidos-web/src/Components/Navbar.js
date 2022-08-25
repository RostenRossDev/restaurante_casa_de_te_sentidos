import React, { useState, useEffect } from "react";
export default function Navbar(props) {

    const [slider, setSlider] = useState(false);
    
    return (
      <>
        <nav className="light-blue">
          <a
            href="#"
            className="sidenav-trigger"
            onClick={() => setSlider(s => !s)}
          >
            <i className="material-icons">menu</i>
          </a>
        </nav>
        <div
          className="sidenav-overlay"
          onClick={() => setSlider(s => !s)}
          style={{
            display: slider && window.screen.width < 980 ? "block" : "none",
            opacity: "1"
          }}
        />
        <ul
          id="slide-out"
          className="sidenav"
          style={{
            transform: slider || window.screen.width > 980 ? "translateX(0%)" : "",
            transitionProperty: "transform",
            transitionDuration: ".25s"
          }}
        >
          <li>
            <h4>RostenRoss</h4>
          </li>
            <li onClick={() => setSlider(s => !s)}>
              Hola raza
            </li>
          <li>
            <div className="divider" />
          </li>
          <li>
            <a className="subheader">Subheader</a>
          </li>
          <li>
            <a className="waves-effect" href="#!">
              Third Link With Waves
            </a>
          </li>
        </ul>
      </>
    );
  }
  