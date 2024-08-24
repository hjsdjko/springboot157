package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuodongxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuodongxinxiView;


/**
 * 活动信息
 *
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface HuodongxinxiService extends IService<HuodongxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongxinxiView> selectListView(Wrapper<HuodongxinxiEntity> wrapper);
   	
   	HuodongxinxiView selectView(@Param("ew") Wrapper<HuodongxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongxinxiEntity> wrapper);
   	

}

