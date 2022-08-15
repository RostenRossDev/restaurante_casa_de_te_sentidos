import { Formik, Field, Form } from "formik";
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";

const MySwal = withReactContent(Swal);

const ModalRegister = values => {
    return new Promise((resolve, reject) => {
      MySwal.fire({
        title: "Enter values",
        html: (
            <Formik
            initialValues={{ username:"", password:"", repeat:"", name: "", lastname:"", email: "" }}
            onSubmit={async (values) => {
              await new Promise((resolve) => setTimeout(resolve, 500));
              alert(JSON.stringify(values, null, 2));
            }}
          >
            <Form>
                
                <div class="form-group">
                    <label htmlFor="username" className="align-start">Usuario: </label>
                    <Field name="username" type="text" id="username" class="form-control"/>
                </div>
                <br/>
                <div class="form-group">
                    <label htmlFor="password">Password: </label>
                    <Field name="password" type="password" id="password" class="form-control"/>
                </div>                
                <br/>
                <label htmlFor="username">Repetir: </label>
                <Field name="repeat" type="password" class="form-control"/>                    
                <br/>
                <label htmlFor="username">Nombres: </label>
                <Field name="name" type="text" class="form-control"/>                    
                <br/>
                <label htmlFor="username">Apellidos: </label>
                <Field name="lastname" type="text" class="form-control" />                    
                <br/>
                <label htmlFor="username">Email: </label>
                <Field name="email" type="email" class="form-control"/>
                <br/>
                <button type="submit">Submit</button>
            </Form>
          </Formik>
        ),
        onClose: () => reject(),
        showConfirmButton: true
      });
    });
  };

export default ModalRegister;