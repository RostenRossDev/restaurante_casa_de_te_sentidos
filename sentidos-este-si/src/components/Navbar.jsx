import { useContext, useRef, useState } from "react";
import styled from "styled-components";
import SignInForm from "./SignInForm";
import sentidosLogo from "../assets/sentidos.png";
import { GiHamburgerMenu } from "react-icons/gi";
import { VscChromeClose } from "react-icons/vsc";
import Context from "../context/userContext";
import UserService from "../Service/UserService";
import Swal from "sweetalert2";

export default function Navbar() {
  const [navbarState, setNavbarState] = useState(false);
  const html = document.querySelector("html");
  html.addEventListener("click", () => setNavbarState(false));
  const context = useContext(Context);
  const [user, setUser] = useState(context.user);
  const [token, setToken]=useState(user.token);
  const [loged, setLoged] =useState(user.loged);
  const refPostValue = useRef("");
  const [photo, setPhoto] = useState(sessionStorage.getItem("photo"));
  const [username, setUsername] = useState(sessionStorage.getItem("username"));
  const [comments, setComments] = useState([]);

  const login = async (login, pass)=>{
    try {
        const response = await UserService.getTokenByAxios(login, pass);
        if (response.status===200) {
            setUsername(await response.data.username);
            setToken(response.data.access_token);
            setLoged(true);
            //window.sessionStorage.setItem("token",response.data.access_token)
            //window.sessionStorage.setItem("username",response.data.username)

            const userDateRes = await UserService.getUserDate(response.data.access_token, response.data.username);

            setUser({
                username: response.data.username, 
                name: userDateRes.name, 
                lastname: userDateRes.lastname, 
                loged: true, 
                token: response.data.access_token, 
                photo: userDateRes.photo, 
                email: userDateRes.email
            });

            setPhoto(await userDateRes.photo);
            await Swal.fire({
                icon: 'success',
                title: 'Usuario creado',
                showConfirmButton: false,
                timer: 2000
            });
          console.log("submit");
          Swal.close();
        }
      } catch (error) {
        Swal.fire({
          icon: 'error',
          title: 'Ha ocurrido un error',
          showConfirmButton: false,
          timer: 2000
        });
        console.log(error);
      }               
}
  return (
    <>
      <Nav>
        <div className="brand">
          <img src={sentidosLogo} alt="Icon" height={100} />
          <div className="toggle">
            {navbarState ? (
              <VscChromeClose onClick={() => setNavbarState(false)} />
            ) : (
              <GiHamburgerMenu
                onClick={(e) => {
                  e.stopPropagation();
                  setNavbarState(true);
                }}
              />
            )}
          </div>
        </div>
        <ul className="links">
          <li>
            <a href="#home" className="active">
              Inicio
            </a>
          </li>
          <li>
            <a href="#services">Nuestros Servicios</a>
          </li>
          <li>
            <a href="#testimonials">Testimonios</a>
          </li>
          <li>
            <a href="#products">Productos</a>
          </li>
          <a href="#"><button onClick={SignInForm}>Ingresar</button></a>
        </ul>
      </Nav>
      <ResponsiveNav state={navbarState} className={navbarState ? "show" : ""}>
        <ul>
          <li>
            <a
              href="#home"
              className="active"
              onClick={() => setNavbarState(false)}
            >
              Inicio
            </a>
          </li>
          <li>
            <a href="#services" onClick={() => setNavbarState(false)}>
              Nuestros Servicios
            </a>
          </li>
          <li>
            <a href="#testimonials" onClick={() => setNavbarState(false)}>
              Testimonios
            </a>
          </li>
          <li>
            <a href="#products" onClick={() => setNavbarState(false)}>
              Productos
            </a>
          </li>
          <li>
            <a href="#newsletter" onClick={() => setNavbarState(false)}>
              Ingresar
            </a>
          </li>
        </ul>
      </ResponsiveNav>
    </>
  );
}

const Nav = styled.nav`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 4vw;
  .brand {
    img {
      margin-top: 1rem;
      cursor: pointer;
    }
    .toggle {
      display: none;
    }
  }
  .links {
    display: flex;
    list-style-type: none;
    gap: 2rem;
    li {
      padding-top: 2rem;
      a {
        color: #fc4958;
        font-weight: 600;
        text-decoration: none;
        text-transform: uppercase;
        letter-spacing: 0.2rem;
        transition: 0.3s ease-in-out;
        &:hover {
          color: #CC99CC;
        }
      }
      .active {
        color: #CC99CC;
      }
    }
    button {
      margin-top: 1rem;
      padding: 0.5rem 1rem;
      font-size: 1.2rem;
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
  @media screen and (min-width: 260px) and (max-width: 1080px) {
    .brand {
      display: flex;
      justify-content: space-between;
      align-items: center;
      width: 100%;
      top: 0;
      .toggle {
        display: block;
      }
    }
    .links {
      display: none;
    }
  }
`;
const ResponsiveNav = styled.div`
  position: fixed;
  right: -100vw;
  top: 0;
  z-index: 10;
  background-color: white;
  height: 100vh;
  width: ${({ state }) => (state ? "60%" : "0%")};
  transition: 0.3s ease-in-out;
  display: flex;
  opacity: 0;
  visibility: hidden;
  ul {
    list-style-type: none;
    width: 100%;
    margin-top: 3rem;
    li {
      width: 100%;
      margin: 1rem 0;
      margin-left: 2rem;
      a {
        text-decoration: none;
        color: #f9c74f;
        font-size: 1.2rem;
        transition: 0.1s ease-in-out;
        &:hover {
          color: #fc4958;
        }
      }
      &:first-of-type {
        a {
          color: #fc4958;
          font-weight: 900;
        }
      }
    }
  }
`;
