import {useState, useEffect} from "react";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import imagen9 from "../assets/imagen9.jpg";
import styled from "styled-components";
import Swal from "sweetalert2";
import scrollreveal from "scrollreveal";

export default function Contact() {

    const [email, setEmail] = useState("");
    const [name, setName] = useState("");
    const [phone, setPhone] = useState("");
    const [comment, setComment] = useState("");

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

    const handleSubmit = (event) => {
        event.preventDefault();
        Swal.fire({
          icon: 'success',
          title: 'Comentario enviado',
          showConfirmButton: false,
          timer: 2000
        });
        setEmail("");
        setComment("");
        setPhone("");
        setName("");
      }

    return (
    <>
        <Navbar/>
        <Section id="contact" >
            <div className="background">
                <img src={imagen9} alt="background" />
            </div>
            <form className="content" onSubmit={handleSubmit}>
                <div className="container">
                    <h2>Formulario de contacto</h2>
                    <div class="mb-3 mailContainer">
                        <br/>
                        <label for="exampleFormControlInput1" class="form-label">Nombre Completo</label>
                        <input 
                        type="text" 
                        class="form-control" 
                        id="exampleFormControlInput1" 
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        />
                    </div>
                    
                    <div class="mb-3 mailContainer">
                        <br/>
                        <label for="exampleFormControlInput1" class="form-label">Correo electrónico</label>
                        <input 
                        type="email" 
                        class="form-control" 
                        id="exampleFormControlInput1" 
                        placeholder="correo@ejemplo.com"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        />
                    </div>
                    <div class="mb-3 mailContainer">
                        <br/>
                        <label for="exampleFormControlInput1" class="form-label">Teléfono</label>
                        <input 
                        type="text" 
                        class="form-control" 
                        id="exampleFormControlInput1" 
                        value={phone}
                        onChange={(e) => setPhone(e.target.value)}
                        />
                    </div>
                    <div class="mb-3 commentContainer">
                        <br/>
                        <label for="exampleFormControlTextarea1" class="form-label">Comentario</label>
                        <textarea 
                        class="form-control" 
                        id="exampleFormControlTextarea1" 
                        rows="6" 
                        style={{"resize": "none"}}
                        value={comment}
                        onChange={(e) => setComment(e.target.value)}>
                        </textarea>
                    </div>
                    <br/>
                    <div>
                        <button type="submit" class="btn btn-primary mb-3 float-right">Enviar</button>
                    </div>
                </div>
            </form>
        </Section>
        <Footer/>
    </>
    );
}

const Section = styled.section`
  height: 130vh;
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
    h2 {
      color: #fc4958;
      text-align: center;
      margin-top: 10px;
    }
    .container {
        background-color: white;
        height: 80%;
        width: 60%;
        border-radius: 5px;
        .mailContainer {
            width: 25%;
            padding-left: 2rem;
            min-width: 15rem;
        }
        .commentContainer {
            width: 100%;
            padding-left: 2rem;
            padding-right: 2rem;
            
        }
        .btn {
           background-color: #fc4958;
           border: none;
           float: right;
           margin-right: 2rem;
           &:hover {
            background-color: #CC99CC;
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