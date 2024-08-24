package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XinjianxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinjianxinxiView;


/**
 * 信件信息
 *
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface XinjianxinxiService extends IService<XinjianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinjianxinxiView> selectListView(Wrapper<XinjianxinxiEntity> wrapper);
   	
   	XinjianxinxiView selectView(@Param("ew") Wrapper<XinjianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinjianxinxiEntity> wrapper);
   	

}

