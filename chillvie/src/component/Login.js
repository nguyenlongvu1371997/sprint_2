import React, { useState } from 'react';
import Header from './Header';
import Swal from "sweetalert2";
import { Link, useNavigate } from "react-router-dom";
import { addJwtTokenToLocalStorage, loginByUserName } from '../service/AppUserService';

const LoginForm = () => {
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const [rememberMe, setRememberMe] = useState(false);

    const handleUserNameChange = (event) => {
        setUserName(event);
    };

    const handlePasswordChange = (event) => {
        setPassword(event);
    };

    const handleRememberMeChange = (event) => {
        setRememberMe(event.target.checked);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        // Add your login logic here
    };

    const navigate = useNavigate();
    const handleLogin = async () => {
        const appUser = {
            username: userName,
            password: password
        }
        try {

            const result = await loginByUserName(appUser);
            console.log("login success ");

            addJwtTokenToLocalStorage(result.data);
            // navigate("/home")
        } catch (e) {
            Swal.fire({
                icon: 'error',  
                text: 'Tài khoản hoặc mật khẩu không đúng',
            })
            console.log(e);
        }

    }

    return (
        <>
            {/* <Header /> */}
            <section className="bg-subtle mt-5 p-3 p-md-4 p-xl-5" style={{ backgroundColor: '#1e1e2a' }}>
                <div className="container">
                    <div className="row justify-content-center">
                        <div className="col-12 col-md-9 col-lg-7 col-xl-6 col-xxl-5">
                            <div className="card border-0 shadow-sm rounded-4">
                                <div className="card-body p-3 p-md-4 p-xl-5">
                                    <div className="row">
                                        <div className="col-12">
                                            <div className="mb-5">
                                                <h3>Đăng nhập</h3>
                                            </div>
                                        </div>
                                    </div>

                                   
                                        <div className="row gy-3 overflow-hidden">
                                            <div className="col-12">
                                                <div className="form-floating mb-3">
                                                    <input
                                                        type="text"
                                                        className="form-control"
                                                        name="userName"
                                                        id="userName"
                                                        placeholder="name@example.com"
                                                        value={userName}
                                                        onChange={(event) => setUserName((pre)=>event.target.value)}
                                                    />
                                                    <label htmlFor="userName" className="form-label">
                                                        Tài khoản
                                                    </label>
                                                </div>
                                            </div>
                                            <div className="col-12">
                                                <div className="form-floating mb-3">
                                                    <input
                                                        type="password"
                                                        className="form-control"
                                                        name="password"
                                                        id="password"
                                                        value={password}
                                                        onChange={(event) => setPassword((pre)=>event.target.value)}
                                                        placeholder="Password"
                                                        required
                                                    />
                                                    <label htmlFor="password" className="form-label">
                                                        Mật khẩu
                                                    </label>
                                                </div>
                                            </div>
                                            <div className="col-12">
                                            </div>
                                            <div className="col-12">
                                                <div className="d-grid">
                                                    <button className="btn btn-primary" onClick={()=>handleLogin()}>
                                                        Đăng nhập
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    

                                    <div className="row">
                                        <div className="col-12">
                                            <hr className="mt-5 mb-4 border-secondary-subtle" />
                                            <div className="d-flex gap-2 gap-md-4 flex-column flex-md-row justify-content-md-end">
                                                <a href="#!" className="link-secondary text-decoration-none">
                                                    Tạo tài khoản
                                                </a>
                                                <a href="#!" className="link-secondary text-decoration-none">
                                                    Tìm mật khẩu
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    );
};

export default LoginForm;