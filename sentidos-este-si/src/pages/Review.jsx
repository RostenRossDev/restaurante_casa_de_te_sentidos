import React, { useEffect } from "react";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import styled from "styled-components";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faArrowRight, faArrowLeft } from '@fortawesome/free-solid-svg-icons';
import { Rating, Typography} from "@mui/material";
import imagen9 from "../assets/imagen9.jpg";
import scrollreveal from "scrollreveal";

export default function Review() {
    const values = {
        excellent: 5,
        good: 4,
        regular: 3,
        bad: 2,
        veryBad: 1
    }

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
            .footer
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
        <Section id="review">
            <div className="background">
                <img src={imagen9} alt="background" />
            </div>
            <section class="pt-5 pb-5 content">
            <div class="container">
                <div class="row">
                <div class="col-6">
                    <h3 class="mb-3" style={{"color": "#fc4958"}}>Reseñas de nuestros clientes</h3>
                </div>
                <div class="col-6 text-right">
                    <a class="btn btn-primary mb-3 " data-bs-target="#carouselExampleControls" data-bs-slide="next" role="button">
                    <FontAwesomeIcon icon={faArrowRight} />
                    </a>
                    <a class="btn btn-primary mb-3 mr-1" data-bs-target="#carouselExampleControls" data-bs-slide="prev" role="button">
                    <FontAwesomeIcon icon={faArrowLeft} />
                    </a>
                </div>
                <div class="col-12">
                    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">

                    <div class="carousel-inner">
                        <div class="carousel-item active">
                        <div class="row">
                            <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <Typography component="legend">Bueno</Typography>
                                    <Rating name="read-only" value={values.good} readOnly />
                                    <br/>
                                    <br/>
                                    
                                    <p class="card-text">"Muy buen lugar, muy buena atención por parte del personal, ricas pastas."</p>
                                    <p>Ivana S.</p>
                                </div>
                            </div>
                            </div>
                            <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <Typography component="legend">Excelente</Typography>
                                    <Rating name="read-only" value={values.excellent} readOnly />
                                    <br/>
                                    <br/>
                                    <p class="card-text">Excelente siempre! Voy seguido pues me encanta el lugar, la atención y la comida. Todo 10 puntos. Buenos precios además. Lo recomiendo sin dudas.</p>
                                    <p>Carlos P.</p>
                                </div>
                            </div>
                            </div>
                            <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <Typography component="legend">Bueno</Typography>
                                    <Rating name="read-only" value={values.good} readOnly />
                                    <br/>
                                    <br/>
                                    <p class="card-text">Deben si o si intentar pasar a este lugar. Las entradas son de gran calidad y los fondos de muy buen tamaño.</p>
                                    <p>Natalia R.</p>
                                </div>
                            </div>
                            </div>
                        </div>
                        </div>
                        <div class="carousel-item">
                        <div class="row">

                            <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <Typography component="legend">Bueno</Typography>
                                    <Rating name="read-only" value={values.good} readOnly />
                                    <br/>
                                    <br/>
                                    <p class="card-text">Todo lo que se consuma es de gran calidad y super fresco. Suelen tener platos de estación. El precio es un poco alto pero súper acorde a la calidad y servicio general que brindan</p>
                                    <p>Marina P.</p>
                                </div>
                            </div>
                            </div>
                            <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <Typography component="legend">Excelente</Typography>
                                    <Rating name="read-only" value={values.excellent} readOnly />
                                    <br/>
                                    <br/>
                                    <p class="card-text">Destacable el servicio. No tuvimos espera pero llegamos muy temprano. Una suavidad y calidad para atender que me sorprendió! En cuanto a la comida muy abundante y bien servido. Sabores clásicos!</p>
                                    <p>Lucas N.</p>
                                </div>
                            </div>
                            </div>
                            <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <Typography component="legend">Excelente</Typography>
                                    <Rating name="read-only" value={values.excellent} readOnly />
                                    <br/>
                                    <br/>
                                    <p class="card-text">El lugar y el servicio es espectacular. Todo estaba INCREÍBLE. Una carta de vinos variada y buenos precios. Un lugar para volver!
</p>
                                    <p>Raúl L.</p>
                                </div>
                            </div>
                            </div>

                        </div>
                        </div>
                        <div class="carousel-item">
                        <div class="row">

                            <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <Typography component="legend">Bueno</Typography>
                                    <Rating name="read-only" value={values.good} readOnly />
                                    <br/>
                                    <br/>
                                    <p class="card-text">Es un lugar 100% recomendable! La atención del servicio y la calidad de los platos, productos lo hacen que quieras volver. Platos ricos y elaborados. Es un plan imperdible para venir con amigos y familia, muy buena carta de vinos . Precio/calidad muy buenos</p>
                                    <p>Laura S.</p>
                                </div>
                            </div>
                            </div>
                            <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <Typography component="legend">Excelente</Typography>
                                    <Rating name="read-only" value={values.excellent} readOnly />
                                    <br/>
                                    <br/>
                                    <p class="card-text">Cualquier cosa que pueda escribir me parece que me quedo corta. La comida es simplemente exquisita, una delicia cada plato. Chequear los precios antes de ir porque pueden parecer un poco elevados, pero lo vale ya que es totalmente acorde a la calidad del producto.</p>
                                    <p>Nadia T.</p>
                                </div>
                            </div>
                            </div>
                            <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <Typography component="legend">Bueno</Typography>
                                    <Rating name="read-only" value={values.good} readOnly />
                                    <br/>
                                    <br/>
                                    <p class="card-text">La porción era abundante, para compartir. La comida un lujo. Es para hacer un monumento. Destaco la atención de los mozos. Todo muy organizado.</p>
                                    <p>Rosa M.</p>
                                </div>
                            </div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
                </div>
                </div>
                <button type="button" class="btn btn-primary btn-lg">Agregar reseña</button>
            </div>
            </section>
            
        </Section>
        <Footer/>
    </>
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
    height: 100%;
    width: 100%;
    .container {
        max-height: -webkit-fill-available !important;
        .btn {
            background-color: #fc4958;
            border: none;
            float: right;
            margin-right: 2rem;
            &:hover {
            background-color: #CC99CC;
        }
        .card {
            height: 15rem !important;
        }
    }
}

  @media screen and (min-width: 260px) and (max-width: 1080px) {
    .content {
      flex-direction: column;
    }
  }
`;