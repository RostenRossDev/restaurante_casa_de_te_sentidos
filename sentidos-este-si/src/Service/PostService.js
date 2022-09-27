const baseLocal="http://127.0.0.1:8080";
const baseWweb="https://sentidos-backend.herokuapp.com";
const base= baseWweb;
const url = `${base}/api/v1/post/`;

const PostService = {
    getPost : async () =>{
        let response;
       await fetch(url)
       .then(res => res.json())
       .then(json => {
            response=json.posts; 
        }).catch(err => console.log("err: "+err));
       return response;
    },
    sendPost : async (message) =>{
        const token = sessionStorage.getItem("token")
        const username = sessionStorage.getItem("username");

        var myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer "+token);
        myHeaders.append("Content-Type", "application/json");

        var raw = JSON.stringify({
            "comment":message,
            "user": username
        });

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };

        return await fetch(url, requestOptions)
       .then(res => res)       
        .catch(err => console.log("err: "+err));
    }
}



export default PostService;