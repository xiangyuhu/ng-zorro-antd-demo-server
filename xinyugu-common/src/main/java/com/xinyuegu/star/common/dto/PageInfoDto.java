package com.xinyuegu.star.common.dto;

import java.util.List;

/**
 * @author hxy
 * @time 2018/1/5
 * @desc
 */
public class PageInfoDto<T> {

    List<T> results;
    long total;

    public PageInfoDto(List<T> results, long total){
        this.results = results;
        this.total = total;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
