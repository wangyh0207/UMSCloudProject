package cn.ekgc.ums.util;

import cn.ekgc.ums.base.pojo.vo.Page;
import com.github.pagehelper.PageInfo;

/**
 * <b>分页信息转换工具类</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
public class PageUtil {
	/**
	 * <b>从 PageHelper 的分页信息 PageInfo 中提取数据，转换到系统分页对象 Page 中</b>
	 * @param page
	 * @param pageInfo
	 * @return
	 */
	public static Page parsePageFromPageInfo(Page page, PageInfo pageInfo) {
		// 从 PageHelper 的分页信息 PageInfo 中提取数据，转换到系统分页对象 Page 中
		page.setList(pageInfo.getList());
		page.setTotalCount(pageInfo.getTotal());
		page.setTotalPage(pageInfo.getPages());
		return page;
	}
}