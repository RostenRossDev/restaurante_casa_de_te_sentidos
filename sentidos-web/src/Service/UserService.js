import { encode } from "base-64";
const urlLogin = "http://127.0.0.1:8080/oauth/token";
const urlRegister = "http://127.0.0.1:8080/api/v1/user/";
const usernameApp ="reactSentidosApp";
const passwordApp ="sentidos3399";

const UserService = {
    getToken : async  function (username, password) {
       var myHeaders = new Headers();
myHeaders.append("Authorization", "Basic cmVhY3RTZW50aWRvc0FwcDpzZW50aWRvczMzOTk=");
myHeaders.append("Content-Type", "application/x-www-form-urlencoded");

var urlencoded = new URLSearchParams();
urlencoded.append("username", "RostenRoss");
urlencoded.append("password", "12345");
urlencoded.append("grant_type", "password");

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: urlencoded,
  redirect: 'follow'
};

fetch("http://127.0.0.1:8080/oauth/token", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
    },

    register : async  function (username, password) {
        let response;
        const bodyReq ={           
            "username":"losten",
            "password":"losten1234",
            "name":"losten",
            "lastname":"losten",
            "email":"lolo@gmail.com"          
        }
        const headerReq = new Headers();
        headerReq.append('Authorization', 'Basic cmVhY3RTZW50aWRvc0FwcDpzZW50aWRvczMzOTk=');
        headerReq.append('Content-Type', 'application/json'); 
              
        /*await fetch("http://127.0.0.1:8080/api/v1/user/",{
        'method': 'post',
        body: JSON.stringify(bodyReq),   
        header: headerReq*/

        var raw = JSON.stringify({
            "username": "losten",
            "password": "losten1234",
            "name": "losten",
            "lastname": "losten",
            "email": "lolo@gmail.com"
          });
        var requestOptions = {
            method: 'POST',
            headers: headerReq,
            body: raw,
            redirect: 'follow'
          };
          
        fetch("http://127.0.0.1:8080/api/v1/user/", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error))
        
      //})
       /*.then(res => {
        console.log(res)
        return res.json();
       })
       .then(json => {
            console.log(json)
            response=json.posts; 
        }).catch(err => console.log("err: "+err));*/
       return "response";
    }
}

export default UserService;