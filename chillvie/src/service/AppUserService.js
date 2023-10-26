import axios from "axios";
import jwt_decode from 'jwt-decode';

export const loginByUserName = (appUser) => {
    const result = axios.post(`http://localhost:8080/api/user/login-by-user`, appUser);
    return result;
}

export const logout = () => {
    localStorage.removeItem("JWT");
}

export const addJwtTokenToLocalStorage = (jwtToken) => {
    localStorage.setItem("JWT", jwtToken);
}

export const infoAppUserByJwtToken = () => {
    const jwtToken = localStorage.getItem("JWT");
    if (jwtToken) {
        const result = jwt_decode(jwtToken);
        return result;
    }
}


export const axiosClient = () => {
  axios.interceptors.request.use(async (config) => {
    const accessToken = localStorage.getItem("JWT");
    if (accessToken) {
      config.headers.Authorization = `Bearer ${accessToken}`;
    }
    return config;
  })
}

