package com.entity;

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
 * 资源分享
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
@TableName("ziyuanfenxiang")
public class ZiyuanfenxiangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZiyuanfenxiangEntity() {
		
	}
	
	public ZiyuanfenxiangEntity(T t) {
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
	 * 分享名称
	 */
					
	private String fenxiangmingcheng;
	
	/**
	 * 分享分类
	 */
					
	private String fenxiangfenlei;
	
	/**
	 * 二维码
	 */
					
	private String erweima;
	
	/**
	 * 文档
	 */
					
	private String wendang;
	
	/**
	 * 视频
	 */
					
	private String shipin;
	
	/**
	 * 音频
	 */
					
	private String yinpin;
	
	/**
	 * 其他文件
	 */
					
	private String qitawenjian;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 分享时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fenxiangshijian;
	
	/**
	 * 分享详情
	 */
					
	private String fenxiangxiangqing;
	
	
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
	 * 设置：分享名称
	 */
	public void setFenxiangmingcheng(String fenxiangmingcheng) {
		this.fenxiangmingcheng = fenxiangmingcheng;
	}
	/**
	 * 获取：分享名称
	 */
	public String getFenxiangmingcheng() {
		return fenxiangmingcheng;
	}
	/**
	 * 设置：分享分类
	 */
	public void setFenxiangfenlei(String fenxiangfenlei) {
		this.fenxiangfenlei = fenxiangfenlei;
	}
	/**
	 * 获取：分享分类
	 */
	public String getFenxiangfenlei() {
		return fenxiangfenlei;
	}
	/**
	 * 设置：二维码
	 */
	public void setErweima(String erweima) {
		this.erweima = erweima;
	}
	/**
	 * 获取：二维码
	 */
	public String getErweima() {
		return erweima;
	}
	/**
	 * 设置：文档
	 */
	public void setWendang(String wendang) {
		this.wendang = wendang;
	}
	/**
	 * 获取：文档
	 */
	public String getWendang() {
		return wendang;
	}
	/**
	 * 设置：视频
	 */
	public void setShipin(String shipin) {
		this.shipin = shipin;
	}
	/**
	 * 获取：视频
	 */
	public String getShipin() {
		return shipin;
	}
	/**
	 * 设置：音频
	 */
	public void setYinpin(String yinpin) {
		this.yinpin = yinpin;
	}
	/**
	 * 获取：音频
	 */
	public String getYinpin() {
		return yinpin;
	}
	/**
	 * 设置：其他文件
	 */
	public void setQitawenjian(String qitawenjian) {
		this.qitawenjian = qitawenjian;
	}
	/**
	 * 获取：其他文件
	 */
	public String getQitawenjian() {
		return qitawenjian;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：分享时间
	 */
	public void setFenxiangshijian(Date fenxiangshijian) {
		this.fenxiangshijian = fenxiangshijian;
	}
	/**
	 * 获取：分享时间
	 */
	public Date getFenxiangshijian() {
		return fenxiangshijian;
	}
	/**
	 * 设置：分享详情
	 */
	public void setFenxiangxiangqing(String fenxiangxiangqing) {
		this.fenxiangxiangqing = fenxiangxiangqing;
	}
	/**
	 * 获取：分享详情
	 */
	public String getFenxiangxiangqing() {
		return fenxiangxiangqing;
	}

}
