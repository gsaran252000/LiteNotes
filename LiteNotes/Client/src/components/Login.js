import React, { useState } from 'react'
import { Navigate, useNavigate } from "react-router-dom";

const Login = (props) => {
    const [creds, setCreds] = useState({ username:"", email: "", password: "" });
    let navigate = useNavigate();
    const onChange = (e) => {
        setCreds({ ...creds, [e.target.name]: e.target.value });
    }
    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await fetch(`http://localhost:5000/api/auth/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ email: creds.email, password: creds.password }),
        });

        const json = await response.json();

        if (json.status === true) {
            localStorage.setItem('token', json.authtoken);
            navigate("/");
            props.showAlert("Logged in Successfully","success")
        }
        else {
            props.showAlert(json.error,"danger")
        }
    }
    return (
        <div>
            <form onSubmit={handleSubmit} className='container my-4'>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address</label>
                    <input type="email" className="form-control" id="email" value={creds.email} name="email" aria-describedby="emailHelp" onChange={onChange} />
                    <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password" name="password" value={creds.password} className="form-control" id="password" onChange={onChange} />
                </div>
                <button type="submit" className="btn btn-primary" >Login</button>
            </form>
        </div>
    )
}

export default Login
