import { Formik, Field, Form } from "formik";
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";
import * as Yup from 'yup';
import UserService from "../Service/UserService";

const MySwal = withReactContent(Swal);

const SignupSchema = Yup.object().shape({
  username: Yup.string()
    .min(4, 'El usuario debe contener 4 o mas caracteres')
    .max(20, 'El usuario debe contener 20 o menos caracteres.')
    .required('El usuario es requerido.'),
  password: Yup.string()
    .min(8, 'La contraseña debe tener 8 o mas caracteres.')
    .max(20, 'La contraseña debe contener 20 o menos caracteres.')
    .required('La contraseña es requerido.'),
  repeat: Yup.string()
    .min(8, 'La debe repetir la contraseña.')
    .max(20, 'La contraseña debe contener 20 o menos caracteres.')
    .required('La contraseña es requerido.')
    .oneOf([Yup.ref('password'), null], 'Las contraseñas no coinciden.'),
  name: Yup.string()
    .min(4, 'El nombre es requerido.')
    .max(20, 'El usuario debe contener 20 o menos caracteres.')
    .required('El nombre es requerido.'),
  lastname: Yup.string()
    .min(4, 'El apellido debe contener 4 o mas caracteres.')
    .max(30, 'El apellido debe contener 30 o menos caracteres.')
    .required('El apellido es requerido.'),
  email: Yup.string().email('El email no es valido.').required('El email es requerido.'),
});

const ModalRegister = () => {   
      MySwal.fire({
        title: "Registrarse",
        html: (
            <Formik
            initialValues={{ username:"", password:"", repeat:"", name: "", lastname:"", email: "" }}
            validationSchema={SignupSchema}
            onSubmit={values => {
              UserService.getToken();
              Swal.close();
            }}
          >
            {({ errors, touched }) => (<Form >                
                <div className="form-group">
                    <label htmlFor="username" className="align-start">Usuario: </label>
                    <Field name="username" type="text" id="username" className="form-control"/>
                    {errors.username && touched.username ? (<div className="error">{errors.username}</div>) : null}
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password: </label>
                    <Field name="password" type="password" id="password" className="form-control"/>
                    {errors.password && touched.password ? (<div className="error">{errors.password}</div>) : null}
                </div>      
                <div className="form-group">        
                  <label htmlFor="repeat">Repetir: </label>
                  <Field name="repeat" type="password" className="form-control"  id="repeat"/> 
                  {errors.repeat && touched.repeat ? (<div className="error">{errors.repeat}</div>) : null}
                </div>                     
                <div className="form-group">  
                  <label htmlFor="name">Nombres: </label>
                  <Field name="name" type="text" className="form-control"  id="name"/>    
                  {errors.name && touched.name ? (<div className="error">{errors.name}</div>) : null}                
                </div> 
                <div className="form-group">  
                  <label htmlFor="lastname">Apellidos: </label>
                  <Field name="lastname" type="text" className="form-control"  id="lastname"/>  
                  {errors.lastname && touched.lastname ? (<div className="error">{errors.lastname}</div>) : null}                  
                </div>
                <div className="form-group"> 
                  <label htmlFor="email">Email: </label>
                  <Field name="email" type="email" className="form-control"  id="email"/>
                  {errors.email && touched.email ? (<div className="error">{errors.email}</div>) : null}
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

export default ModalRegister;