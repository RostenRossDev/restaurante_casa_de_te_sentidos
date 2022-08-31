import { getDay } from "date-fns";
import { addMonths } from "date-fns/esm";
import { forwardRef, useEffect, useState } from "react";
import DatePicker from "react-datepicker";

const Calendar =({startDate, changeDate, change})=>{
    const [start, setStart]=useState(startDate)
    const [minDate, setMinDate]=useState(new Date())
    useEffect(()=>{
        const year = start.getFullYear(); // 1e4 gives us the the other digits to be filled later, so 20210000.
        const month = "0"+(start.getMonth()+1); // months are numbered 0-11 in JavaScript, * 100 to move two digits to the left. 20210011 => 20211100
        const day = start.getDate(); // 20211100 => 20211124
        const result = year+"-"+ month+"-" +day;   
        console.log(result)
        sessionStorage.setItem("reservationDate",result)
});
    const setDate=(date)=>{
        const year = date.getFullYear(); // 1e4 gives us the the other digits to be filled later, so 20210000.
        const month = "0"+(date.getMonth()+1); // months are numbered 0-11 in JavaScript, * 100 to move two digits to the left. 20210011 => 20211100
        const day = date.getDate(); // 20211100 => 20211124
        const result = year+"-"+ month+"-" +day;   
        console.log(result)
        console.log(date)
        sessionStorage.setItem("reservationDate",result)
        setStart(date)
        console.log(sessionStorage.getItem("reservationDate"))
        changeDate(!change) 
    }
    const ExampleCustomInput = forwardRef(({ value, onClick }, ref) => (
        <button className="btn btn-primary datepicker" onClick={onClick} ref={ref}>
            {value}
        </button>
    ));

    const isWeekday = (date) => {
        const day = getDay(date);
        return day !== 0 && day !== 6;
      };

  return   <DatePicker 
                filterDate={isWeekday}
                selected={start} 
                onChange={setDate}
                minDate={new Date()}
                maxDate={addMonths(new Date(), 1)}
                //showDisabledMonthNavigation
                customInput={<ExampleCustomInput />}                             
            />
}

export default Calendar;