package cn.hucode.mall.account.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * 账号表 实体
 *
 * @author hujj
 */
@Setter
@Getter
@ToString
@Table(name = "account")
@ApiModel("账号表")
public class Account implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	@Id
    @ApiModelProperty("id")
	private Long id;
	
	/**
	 * 账号名（登录名）
	 */
    @ApiModelProperty("账号名（登录名）")
	private String accountName;
	
	/**
	 * 昵称
	 */
    @ApiModelProperty("昵称")
	private String nickName;
	
	/**
	 * 密码
	 */
    @ApiModelProperty("密码")
	private String password;
	
	/**
	 * 密码加密slat
	 */
    @ApiModelProperty("密码加密slat")
	private String slat;
	
	/**
	 * 手机号
	 */
    @ApiModelProperty("手机号")
	private String mobile;
	
	/**
	 * Email
	 */
    @ApiModelProperty("Email")
	private String email;
	
	/**
	 * 状态 0-正常 1-禁用
	 */
    @ApiModelProperty("状态 0-正常 1-禁用")
	private Integer status;
	
	/**
	 * createdAt
	 */
    @ApiModelProperty("createdAt")
	private Date createdAt;
	
	/**
	 * updatedAt
	 */
    @ApiModelProperty("updatedAt")
	private Date updatedAt;
	
	/**
	 * deletedAt
	 */
    @ApiModelProperty("deletedAt")
	private Date deletedAt;
}
