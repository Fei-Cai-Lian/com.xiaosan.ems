package com.xiaosan.ems.service;

import com.xiaosan.ems.entity.EmpManager;

/**
 * 编写顺序——database.properties 配置文件
 *      ——utils中的 DbUtils 工具类
 *      ——entity 实体类中的 EmpManager
 *      ——dao 中的 EmpManagerDao接口
 *      ——dao 中的 EmpManagerDao接口 的实现类 EmpManagerDaoImpl
 *      ——service 中的 EmpManagerService 接口
 *
 */
public interface EmpManagerService {
    public EmpManager login(String username, String password) ;
}//——》EmpManagerServiceImpl
