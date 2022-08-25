import "materialize-css/dist/css/materialize.min.css";
import "materialize-css/dist/js/materialize.min.js";
import M from 'materialize-css/dist/js/materialize.min.js';
import React, { useCallback, useContext, useEffect, useRef, useState } from "react";
import Context from "../context/userContext";
import defaultImg from "../img/default.png";
import fondo1 from "../img/fondo1.jpg"
import fondo2 from "../img/fondo2.jpg"
import fondo3 from "../img/fondo3.jpg"
import fondo4 from "../img/fondo4.jpg"
import fondo5 from "../img/fondo5.jpg"
import * as Yup from 'yup';
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";

import { Field, Form, Formik } from "formik";
import PreviewImage from "./PreviewImage";
import UserService from "../Service/UserService";

const SUPPORTED_FORMATS = ["image/jpg", "image/jpeg", "image/png"]
const schema = Yup.object().shape({
    file: Yup
    .mixed()
    .required('File is required')
    .test("FILE_FORMAT", "Solo son aceptados los formatos: .jpeg, .jpg, y .png", (value) => !value || (value && SUPPORTED_FORMATS.includes(value?.type)))
    .test('FILE_SIZE', "La foto debe ser menor a 10 Mb.", value => value.size <= 1024*1024),
})


function useForceUpdate(){
    const [value, setValue] = useState(0); // integer state
    return () => setValue(value => value + 1); // update state to force render
    // An function that increment 👆🏻 the previous state like here 
    // is better than directly setting `value + 1`
}

const MySwal = withReactContent(Swal);

function Menu ({clear, updatePhoto, username, email, name, lastname, token, id, photo}){   

    const base ="https://sentidos-backend.herokuapp.com";
    const urlGetPhoto= base+"/api/v1/user/uploads/img/"
    const context = useContext(Context);
    const [user, setUser] = useState(context.user);
    const fileRef= useRef(null);
    const [img, setImg] = useState(urlGetPhoto+sessionStorage.getItem("photo"));

    const [perfilImg, setPerfilImg] =useState(urlGetPhoto+sessionStorage.getItem("photo"))

    useEffect(() => {
        const getDataAndPhoto = async ()=>{
            console.log("renderizando menu")
            console.log(perfilImg !==urlGetPhoto+sessionStorage.getItem("photo"))
            console.log(urlGetPhoto+sessionStorage.getItem("photo"))
            console.log(perfilImg )
            if(perfilImg !==urlGetPhoto+sessionStorage.getItem("photo")){
                setPerfilImg(urlGetPhoto+sessionStorage.getItem("photo"))
                const data = await UserService.getUserDate(token, sessionStorage.getItem('username'));
                window.location.reload();
            }
        }
        getDataAndPhoto();
        M.AutoInit();
        
    },[])  
           
    const uploadPhotoModal=  ()=>{
        MySwal.fire({
            title: "Cambiar foto de perfil",
            html: (
                <Formik
                initialValues={{ file:null}}
                validationSchema={schema}
                onSubmit={ async(values) => {

                  //loginService(values.username, values.password)
                  await UserService.updatePhoto(values.file, username, token)              

                  const data = await UserService.getUserDate(token, sessionStorage.getItem('username'));
                  updatePhoto(base+"/api/v1/user/uploads/img/"+ data.photo)
                  window.location.reload();
                  
                  Swal.close();
                }}
              >
                {({ errors, values, setFieldValue }) => (
                    <Form >
                
                    <div className="form-group files">

                        <input
                            hidden
                            ref={fileRef}
                            type="file"
                            onChange={(e)=>{
                                setFieldValue("file",e.target.files[0]);
                            }}
                        />

                        {errors.file ? <div>{errors.file}</div>:null}
                        {values.file && <PreviewImage file={values.file}/>}
                        <div className="btn btn-primary"  onClick={()=> fileRef.current.click()}>
                            Subir imagen
                        </div>
                    </div>
                    <button type="submit" className="btn btn-primar y" >Submit</button>
                </Form>
                )}
              </Formik>
            ),
            showCloseButton: false,
            showCancelButton: false,
            showConfirmButton: false,
          });    
    }
    
    return(
        <>
            <nav className="user-menu">
                <div className="nav-wrapper">
                <a  href="#" data-target="mobile-demo" className="sidenav-trigger  show-on-large">
                    <i className="material-icons" >menu</i>
                </a>
                <p className="brand-logo">Date un gusto</p>
                <ul id="nav-mobile" className="right hide-on-med-and-down">
                   <a href="#" onClick={clear}>Cerrar sesión</a>
                </ul>
            </div>
        </nav>

        <ul className="sidenav" id="mobile-demo">
            <li>
                <div class="user-view">
                    <div class="background">
                        <img src={fondo2} /> 
                    </div>
                    <div style={{display:"flex"}}>
                        {console.log(perfilImg)}
                        {photo!==null? <img class="circle fluid" src={perfilImg} alt="usuario" /> :<img class="circle fluid" src={defaultImg} alt="usuario" style={{marginRight:"0px"}}/> }
                        <a href="#"><i className="material-icons " onClick={uploadPhotoModal}>camera_alt</i></a>
                    </div>
                    <a href="#name"><span className="white-text name">{name} {lastname}</span></a>
                    <a href="#email"><span className="white-text email">{email}</span></a>
                </div>
            </li>
            <div className="divider" />            
            <li><a href="#">Datos de logeo <i className="material-icons" style={{color:"#FFC300"}}>star</i></a></li>
            <li><a href="#">Nombre completo <i className="material-icons" style={{color:"#FFC300"}}>star</i></a></li>
            <li><a href="#">Direccion <i className="material-icons" style={{color:"#FFC300"}}>star</i></a></li>
            <li><a href="#">Correo electronico <i className="material-icons" style={{color:"#FFC300"}}>star</i></a></li>
            <li><a href="#">Medios de pago <i className="material-icons" style={{color:"#FFC300"}}>star</i></a></li>
        </ul>
      </>
  )
}


export default Menu;