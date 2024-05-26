import {Button, message, Space, Table} from "antd";
import React, {useEffect, useImperativeHandle, useRef, useState} from "react";
import {deleteTenantAPI, fetchTenantListAPI} from "@/apis/user.jsx";

const TenantList = React.forwardRef(
    (props, ref) => {
        const [tenantTotal, setTenantTotal] = useState(0);
        const [currentPage, setCurrentPage] = useState(1);
        const [data, setData] = useState([]);

        const columns = [
            {
                title: '租户名称',
                dataIndex: 'username',
                key: 'username',
                render: (text) => <div>{text}</div>,
            },
            // {
            //     title: 'Tags',
            //     key: 'tags',
            //     dataIndex: 'tags',
            //     render: (_, { tags }) => (
            //         <>
            //             {tags.map((tag) => {
            //                 let color = tag.length > 5 ? 'geekblue' : 'green';
            //                 if (tag === 'loser') {
            //                     color = 'volcano';
            //                 }
            //                 return (
            //                     <Tag color={color} key={tag}>
            //                         {tag.toUpperCase()}
            //                     </Tag>
            //                 );
            //             })}
            //         </>
            //     ),
            // },
            {
                title: '操作',
                key: 'action',
                width: 100,
                align: 'center',
                render: (_, record) => (
                    <Space size="middle">
                        {
                            record.username !== 'admin' &&
                            <Button type={'default'} danger onClick={() => deleteTenant(record.userId)}>删除</Button>
                        }
                    </Space>
                ),
            },
        ];

        const deleteTenant = (id) => {
            deleteTenantAPI({id}).then(() => {
                message.success('删除租户成功').then()
                fetchData()
            }).catch(() => {
                message.error('删除租户失败').then()
            })
        }

        const fetchData = () => {
            fetchTenantListAPI({
                username: props.tenantName ? props.tenantName : 'null',
                page: currentPage,
                pageSize: 10
            }).then(res => {
                setData(res.data.data)
                setCurrentPage(res.data.currentPage)
                setTenantTotal(res.data.total)
            }).catch(() => {
                message.error('获取租户列表失败').then()
            })
        }

        useImperativeHandle(ref, () => ({
            refresh: () => {
                fetchData()
            }
        }))

        useEffect(() => {
            fetchData()
        }, [currentPage, props.tenantName])

        return (
            <Table
                columns={columns}
                dataSource={data}
                pagination={{
                    total: tenantTotal,
                    pageSize: 10,
                    current: currentPage,
                    onChange: page => {
                        setCurrentPage(page);
                    }
                }}/>
        );
    }
)

export default TenantList;