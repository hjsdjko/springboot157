package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FeiyongxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FeiyongxinxiView;


/**
 * 费用信息
 *
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface FeiyongxinxiService extends IService<FeiyongxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FeiyongxinxiView> selectListView(Wrapper<FeiyongxinxiEntity> wrapper);
   	
   	FeiyongxinxiView selectView(@Param("ew") Wrapper<FeiyongxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FeiyongxinxiEntity> wrapper);
   	

}

