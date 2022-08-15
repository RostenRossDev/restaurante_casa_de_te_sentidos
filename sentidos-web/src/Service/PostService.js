const url = "http://127.0.0.1:8080/api/v1/post/";

const PostService = {
    getPost : async () =>{
        let response;
       await fetch(url)
       .then(res => res.json())
       .then(json => {
            response=json.posts; 
        }).catch(err => console.log("err: "+err));
       return response;
    }
}

export default PostService;