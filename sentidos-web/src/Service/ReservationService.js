const baseLocal="http://127.0.0.1:8080";
const baseWweb="https://sentidos-backend.herokuapp.com";
const base= baseLocal;
const url = `${base}/api/v1/reservation/`;

  const ReservationService = {
    
    allReservations: async() =>{

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        
        var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
        };

       return  await fetch(url+"all", requestOptions)
        .then(response => response.text())
        .catch(error => console.log('error', error));
                
    },
    createReservation: async (date, table)=>{
        console.log(typeof date)
        const myArray = date.split("-");
        const selectedDate= new Date(myArray[0], "0"+(myArray[1]-1), myArray[2])
        const token= sessionStorage.getItem("token")
        const username= sessionStorage.getItem("username")
        var myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer "+token);
        myHeaders.append("Content-Type", "application/json");

        var raw = JSON.stringify({
        "username": username,
        "dateReservation": selectedDate,
        "table": table
        });

        var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
        };

        return await fetch("http://127.0.0.1:8080/api/v1/reservation", requestOptions)
        .then(response => response.text())
        .catch(error => console.log('error', error));
    }
}

export default ReservationService;