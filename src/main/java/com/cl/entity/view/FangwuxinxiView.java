package com.cl.entity.view;

import com.cl.entity.FangwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 房屋信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
@TableName("fangwuxinxi")
public class FangwuxinxiView  extends FangwuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FangwuxinxiView(){
	}
 
 	public FangwuxinxiView(FangwuxinxiEntity fangwuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, fangwuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
