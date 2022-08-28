import img1 from "../../img/imagen1.jpg"
import img2 from "../../img/imagen2.jpg"
import img3 from "../../img/imagen3.jpg"
import img4 from "../../img/imagen4.jpg"
import img5 from "../../img/imagen5.jpg"
import img6 from "../../img/imagen6.jpg"
import img7 from "../../img/imagen7.jpg"
import img8 from "../../img/imagen8.jpg"
import img10 from "../../img/imagen10.jpg"
import logo from "../../img/sentidos_logo.png"
import PostBox from "../../Components/PostBox"
import StikyMenu from "../../Components/StikyMenu"
import { useCallback, useContext, useEffect, useRef, useState } from "react"
import Context from "../../context/userContext"
import UserService from "../../Service/UserService"
import Menu from "../../Components/Menu"
import defaultUser from '../../img/default.png'
import PostService from "../../Service/PostService"

function useForceUpdate(){
    const [value, setValue] = useState(0); // integer state
    return () => setValue(value => value + 1); // update state to force render
    // An function that increment 👆🏻 the previous state like here 
    // is better than directly setting `value + 1`
}
function Home() {
    const context = useContext(Context);
    const [user, setUser] = useState(context.user);
    const [token, setToken]=useState(user.token);
    const [loged, setLoged] =useState(user.loged);
    const refPostValue = useRef("");
    const [photo, setPhoto] = useState(sessionStorage.getItem("photo"))
    const [username, setUsername] = useState(sessionStorage.getItem("username"))
    const [comments, setComments] = useState([]);
    

    useEffect(()=>{        
        if(sessionStorage.getItem("token")!== false){
            setToken(sessionStorage.getItem("token"))
            setUser({...user,token:sessionStorage.getItem("token")})
        }

        if(sessionStorage.getItem("photo") !== ""){
            setPhoto(sessionStorage.getItem("photo"))
            setUser({...user,photo:sessionStorage.getItem("photo")})

        }
        if(sessionStorage.getItem("username") !== ""){
            setUsername(sessionStorage.getItem("username"))
            setUser({...user,username:sessionStorage.getItem("username")})
        }       
 
        if(sessionStorage.getItem("token")!== false && sessionStorage.getItem("username") !== ""){          
            getData()     
        }
    },[]);

    useEffect(()=>{
        PostService.getPost().then(res =>{
            setComments([...res].reverse());
            console.log(res)
        });
        console.log(comments)

    },[]);
    //useEffect(()=>{sessionStorage.setItem("token", JSON.stringify(token))},[token]);
    useEffect(()=>{
        const data = UserService.getUserDate(token, username)
        setPhoto(data.photo)
    },[user]);
    
    const getData = async ()=>{
        const userDateRes = await UserService.getUserDate(sessionStorage.getItem("token"), setUsername(sessionStorage.getItem("username")));
        //setUser({username: username, token:token, name:userDateRes.name, lastname:userDateRes.lastname, loged:true, photo: userDateRes.photo, email: userDateRes.email})
        console.log(userDateRes.email)
        setPhoto(await userDateRes.photo)
    }
    const login =async (login, pass)=>{
        const res = await UserService.getTokenByAxios(login, pass);

        if(res.status===200){            

            setUsername(await res.data.username)
            setToken(res.data.access_token)
            setLoged(true)
            //window.sessionStorage.setItem("token",res.data.access_token)
            //window.sessionStorage.setItem("username",res.data.username)

            const userDateRes = await UserService.getUserDate(res.data.access_token, res.data.username);

            setUser({username: res.data.username, name:userDateRes.name, lastname:userDateRes.lastname, loged:true, token:res.data.access_token, photo: userDateRes.photo, email: userDateRes.email})

            setPhoto(await userDateRes.photo)
        }       
    }

    const sendPost =()=>{
        const send = async () =>{
            const postMessage = refPostValue.current.value;
            const post = await PostService.sendPost(postMessage)
            if(post.status === 200){
                const getPost = await PostService.getPost().then(res =>{
                    setComments(res.reverse());
                });
                getPost();
            }
        }

        send()
        
    }

    const updatePhoto =async (value) =>{
        setUser({...user, photo:await value})
    }

    const clear =()=>{
        sessionStorage.clear()
        window.location.reload();
        setUser({ user: {username:"",token:false,loged:false, name:"", lastname:"", email:"",photo:null}, setUser: () => {} })
    }
    return (        
        <div className="home">
            {(token !==false  && token !==null)? <Menu clear={clear} updatePhoto={updatePhoto} username={user.username} name={user.name} lastname={user.lastname} email={user.email} token={token} id={1} photo={user.photo}/> : null}
            
            {(token === false || token ===null)? <StikyMenu loginService={login}/> : null}
            
            <div className="main container col-md-12 col-sm-12">
                <div className="card text-bg-dark">
                    <img src={img1} className="card-img imgBlurHov" alt="...." />
                    <div className="card-img-overlay">
                        <p className="text-center titulo"> <span>Sentidos</span> restaurante y casa de té</p>
                        <div className="container logo">
                            <img src={logo}/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div className="main container col-md-12 col-sm-12">
                <div className="row row-cols-1 row-cols-md-4 row-cols-sm-4 menu">
                    <div className="col text-center align-bottom blurHover">
                            <div className="card text-bg-dark">
                                <img src={img7} className="card-img imgBlurHov" alt="..." />
                                <div className="card-img-overlay">
                                    <p className="titulo-menu">Eventos Corporativos</p>
                                </div>
                            </div>
                        </div>
                        <div className="col text-center align-bottom blurHover" >
                            <div className="card text-bg-dark">
                            <img src={img8} className="card-img imgBlurHov" alt="..." />
                                <div className="card-img-overlay">
                                    <p className="titulo-menu">Reservar Mesa</p>
                                </div>
                            </div>
                        </div>
                        <div className="col text-center align-bottom blurHover">
                            <div className="card text-bg-dark">
                            <img src={img5} className="card-img imgBlurHov" alt="..." />
                                <div className="card-img-overlay">
                                    <p className="titulo-menu">Delivery</p>
                                </div>
                            </div>
                        </div>
                        <div className="col text-center align-bottom blurHover">
                            <div className="card text-bg-dark">
                                <img src={img6} className="card-img imgBlurHov" alt="..." />
                                <div className="card-img-overlay">
                                    <p className="titulo-menu">Menu</p>
                                </div>
                            </div>
                        </div>
                    </div>                
                </div>
            <div className="container col-md-12 col-sm-12">
                <div className="card text-bg-dark text-center justify-content-center" >
                    <img src={img4} className="card-img imgBlur" alt="..."  />
                    <div className="card-img-overlay container borde">
                        <h3 className="card-title">Sentidos</h3>
                        <h4>Restaurante y casa de té</h4>                        
                    </div>
                </div>
            </div>
            <div className="container col-md-12 col-sm-12">
                    <div className=" card text-bg-dark text-center justify-content-center opiniones">
                        <PostBox comments={comments}/>
                        {console.log("session token "+sessionStorage.getItem("token"))}
                        {console.log("token "+token)}
                        { token!==null?                      
                        <div className="cajaTexto">
                            <textarea className="form-control" aria-label="With textarea" ref={refPostValue}></textarea>
                            
                            <button className="btn btn-primary" style={{"marginTop":"10px", "marginBottom":"10px"}} onClick={sendPost}>Comentar</button>                                                    
                        </div> :null 
                        }                   
                    </div>
            </div>
           
        </div>
    );
}

export default Home;

