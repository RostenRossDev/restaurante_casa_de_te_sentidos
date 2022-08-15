import { encode } from "base-64";
const urlLogin = "http://127.0.0.1:8080/auth/token";
const urlRegister = "http://127.0.0.1:8080/api/v1/user";
const usernameApp ="reactSentidosApp";
const passwordApp ="sentidos3399";
const UserService = {
    createUser : async (username, password) =>{
        let response;
       await fetch(urlRegister,{
        method: 'post',
        headers: new Headers({
          'Authorization': 'Basic ' + encode(usernameApp + ":" + passwordApp),
          'Content-Type': 'application/json'
        }),
        body: JSON.stringify({
          "username": "RostenRoss",
          "password": "12345",
          "grant_type":"password"
        })
      })
       .then(res => res.json())
       .then(json => {
            response=json.posts; 
        }).catch(err => console.log("err: "+err));
       return response;
    }
}

export default UserService;