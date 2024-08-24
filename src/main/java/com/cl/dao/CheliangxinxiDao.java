package com.cl.dao;

import com.cl.entity.CheliangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangxinxiView;


/**
 * 车辆信息
 * 
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface CheliangxinxiDao extends BaseMapper<CheliangxinxiEntity> {
	
	List<CheliangxinxiView> selectListView(@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);

	List<CheliangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);
	
	CheliangxinxiView selectView(@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);
	

}
