import React from "react";
import styled from "styled-components";
import product2 from "../assets/product2.jpg";
import product3 from "../assets/product3.jpg";
import product4 from "../assets/product4.jpg";
import imagen2 from "../assets/imagen2.jpg";
import imagen3 from "../assets/imagen3.jpg";
import imagen4 from "../assets/imagen4.jpg";
import imagen5 from "../assets/imagen5.jpg";
import imagen6 from "../assets/imagen6.jpg";
import imagen7 from "../assets/imagen7.jpg";
import { TitleStyles } from "./ReusableStyles";

export default function Gallery() {

  return (
    <Section id="products">
      <div className="title">
        <h1>
          <span>Disfruta</span> de nuestros sabores
        </h1>
      </div>
      <section class="pt-5 pb-5">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                  <div class="carousel-item active" data-bs-interval="5000">
                    <div class="row">
                      <div class="col-md-4 mb-3">
                        <div class="card">
                          <img src={imagen6} class="d-block w-100" alt="Product image"/>
                        </div>
                      </div>
                      <div class="col-md-4 mb-3">
                        <div class="card">
                          <img src={product4} class="d-block w-100" alt="Product image" height={415}/>
                        </div>
                      </div>
                      <div class="col-md-4 mb-3">
                        <div class="card">
                          <img src={imagen2} class="d-block w-100" alt="Product image"/>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="carousel-item" data-bs-interval="5000">
                    <div class="row">
                      <div class="col-md-4 mb-3">
                        <div class="card">
                          <img src={imagen5} class="d-block w-100" alt="Product image"/>
                        </div>
                      </div>
                      <div class="col-md-4 mb-3">
                        <div class="card">
                          <img src={imagen7} class="d-block w-100" alt="Product image"/>
                        </div>
                      </div>
                      <div class="col-md-4 mb-3">
                        <div class="card">
                          <img src={imagen4} class="d-block w-100" alt="Product image"/>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="carousel-item" data-bs-interval="5000">
                    <div class="row">
                      <div class="col-md-4 mb-3">
                        <div class="card">
                          <img src={product2} class="d-block w-100" alt="Product image" height={415}/>
                        </div>
                      </div>
                      <div class="col-md-4 mb-3">
                        <div class="card">
                          <img src={imagen3} class="d-block w-100" alt="Product image"/>
                        </div>
                      </div>
                      <div class="col-md-4 mb-3">
                        <div class="card">
                          <img src={product3} class="d-block w-100" alt="Product image" height={415}/>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Next</span>
                </button>
              </div>
            </div>
          </div>
        </div>
      </section>
    </Section>
  );
}

const Section = styled.section`
  ${TitleStyles};
  .products {
      p {
        text-align: center;
        font-size: 1.1rem;
        line-height: 2rem;
        letter-spacing: 0.1rem;
      }
`;
