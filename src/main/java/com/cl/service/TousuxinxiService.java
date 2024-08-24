package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TousuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TousuxinxiView;


/**
 * 投诉信息
 *
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface TousuxinxiService extends IService<TousuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TousuxinxiView> selectListView(Wrapper<TousuxinxiEntity> wrapper);
   	
   	TousuxinxiView selectView(@Param("ew") Wrapper<TousuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TousuxinxiEntity> wrapper);
   	

}

