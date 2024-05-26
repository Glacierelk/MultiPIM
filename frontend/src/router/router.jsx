import {createBrowserRouter} from "react-router-dom";
import Login from "@/pages/Login/login.jsx";
import Home from "@/pages/Home/home.jsx";
import AuthRoute from "@/components/AuthRoute.jsx";
import TenantManage from "@/pages/TenantManage/tenantManage.jsx";

const router = createBrowserRouter([
    {
        path: '/login',
        element: <Login/>
    },
    {
        path: '/',
        element: <AuthRoute> <Home/> </AuthRoute>,
        children: [
            {
                path: '/tenant',
                element: <TenantManage />
            }
        ]
    }
])
export default router;