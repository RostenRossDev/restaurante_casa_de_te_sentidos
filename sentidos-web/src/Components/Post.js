import React from 'react';

function Post({comment, username}) {

    return (
        
        <p className="comentarios"><span className="username-coment">{username}: </span> {comment}</p>
        
    )
}

export default Post;