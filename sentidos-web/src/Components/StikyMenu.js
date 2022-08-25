import LoginIcon from "../img/right-to-bracket-solid.svg"
import RegisterIcon from "../img/user-plus-solid.svg"
import ModalRegister from "./ModalRegister";
import { ModalLogin } from "./ModalLogin";
import { useContext, useState } from "react";
import Swal from "sweetalert2";
import UserService from "../Service/UserService";
import Context from "../context/userContext";

function StikyMenu ({loginService}){   

    const context = useContext(Context);
    const {user} =context;
   

    const modalRegister = ()=>{
        ModalRegister();       
    }

    const modaLogin =  ()=>{
        Swal.fire({
            title: "Sign-in",
            html: `<input type="text" id="login" class="swal2-input" placeholder="Username">
            <input type="password" id="password" class="swal2-input" placeholder="Password">`,
            confirmButtonText: 'Sign in',
            focusConfirm: false,
            preConfirm: async () => {
              const login = Swal.getPopup().querySelector('#login').value
              const password = Swal.getPopup().querySelector('#password').value
              if (!login || !password) {
                Swal.showValidationMessage(`Please enter login and password`)
              }
    
              try{
              
                const res = await loginService(login, password);
                console.log(res)
                Swal.close();
                }catch(error){
                    console.log(error)
                    if(error.code === 'ERR_BAD_REQUEST'){
                        Swal.fire(`
                          Contraseña o usuario incorrectos!!
                        `.trim()
                        )
                      }
                }
            }
          }).then( async (result) => {     
    
            const response = await result.value.res.body;

            if(response === 400){
              Swal.fire(`
                Contraseña o usuario incorrectos!!
              `.trim()
              )
            }
            else if(response.statusCode === 200){
              Swal.fire(`
                Inicio de sesiòn exitosa!!
             `.trim()
              )
            }
            else {
                Swal.fire(`
                status: ${response.statusCode}
              `.trim()    
              )
            }
                    
        }).catch(e => {
           
            if(e.code === 'ERR_BAD_REQUEST'){
                Swal.fire(`
                  Contraseña o usuario incorrectos!!
                `.trim()
                )
              }
        });    }
    
    return (
        
        <div className="stiky-options">
            <img src={LoginIcon} onClick={modaLogin}/>
            <br />
            <img src={RegisterIcon} onClick={modalRegister}/>
        </div>
    
        
    )   
}
export default StikyMenu;