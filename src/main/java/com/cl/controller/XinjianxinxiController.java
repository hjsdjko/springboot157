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

import com.cl.entity.XinjianxinxiEntity;
import com.cl.entity.view.XinjianxinxiView;

import com.cl.service.XinjianxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 信件信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
@RestController
@RequestMapping("/xinjianxinxi")
public class XinjianxinxiController {
    @Autowired
    private XinjianxinxiService xinjianxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinjianxinxiEntity xinjianxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xinjianxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XinjianxinxiEntity> ew = new EntityWrapper<XinjianxinxiEntity>();

		PageUtils page = xinjianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinjianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinjianxinxiEntity xinjianxinxi, 
		HttpServletRequest request){
        EntityWrapper<XinjianxinxiEntity> ew = new EntityWrapper<XinjianxinxiEntity>();

		PageUtils page = xinjianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinjianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinjianxinxiEntity xinjianxinxi){
       	EntityWrapper<XinjianxinxiEntity> ew = new EntityWrapper<XinjianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinjianxinxi, "xinjianxinxi")); 
        return R.ok().put("data", xinjianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinjianxinxiEntity xinjianxinxi){
        EntityWrapper< XinjianxinxiEntity> ew = new EntityWrapper< XinjianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinjianxinxi, "xinjianxinxi")); 
		XinjianxinxiView xinjianxinxiView =  xinjianxinxiService.selectView(ew);
		return R.ok("查询信件信息成功").put("data", xinjianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinjianxinxiEntity xinjianxinxi = xinjianxinxiService.selectById(id);
		xinjianxinxi = xinjianxinxiService.selectView(new EntityWrapper<XinjianxinxiEntity>().eq("id", id));
        return R.ok().put("data", xinjianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinjianxinxiEntity xinjianxinxi = xinjianxinxiService.selectById(id);
		xinjianxinxi = xinjianxinxiService.selectView(new EntityWrapper<XinjianxinxiEntity>().eq("id", id));
        return R.ok().put("data", xinjianxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinjianxinxiEntity xinjianxinxi, HttpServletRequest request){
    	xinjianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinjianxinxi);
        xinjianxinxiService.insert(xinjianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinjianxinxiEntity xinjianxinxi, HttpServletRequest request){
    	xinjianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinjianxinxi);
        xinjianxinxiService.insert(xinjianxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinjianxinxiEntity xinjianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinjianxinxi);
        xinjianxinxiService.updateById(xinjianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinjianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
