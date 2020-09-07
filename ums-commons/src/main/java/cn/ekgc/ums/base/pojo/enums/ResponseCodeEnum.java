package cn.ekgc.ums.base.pojo.enums;

/**
 * <b>系统响应码枚举信息</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
public enum  ResponseCodeEnum {
	RESPONSE_CODE_200(200, "系统响应成功"),
	RESPONSE_CODE_500(500, "系统响应失败");

	private Integer code;               // 响应吗
	private String remark;              // 说明

	private ResponseCodeEnum(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
