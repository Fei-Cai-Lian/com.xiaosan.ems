package com.xiaosan.ems.service.impl;

import com.xiaosan.ems.dao.EmpManagerDao;
import com.xiaosan.ems.dao.impl.EmpManagerDaoImpl;
import com.xiaosan.ems.entity.EmpManager;
import com.xiaosan.ems.service.EmpManagerService;
import com.xiaosan.ems.utils.DbUtils;

/**
 * 编写顺序——database.properties 配置文件
 *      ——utils中的 DbUtils 工具类
 *      ——entity 实体类中的 EmpManager
 *      ——dao 中的 EmpManagerDao接口
 *      ——dao 中的 EmpManagerDao接口 的实现类 EmpManagerDaoImpl
 *      ——service 中的 EmpManagerService 接口
 *      ——service 中的 EmpManagerService 接口的实现类 EmpManagerServiceImpl
 */
public class EmpManagerServiceImpl implements EmpManagerService {

    private EmpManagerDao empManagerDao = new EmpManagerDaoImpl() ;

    @Override
    public EmpManager login(String username, String password) {
        EmpManager empManager = null ;
        try {
            DbUtils.begin();
            EmpManager temp = empManagerDao.select(username);
            if(temp != null ){
                if(temp.getPassword().equals(password)){
                    empManager = temp ;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return empManager;
    }
}

//——》login.jsp