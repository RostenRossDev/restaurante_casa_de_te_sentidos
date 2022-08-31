import { useEffect, useState } from "react";
import Calendar from "./Calendar";
import fondo from "../img/sentidos_arriba.png"
import tables from '../img/restaurant.png'
import ReservationService from "../Service/ReservationService";
import ReactTooltip from "react-tooltip";
import teaIco from "../img/tea.svg";
import resto from "../img/silverware.svg"
function Tables({modal}){
    
    const [reservas, setReservas] = useState([]);
    const [reservasDiasMesa, setReservasDiasMesas]=useState([])
    const [changeDate, setChangeDate] = useState(false);
    const [hour, setHour] = useState(1);

   
    useEffect(()=>{

        async  function allReservations () { 
            const fetch =JSON.parse(await ReservationService.allReservations());
           
            if (reservas.length !== fetch.reservations.length){
                setReservas(await fetch.reservations);
                setReservasDiasMesas(await fetch.reservations.map(el =>{
                    return {"table":el.table, "dateReservation":el.dateReservationString,"username":el.username}
                }))
            }

        }
        allReservations();
    })
    
  

    const [startDate, setStartDate] = useState(new Date());
    const [lastTable, setLasTable] =useState(null)

    const selectTable =(e)=>{  
        if(sessionStorage.getItem("token")!==null) {
            if(lastTable!==null){
                lastTable.style.backgroundColor="transparent"
                setLasTable(e.currentTarget)
                e.currentTarget.style.backgroundColor="green"
                e.currentTarget.style.borderRadius="10px"

                sessionStorage.setItem("table",e.currentTarget.id)
            }else{
                setLasTable(e.currentTarget)
                e.currentTarget.style.backgroundColor="green"
                e.currentTarget.style.borderRadius="10px"
                sessionStorage.setItem("table",e.currentTarget.id)
            }
        }
    }

    const matchUsername =(username)=>{
        let match=false;

        reservasDiasMesa.forEach(el =>{
            if(el.username ===(username)){
                match=true;
            }
        })
        return match;

    }
    const matchDayTable = (table, date) =>{
        let match=false;
        console.log(JSON.stringify(reservasDiasMesa))
        reservasDiasMesa.forEach(el =>{
            const myArray = el.dateReservation.split("-");

            const elementDate = new Date(myArray[0], myArray[1], myArray[2])
            const elementDateFormated = elementDate.getFullYear()+"-"+(elementDate.getMonth()).toString().padStart(2, '0')+"-"+elementDate.getDate()

            if(elementDateFormated.localeCompare(date) === 0){
                
                if(el.table === table){
                    match= true;
                }
            }
        })
        return match;
    }

    const tablesLeft = ()=>{
        const tableList=[];
        const breaks =[2,4,7,10,13];
        let tableClass="noTable";      
        if(sessionStorage.getItem("token")!==null) tableClass="table";
        const reservations = sessionStorage.getItem("reservations");
        const today=new Date(sessionStorage.getItem("reservationDate"))
        const todayFormated = today.getFullYear()+"-"+(today.getMonth() + 1).toString().padStart(2, '0')+"-"+(today.getDate())
        for(let i=0;i<17;i++){
            tableClass="";          

            console.log("mesa: "+(i+1)+", fecha: "+todayFormated)
            if(matchDayTable((i+1), todayFormated)){
                console.log("mas aca")

                const username=sessionStorage.getItem("username")
                if(matchUsername(username)){
                    console.log("mas mas aca")

                    tableClass="tuReserva"
                }else{
                    console.log("mas mas mas aca")

                    tableClass="reservado";  
                }
            }
            const id =`table`+(i+1)

            tableList.push(
                <div  data-tip data-for={id} onClick={(e)=>selectTable(e)} className={tableClass} id={i+1} style={{"marginBottom":"20px", "marginRight":"35px","float":"left","cursor":"pointer","width":"45px","height":"45px"}}>
                    <img src={tables} height="40" width="40" />
                    <ReactTooltip id={id}  type='error'>
                        <span>Mesa N°{i+1}</span>
                    </ReactTooltip>
                </div>
            )
            if(breaks.includes(i)){
                tableList.push(<br/>)
            }
        }
        return tableList;
    }  
    const tablesRigth = ()=>{
        const tableList=[];
        const breaks =[2,4,7,10,13]
        let tableClass="noTable";      
        if(sessionStorage.getItem("token")!==null) tableClass="table"
        const today=new Date(sessionStorage.getItem("reservationDate"))
        const todayFormated = today.getFullYear()+"-"+(today.getMonth() + 1).toString().padStart(2, '0')+"-"+(today.getDate()+1)
        for(let i=0;i<17;i++){

            tableClass="";          

            if(matchDayTable(i, todayFormated)){
                console.log("mas aca")

                const username=sessionStorage.getItem("username")
                if(matchUsername(username)){
                    console.log("mas mas aca")

                    tableClass="tuReserva"
                }else{
                    console.log("mas mas mas aca")

                    tableClass="reservado";  
                }
            }
            const id =`table`+(i+18)
            tableList.push(
                <div data-tip data-for={id}  onClick={(e)=>selectTable(e)} className={tableClass} id={i+18} style={{"marginBottom":"20px", "marginRight":"35px", "cursor":"pointer","width":"45px","height":"45px", "float":"right"}}>
                    <img src={tables} height="40" width={40} />
                    <ReactTooltip id={id}  type='error'>
                        <span>Mesa N°{i+18}</span>
                    </ReactTooltip>
                </div>
            )
            if(breaks.includes(i)){
                tableList.push(<br/>)
            }
        }
        return tableList;
    } 
    
    const [teCheckbox, setTeCheckbox] = useState(false);
    const [RestCheckbox, setRestCheckbox] = useState(false);

    const updateCheckBox =(e)=>{
        if(e.currentTarget.name==="te"){
            setRestCheckbox(teCheckbox);            
            setTeCheckbox(!teCheckbox);
        }else{
            setTeCheckbox(RestCheckbox);           
            setRestCheckbox(!RestCheckbox);
        }
    }

    const sendReservation = async () =>{
        const reservationDate = sessionStorage.getItem("reservationDate")
        const table =sessionStorage.getItem("table")
        console.log("fecha: "+typeof reservationDate)
        const response = await ReservationService.createReservation(reservationDate, table);
        if(response){
            console.log(JSON.stringify(response))
        }
        setReservasDiasMesas([...reservasDiasMesa,response.reservation])
        if(response!==null){
            let timerInterval
            modal.fire({
              title: 'Reserva',
              html: 'Se guardo su reserva con exito!!',
              timer: 2000,
              timerProgressBar: true,
              didOpen: () => {
                
                const b = modal.getHtmlContainer().querySelector('b')
                timerInterval = setInterval(() => {
                  b.textContent = modal.getTimerLeft()
                }, 100)
              },
              willClose: () => {
                clearInterval(timerInterval)
              }
            }).then((result) => {
              /* Read more about handling dismissals below */
              if (result.dismiss === modal.DismissReason.timer) {
                console.log('I was closed by the timer')
              }
            })
        }  
    }

    
    const changeHour =(hour)=>{
        console.log("hora: "+hour)
        setHour(hour)
    } 
    return (
        <div>
            <div className="row headerReservation">
                <div className="col row  reservaDiv headerReservation">
                    Reservado: <div className="reservado "></div>
                </div>
                <div className="col row center-align tuReservaDiv headerReservation">
                    Tu reserva: <div className="tuReserva "></div>
                </div>
                <div className="col row">
                    Libres: sin color
                </div>      
               { sessionStorage.getItem("token")!==null?<>
               <div className="col row headerReservation">
                    <label>
                        <input name="rest" type="checkbox" class="filled-in"  onClick={updateCheckBox} checked={RestCheckbox}/>
                        <span style={{"fontSize":"13px"}}>    
                            <img src={resto} height="20px" width="20px" />
                        </span>                        
                    </label>                   
                    <label>
                        <input name="te" type="checkbox" class="filled-in"  onClick={updateCheckBox} checked={teCheckbox}/>
                        <span  style={{"fontSize":"13px"}}>
                            <img src={teaIco} height="20px" width="20px" />
                        </span>                                                
                    </label>                   
                    
                </div>   
                <div className="col">
                        
                       
                            <select id="hour" style={{"display":"block"}} onChange={e => changeHour(e.target.value)} value={hour}>
                            {teCheckbox?
                                <>
                                    <option value={1}>11hs a 15hs</option>
                                    <option value={2}>18hs a 00hs</option>
                                </>:
                                <>
                                    <option value="1">7hs a 11hs</option>
                                    <option value="2">15hs a 19hs</option>
                                </>
                            }
                            </select>
                            
                        
                    </div>   
                <div className="col headerReservation"><button className="btn" onClick={sendReservation}>Confirmar</button></div></>    
                :null
                }       
                <Calendar startDate={startDate} changeDate={setChangeDate} change={changeDate}/>
            </div>     
            
            <img src={fondo} alt="fondo"/>

            <div className="col" style={{ "position": "absolute", "top": "335px",  "left": "140px"}}>
                {tablesLeft()}
            </div>

            <div className="col" style={{ "position": "absolute", "top": "335px",  "left": "450px"}}>
                {tablesRigth()}                
            </div>

            <div className="toilet"  data-tip data-for='toilet'>
                <ReactTooltip id='toilet' type='error'>
                    <span>Servicios</span>
                </ReactTooltip>
            </div>

            <div className="exit"  data-tip data-for='exit'>
                <ReactTooltip id='exit' type='error'>
                    <span>Salida de emergencia</span>
                </ReactTooltip>
            </div>

            <div className="cash"  data-tip data-for='cash'>
                <ReactTooltip id='cash' type='error'>
                    <span>Caja</span>
                </ReactTooltip>
            </div>

            <div className="window1"  data-tip data-for='window1'>
                <ReactTooltip id='window1' type='error'>
                    <span>Ventana</span>
                </ReactTooltip>
            </div>

            <div className="window2"  data-tip data-for='window2'>
                <ReactTooltip id='window2' type='error'>
                    <span>Ventana</span>
                </ReactTooltip>
            </div>

            <div className="window3"  data-tip data-for='window3'>
                <ReactTooltip id='window3' type='error'>
                    <span>Ventana</span>
                </ReactTooltip>
            </div>
            <div className="window4"  data-tip data-for='window4'>
                <ReactTooltip id='window4' type='error'>
                    <span>Ventana</span>
                </ReactTooltip>
            </div>

            <div className="window5"  data-tip data-for='window5'>
                <ReactTooltip id='window5' type='error'>
                    <span>Ventana</span>
                </ReactTooltip>
            </div>

            <div className="window6"  data-tip data-for='window6'>
                <ReactTooltip id='window6' type='error'>
                    <span>Ventana</span>
                </ReactTooltip>
            </div>

            <div className="window7"  data-tip data-for='window7'>
                <ReactTooltip id='window7' type='error'>
                    <span>Ventana</span>
                </ReactTooltip>
            </div>

            <div className="window8"  data-tip data-for='window8'>
                <ReactTooltip id='window8' type='error'>
                    <span>Ventana</span>
                </ReactTooltip>
            </div>

            <div className="door"  data-tip data-for='door'>
                <ReactTooltip id='door' type='error'>
                    <span>Entrada/Salida</span>
                </ReactTooltip>
            </div>

        </div>
    )
}

export default Tables;