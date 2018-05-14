package com.peng.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * DataGridResult 表示返回结果
 *
 * @author renyapeng
 * @date 2018/05/12
 */
public class DataGridResult implements Serializable {

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页的数据列表，数组
     */
    private List rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public DataGridResult() {
    }

    public DataGridResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}