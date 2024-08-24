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


import com.cl.dao.RenlianshibiechuruDao;
import com.cl.entity.RenlianshibiechuruEntity;
import com.cl.service.RenlianshibiechuruService;
import com.cl.entity.view.RenlianshibiechuruView;

@Service("renlianshibiechuruService")
public class RenlianshibiechuruServiceImpl extends ServiceImpl<RenlianshibiechuruDao, RenlianshibiechuruEntity> implements RenlianshibiechuruService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenlianshibiechuruEntity> page = this.selectPage(
                new Query<RenlianshibiechuruEntity>(params).getPage(),
                new EntityWrapper<RenlianshibiechuruEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenlianshibiechuruEntity> wrapper) {
		  Page<RenlianshibiechuruView> page =new Query<RenlianshibiechuruView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RenlianshibiechuruView> selectListView(Wrapper<RenlianshibiechuruEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenlianshibiechuruView selectView(Wrapper<RenlianshibiechuruEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
