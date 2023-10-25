import { BASE_API_URL } from "../../Config/api"
import { LOGIN,  REGISTER } from "./ActionType"

export const register = (data) => async (dispatch) => {
    try {
        const res = await fetch(`${BASE_API_URL}/auth/signup`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data)
        })
        const resData = await res.json();
        if (resData.jwt) localStorage.setItem("token", resData.jwt)
        console.log("register ", resData);
        dispatch({ type: REGISTER, payload: resData })
    } catch (error) {
        console.log("catch error ", error);
    }
}


export const login = (data) => async (dispatch) => {
    try {
        const res = await fetch(`${BASE_API_URL}/auth/signin`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data)
        })
        const resData = await res.json();
        console.log("register", resData);
        if (resData.jwt) localStorage.setItem("token", resData.jwt)
        dispatch({ type: LOGIN, payload: resData });

    } catch (error) {
        console.log("catch error ", error);
    }
}


