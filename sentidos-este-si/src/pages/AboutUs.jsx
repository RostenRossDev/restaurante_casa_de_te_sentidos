import React, { useEffect } from "react";
import Navbar from "../components/Navbar";
import styled from "styled-components";
import fondo2 from "../assets/fondo2.jpg";
import cocinero1 from "../assets/cocinero1.jpg";
import cocinero2 from "../assets/cocinero2.jpg";
import cocinero3 from "../assets/cocinero3.jpg";
import scrollreveal from "scrollreveal";
import Footer from "../components/Footer";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faShieldCheck } from '@fortawesome/free-regular-svg-icons';
import { faCircleCheck } from "@fortawesome/free-solid-svg-icons";

export default function AboutUs() {
    useEffect(() => {
        const sr = scrollreveal({
          origin: "top",
          distance: "80px",
          duration: 2000,
          reset: false,
        });
        sr.reveal(
          `
            nav,
            .aboutUs,
            .footer,
            img
        `,
          {
            opacity: 0,
            interval: 200,
          }
        );
      }, []);

    return (
    <>
        <Navbar/>
        <Section id="aboutUs">    
            <div className="background">
                <img src={fondo2} alt="Background" />
            </div>
            <div className="content">
                <div className="info">
                    <section id="experience" class="block">
                    <div>
                        <div>
                            <h1>La Experiencia Gastronómica</h1>
                            <div>
                                <br/>
                                <h2>Nuestro principal objetivo es crear una experiencia gastronómica inolvidable.</h2>			
                            </div>
                        </div>
                        <div>
                            <div>
                                <br/>
                                <h5>Trabajar, esforzarse, sentir, escuchar, conversar, saborear, observar, ilusionar, mejorar, emocionar, pensar, imaginar, inspirarse, decorar, mimar, reflexionar...</h5>
                                <h5>Trabajar con alegría, ilusión, inteligencia e intuición es nuestra mejor receta para poder transmitir los sabores a los paladares sedientos de una experiencia gastronómica inigualable.</h5>
                                <br/>
                                <br/>
                                <img src={cocinero1} class="rounded mx-auto d-block" alt="..."></img>
                            </div>          
                        </div>
                    </div>
                    </section>
                </div>
            </div>     
            {/* <div className="container">
                <div className="row">
                    <div className="col-md-4">
                        <img src={cocinero1} class="rounded mx-auto d-block" alt="..."></img>
                    </div>
                    <div className="col-md-4">
                        <img src={cocinero2} class="rounded mx-auto d-block" alt="..."></img>
                    </div>
                    <div className="col-md-4">
                        <img src={cocinero3} class="rounded mx-auto d-block" alt="..."></img>
                    </div>
                </div>
            </div>                 */}
            <div className="services">
                <div className="service">
                    <FontAwesomeIcon icon={faCircleCheck} className="service"/>
                    <h4>Nuestra misión</h4>
                    <p>
                        Nos dedicamos a satisfacer las necesidades gastronómicas de nuestros clientes, preparando y ofreciendo alimentos y servicios de la calidad más alta y una atención personalizada que asegure su satisfacción.
                    </p>
                </div>
                <div className="service">
                    <FontAwesomeIcon icon={faCircleCheck} className="service"/>
                    <h4>Nuestra visión</h4>
                    <p>
                        Ser reconocidos como una marca que ofrece experiencias inolvidables, con un excelente servicio y productos de calidad.
                    </p>
                </div>
                <div className="service">
                    <FontAwesomeIcon icon={faCircleCheck} className="service"/>
                    <h4>Nuestros valores</h4>
                    <p>
                    Excelencia, Calidad, Responsabilidad, Confianza, Honestidad y Solidaridad.
                    </p>
                </div>
            </div>
            <br/>
        </Section >


       <Footer />
    </>
    );
}

const Section = styled.section`
width: 100vw;
position: relative;
// min-height: calc(100vh - 100px - 300px);
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
height: 50%;
width: 100%;
    .info {
        position: absolute;
        top: 20%;
        left: 25%;
        right: 25%;
        display: flex;
        flex-direction: column;
        align-items: flex-end;
        gap: 1rem;
        color: white;
    }
}
.services {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 10vw;
    margin-top: 4rem;
    .service {
      display: flex;
      flex-direction: column;
      align-items: center;
      gap: 1.5vw;
      padding: 0 3vw;
      .service {
        height: 2.8rem;
        color: #fc4958;
      }
      p {
        text-align: center;
        line-height: 2rem;
        font-size: 1.1rem;
        letter-spacing: 0.1rem;
      }
      h4 {
        text-align: center;
        line-height: 2rem;
        font-size: 1.5rem;
        letter-spacing: 0.1rem;
        color: #fc4958;
      }
      button {
        padding: 0.6rem 3rem;
        letter-spacing: 0.2rem;
        border-radius: 2rem;
        font-size: 1.1rem;
        border: none;
        color: white;
        background-color: #fc4958;
        transition: 0.3s ease-in-out;
        &:hover {
          background-color: #CC99CC;
        }
      }
    }
    .yellow {
      button {
        background-color: #f9c74f;
        &:hover {
          background-color: #fc4958;
        }
      }
    }
  }

    @media screen and (min-width: 260px) and (max-width: 1080px) {
        .content {
        flex-direction: column;
        }
    }
`;
