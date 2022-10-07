import React, { useEffect, useState } from "react";
import styled from "styled-components";
import { imageZoomEffect, TitleStyles } from "./ReusableStyles";
import Post from "./Post";
import PostService from "../Service/PostService";

export default function Testimonials() {
  const  [comments, setComments] = useState([]);

  useEffect(()=>{
    PostService.getPost().then(res =>{
        setComments([...res].reverse());
        console.log(res)
    });
    console.log(comments)

  },[]);

  return (
    <Section id="testimonials">
      <div className="container">
      
        <div className="title">
          <h1>
            <span>Deja</span> tu comentario
          </h1>          
        </div>

        <div className="testimonials text-start chat" style={{"marginTop":"10px", "marginLeft":"10px","marginRight":"10px","paddingTop":"10px","display":"block"}}>

          {comments.map(p=><Post comment={p.comment} username={p.user} date={p.createAt}/>)}        
        
        </div>
      </div>
    </Section>
  );
}

const Section = styled.section`
  margin: 5vw;
  background: linear-gradient(to right, #fc4958, #CC99CC);
  padding: 0.2rem;
  border-radius: 1.5rem;
  position: relative;
  .container {
    margin-top: 0.5rem;
    margin-bottom: 0.5rem;
    padding-top: 1vw;
    padding-bottom: 4vw;
    background-color: white;
    border-radius: 1rem;
    ${TitleStyles};
    .title {
      position: absolute;
      top: -1rem;
      left: 25%;
      padding: 0 2rem;
      background-color: white;
    }
    .testimonials {
      display: flex;
      justify-content: space-between;
      align-items: center;
      gap: 6vw;
      margin-top: 3vw;
      .testimonial {
        padding: 0 4vw;
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align: center;
        gap: 1rem;
        p {
          font-size: 1.1rem;
          line-height: 2rem;
          letter-spacing: 0.1rem;
          span {
            color: #fc4958;
          }
        }
        ${imageZoomEffect};
        .image {
          overflow: hidden;
          width: max-content;
          max-height: 10rem;
          border-radius: 10rem;
          img {
            height: 10rem;
          }
        }
      }
    }
  }
  @media screen and (min-width: 260px) and (max-width: 1080px) {
    .container {
      .title {
        position: initial;
        background-color: transparent;
      }
      .testimonials {
        flex-direction: column;
      }
    }
  }
`;
