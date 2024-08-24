package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.HuodongxinxiDao;
import com.cl.entity.HuodongxinxiEntity;
import com.cl.service.HuodongxinxiService;
import com.cl.entity.view.HuodongxinxiView;

@Service("huodongxinxiService")
public class HuodongxinxiServiceImpl extends ServiceImpl<HuodongxinxiDao, HuodongxinxiEntity> implements HuodongxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongxinxiEntity> page = this.selectPage(
                new Query<HuodongxinxiEntity>(params).getPage(),
                new EntityWrapper<HuodongxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongxinxiEntity> wrapper) {
		  Page<HuodongxinxiView> page =new Query<HuodongxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuodongxinxiView> selectListView(Wrapper<HuodongxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongxinxiView selectView(Wrapper<HuodongxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
