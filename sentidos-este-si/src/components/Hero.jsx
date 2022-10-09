import React from "react";
import styled from "styled-components";
import imagen1 from "../assets/imagen1.jpg";
import SignInForm from "./SignInForm";

export default function Hero() {
  return (
    <Section id="home">
      <div className="background">
        <img src={imagen1} alt="Background" />
      </div>
      <div className="content">
        <div className="info">
          <h2>Ordenar</h2>
          <em>
            Para reservar mesas o solicitar un envío por favor regístrese e ingrese al sistema.
            <br/>
            Aceptamos pagos en efectivo y todas las tarjetas de débito y crédito.
          </em>
          <button onClick={SignInForm}>Llevame ahi</button>
        </div>
      </div>
    </Section>
  );
}

const Section = styled.section`
  height: 90vh;
  width: 100vw;
  position: relative;
  .background {
    height: 100%;
    img {
      object-fit: cover;
      width: 100%;
      height: 100%;
      filter: brightness(60%);
    }
  }
  .content {
    position: absolute;
    top: 0;
    display: flex;
    align-items: center;
    justify-content: space-between;
    height: 100%;
    width: 100%;
    .info {
      position: absolute;
      top: 20%;
      right: 10%;
      display: flex;
      flex-direction: column;
      align-items: flex-end;
      gap: 1rem;
      h2 {
        color: #F37F9F;
        font-size: 4rem;
        letter-spacing: 0.5rem;
      }
      em {
        color: white;
        width: 60%;
        text-align: end;
        font-size: 1.5rem;
        line-height: 2rem;
        letter-spacing: 0.1rem;
      }
      button {
        padding: 1rem 2rem;
        font-size: 1.4rem;
        background-color: #CC6699;
        border: none;
        color: white;
        font-weight: 800;
        letter-spacing: 0.2rem;
        transition: 0.3s ease-in-out;
        cursor: pointer;
        border-radius: 1rem;
        &:hover {
          background-color: #CC99CC;
        }
      }
    }
  }
  @media screen and (min-width: 260px) and (max-width: 1080px) {
    .content {
      flex-direction: column;
      .sale {
        display: none;
      }
      .info {
        top: 25%;
        h2 {
          font-size: 2rem;
        }
        em {
          width: 90%;
        }
      }
    }
  }
`;
