package com.xiaosan.ems.dao;

import com.xiaosan.ems.entity.EmpManager;

/**
 * 编写顺序——database.properties 配置文件
 *      ——utils中的 DbUtils 工具类
 *      ——entity 实体类中的 EmpManager
 *      ——dao 中的 EmpManagerDao接口
 *
 */
public interface EmpManagerDao {
    public EmpManager select(String username) ;

}

// ——》 EmpManagerDaoImpl