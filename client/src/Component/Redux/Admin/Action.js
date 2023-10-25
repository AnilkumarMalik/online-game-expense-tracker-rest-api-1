import { BASE_API_URL } from "../../Config/api";
import { ADMINLOGIN } from "./ActionType";


export const adminLogin = (data) => async (dispatch) => {
    try {
        const res = await fetch(`${BASE_API_URL}/admin/signin`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data)
        })
        const resData = await res.json();
        if (resData.jwt) localStorage.setItem("token", resData.jwt)
        console.log("login ", resData);
        dispatch({ type: ADMINLOGIN, payload: resData })
    } catch (error) {
        console.log("catch error ", error);
    }
}
