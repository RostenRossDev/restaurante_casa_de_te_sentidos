import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";
import * as Yup from 'yup';
import { Field, Form, Formik } from "formik";
import SignUpForm from "./SignUpForm";
import UserService from "../Service/UserService";

const MySwal = withReactContent(Swal);

const SignupSchema = Yup.object().shape({
  username: Yup.string()
    .min(4, 'El usuario debe contener 4 o más caracteres')
    .max(20, 'El usuario debe contener 20 o menos caracteres.')
    .required('El usuario es requerido.')
  })

  const SignInForm = (login)=>{
   MySwal.fire({
        title: "Ingresar",
        html: (
            <Formik
            initialValues={{ username:"", password:""}}
            validationSchema={SignupSchema}
            onSubmit={async (values) => {
              try {
                login(values.username, values.password);
                Swal.close();
              } catch (error) {
                Swal.fire({
                  icon: 'error',
                  title: 'Ha ocurrido un error',
                  showConfirmButton: false,
                  timer: 2000
                });
                console.log(error);
              }
            }}
          >
            {({ errors, touched }) => (<Form >                
                <div className="form-group">
                    <label htmlFor="username" className="align-start">Usuario: </label>
                    <Field name="username" type="text" id="username" className="form-control"/>
                    {errors.username && touched.username ? (<div className="bg-warning error">{errors.username}</div>) : null}
                </div>
                <br/>
                <div className="form-group">
                    <label htmlFor="password">Password: </label>
                    <Field name="password" type="password" id="password" className="form-control"/>
                    {errors.password && touched.password ? (<div className="bg-warning error">{errors.password}</div>) : null}
                </div>        
                <br/>            
                <button type="submit" className="btn btn-primary" style={{"backgroundColor": "#CC6699", "border": "none"}}>Aceptar</button>
                <br/>
                <br/>
                <p>Si aún no está registrado, por favor <a href="#" onClick={SignUpForm}>regístrese</a></p>
            </Form>
            )}
          </Formik>
        ),
        showCloseButton: true,
        showCancelButton: false,
        showConfirmButton: false,
      });    
  };
  const modal=(LOG)=>{
    const login = async (login, pass)=>{
      try {
        const response = await UserService.getTokenByAxios(login, pass);
        if (response.status===200) {
      
            window.sessionStorage.setItem("token",response.data.access_token)
            window.sessionStorage.setItem("username",response.data.username)
            window.sessionStorage.setItem("loged","true")
            
            await Swal.fire({
                icon: 'success',
                title: 'Registro exitoso',
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
    return(
      <>
        {SignInForm(login)}
      </>
    )
  }
  export default modal;