package cn.ekgc.ums.base.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础实体信息</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer status;                     // 状态：0-禁用，1-启用
	private Date createTime;                    // 创建时间
	private Date updateTime;                    // 修改时间

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
