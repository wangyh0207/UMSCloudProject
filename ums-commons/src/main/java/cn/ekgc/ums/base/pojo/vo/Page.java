package cn.ekgc.ums.base.pojo.vo;

import cn.ekgc.ums.util.ConstantUtil;

import java.io.Serializable;
import java.util.List;

/**
 * <b>分页视图信息</b>
 * @param <E>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
public class Page<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;
	private Integer pageSize;
	private List<E> list;
	private Integer draw;
	private Long totalCount;
	private Integer totalPage;

	public Page() {}

	public Page(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0) {
			// pageNum 有效
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}

		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
	}

	public Page(Integer pageNum, Integer pageSize, Integer draw) {
		if (pageNum != null && pageNum > 0) {
			// pageNum 有效
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}

		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
		this.draw = draw;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
