package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheliangxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangxinxiView;


/**
 * 车辆信息
 *
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface CheliangxinxiService extends IService<CheliangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangxinxiView> selectListView(Wrapper<CheliangxinxiEntity> wrapper);
   	
   	CheliangxinxiView selectView(@Param("ew") Wrapper<CheliangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangxinxiEntity> wrapper);
   	

}

