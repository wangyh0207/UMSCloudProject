package cn.ekgc.ums.base.pojo.vo;

import cn.ekgc.ums.base.pojo.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * <b>系统响应视图对象</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
public class ResponseVO<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer code;                   // 响应编码
	private boolean result;                 // 系统处理结果
	private E data;                         // 响应信息

	public ResponseVO() {}
	public ResponseVO(ResponseCodeEnum codeEnum) {
		this.code = codeEnum.getCode();
	}

	public ResponseVO(ResponseCodeEnum codeEnum, boolean result) {
		this.code = codeEnum.getCode();
		this.result = result;
	}

	public ResponseVO(ResponseCodeEnum codeEnum, E data) {
		this.code = codeEnum.getCode();
		this.data = data;
	}

	public ResponseVO(ResponseCodeEnum codeEnum, boolean result, E data) {
		this.code = codeEnum.getCode();
		this.result = result;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * <b>获得系统处理成功响应视图</b>
	 * @return
	 */
	public static ResponseVO successResponse() {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, true);
	}

	/**
	 * <b>获得系统处理成功响应视图</b>
	 * @return
	 */
	public static ResponseVO successResponse(Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, true, data);
	}

	/**
	 * <b>获得系统处理错误响应视图</b>
	 * @return
	 */
	public static ResponseVO errorResponse() {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, false);
	}

	/**
	 * <b>获得系统处理错误响应视图</b>
	 * @return
	 */
	public static ResponseVO errorResponse(Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, false, data);
	}

	/**
	 * <b>获得系统处理失败响应视图</b>
	 * @return
	 */
	public static ResponseVO failureResponse() {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_500, false);
	}

	/**
	 * <b>获得系统处理失败响应视图</b>
	 * @return
	 */
	public static ResponseVO failureResponse(Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_500, false, data);
	}
}
