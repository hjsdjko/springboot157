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


import com.cl.dao.XinjianxinxiDao;
import com.cl.entity.XinjianxinxiEntity;
import com.cl.service.XinjianxinxiService;
import com.cl.entity.view.XinjianxinxiView;

@Service("xinjianxinxiService")
public class XinjianxinxiServiceImpl extends ServiceImpl<XinjianxinxiDao, XinjianxinxiEntity> implements XinjianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinjianxinxiEntity> page = this.selectPage(
                new Query<XinjianxinxiEntity>(params).getPage(),
                new EntityWrapper<XinjianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinjianxinxiEntity> wrapper) {
		  Page<XinjianxinxiView> page =new Query<XinjianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XinjianxinxiView> selectListView(Wrapper<XinjianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinjianxinxiView selectView(Wrapper<XinjianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
