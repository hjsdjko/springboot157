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


import com.cl.dao.TousuxinxiDao;
import com.cl.entity.TousuxinxiEntity;
import com.cl.service.TousuxinxiService;
import com.cl.entity.view.TousuxinxiView;

@Service("tousuxinxiService")
public class TousuxinxiServiceImpl extends ServiceImpl<TousuxinxiDao, TousuxinxiEntity> implements TousuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TousuxinxiEntity> page = this.selectPage(
                new Query<TousuxinxiEntity>(params).getPage(),
                new EntityWrapper<TousuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TousuxinxiEntity> wrapper) {
		  Page<TousuxinxiView> page =new Query<TousuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TousuxinxiView> selectListView(Wrapper<TousuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TousuxinxiView selectView(Wrapper<TousuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
