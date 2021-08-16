package com.xiaosan.ems.entity;
/**
 * 编写顺序
 *      1——database.properties 配置文件
 *      2——utils中的 DbUtils 工具类
 *      3——entity 实体类中的 EmpManager
 *      4——dao 中的 EmpManagerDao接口
 *      5——dao 中的 EmpManagerDao接口 的实现类 EmpManagerDaoImpl
 *      6——service 中的 EmpManagerService 接口
 *      7——service 中的 EmpManagerService 接口的实现类 EmpManagerServiceImpl
 *      8——web 下的login.jsp
 *      9——controller 中的 EmpManagerLoginController
 *      10——controller 中的 ShowAllEmpController
 *      11—— controller 中的 CreateCodeController ——生成验证码
 *      12—— entity 实体类下的 Emp
 *      13—— entity 实体类下的 Page  （分页）
 *
 */
public class Page {
    private Integer pageIndex;//当前页码

    private Integer pageSize;//页大小

    private Integer totalCounts;//数据总条数

    private Integer totalPages;//总页数

    private Integer startRows;//起始行

    //方法—— 一参 两参    所有的get和set

    public Page(Integer pageIndex) {
        this(pageIndex,5);
    }

    public Page(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.setStartRows((pageIndex - 1) * pageSize);
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;

        this.setTotalPages(this.totalCounts % this.pageSize ==0? this.totalCounts / this.pageSize : this.totalCounts / this.pageSize + 1);
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getStartRows() {
        return startRows;
    }

    public void setStartRows(Integer startRows) {
        this.startRows = startRows;
    }
}


/*
————》 dao.EmpDao 接口
 */