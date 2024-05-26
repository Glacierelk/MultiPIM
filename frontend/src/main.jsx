import ReactDOM from 'react-dom/client'
import './index.scss'
import {RouterProvider} from "react-router-dom";
import router from "@/router/router";
import {Provider} from "react-redux";
import store from "@/store/store";
import 'normalize.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <Provider store={store}>
        <RouterProvider router={router}/>
    </Provider>
);