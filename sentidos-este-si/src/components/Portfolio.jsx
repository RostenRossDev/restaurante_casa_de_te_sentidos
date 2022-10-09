import React from "react";
import styled from "styled-components";
import imagen8 from "../assets/imagen8.jpg";
import sentidosLogo from "../assets/sentidosLetraTransaparente.png";

export default function Portfolio() {
  return (
    <Section id="portfolio">
      <div className="background">
        <img src={imagen8} alt="Room Image" />
      </div>
      <div className="content">
        <img src={sentidosLogo} alt="Logo" />
        <h2>
          Trabajar con alegría, ilusión, inteligencia e intuición es nuestra mejor receta para poder transmitir los sabores a los paladares sedientos de una experiencia gastronómica inolvidable.
        </h2>
      </div>
    </Section>
  );
}

const Section = styled.section`
  height: 80vh;
  position: relative;
  border-radius: 5rem;
  &:hover {
    .background {
      img {
        transform: scale(1.2);
      }
    }
  }
  .background {
    height: 100%;
    max-width: 100%;
    overflow: hidden;
    border-radius: 1rem;
    img {
      object-fit: cover;
      width: 100%;
      height: 100%;
      filter: brightness(60%);
      border-radius: 1rem;
      transition: 0.8s ease-in-out;
    }
  }
  .content {
    position: absolute;
    top: 20%;
    left: 10%;
    color: white;
    display: flex;
    flex-direction: column;
    gap: 1rem;
    justify-content: center;
    align-items: flex-start;
    h2 {
      width: 60%;
    }
    }
  }
  @media screen and (min-width: 260px) and (max-width: 1080px) {
    /* display: none; */
    .content {
      h1 {
        width: 90%;
        font-size: 1.5rem;
      }
      h2 {
        font-size: 1.2em;
        width: 90%;
      }
      button {
        padding: 1rem 2rem;
        font-size: 1rem;
      }
    }
  }
`;
