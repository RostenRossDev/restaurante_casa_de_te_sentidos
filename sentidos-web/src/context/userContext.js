import { createContext } from "react";
import defaultUser from '../img/default.png'


const Context = createContext({ user: {username:"",token:false,loged:false, name:"", lastname:"", email:"",photo:null}, setUser: () => {} });

export default Context;