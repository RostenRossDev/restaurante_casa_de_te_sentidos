import React from "react";
import styled from "styled-components";
import sentidosLogo from "../assets/sentidosLetraTransaparente.png";
import { AiFillInstagram } from "react-icons/ai";
import { BsTwitter } from "react-icons/bs";
import { FaFacebookF } from "react-icons/fa";
import { GrLinkedinOption } from "react-icons/gr";

export default function Footer() {
  return (
    <div className="footer">
      <Section>
        <div className="brand container">
          <img src={sentidosLogo} alt="Logo" />
          <ul>
            <li>
              <a href="https://www.instagram.com" target={"_blank"}>
                <AiFillInstagram />
              </a>
            </li>
            <li>
              <a href="https://www.facebook.com" target={"_blank"}>
                <FaFacebookF />
              </a>
            </li>
            <li>
              <a href="https://www.linkedin.com" target={"_blank"}>
                <GrLinkedinOption />
              </a>
            </li>
            <li>
              <a href="https://www.twitter.com" target={"_blank"}>
                <BsTwitter />
              </a>
            </li>
          </ul>
        </div>
        <div className="about container">
          <div className="title">
            <h3>Sobre nosotros</h3>
          </div>
          <p>
            Desde 1990 brindando la mejor experiencia gastronómica basada en los más altos estándares de calidad en nuestros productos y los mejores profesionales.
          </p>
        </div>
        <div className="contact container">
          <div className="title">
            <h3>Contacto</h3>
          </div>
          <p>+54 362-154203121</p>
          <p>sentidos_contacto@gmail.com</p>
          <p>Av. Sarmiento 453, Resistencia, Chaco</p>
        </div>
      </Section>
      <LowerFooter className="lower__footer">
        <h2>
          Copyright &copy; 2022 <span>Sentidos</span> desarrollado por SysTech
        </h2>
      </LowerFooter>
    </div>
  );
}

const Section = styled.footer`
  margin: 0;
  background: linear-gradient(to right, #fc4958, #CC99CC);
  color: white;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 10vw;
  padding: 4vw;
  p {
    font-size: 1.1rem;
    line-height: 2rem;
    letter-spacing: 0.1rem;
  }
  ul {
    display: flex;
    list-style-type: none;
    gap: 4vw;
    margin-top: 2vw;
    li {
      padding: 0.8rem;
      border-radius: 2rem;
      background-color: white;
      transition: 0.3s ease-in-out;
      cursor: pointer;
      &:hover {
        background-color: black;
        svg {
          transform: scale(1.2);
        }
      }
      svg {
        display: flex;
        justify-content: center;
        align-items: center;
        color: #fc4958;
        font-size: 1.6rem;
        transition: 0.3s ease-in-out;
        &:hover {
        }
      }
    }
  }
  img {
    filter: brightness(0) invert(1);
    width: 10vw;
    margin-left: 35%;
    margin-top: 10%;
  }
  .container {
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
    h3 {
      font-size: 2rem;
    }
  }
  @media screen and (min-width: 260px) and (max-width: 1080px) {
    grid-template-columns: 1fr;
    .container {
      img {
        height: 4rem;
        width: 10rem;
      }
    }
  }
`;

const LowerFooter = styled.div`
  margin: 0;
  text-align: center;
  background-color: black;
  color: white;
  padding: 1rem;
  h2 {
    span {
      color: #fc4958;
      text-transform: uppercase;
    }
  }
  @media screen and (min-width: 260px) and (max-width: 450px) {
    h2 {
      span {
        display: block;
      }
    }
  }
`;
