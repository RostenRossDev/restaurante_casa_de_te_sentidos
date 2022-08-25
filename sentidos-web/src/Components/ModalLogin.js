import { useContext, useState } from "react";
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";
import Context from "../context/userContext";
import UserService from "../Service/UserService";
import * as Yup from 'yup';
import { Field, Form, Formik } from "formik";

const MySwal = withReactContent(Swal);

const SignupSchema = Yup.object().shape({
  username: Yup.string()
    .min(4, 'El usuario debe contener 4 o mas caracteres')
    .max(20, 'El usuario debe contener 20 o menos caracteres.')
    .required('El usuario es requerido.')
  })

  const ModalLogin = (loginService)=>{
   MySwal.fire({
        title: "Registrarse",
        html: (
            <Formik
            initialValues={{ username:"", password:""}}
            validationSchema={SignupSchema}
            onSubmit={values => {
              console.log("hola: "+JSON.stringify(values))
              loginService(values.username, values.password)
              Swal.close();
            }}
          >
            {({ errors, touched }) => (<Form >                
                <div className="form-group">
                    <label htmlFor="username" className="align-start">Usuario: </label>
                    <Field name="username" type="text" id="username" className="form-control"/>
                    {errors.username && touched.username ? (<div className="bg-warning error">{errors.username}</div>) : null}
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password: </label>
                    <Field name="password" type="password" id="password" className="form-control"/>
                    {errors.password && touched.password ? (<div className="bg-warning error">{errors.password}</div>) : null}
                </div>                    
                <button type="submit" className="btn btn-primary" >Submit</button>
            </Form>
            )}
          </Formik>
        ),
        showCloseButton: false,
        showCancelButton: false,
        showConfirmButton: false,
      });    
  };

  const modal=({loginService})=>{

    return(
      <>
        {ModalLogin(loginService)}
      </>
    )
  }
  export default modal;