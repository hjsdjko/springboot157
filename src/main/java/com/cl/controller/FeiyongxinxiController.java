package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.FeiyongxinxiEntity;
import com.cl.entity.view.FeiyongxinxiView;

import com.cl.service.FeiyongxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 费用信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
@RestController
@RequestMapping("/feiyongxinxi")
public class FeiyongxinxiController {
    @Autowired
    private FeiyongxinxiService feiyongxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FeiyongxinxiEntity feiyongxinxi,
                @RequestParam(required = false) Double shoufeijinestart,
                @RequestParam(required = false) Double shoufeijineend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			feiyongxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FeiyongxinxiEntity> ew = new EntityWrapper<FeiyongxinxiEntity>();
                if(shoufeijinestart!=null) ew.ge("shoufeijine", shoufeijinestart);
                if(shoufeijineend!=null) ew.le("shoufeijine", shoufeijineend);

		PageUtils page = feiyongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, feiyongxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FeiyongxinxiEntity feiyongxinxi, 
                @RequestParam(required = false) Double shoufeijinestart,
                @RequestParam(required = false) Double shoufeijineend,
		HttpServletRequest request){
        EntityWrapper<FeiyongxinxiEntity> ew = new EntityWrapper<FeiyongxinxiEntity>();
                if(shoufeijinestart!=null) ew.ge("shoufeijine", shoufeijinestart);
                if(shoufeijineend!=null) ew.le("shoufeijine", shoufeijineend);

		PageUtils page = feiyongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, feiyongxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FeiyongxinxiEntity feiyongxinxi){
       	EntityWrapper<FeiyongxinxiEntity> ew = new EntityWrapper<FeiyongxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( feiyongxinxi, "feiyongxinxi")); 
        return R.ok().put("data", feiyongxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FeiyongxinxiEntity feiyongxinxi){
        EntityWrapper< FeiyongxinxiEntity> ew = new EntityWrapper< FeiyongxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( feiyongxinxi, "feiyongxinxi")); 
		FeiyongxinxiView feiyongxinxiView =  feiyongxinxiService.selectView(ew);
		return R.ok("查询费用信息成功").put("data", feiyongxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FeiyongxinxiEntity feiyongxinxi = feiyongxinxiService.selectById(id);
		feiyongxinxi = feiyongxinxiService.selectView(new EntityWrapper<FeiyongxinxiEntity>().eq("id", id));
        return R.ok().put("data", feiyongxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FeiyongxinxiEntity feiyongxinxi = feiyongxinxiService.selectById(id);
		feiyongxinxi = feiyongxinxiService.selectView(new EntityWrapper<FeiyongxinxiEntity>().eq("id", id));
        return R.ok().put("data", feiyongxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FeiyongxinxiEntity feiyongxinxi, HttpServletRequest request){
    	feiyongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(feiyongxinxi);
        feiyongxinxiService.insert(feiyongxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FeiyongxinxiEntity feiyongxinxi, HttpServletRequest request){
    	feiyongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(feiyongxinxi);
        feiyongxinxiService.insert(feiyongxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FeiyongxinxiEntity feiyongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(feiyongxinxi);
        feiyongxinxiService.updateById(feiyongxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        feiyongxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
