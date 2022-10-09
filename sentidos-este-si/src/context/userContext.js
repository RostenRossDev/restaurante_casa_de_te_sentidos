import { createContext } from "react";


const Context = createContext({ user: {username:"",token:false,loged:false, name:"", lastname:"", email:"",photo:null}, setUser: () => {} });

export default Context;