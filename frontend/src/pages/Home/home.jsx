import {Outlet, useNavigate} from "react-router-dom";
import {Layout, Menu, Popconfirm} from "antd";
import {LogoutOutlined, UsergroupAddOutlined} from '@ant-design/icons';
import './home.scss';
import {useDispatch} from "react-redux";
import {clearUserInfo} from "@/store/modules/user.jsx";

const {Header, Sider} = Layout;

const items = [
    {
        label: '租户管理',
        key: '/tenant',
        icon: <UsergroupAddOutlined/>,
    }
]

const Home = () => {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const doLogout = () => {
        dispatch(clearUserInfo());
        navigate('/login');
    };

    const onMenuClick = (item) => {
        navigate(item.key);
    };

    return (
        <Layout>
            <Header className="header">
                <div className={'text-logo'}>多租户管理系统</div>
                <div className="user-info">
                    <span className="user-name">11223</span>
                    <span className="user-logout">
                        <Popconfirm title="是否确认退出？" okText="退出" cancelText="取消" onConfirm={doLogout}>
                            <LogoutOutlined/> 退出
                        </Popconfirm>
                    </span>
                </div>
            </Header>
            <Layout>
                <Sider width={200} className="site-layout-background">
                    <Menu
                        mode="inline"
                        theme="light"
                        items={items}
                        onClick={onMenuClick}
                        style={{height: '100%', borderRight: 0}}></Menu>
                </Sider>
                <Layout className="layout-content" style={{padding: 20}}>
                    <Outlet/>
                </Layout>
            </Layout>
        </Layout>
    )
}

export default Home;