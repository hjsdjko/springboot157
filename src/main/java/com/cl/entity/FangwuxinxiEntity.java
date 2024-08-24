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
 * 房屋信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
@TableName("fangwuxinxi")
public class FangwuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FangwuxinxiEntity() {
		
	}
	
	public FangwuxinxiEntity(T t) {
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
	 * 小区名称
	 */
					
	private String xiaoqumingcheng;
	
	/**
	 * 小区类型
	 */
					
	private String xiaoquleixing;
	
	/**
	 * 小区地址
	 */
					
	private String xiaoqudizhi;
	
	/**
	 * 建筑面积
	 */
					
	private Double jianzhumianji;
	
	/**
	 * 小区图片
	 */
					
	private String xiaoqutupian;
	
	/**
	 * 周围环境
	 */
					
	private String zhouweihuanjing;
	
	/**
	 * 楼栋数
	 */
					
	private Integer loudongshu;
	
	/**
	 * 房间号
	 */
					
	private String fangjianhao;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	
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
	 * 设置：小区类型
	 */
	public void setXiaoquleixing(String xiaoquleixing) {
		this.xiaoquleixing = xiaoquleixing;
	}
	/**
	 * 获取：小区类型
	 */
	public String getXiaoquleixing() {
		return xiaoquleixing;
	}
	/**
	 * 设置：小区地址
	 */
	public void setXiaoqudizhi(String xiaoqudizhi) {
		this.xiaoqudizhi = xiaoqudizhi;
	}
	/**
	 * 获取：小区地址
	 */
	public String getXiaoqudizhi() {
		return xiaoqudizhi;
	}
	/**
	 * 设置：建筑面积
	 */
	public void setJianzhumianji(Double jianzhumianji) {
		this.jianzhumianji = jianzhumianji;
	}
	/**
	 * 获取：建筑面积
	 */
	public Double getJianzhumianji() {
		return jianzhumianji;
	}
	/**
	 * 设置：小区图片
	 */
	public void setXiaoqutupian(String xiaoqutupian) {
		this.xiaoqutupian = xiaoqutupian;
	}
	/**
	 * 获取：小区图片
	 */
	public String getXiaoqutupian() {
		return xiaoqutupian;
	}
	/**
	 * 设置：周围环境
	 */
	public void setZhouweihuanjing(String zhouweihuanjing) {
		this.zhouweihuanjing = zhouweihuanjing;
	}
	/**
	 * 获取：周围环境
	 */
	public String getZhouweihuanjing() {
		return zhouweihuanjing;
	}
	/**
	 * 设置：楼栋数
	 */
	public void setLoudongshu(Integer loudongshu) {
		this.loudongshu = loudongshu;
	}
	/**
	 * 获取：楼栋数
	 */
	public Integer getLoudongshu() {
		return loudongshu;
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

}
