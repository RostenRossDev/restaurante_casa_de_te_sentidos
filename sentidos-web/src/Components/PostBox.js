import { useEffect, useState } from "react";
import PostService from "../Service/PostService";
import Post from "./Post";

function PostBox() {
    const  [posts, setPosts] = useState([{"user":"mensaje","comment":"No hay comentarios"}]);

    useEffect(()=>{
        PostService.getPost().then(res =>{
            setPosts(res);
            console.log(res)
        });
        console.log(posts)

    },[]);

    return(
        <div className="text-start chat" style={{"marginTop":"10px", "marginLeft":"10px","marginRight":"10px","paddingTop":"10px"}}>
            {posts.map(p=><Post comment={p.comment} username={p.user} />)}
        </div> 
    )
}

export default PostBox;
