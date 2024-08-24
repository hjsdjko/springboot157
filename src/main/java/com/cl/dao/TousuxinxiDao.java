package com.cl.dao;

import com.cl.entity.TousuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TousuxinxiView;


/**
 * 投诉信息
 * 
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface TousuxinxiDao extends BaseMapper<TousuxinxiEntity> {
	
	List<TousuxinxiView> selectListView(@Param("ew") Wrapper<TousuxinxiEntity> wrapper);

	List<TousuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TousuxinxiEntity> wrapper);
	
	TousuxinxiView selectView(@Param("ew") Wrapper<TousuxinxiEntity> wrapper);
	

}
