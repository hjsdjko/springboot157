package com.cl.dao;

import com.cl.entity.XinjianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinjianxinxiView;


/**
 * 信件信息
 * 
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface XinjianxinxiDao extends BaseMapper<XinjianxinxiEntity> {
	
	List<XinjianxinxiView> selectListView(@Param("ew") Wrapper<XinjianxinxiEntity> wrapper);

	List<XinjianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XinjianxinxiEntity> wrapper);
	
	XinjianxinxiView selectView(@Param("ew") Wrapper<XinjianxinxiEntity> wrapper);
	

}
