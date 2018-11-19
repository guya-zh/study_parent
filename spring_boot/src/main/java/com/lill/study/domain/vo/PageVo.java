package com.lill.study.domain.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/10/23 18:58
 * @description 描述当前类的用途
 */
public class PageVo {
    private Integer total; // 数据总条数
    private Integer pageSize; // 每页显示条数 只能为20 30 50 默认20
    private Integer pageNum; // 当前页码
    private Integer pageCount; // 页码总数
    private List<?> resultList;// 查询结果集
    private Integer start; // 查询开始值
    private Map<String, String> map;//搜索参数

    public Map<String, String> getMap() {
        if (map == null)
            map = new HashMap<String, String>();
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNum() {
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        } else {
            if (getPageCount() != null && pageCount != 0) {
                if (pageNum > pageCount) {
                    pageNum = pageCount;
                }
            }
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageCount() {
        pageCount = total / getPageSize() + (total % getPageSize() == 0 ? 0 : 1);
        return pageCount;
    }

    public List<?> getResultList() {
        return resultList;
    }

    public void setResultList(List<?> resultList) {
        this.resultList = resultList;
    }

    public Integer getStart() {
        start = (getPageNum() - 1) * getPageSize();
        return start;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
