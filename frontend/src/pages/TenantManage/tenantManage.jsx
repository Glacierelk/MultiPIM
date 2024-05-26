import {Button, Col, Form, Input, message, Modal, Row, Space, theme} from 'antd';
import TenantList from "@/pages/TenantManage/DataList/TenantList.jsx";
import {useRef, useState} from "react";
import {addTenantAPI} from "@/apis/user.jsx";
import './tenantManage.css';

const TenantManage = () => {
    const {token} = theme.useToken();
    const formStyle = {
        maxWidth: 'none',
        background: token.colorFillAlter,
        borderRadius: token.borderRadiusLG,
        padding: 24,
    };

    const [form] = Form.useForm();
    const [searchParams, setSearchParams] = useState('');
    const searchTenant = (values) => {
        if (values.tenantName === undefined) {
            values.tenantName = 'null';
        }
        console.log('Received values of form: ', values);
        setSearchParams(values.tenantName);
        // refreshList();
    };

    const createNewTenant = () => {
        setOpen(true);
    }

    const [addForm] = Form.useForm();
    const [open, setOpen] = useState(false);
    const addTenant = (values) => {
        console.log('values: ', values);
        addTenantAPI(values).then(res => {
            console.log('res: ', res);
            if (res.status === 200) {
                message.success('新增租户成功').then();
                addForm.resetFields();
                form.resetFields();
                setSearchParams('');
                setOpen(false);
                refreshList();
            }
        }).catch(err => {
            console.error('err: ', err);
            message.error('新增租户失败').then();
        });
    };
    const closeDialog = () => {
        setOpen(false);
        addForm.resetFields();
    };

    const tenantListRef = useRef(null);
    const refreshList = () => {
        tenantListRef.current.refresh();
    }

    return (
        <>
            <Modal
                title="新增租户"
                open={open}
                footer={null}
            >
                <Form
                    name="basic"
                    form={addForm}
                    initialValues={{
                        remember: true,
                    }}
                    onFinish={addTenant}
                    // onFinishFailed={onFinishFailed}
                    autoComplete="off"
                    style={{marginTop: '10px'}}
                >
                    <Form.Item
                        label="用户名"
                        name="username"
                        rules={[
                            {
                                required: true,
                                message: '请输入租户用户名!',
                            },
                        ]}
                    >
                        <Input/>
                    </Form.Item>

                    <Form.Item
                        label="密码"
                        name="password"
                        rules={[
                            {
                                required: true,
                                message: '请输入租户密码！',
                            },
                        ]}
                    >
                        <Input.Password/>
                    </Form.Item>

                    <Form.Item style={{display: 'flex', justifyContent: 'flex-end'}}>
                        <Button onClick={closeDialog}>
                            取消
                        </Button>

                        <Button
                            htmlType="submit"
                            type="primary"
                            style={{
                                backgroundColor: 'green',
                                borderColor: 'green',
                                color: 'white',
                                opacity: '0.6',
                                marginLeft: '10px'
                            }}
                        >
                            新增
                        </Button>
                    </Form.Item>
                </Form>
            </Modal>

            <Form form={form} name="advanced_search" style={formStyle} onFinish={searchTenant}>
                <Row gutter={24}>
                    <Col span={19} key={1}>
                        <Form.Item
                            name="tenantName"
                            label={`租户名称`}
                        >
                            <Input placeholder="请输入租户名称"/>
                        </Form.Item>
                    </Col>
                </Row>
                <div
                    style={{
                        textAlign: 'right',
                    }}
                >
                    <Space size="small">
                        <Button type="primary" htmlType="submit">
                            查询
                        </Button>

                        <Button
                            onClick={() => {
                                form.resetFields();
                                setSearchParams('');
                                // refreshList();
                            }}
                        >
                            清空
                        </Button>

                        <Button type={'default'}
                                style={{backgroundColor: 'green', borderColor: 'green', color: 'white', opacity: '0.6'}}
                                onClick={createNewTenant}>
                            新增租户
                        </Button>
                    </Space>
                </div>
            </Form>

            <div className={'tenant-list'}>
                <TenantList tenantName={searchParams} ref={tenantListRef}/>
            </div>
        </>
    );
};

export default TenantManage;