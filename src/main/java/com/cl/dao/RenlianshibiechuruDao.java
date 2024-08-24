package com.cl.dao;

import com.cl.entity.RenlianshibiechuruEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenlianshibiechuruView;


/**
 * 人脸识别出入
 * 
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface RenlianshibiechuruDao extends BaseMapper<RenlianshibiechuruEntity> {
	
	List<RenlianshibiechuruView> selectListView(@Param("ew") Wrapper<RenlianshibiechuruEntity> wrapper);

	List<RenlianshibiechuruView> selectListView(Pagination page,@Param("ew") Wrapper<RenlianshibiechuruEntity> wrapper);
	
	RenlianshibiechuruView selectView(@Param("ew") Wrapper<RenlianshibiechuruEntity> wrapper);
	

}
