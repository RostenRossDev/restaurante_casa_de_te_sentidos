import LoginIcon from "../img/right-to-bracket-solid.svg"
import RegisterIcon from "../img/user-plus-solid.svg"
import { useState } from 'react'
import Swal from "sweetalert2";
import ModalRegister from "./ModalRegister";
import UserService from "../Service/UserService";

function StikyMenu () {   

    const modalRegister = ()=>{
        let reg = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;

        ModalRegister();
       
    }

    const modaLogin = ()=>{
        Swal.fire({
            title: "Sign-in",
            html: `<input type="text" id="login" class="swal2-input" placeholder="Username">
            <input type="password" id="password" class="swal2-input" placeholder="Password">`,
            confirmButtonText: 'Sign in',
            focusConfirm: false,
           /* preConfirm: () => {
              const login = Swal.getPopup().querySelector('#login').value
              const password = Swal.getPopup().querySelector('#password').value
              if (!login || !password) {
                Swal.showValidationMessage(`Please enter login and password`)
              }
              return { login: login, password: password }
            }*/
          }).then((result) => {
            UserService.register();

            UserService.getToken();
           /* Swal.fire(`
              Login: ${result.value.login}
              Password: ${result.value.password}
            `.trim())
            */
        }).catch(e =>console.log(e));
    }
    return (
        <div className="stiky-options">
            <img src={LoginIcon} onClick={modaLogin}/>
            <br />
            <img src={RegisterIcon} onClick={modalRegister}/>

        </div>    
        
    )   
}
export default StikyMenu;