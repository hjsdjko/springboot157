package com.cl.dao;

import com.cl.entity.FangwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuxinxiView;


/**
 * 房屋信息
 * 
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface FangwuxinxiDao extends BaseMapper<FangwuxinxiEntity> {
	
	List<FangwuxinxiView> selectListView(@Param("ew") Wrapper<FangwuxinxiEntity> wrapper);

	List<FangwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FangwuxinxiEntity> wrapper);
	
	FangwuxinxiView selectView(@Param("ew") Wrapper<FangwuxinxiEntity> wrapper);
	

}
