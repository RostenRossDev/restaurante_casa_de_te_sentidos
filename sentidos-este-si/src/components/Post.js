import React from 'react';

function Post({comment, username, date}) {
    return (     
               
        <div className='row post'>
            <div className='postContainer testimonial' style={{"alignSelf":"start"}}>   
                <p className="comentarios" style={{"alignSelf":"start","marginTop":"10px"}}>
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

/*

 <div className="testimonial">            
            <p>
              He Printing and Typesetting the industry. <span>Lorem Ipsum</span>{" "}
              has been the Industry's
            </p>
          </div>

          <div className="testimonial">            
            <p>
              He Printing and Typesetting the industry. <span>Lorem Ipsum</span>{" "}
              has been the Industry's
            </p>
          </div>
          <div className="testimonial">
            
            <p>
              He Printing and Typesetting the industry. <span>Lorem Ipsum</span>{" "}
              has been the Industry's
            </p>
          </div>
*/