package com.zzh.qo;

/**
 * @author zzh
 * @description
 * @date
 */
public class Page {
    private Integer page = 1;
    private Integer pageSize = 4;
    private Integer index;
    private Integer count;
    private Integer pageTotal;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getIndex() {
        return (this.page-1)*pageSize;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageTotal() {
        pageTotal =this.count % this.pageSize ==0? this.count / this.pageSize : this.count / this.pageSize+1;
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }
}
