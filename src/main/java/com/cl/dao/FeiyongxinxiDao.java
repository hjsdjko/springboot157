package com.cl.dao;

import com.cl.entity.FeiyongxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FeiyongxinxiView;


/**
 * 费用信息
 * 
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface FeiyongxinxiDao extends BaseMapper<FeiyongxinxiEntity> {
	
	List<FeiyongxinxiView> selectListView(@Param("ew") Wrapper<FeiyongxinxiEntity> wrapper);

	List<FeiyongxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FeiyongxinxiEntity> wrapper);
	
	FeiyongxinxiView selectView(@Param("ew") Wrapper<FeiyongxinxiEntity> wrapper);
	

}
