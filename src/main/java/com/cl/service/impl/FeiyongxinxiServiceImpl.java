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


import com.cl.dao.FeiyongxinxiDao;
import com.cl.entity.FeiyongxinxiEntity;
import com.cl.service.FeiyongxinxiService;
import com.cl.entity.view.FeiyongxinxiView;

@Service("feiyongxinxiService")
public class FeiyongxinxiServiceImpl extends ServiceImpl<FeiyongxinxiDao, FeiyongxinxiEntity> implements FeiyongxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FeiyongxinxiEntity> page = this.selectPage(
                new Query<FeiyongxinxiEntity>(params).getPage(),
                new EntityWrapper<FeiyongxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FeiyongxinxiEntity> wrapper) {
		  Page<FeiyongxinxiView> page =new Query<FeiyongxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FeiyongxinxiView> selectListView(Wrapper<FeiyongxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FeiyongxinxiView selectView(Wrapper<FeiyongxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
