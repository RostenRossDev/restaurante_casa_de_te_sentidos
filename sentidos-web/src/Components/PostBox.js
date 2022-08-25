import { useEffect, useState } from "react";
import PostService from "../Service/PostService";
import Post from "./Post";

function PostBox({comments}) {
    const  [posts, setPosts] = useState([{"user":"mensaje","comment":"No hay comentarios"}]);

    useEffect(()=>{
        PostService.getPost().then(res =>{
            setPosts(res);
            console.log(res)
        });
        console.log(posts)

    },[]);
    console.log(comments.createAt)
    return(
        <div className="text-start chat" style={{"marginTop":"10px", "marginLeft":"10px","marginRight":"10px","paddingTop":"10px"}}>
            {comments.map(p=><Post comment={p.comment} username={p.user} date={p.createAt}/>)}
        </div> 
    )
}

export default PostBox;
