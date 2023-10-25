import { LOGIN, REGISTER} from "./ActionType"
const initialValue={
    signup:null,
    signin:null,
}

export const authReducer=(store=initialValue,{type,payload})=>{
    if(type===REGISTER){
        return {...store,signup:payload}
    }
    else if(type===LOGIN){
        return{...store,signin:payload}
    }
    return store;
}