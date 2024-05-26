import {getToken} from "@/utils/utils.jsx";
import {Navigate} from "react-router-dom";

const AuthRoute = ({ children }) => { // children是一个组件
    const token = getToken();
    if (token) {
        return <> {children} </>;
    } else {
        return <Navigate to="/login" replace />;
    }
};

export default AuthRoute;