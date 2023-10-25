import { Alert, Snackbar } from "@mui/material";
import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { login } from "../Redux/Auth/Action";


const Login = () => {

    const navigate = useNavigate();
    const [inputData, setInputData] = useState({ email: "", password: "" });
    const [openSnackbar, setOpenSnackBar] = useState(false);

    const dispatch = useDispatch();

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("handle submit");
        dispatch(login(inputData))
        setOpenSnackBar(true)
    }

    const handleChange = (e) => {
        const { name, value } = e.target;
        setInputData((values) => ({ ...values, [name]: value }))
    }

    const handleSnackbarClose = () => {
        setOpenSnackBar(false);
    }

    return (
        <div className="auth-form-container">
            <h2 style={{color:'white'}}>Login</h2>
            <form className="login-form" onSubmit={handleSubmit}>
                <label style={{color:'white'}} htmlFor="email">Email</label>
                <input value={inputData.email} onChange={(e) => handleChange(e)} type="email" placeholder="youremail@gmail.com" id="email" name="email" />
                <label style={{color:'white'}} htmlFor="password">Password</label>
                <input value={inputData.password} onChange={(e) => handleChange(e)} type="password" placeholder="********" id="password" name="password" />
                <button type="submit" onClick={()=>navigate("/src/usercomponents/Nav.js")}>LogIn</button>
            </form>
            <button className="link-btn" onClick={() => navigate("/userSignup")}>Don't have an account? Register here.</button>


            <Snackbar open={openSnackbar} autoHideDuration={6000} onClose={handleSnackbarClose}>
                <Alert onClose={handleSnackbarClose} severity="success" sx={{ width: '100%' }}>
                    Login Successfull!
                </Alert>
            </Snackbar>
        </div>

    )
}
export default Login