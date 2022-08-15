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

function Home() {
    return (        
        <div className="home">
            <StikyMenu />
            <div className="main container col-md-12 col-sm-12">
                <div className="card text-bg-dark">
                    <img src={img1} className="card-img imgBlurHov" alt="...." />
                    <div className="card-img-overlay">
                        <p className="card-title text-center titulo"> <span>Sentidos</span> restaurante y casa de té</p>
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
                                    <h4 className="card-title">Eventos Coorporativos</h4>
                                </div>
                            </div>
                        </div>
                        <div className="col text-center align-bottom blurHover">
                            <div className="card text-bg-dark">
                            <img src={img8} className="card-img imgBlurHov" alt="..." />
                                <div className="card-img-overlay">
                                    <h4 className="card-title">Reservar Mesa</h4>
                                </div>
                            </div>
                        </div>
                        <div className="col text-center align-bottom blurHover">
                            <div className="card text-bg-dark">
                            <img src={img5} className="card-img imgBlurHov" alt="..." />
                                <div className="card-img-overlay">
                                    <h4 className="card-title">Delivery</h4>
                                </div>
                            </div>
                        </div>
                        <div className="col text-center align-bottom blurHover">
                            <div className="card text-bg-dark">
                                <img src={img6} className="card-img imgBlurHov" alt="..." />
                                <div className="card-img-overlay">
                                    <h4 className="card-title">Menu</h4>
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
                        <PostBox />                        
                        <div className="cajaTexto">
                            <textarea className="form-control" aria-label="With textarea"></textarea>
                            <button className="btn btn-primary" style={{"marginTop":"10px", "marginBottom":"10px"}}>Comentar</button>
                        </div>                      
                    </div>
            </div>
           
        </div>
    );
}

export default Home;

