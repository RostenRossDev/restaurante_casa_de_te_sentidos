import img1 from "../../img/imagen1.jpg"
import img2 from "../../img/imagen2.jpg"
import img3 from "../../img/imagen3.jpg"
import img4 from "../../img/imagen4.jpg"
import img5 from "../../img/imagen5.jpg"
import img6 from "../../img/imagen6.jpg"
import img7 from "../../img/imagen7.jpg"
import img8 from "../../img/imagen8.jpg"
import img10 from "../../img/imagen10.jpg"

function Home() {
    return (
        <div className="home">
            <div className="main container col-md-12 col-sm-12">
                <div className="card text-bg-dark">
                    <img src={img1} className="card-img imgBlurHov" alt="...." />
                    <div className="card-img-overlay">
                        <p className="card-title text-center titulo"> <span>Sentidos</span> restaurante y casa de té</p>
                    </div>
                </div>
            </div>
            
            <div className="main container col-md-12 col-sm-12">
                <div className="row row-cols-1 row-cols-md-4 row-cols-sm-2 menu">
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
                        <div className="text-start chat" style={{"marginTop":"10px", "marginLeft":"10px","marginRight":"10px","paddingTop":"10px"}}>
                            <p className="comentarios"> <span>Marisa Lalo: </span>Muy rico todo.</p>
                            <p className="comentarios"> <span>Pepito Lovos: </span>Excelente atencion.</p>
                            <p className="comentarios"> <span>Martin Boeta: </span>Me encanto la musica y la comida.</p>
                            <p className="comentarios"> <span>Jose Palaso: </span>Lo lindo es la variedad en el menu Vegano.</p>
                        </div> 
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

