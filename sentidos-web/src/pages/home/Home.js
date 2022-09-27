import img1 from "../../img/imagen1.jpg"
import img2 from "../../img/imagen2.jpg"
import img3 from "../../img/imagen3.jpg"
import img4 from "../../img/imagen4.jpg"
import img5 from "../../img/imagen5.jpg"
import img6 from "../../img/imagen6.jpg"
import img7 from "../../img/imagen7.jpg"
import img10 from "../../img/imagen10.jpg"
import logo from "../../img/sentidos_logo.png"
import PostBox from "../../Components/PostBox"
//import StikyMenu from "../../Components/StikyMenu"
import { useCallback, useContext, useEffect, useRef, useState } from "react"
import Context from "../../context/userContext"
import UserService from "../../Service/UserService"
//import Menu from "../../Components/Menu"
import defaultUser from '../../img/default.png'
import PostService from "../../Service/PostService"
import Reservation from "../../Components/Reservation"
//import Footer from "../../Components/Footer"
import { Link } from "react-router-dom"

//imagenes
import bannerForeground4 from  "../../static/images/banner/foreground-04-1600x60.png" ;
import warning_bar from  "../../static/images/ie8-panel/warning_bar_0000_us.jpg"; 
import logoDefault from "../../static/images/logo-default1-140x57.png"; 
import homeImg from "../../static/images/home-3-1-483x327.jpg";
import homeImg2 from "../../static/images/home-3-2-341x391.png";
import signature from "../../static/images/signature-1-140x50.png"  ;
import product1 from "../../static/images/product-1-370x395.jpg" ;
import product2 from "../../static/images/product-2-370x395.jpg";
import product3 from "../../static/images/product-3-370x395.jpg";
import galleryMasonry from "../../static/images/gallery-masonry-1-640x429.jpg";
import galleryMasonry5 from "../../static/images/gallery-masonry-5-960x429.jpg";
import galleryMasonry3 from "../../static/images/gallery-masonry-3-640x429.jpg" ;
import galleryMasonry2 from "../../static/images/gallery-masonry-2-640x429.jpg";
import galleryMasonry4 from "../../static/images/gallery-masonry-4-960x429.jpg";
import bannerForeground3 from "../../static/images/banner/foreground-03-1600x310.png" ;
import logoDefault2 from "../../static/images/logo-default1-140x57.png";

import foreground04_1600 from "../../static/images/banner/foreground-04-1600x60.png";
import froreground04_3200 from "../../static/images/banner/foreground-04-3200x120.png";
import logoDefault_280 from "../../static/images/logo-default-280x113.png";  
import foreground03_1600 from "../../static/images/banner/foreground-03-1600x310.png"
import foreground03_3200 from "../../static/images/banner/foreground-03-3200x620.png"


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

    return(
        <>
             <div className="ie-panel"><Link to="http://windows.microsoft.com/en-US/internet-explorer/"><img src={warning_bar} height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." /></Link></div>
    <div className="preloader">
      <div className="preloader-body">
        <div className="cssload-container">
          <div className="cssload-speeding-wheel"></div>
        </div>
        <p>Loading...</p>
      </div>
    </div>
    <div className="page"><Link className="section section-banner d-none d-xl-flex" to="https://www.templatemonster.com/website-templates/monstroid2.html" style={{
  backgroundImage: [
    'url(images/banner/background-04-1920x60.jpg)',
    '-webkit-image-set( url(images/banner/background-04-1920x60.jpg) 1x, url(images/banner/background-04-3840x120.jpg) 2x )'
  ]
}}><img src={bannerForeground4} srcSet={`${foreground04_1600} 1x, ${froreground04_3200} 2x`} alt="" width="1600" height="310" /></Link>
      {/*Page Header*/}
      <header className="section page-header">
        {/*RD Navbar*/}
        <div className="rd-navbar-wrap">
          <nav className="rd-navbar rd-navbar-classNameic" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fixed" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-static" data-xl-layout="rd-navbar-static" data-xl-device-layout="rd-navbar-static" data-lg-stick-up-offset="46px" data-xl-stick-up-offset="46px" data-xxl-stick-up-offset="46px" data-lg-stick-up="true" data-xl-stick-up="true" data-xxl-stick-up="true">
            <div className="rd-navbar-main-outer">
              <div className="rd-navbar-main">
                {/*RD Navbar Panel*/}
                <div className="rd-navbar-panel"> 
                  {/*RD Navbar Toggle*/}
                  <button className="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>                
                  {/*RD Navbar Brand*/}
                  <div className="rd-navbar-brand"><Link to="index.html"><img className="brand-logo-light" src={logoDefault} alt="" width="140" height="57" srcSet={`${logoDefault_280} 2x`}/></Link></div>
                </div>
                <div className="rd-navbar-main-element">
                  <div className="rd-navbar-nav-wrap">
                    
                    {/*RD Navbar Nav*/}
                    <ul className="rd-navbar-nav">
                      <li className="rd-nav-item active"><Link className="rd-nav-link" to="index.html">Home</Link>
                      </li>
                      <li className="rd-nav-item"><Link className="rd-nav-link" to="about-us.html">About</Link>
                      </li>
                      <li className="rd-nav-item"><Link className="rd-nav-link" to="typography.html">Typography</Link>
                      </li>
                      <li className="rd-nav-item"><Link  className="rd-nav-link" to="contacts.html">Contacts</Link>
                      </li>
                    </ul><Link className="button button-white button-sm" to="#">book now</Link>
                  </div>
                </div><Link className="button button-white button-sm" to="#">book now</Link>
              </div>
            </div>
          </nav>
        </div>
      </header>
      {/*Swiper */}
      <section className="section section-lg section-main-bunner section-main-bunner-filter text-center">
        <div className="main-bunner-img" style={{
            backgroundImage: 'url(&quot;images/bg-bunner-2.jpg&quot;)',
            backgroundSize: 'cover'
        }}>

</div>
        <div className="main-bunner-inner">
          <div className="container">
            <div className="box-default">
              <h1 className="box-default-title">Welcome</h1>
              <div className="box-default-decor"></div>
              <p className="big box-default-text">Our restaurant offers full-service dining with breathtaking views seen from our indoor covered patio and our outdoor sundeck.</p>
            </div>
          </div>
        </div>
      </section>
      <div className="bg-gray-1">
        <section className="section-transform-top">
          <div className="container">
            <div className="box-booking">
              <form className="rd-form rd-mailform booking-form">
                <div>
                  <p className="booking-title">Name</p>
                  <div className="form-wrap">
                    <input className="form-input" id="booking-name" type="text" name="name" data-constraints="@Required" />
                    <label className="form-label" htmlFor="booking-name">Your name</label>
                  </div>
                </div>
                <div>
                  <p className="booking-title">Phone</p>
                  <div className="form-wrap">
                    <input className="form-input" id="booking-phone" type="text" name="phone" data-constraints="@Numeric" />
                    <label className="form-label" htmlFor="booking-phone">Your phone number</label>
                  </div>
                </div>
                <div>
                  <p className="booking-title">Date</p>
                  <div className="form-wrap form-wrap-icon"><span className="icon mdi mdi-calendar-text"></span>
                    <input className="form-input" id="booking-date" type="text" name="date" data-constraints="@Required" data-time-picker="date" />
                  </div>
                </div>
                <div>
                  <p className="booking-title">no. of people</p>
                  <div className="form-wrap">
                    <select data-placeholder="2">
                      <option label="placeholder"></option>
                      <option>1</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
                      <option>6</option>
                      <option>7</option>
                    </select>
                  </div>
                </div>
                <div>
                  <button className="button button-lg button-gray-600" type="submit">Check availability</button>
                </div>
              </form>
            </div>
          </div>
        </section>
        <section className="section section-lg section-inset-1 bg-gray-1 pt-lg-0">
          <div className="container">
            <div className="row row-50 justify-content-xl-between align-items-lg-center">
              <div className="col-lg-6 wow fadeInLeft">
                <div className="box-image"><img className="box-image-static" src={homeImg} alt="" width="483" height="327"/><img className="box-image-position" src={homeImg2} alt="" width="341" height="391"/>
                </div>
              </div>
              <div className="col-lg-6 col-xl-5 wow fadeInRight">
                <h2>About Us</h2>
                <p>Pesto is a family owned and operated Italian Restaurant offering a combination of fresh ingredients and authentic Italian cooking.</p>
                <p>We will make sure you are served the most authentic and fresh Italian dishes, while offering the best customer service. Our kitchen is committed to providing our guests with the best Italian Cuisine.</p><img src={signature} alt="" width="140" height="50"/>
              </div>
            </div>
          </div>
        </section>
      </div>
      {/*Featured Offers */}
      <section className="section section-lg bg-default">
        <div className="container">
          <div className="row justify-content-center text-center">
            <div className="col-md-9 col-lg-7 wow-outer">
              <div className="wow slideInDown">
                <h2>Featured Offers</h2>
                <p className="text-opacity-80">We offer a great variety of  the best Italian dishes to our visitors and guests. Below are some of our most popular main dishes and desserts.</p>
              </div>
            </div>
          </div>
          <div className="row row-20 row-lg-30">
            <div className="col-md-6 col-lg-4 wow-outer">
              <div className="wow fadeInUp">
                <div className="product-featured">
                  <div className="product-featured-figure"><img src={product1} alt="" width="370" height="395"/>
                    <div className="product-featured-button"><Link className="button button-primary" to="#">order now</Link></div>
                  </div>
                  <div className="product-featured-caption">
                    <h4><Link className="product-featured-title" to="#">Ravioli</Link></h4>
                    <p className="big">$8</p>
                  </div>
                </div>
              </div>
            </div>
            <div className="col-md-6 col-lg-4 wow-outer">
              <div className="wow fadeInUp">
                <div className="product-featured">
                  <div className="product-featured-figure"><img src={product2} alt="" width="370" height="395"/>
                    <div className="product-featured-button"><Link className="button button-primary" to="#">order now</Link></div>
                  </div>
                  <div className="product-featured-caption">
                    <h4><Link className="product-featured-title" to="#">Black Pasta</Link></h4>
                    <p className="big">$13</p>
                  </div>
                </div>
              </div>
            </div>
            <div className="col-md-6 col-lg-4 wow-outer">
              <div className="wow fadeInUp">
                <div className="product-featured">
                  <div className="product-featured-figure"><img src={product3} alt="" width="370" height="395"/>
                    <div className="product-featured-button"><Link className="button button-primary" to="#">order now</Link></div>
                  </div>
                  <div className="product-featured-caption">
                    <h4><Link className="product-featured-title" to="#">Gelato</Link></h4>
                    <p className="big">$4</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section className="section section-lg bg-gray-1">
        <div className="container">
          <h2 className="text-center">Our Restaurant Menu</h2>
          <div className="row">
            <div className="col-12">
              <div className="tabs-custom tabs-horizontal tabs-classNameic" id="tabs-1">
                <ul className="nav nav-tabs nav-tabs-classNameic">
                  <li className="nav-item" role="presentation"><Link className="nav-link active" to="#tabs-1-1" data-toggle="tab">mains</Link></li>
                  <li className="nav-item" role="presentation"><Link className="nav-link" to="#tabs-1-2" data-toggle="tab">Desserts</Link></li>
                  <li className="nav-item" role="presentation"><Link className="nav-link" to="#tabs-1-3" data-toggle="tab">drinks</Link></li>
                </ul>
                <div className="tab-content">
                  <div className="tab-pane fade show active" id="tabs-1-1">
                    <div className="box-event-modern">
                      <div className="event-item-modern">
                        <p className="event-time">$25.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Osso Buco</Link></h4>
                        <div className="event-item-modern-text">
                          <p>Osso Buco is one of the Italian greats - slow cooked veal in a white wine tomato sauce. Meltingly tender, this is both hearty and luxurious.</p>
                        </div>
                      </div>
                      <div className="event-item-modern">
                        <p className="event-time">$16.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Pappardelle Mimmo</Link></h4>
                        <div className="event-item-modern-text">
                          <p>This delicious dish tops long, wide pasta with scallops, lobster, asparagus, butter, sage and truffle oil to cater every palate.</p>
                        </div>
                      </div>
                      <div className="event-item-modern">
                        <p className="event-time">$17.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Trippa Satriano</Link></h4>
                        <div className="event-item-modern-text">
                          <p>Thinly sliced herb encrusted ahi tuna topped with diced tomatoes, olives, capers, red onions and fennel. Perfect choice even for the first-time visitors!</p>
                        </div>
                      </div>
                      <div className="event-item-modern">
                        <p className="event-time">$18.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Filetto Di Manzo</Link></h4>
                        <div className="event-item-modern-text">
                          <p>Wonderful combination of prime tenderloin, winter greens, Jerusalem artichoke puree, and oxtail reduction sauce.</p>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div className="tab-pane fade" id="tabs-1-2">
                    <div className="box-event-modern">
                      <div className="event-item-modern">
                        <p className="event-time">$20.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Tiramisu</Link></h4>
                        <div className="event-item-modern-text">
                          <p>A Pesto’s favorite - classNameic Italian dessert made with lady fingers, Mascarpone cheese & espresso. Perfect for both kids and adults.</p>
                        </div>
                      </div>
                      <div className="event-item-modern">
                        <p className="event-time">$6.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Cannoli</Link></h4>
                        <div className="event-item-modern-text">
                          <p>Trio tower of cannoli filled with smooth ricotta, sugar & cinnamon, with chocolate & raspberry sauces. Single cannoli is also available.</p>
                        </div>
                      </div>
                      <div className="event-item-modern">
                        <p className="event-time">$5.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Pistachio Passion</Link></h4>
                        <div className="event-item-modern-text">
                          <p>Layered pistachio cream, cream cheese custard & whipped cream atop a rich walnut crust.</p>
                        </div>
                      </div>
                      <div className="event-item-modern">
                        <p className="event-time">$4.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Chocolate-and-Pistachio Biscotti</Link></h4>
                        <div className="event-item-modern-text">
                          <p>At Pesto, we vary these wonderful nutty biscotti, while also dipping them in melted dark chocolate for an extra layer of flavor.</p>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div className="tab-pane fade" id="tabs-1-3">
                    <div className="box-event-modern">
                      <div className="event-item-modern">
                        <p className="event-time">$10.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Aperol Spritz</Link></h4>
                        <div className="event-item-modern-text">
                          <p>The most popular drink in Venice: refreshing, easygoing &…happy! Perfect to be sipped as an “Aperitivo” just before dinner - delightful!</p>
                        </div>
                      </div>
                      <div className="event-item-modern">
                        <p className="event-time">$9.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Negroni</Link></h4>
                        <div className="event-item-modern-text">
                          <p>Reward yourself with a moment of relaxation & pure pleasure while enjoying the full flavour & simplicity of a Negroni, an iconic Italian cocktail.</p>
                        </div>
                      </div>
                      <div className="event-item-modern">
                        <p className="event-time">$11.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">Negroni Sbagliato</Link></h4>
                        <div className="event-item-modern-text">
                          <p>A cocktail for those who prefer more delicate flavours but nonetheless want a drink full of taste & personality.</p>
                        </div>
                      </div>
                      <div className="event-item-modern">
                        <p className="event-time">$8.89</p>
                        <h4 className="event-item-modern-title"><Link to="#">White Peach Bellini</Link></h4>
                        <div className="event-item-modern-text">
                          <p>White Peach Bellini is a classNameic drink from Venice Italy of white peach purée and Prosecco. It is one of our most popular drinks at Pesto.</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section className="section">
        <div className="row isotope-wrap">
          {/*Isotope Content */}
          <div className="col-lg-12">
            <div className="isotope" data-isotope-layout="fitRows" data-isotope-group="gallery" data-lightgallery="group" data-lg-thumbnail="false">
              <div className="row no-gutters row-condensed">
                <div className="col-12 col-sm-6 col-md-4 isotope-item wow-outer" data-filter="*">
                  <div className="wow slideInDown">
                    <div className="gallery-item-classNameic"><img src={galleryMasonry} alt="" width="640" height="429"/>
                      <div className="gallery-item-classNameic-caption"><Link to="images/gallery-masonry-1-original.jpg" data-lightgallery="item">zoom</Link></div>
                    </div>
                  </div>
                </div>
                <div className="col-12 col-sm-6 col-md-4 isotope-item wow-outer" data-filter="Category 3">
                  <div className="wow slideInDown">
                    <div className="gallery-item-classNameic"><img src={galleryMasonry2} alt="" width="640" height="429"/>
                      <div className="gallery-item-classNameic-caption"><Link to="images/gallery-masonry-2-original.jpg" data-lightgallery="item">zoom</Link></div>
                    </div>
                  </div>
                </div>
                <div className="col-12 col-md-4 isotope-item wow-outer" data-filter="Category 3">
                  <div className="wow slideInDown">
                    <div className="gallery-item-classNameic"><img src={galleryMasonry3}alt="" width="640" height="429"/>
                      <div className="gallery-item-classNameic-caption"><Link to="images/gallery-masonry-3-original.jpg" data-lightgallery="item">zoom</Link></div>
                    </div>
                  </div>
                </div>
                <div className="col-12 col-sm-12 col-md-6 isotope-item wow-outer" data-filter="Category 3">
                  <div className="wow fadeInUp">
                    <div className="gallery-item-classNameic"><img src={galleryMasonry4} alt="" width="960" height="429"/>
                      <div className="gallery-item-classNameic-caption"><Link to="images/gallery-masonry-4-original.jpg" data-lightgallery="item">zoom</Link></div>
                    </div>
                  </div>
                </div>
                <div className="col-12 col-sm-12 col-md-6 isotope-item wow-outer" data-filter="Category 2">
                  <div className="wow fadeInUp">
                    <div className="gallery-item-classNameic"><img src={galleryMasonry5} alt="" width="960" height="429"/>
                      <div className="gallery-item-classNameic-caption"><Link to="images/gallery-masonry-5-original.jpg" data-lightgallery="item">zoom</Link></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section className="section-lg bg-default">
        <div className="container wow-outer">
          <h2 className="text-center wow slideInDown">Recent News</h2>
         
          {/*Owl Carousel */}
          <div className="owl-carousel wow fadeInUp" data-items="1" data-md-items="2" data-lg-items="3" data-dots="true" data-nav="false" data-stage-padding="15" data-loop="false" data-margin="30" data-mouse-drag="false">
            <div className="post-corporate"><Link className="badge" to="#">Jul 02, 2019</Link>
              <h4 className="post-corporate-title"><Link to="#">Genuine Italian Pizza: Authenticity and Choice</Link></h4>
              <div className="post-corporate-text">
                <p>As an Italian restaurant, we are very proud of our delicious authentic pizzas. Our three most popular choices are the Rustica, the Toscana and...</p>
              </div><Link className="post-corporate-link" to="#">Read more<span className="icon linearicons-arrow-right"></span></Link>
            </div>
            <div className="post-corporate"><Link className="badge" to="#">Jul 12, 2019</Link>
              <h4 className="post-corporate-title"><Link to="#">Italian vs. American Spaghetti: Top 5 Differences</Link></h4>
              <div className="post-corporate-text">
                <p>Commonly, when we hear there is spaghetti for dinner we will be expecting a red tomato sauce with meat and seasonings poured over long...</p>
              </div><Link className="post-corporate-link" to="#">Read more<span className="icon linearicons-arrow-right"></span></Link>
            </div>
            <div className="post-corporate"><Link className="badge" to="#">aug 02, 2019</Link>
              <h4 className="post-corporate-title"><Link to="#">The Delicious History of Lasagna and Its Origins</Link></h4>
              <div className="post-corporate-text">
                <p>Lasagna, could there be a more perfect dish? It’s comfort food on steroids. Layers of cheese generously piled on top of decadent amounts...</p>
              </div><Link className="post-corporate-link" to="#">Read more<span className="icon linearicons-arrow-right"></span></Link>
            </div>
            <div className="post-corporate"><Link className="badge" to="#">Aug 15, 2019</Link>
              <h4 className="post-corporate-title"><Link to="#">Making Gelato Like a True Italian: Tips From Our Chef</Link></h4>
              <div className="post-corporate-text">
                <p>Most would agree that gelato is the most delicious frozen dessert; the perfect ending to any meal. With origins in Sicily, gelato has been made famous...</p>
              </div><Link className="post-corporate-link" to="#">Read more<span className="icon linearicons-arrow-right"></span></Link>
            </div>
            <div className="post-corporate"><Link className="badge" to="#">Sep 15, 2019</Link>
              <h4 className="post-corporate-title"><Link to="#">Italian Ingredients You Can Easily Grow at Home</Link></h4>
              <div className="post-corporate-text">
                <p>Imagine preparing an Italian dinner but having to stop cooking because you forget an ingredient and must run to the store. How nice would it be to go...</p>
              </div><Link className="post-corporate-link" to="#">Read more<span className="icon linearicons-arrow-right"></span></Link>
            </div>
            <div className="post-corporate"><Link className="badge" to="#">Sep 28, 2019</Link>
              <h4 className="post-corporate-title"><Link to="#">Our Brief Guide to Pairing Wine and Pasta the Right Way</Link></h4>
              <div className="post-corporate-text">
                <p>To Italians, pasta is the food of the gods, and there is nothing better to go with a good pasta than a perfect wine. To the uninitiated, finding the right...</p>
              </div><Link className="post-corporate-link" to="#">Read more<span className="icon linearicons-arrow-right"></span></Link>
            </div>
            <div className="post-corporate"><Link className="badge" to="#">Oct 05, 2019</Link>
              <h4 className="post-corporate-title"><Link to="#">Top 10 Famous Spring Dishes in Italian Restaurants</Link></h4>
              <div className="post-corporate-text">
                <p>Spring is the time for growth and rebirth. One can see this throughout the countrysides of Italy with blooming flowers and budding trees. Springtime is...</p>
              </div><Link className="post-corporate-link" to="#">Read more<span className="icon linearicons-arrow-right"></span></Link>
            </div>
            <div className="post-corporate"><Link className="badge" to="#">Oct 17, 2019</Link>
              <h4 className="post-corporate-title"><Link to="#">What Makes Some Seasonings Truly Italian?</Link></h4>
              <div className="post-corporate-text">
                <p>When thinking of Italian cuisine, dishes like pasta enveloped in hearty sauces come to mind. Certain flavors seem to be found across the different...</p>
              </div><Link className="post-corporate-link" to="#">Read more<span className="icon linearicons-arrow-right"></span></Link>
            </div>
            <div className="post-corporate"><Link className="badge" to="#">Nov 10, 2019</Link>
              <h4 className="post-corporate-title"><Link to="#">Types of Italian Sausage and Why They Are Different</Link></h4>
              <div className="post-corporate-text">
                <p>There are many types of Italian sausage. The main difference in Italian sausage when compared to other sausages is the seasoning. The particular...</p>
              </div><Link className="post-corporate-link" to="#">Read more<span className="icon linearicons-arrow-right"></span></Link>
            </div>
          </div>
        </div>
      </section>
        <Link className="section section-banner" to="https://www.templatemonster.com/website-templates/monstroid2.html" style={{
  backgroundImage: [
    'url(images/banner/background-03-1920x310.jpg)',
    '-webkit-image-set( url(images/banner/background-03-1920x310.jpg) 1x, url(images/banner/background-03-3840x620.jpg) 2x )'
  ]
}}>
            <img src={bannerForeground3} srcSet={`${foreground03_1600} 1x, ${foreground03_3200} 2x`} alt="" width="1600" height="310" />
        </Link>
      {/* Page Footer*/}
      <footer className="section footer-minimal context-dark">
        <div className="container wow-outer">
          <div className="wow fadeIn">
            <div className="row row-60">
              <div className="col-12"><Link to="index.html"><img src={logoDefault2} alt="" width="140" height="57" srcSet={`${logoDefault_280} 2x`} /></Link></div>
              <div className="col-12">
                <ul className="footer-minimal-nav">
                  <li><Link to="#">Menu</Link></li>
                  <li><Link to="#">Blog</Link></li>
                  <li><Link to="contacts.html">Contacts</Link></li>
                  <li><Link to="#">Gallery</Link></li>
                  <li><Link to="about-us.html">About</Link></li>
                </ul>
              </div>
              <div className="col-12">
                <ul className="social-list">
                  <li><Link className="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-facebook" to="#"></Link></li>
                  <li><Link className="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-instagram" to="#"></Link></li>
                  <li><Link className="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-twitter" to="#"></Link></li>
                  <li><Link className="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-youtube-play" to="#"></Link></li>
                  <li><Link className="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-pinterest-p" to="#"></Link></li>
                </ul>
              </div>
            </div>
            <p className="rights"><span>&copy;&nbsp; </span><span className="copyright-year"></span><span>&nbsp;</span><span>Pesto</span><span>.&nbsp;</span><span>All Rights Reserved.</span><span>&nbsp;</span><Link to="#">Privacy Policy</Link>. Design&nbsp;by&nbsp;<Link to="https://www.templatemonster.com">Templatemonster</Link></p>
          </div>
        </div>
      </footer>
    </div>
    <div className="snackbars" id="form-output-global"></div>
        </>
    );
   /*
    return (    
        <>    
        <div classNameName="home">
            {(token !==false  && token !==null)? <Menu clear={clear} updatePhoto={updatePhoto} username={user.username} name={user.name} lastname={user.lastname} email={user.email} token={token} id={1} photo={user.photo}/> : null}
            
            {(token === false || token ===null)? <StikyMenu loginService={login}/> : null}
            
            <div classNameName="main container col-md-12 col-sm-12">
                <div classNameName="card text-bg-dark">
                    <img src={img1} classNameName="card-img imgBlurHov" alt="...." />
                    <div classNameName="card-img-overlay">
                        <p classNameName="text-center titulo"> <span>Sentidos</span> restaurante y casa de té</p>
                        <div classNameName="container logo">
                            <img src={logo}/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div classNameName="main container col-md-12 col-sm-12">
                <div classNameName="row row-cols-1 row-cols-md-4 row-cols-sm-4 menu">
                    <div classNameName="col text-center align-bottom blurHover">
                            <div classNameName="card text-bg-dark">
                                <img src={img7} classNameName="card-img imgBlurHov" alt="..." />
                                <div classNameName="card-img-overlay">
                                    <p classNameName="titulo-menu">Eventos Corporativos</p>
                                </div>
                            </div>
                        </div>
                        <Reservation/>
                        <div classNameName="col text-center align-bottom blurHover">
                            <div classNameName="card text-bg-dark">
                            <img src={img5} classNameName="card-img imgBlurHov" alt="..." />
                                <div classNameName="card-img-overlay">
                                    <p classNameName="titulo-menu">Delivery</p>
                                </div>
                            </div>
                        </div>
                        <div classNameName="col text-center align-bottom blurHover">
                            <div classNameName="card text-bg-dark">
                                <img src={img6} classNameName="card-img imgBlurHov" alt="..." />
                                <div classNameName="card-img-overlay">
                                    <p classNameName="titulo-menu">Menu</p>
                                </div>
                            </div>
                        </div>
                    </div>                
                </div>
            <div classNameName="container col-md-12 col-sm-12">
                <div classNameName="card text-bg-dark text-center justify-content-center" >
                    <img src={img4} classNameName="card-img imgBlur" alt="..."  />
                    <div classNameName="card-img-overlay container borde">
                        <h3 classNameName="card-title">Sentidos</h3>
                        <h4>Restaurante y casa de té</h4>      
                        <p className="texto-presentacion">Buscamos atraer la atención de nuestros clientes a travéz de experiencias inspiradoras en la seducción de los sentidos para que disfrute de un momento de bienestar, en total armonía.</p>                  
                    </div>
                </div>
            </div>
            <div classNameName="container col-md-12 col-sm-12">
                    <div classNameName=" card text-bg-dark text-center justify-content-center opiniones">
                        <PostBox comments={comments}/>
                        {console.log("session token "+sessionStorage.getItem("token"))}
                        {console.log("token "+token)}
                        { token!==null?                      
                        <div classNameName="cajaTexto">
                            <textarea classNameName="form-control" aria-label="With textarea" ref={refPostValue}></textarea>
                            
                            <button classNameName="btn btn-primary" style={{"marginTop":"10px", "marginBottom":"10px"}} onClick={sendPost}>Comentar</button>                                                    
                        </div> :null 
                        }                   
                    </div>
            </div>
           
        </div>
        <Footer/>
        </>
    );
    */
}

export default Home;

