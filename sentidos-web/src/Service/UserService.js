import { encode } from "base-64";
const urlLogin = "http://127.0.0.1:8080/oauth/token";
const urlRegister = "http://127.0.0.1:8080/api/v1/user/";
const usernameApp ="reactSentidosApp";
const passwordApp ="sentidos3399";

const UserService = {
    getToken : async  function (username, password) {
        let response;
        const bodyReq ={           
            'username': "RostenRoss",
            'password': "12345",
            'grant_type':"password"
          
        }
        const headerReq = new Headers();
        headerReq.append('Authorization', 'Basic cmVhY3RTZW50aWRvc0FwcDpzZW50aWRvczMzOTk=');
        headerReq.append('Content-Type', 'application/x-www-form-urlencoded'); 
              
        await fetch(urlLogin,{
        'method': 'post',     
        body: JSON.stringify(bodyReq),   
        header: headerReq
      })
       .then(res => {
        console.log(res)
        return res.json();
       })
       .then(json => {
            console.log(json)
            response=json.posts; 
        }).catch(err => console.log("err: "+err));
       return response;
    }
}

export default UserService;