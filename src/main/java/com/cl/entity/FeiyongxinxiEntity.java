package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 费用信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
@TableName("feiyongxinxi")
public class FeiyongxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FeiyongxinxiEntity() {
		
	}
	
	public FeiyongxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 小区名称
	 */
					
	private String xiaoqumingcheng;
	
	/**
	 * 房间号
	 */
					
	private String fangjianhao;
	
	/**
	 * 楼栋数
	 */
					
	private String loudongshu;
	
	/**
	 * 物业费
	 */
					
	private Double wuyefei;
	
	/**
	 * 取暖费
	 */
					
	private Double qunuanfei;
	
	/**
	 * 水电费
	 */
					
	private Double shuidianfei;
	
	/**
	 * 收费金额
	 */
					
	private Double shoufeijine;
	
	/**
	 * 结算时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiesuanshijian;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：小区名称
	 */
	public void setXiaoqumingcheng(String xiaoqumingcheng) {
		this.xiaoqumingcheng = xiaoqumingcheng;
	}
	/**
	 * 获取：小区名称
	 */
	public String getXiaoqumingcheng() {
		return xiaoqumingcheng;
	}
	/**
	 * 设置：房间号
	 */
	public void setFangjianhao(String fangjianhao) {
		this.fangjianhao = fangjianhao;
	}
	/**
	 * 获取：房间号
	 */
	public String getFangjianhao() {
		return fangjianhao;
	}
	/**
	 * 设置：楼栋数
	 */
	public void setLoudongshu(String loudongshu) {
		this.loudongshu = loudongshu;
	}
	/**
	 * 获取：楼栋数
	 */
	public String getLoudongshu() {
		return loudongshu;
	}
	/**
	 * 设置：物业费
	 */
	public void setWuyefei(Double wuyefei) {
		this.wuyefei = wuyefei;
	}
	/**
	 * 获取：物业费
	 */
	public Double getWuyefei() {
		return wuyefei;
	}
	/**
	 * 设置：取暖费
	 */
	public void setQunuanfei(Double qunuanfei) {
		this.qunuanfei = qunuanfei;
	}
	/**
	 * 获取：取暖费
	 */
	public Double getQunuanfei() {
		return qunuanfei;
	}
	/**
	 * 设置：水电费
	 */
	public void setShuidianfei(Double shuidianfei) {
		this.shuidianfei = shuidianfei;
	}
	/**
	 * 获取：水电费
	 */
	public Double getShuidianfei() {
		return shuidianfei;
	}
	/**
	 * 设置：收费金额
	 */
	public void setShoufeijine(Double shoufeijine) {
		this.shoufeijine = shoufeijine;
	}
	/**
	 * 获取：收费金额
	 */
	public Double getShoufeijine() {
		return shoufeijine;
	}
	/**
	 * 设置：结算时间
	 */
	public void setJiesuanshijian(Date jiesuanshijian) {
		this.jiesuanshijian = jiesuanshijian;
	}
	/**
	 * 获取：结算时间
	 */
	public Date getJiesuanshijian() {
		return jiesuanshijian;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
