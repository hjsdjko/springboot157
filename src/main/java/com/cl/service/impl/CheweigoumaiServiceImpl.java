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


import com.cl.dao.CheweigoumaiDao;
import com.cl.entity.CheweigoumaiEntity;
import com.cl.service.CheweigoumaiService;
import com.cl.entity.view.CheweigoumaiView;

@Service("cheweigoumaiService")
public class CheweigoumaiServiceImpl extends ServiceImpl<CheweigoumaiDao, CheweigoumaiEntity> implements CheweigoumaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheweigoumaiEntity> page = this.selectPage(
                new Query<CheweigoumaiEntity>(params).getPage(),
                new EntityWrapper<CheweigoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheweigoumaiEntity> wrapper) {
		  Page<CheweigoumaiView> page =new Query<CheweigoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CheweigoumaiView> selectListView(Wrapper<CheweigoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheweigoumaiView selectView(Wrapper<CheweigoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
