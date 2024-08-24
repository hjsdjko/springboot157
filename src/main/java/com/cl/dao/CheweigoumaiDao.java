package com.cl.dao;

import com.cl.entity.CheweigoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweigoumaiView;


/**
 * 车位购买
 * 
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface CheweigoumaiDao extends BaseMapper<CheweigoumaiEntity> {
	
	List<CheweigoumaiView> selectListView(@Param("ew") Wrapper<CheweigoumaiEntity> wrapper);

	List<CheweigoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<CheweigoumaiEntity> wrapper);
	
	CheweigoumaiView selectView(@Param("ew") Wrapper<CheweigoumaiEntity> wrapper);
	

}
