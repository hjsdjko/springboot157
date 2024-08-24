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


import com.cl.dao.CheliangxinxiDao;
import com.cl.entity.CheliangxinxiEntity;
import com.cl.service.CheliangxinxiService;
import com.cl.entity.view.CheliangxinxiView;

@Service("cheliangxinxiService")
public class CheliangxinxiServiceImpl extends ServiceImpl<CheliangxinxiDao, CheliangxinxiEntity> implements CheliangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheliangxinxiEntity> page = this.selectPage(
                new Query<CheliangxinxiEntity>(params).getPage(),
                new EntityWrapper<CheliangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheliangxinxiEntity> wrapper) {
		  Page<CheliangxinxiView> page =new Query<CheliangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CheliangxinxiView> selectListView(Wrapper<CheliangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheliangxinxiView selectView(Wrapper<CheliangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
