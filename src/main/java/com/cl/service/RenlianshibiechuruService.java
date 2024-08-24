package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenlianshibiechuruEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenlianshibiechuruView;


/**
 * 人脸识别出入
 *
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
public interface RenlianshibiechuruService extends IService<RenlianshibiechuruEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenlianshibiechuruView> selectListView(Wrapper<RenlianshibiechuruEntity> wrapper);
   	
   	RenlianshibiechuruView selectView(@Param("ew") Wrapper<RenlianshibiechuruEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenlianshibiechuruEntity> wrapper);
   	

}

