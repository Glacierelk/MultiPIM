import {createSlice} from "@reduxjs/toolkit";
import {loginAPI} from "@/apis/user.jsx";
import {removeToken, setToken as _setToken} from "@/utils/utils.jsx";

const userStore = createSlice({
    name: 'user',
    initialState: {
        token: null,
        userInfo: null,
    },
    reducers: {
        setToken(state, action) {
            state.token = action.payload;
            _setToken(action.payload);
        },
        clearUserInfo(state) {
            state.token = '';
            state.userInfo = {};
            removeToken();
        }
    }
})

const {setToken, clearUserInfo} = userStore.actions;

// 异步获取token
const doLogin = (loginForm) => {
    return async (dispatch) => {
        const res = await loginAPI(loginForm);
        console.log('res: ', res);
        if (res && res.status === 200) {
            dispatch(setToken(res.data));
        }
    }
};

export {doLogin, clearUserInfo};
export default userStore.reducer;