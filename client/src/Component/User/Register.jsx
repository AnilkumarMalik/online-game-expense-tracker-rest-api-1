import { Alert, Snackbar } from "@mui/material";
import React, {  useState } from "react";
import {  useDispatch } from "react-redux";

import { useNavigate } from "react-router-dom";
import { register } from "../Redux/Auth/Action";




const Register = () => {

    const [openSnackbar, setOpenSnackBar] = useState(false);
    const navigate = useNavigate();
    const [inputData, setInputData] = useState({ full_name: "", email: "",phone:"", password: "" });
    
    const dispatch=useDispatch();


    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("handle submit ", inputData);
        dispatch(register(inputData));
        setOpenSnackBar(true);
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
            <h2 style={{color:'white'}}>Register</h2>
            <form className="register-form" onSubmit={handleSubmit}>
                <label htmlFor="name" style={{color:'white'}}>Full name</label>
                <input value={inputData.full_name} name="full_name" onChange={(e) => handleChange(e)} id="name" placeholder="full Name" />
                <label htmlFor="email" style={{color:'white'}}>Email</label>
                <input value={inputData.email} onChange={(e) => handleChange(e)} type="email" placeholder="youremail@gmail.com" id="email" name="email" />
                
                <label htmlFor="phone" style={{color:'white'}}>Phone Number</label>
                <input value={inputData.phone} onChange={(e) => handleChange(e)} type="number" placeholder="9999999999" id="phone" name="phone" />
                
                <label htmlFor="password" style={{color:'white'}}>Password</label>
                <input value={inputData.password} onChange={(e) => handleChange(e)} type="password" placeholder="********" id="password" name="password" />
                <button type="submit" >Register</button>
            </form>
            <button className="link-btn" onClick={() => navigate("/userSignin")}>Already have an account? Login here.</button>
            <Snackbar open={openSnackbar} autoHideDuration={6000} onClose={handleSnackbarClose}>
                <Alert onClose={handleSnackbarClose} severity="success" sx={{ width: '100%' }}>
                    Your Account Successfully Created!
                </Alert>
            </Snackbar>
        </div>
       
    )
}

export default Register