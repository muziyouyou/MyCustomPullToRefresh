package com.itheima.oschina.bean;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 动态实体列表
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年10月22日 下午3:34:21
 * 
 */
@SuppressWarnings("serial")
@XStreamAlias("oschina")
public class ActiveListNote extends Entity implements ListEntity<Active> {

    public final static int CATALOG_LASTEST = 1;// 最新
    public final static int CATALOG_ATME = 2;// @我
    public final static int CATALOG_COMMENT = 3;// 评论
    public final static int CATALOG_MYSELF = 4;// 我自己

    @XStreamAlias("pagesize")
    private int pageSize;

    @XStreamAlias("activeCount")
    private int activeCount;

    @XStreamAlias("notice")
    private Notice notice;
    
    public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	@XStreamAlias("activies")
    private List<Active> activelist = new ArrayList<Active>();
    
    public int getPageSize() {
	return pageSize;
    }

    public int getActiveCount() {
	return activeCount;
    }

    public List<Active> getActivelist() {
	return activelist;
    }

    @Override
    public List<Active> getList() {
	return activelist;
    }
    
    


}
