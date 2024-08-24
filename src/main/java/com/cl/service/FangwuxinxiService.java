package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangwuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuxinxiView;


/**
 * 房屋信息
 *
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface FangwuxinxiService extends IService<FangwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwuxinxiView> selectListView(Wrapper<FangwuxinxiEntity> wrapper);
   	
   	FangwuxinxiView selectView(@Param("ew") Wrapper<FangwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwuxinxiEntity> wrapper);
   	

}

