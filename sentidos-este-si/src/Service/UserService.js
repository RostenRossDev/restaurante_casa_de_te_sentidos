//import { encode } from "base-64";
import qs from "qs";
import axios from "axios";

const baseLocal="http://127.0.0.1:8080";
const baseWweb="https://sentidos-backend.herokuapp.com";
const base= baseLocal;
const urlLogin = base+"/oauth/token";
const urlRegister = base+"/api/v1/user/";
const urlUploadPhoto = base+"/api/v1/user/uploads";
const urlPost=base+"/api/v1/post/";
const urlGetPhoto= base+"/api/v1/user/uploads/img/"
const usernameApp ="reactSentidosApp";
const passwordApp ="sentidos3399";

const UserService = {
    getToken : async (username, password) => {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", "Basic cmVhY3RTZW50aWRvc0FwcDpzZW50aWRvczMzOTk=");
      myHeaders.append("Content-Type", "application/x-www-form-urlencoded");

      var urlencoded = new URLSearchParams();
      urlencoded.append("username", username);
      urlencoded.append("password", password);
      urlencoded.append("grant_type", "password");

      var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: urlencoded,
        redirect: 'follow'
      };

      let result={
        statusCode:"",
        body:"",
        error:null
      };
      const response = fetch(urlLogin, requestOptions)
        .then(response => {
          return response;
        })
        .catch(error => {
          return error;
        }); 

        await response.then(res =>{ 
          result.statusCode=res.status
          result.body=res.text()
        }).catch(err => result.error=err)


      return result;
    },
    getTokenByAxios: async(username, password) =>{
      var data = qs.stringify({
        username: username,
        password: password,
        grant_type: "password"
      });
      var config = {
        method: "post",
        url: urlLogin,
        headers: {
          Authorization: "Basic cmVhY3RTZW50aWRvc0FwcDpzZW50aWRvczMzOTk=",
          "Content-Type": "application/x-www-form-urlencoded"
        },
        data: data
      };
  
      const resp =await axios(config);
      //sessionStorage.setItem("token",resp.data.access_token)
      sessionStorage.setItem("username",resp.data.username)
      sessionStorage.setItem("token",resp.data.access_token)

      return await resp;
    },
    register : async  (data) => {        
        const headerReq = new Headers();
        headerReq.append('Authorization', 'Basic cmVhY3RTZW50aWRvc0FwcDpzZW50aWRvczMzOTk=');
        headerReq.append('Content-Type', 'application/json'); 
     
        var raw = JSON.stringify({
            "username": data.username,
            "password": data.password,
            "name": data.name,
            "lastname": data.lastname,
            "email": data.email
          });
        var requestOptions = {
            method: 'POST',
            headers: headerReq,
            body: raw,
            redirect: 'follow'
          };
          
        fetch(urlRegister, requestOptions)
        .then(response => response.text())
        .then(result => console.log("Te registraste, tu token es: "+result))
        .catch(error => console.log('error', error));   
       return "response";
    },


    getUserDate:async  () => {   
      const username = sessionStorage.getItem("username");
      const token =sessionStorage.getItem("token")
      var config = {
        method: 'get',
        url: urlRegister+`?username=${username}`,
        headers: { 
          'Authorization': `Bearer ${token}`
        }
      };
      let result={
        name:"",
        email:"",
        lastname:"",
      };

      const  getData= axios(config)
        .then()
        .then((response) => {
          window.sessionStorage.setItem("name", response.data.name)
          window.sessionStorage.setItem("lastname", response.data.lastname)
          window.sessionStorage.setItem("email", response.data.email)
          console.log(response.data)
          window.sessionStorage.setItem("photo", response.data.photo)
          return response.data
        })
        .catch(function (error) {
          console.log(error.response.status);
          if(error.response.status) sessionStorage.clear()
        });     

      return getData;
    },

    updatePhoto: async (fileInput, username, token)=>{var myHeaders = new Headers();
      myHeaders.append("Authorization", "Bearer "+token);
      
      var formdata = new FormData();
      //formdata.append("file", fileInput, "[PROXY]");
      formdata.append("file", fileInput);
      formdata.append("id", "1");
      
      var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: formdata,
        redirect: 'follow'
      };
      
      fetch(urlUploadPhoto, requestOptions)
        .then(response => response.text())
        .catch(error => console.log('error', error));
    }      
}

export default UserService;