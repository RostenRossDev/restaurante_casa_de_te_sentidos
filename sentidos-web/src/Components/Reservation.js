import img8 from "../img/imagen8.jpg"
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";
import fondo from "../img/sentidos_arriba.png"
import tables from '../img/restaurant.png'
import { forwardRef, useEffect, useState } from "react";
import "materialize-css/dist/css/materialize.min.css";
import "materialize-css/dist/js/materialize.min.js";
import DatePicker from "react-datepicker";

import "react-datepicker/dist/react-datepicker.css";
import Calendar from "./Calendar";
import { stringify } from "qs";
import Tables from "./Tables";

const MySwal = withReactContent(Swal);

function Reservation(){

    const [today, setToday] = useState(new Date())

    const [endDate, setEndDate] = useState(`${today.getDate}-${today.getMonth}-${today.getFullYear}`)
   
    const [startDate, setStartDate] = useState(new Date());

    const [show, setShow] =useState(false);
    const [table, setTable] =useState(0);
    const [ lastTable, setLasTable] = useState(false);
    var options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };

    const selectTable =(e)=>{

            try{
                lastTable.style.backgroundColor="white";
            }catch(e){
                console.log(e)
            }
            setLasTable(table)
            setTable(e.currentTarget)
            e.currentTarget.style.backgroundColor="blue"
        
    }
  
    const modalReservation=()=>{
        MySwal.fire({
            title: "Mesas - "+ today.toLocaleDateString("es-ES", options),
            width: 800,
            html: (
                <Tables modal={MySwal}/>
            ),
            showCloseButton: false,
            showCancelButton: false,
            showConfirmButton: false,
          });

    }   

    return(
        <> 
            <div className="col text-center align-bottom blurHover" onClick={()=>setShow(!show)}>
                <div className="card text-bg-dark">
                <img src={img8} className="card-img imgBlurHov" alt="..." />
                    <div className="card-img-overlay">
                        <p className="titulo-menu">Reservar Mesa</p>
                    </div>
                </div>
            </div>
            {show ? modalReservation(startDate):null}
        </>
    )
}

export default Reservation;