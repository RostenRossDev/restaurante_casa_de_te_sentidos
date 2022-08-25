import React from 'react';

function Post({comment, username, date}) {
    return (     
        <div className='row post'>
            <div className='postContainer '>   
                <p className="comentarios ">
                    <span className="comentario">{username}: {comment}</span>
                </p>
            </div>
            <div className='postDate'>
                {date}
            </div>
            <div className='linea'></div>
        </div>
    )
}

export default Post;