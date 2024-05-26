import {request} from "@/utils/utils.jsx";

// 用户登录
export const loginAPI = (params) => {
    return request({
        url: '/user/login',
        method: 'POST',
        data: params
    });
};

// 新增租户
export const addTenantAPI = (params) => {
    return request({
        url: '/user/create',
        method: 'POST',
        data: params
    });
};

// 获取租户列表
export const fetchTenantListAPI = (params) => {
    return request({
        url: `/user/list/${params.username}/${params.page}/${params.pageSize}`,
        method: 'GET'
    });
};

// 删除租户
export const deleteTenantAPI = (params) => {
    return request({
        url: `/user/delete/${params.id}`,
        method: 'DELETE'
    });
};
