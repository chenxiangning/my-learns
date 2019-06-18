package com.cxn.learn.es.beans.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author cxn
 * Date: 19-6-18 上午10:59
 * This is my work in reachauto code.
 * mail:chenxiangning@reachauto.com
 * Description:
 */
@Data
public class EsVO {
    // 当前页的索引值，起始值为0
    private int currentPage;
    private int currentSize;
    // 总页数
    private int totalPages;
    // 数据总数
    private long totalCount;
    private List<Map> list;
}