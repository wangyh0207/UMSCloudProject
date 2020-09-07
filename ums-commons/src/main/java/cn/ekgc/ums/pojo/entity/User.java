package cn.ekgc.ums.pojo.entity;

import cn.ekgc.ums.base.pojo.entity.BaseEntity;

import java.io.Serializable;

/**
 * <b>用户信息实体类</b>
 * @author wangyuhang
 * @version 4.0.0
 * @since 4.0.0
 */
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private Long id;                        // 主键
	private String name;                    // 姓名
	private String cellphone;               // 手机号码
	private String password;                // 登陆密码
	private String idCard;                  // 身份证号码
	private String email;                   // 电子邮件
	private String avatar;                  // 头像
	private String introduce;               // 自我介绍

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
