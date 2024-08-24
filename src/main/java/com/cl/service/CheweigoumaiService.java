package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheweigoumaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweigoumaiView;


/**
 * 车位购买
 *
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface CheweigoumaiService extends IService<CheweigoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheweigoumaiView> selectListView(Wrapper<CheweigoumaiEntity> wrapper);
   	
   	CheweigoumaiView selectView(@Param("ew") Wrapper<CheweigoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheweigoumaiEntity> wrapper);
   	

}

