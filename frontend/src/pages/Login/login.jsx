import './login.scss';
import {Button, Card, Form, Input, message} from 'antd';
import {useDispatch} from "react-redux";
import {useNavigate} from "react-router-dom";
import {doLogin} from "@/store/modules/user.jsx";
import {getToken} from "@/utils/utils.jsx";

const Login = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const submit = async (values) => {
        // console.log('表单数据: ', values);
        await dispatch(doLogin(values));
        const token = getToken();
        if (!token) {
            message.error('登录失败').then();
            return;
        }
        navigate('/');
        message.success('登录成功').then();
    };

    return (
        <div className="login">
            <Card className="login-container">
                <h2 className="login-title">多租户个人信息管理系统</h2>
                {/* 登录表单 */}
                <Form
                    validateTrigger="onBlur"
                    onFinish={submit}
                >
                    <Form.Item
                        label={'账号'}
                        name="username"
                        rules={[
                            // 串行校验
                            {required: true, message: '请输入账号'},
                            // {pattern: /^1[3-9]\d{9}$/, message: '手机号格式不正确'}
                        ]}
                    >
                        <Input size="large" placeholder="请输入账号"/>
                    </Form.Item>
                    <Form.Item
                        label={'密码'}
                        name="password"
                        rules={[{required: true, message: '请输入密码'}]}
                    >
                        <Input.Password size="large" placeholder="请输入密码"/>
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit" size="large" block>
                            登录
                        </Button>
                    </Form.Item>
                </Form>
            </Card>
        </div>
    )
};

export default Login;