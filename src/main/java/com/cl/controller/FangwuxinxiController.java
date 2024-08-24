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

import com.cl.entity.FangwuxinxiEntity;
import com.cl.entity.view.FangwuxinxiView;

import com.cl.service.FangwuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房屋信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
@RestController
@RequestMapping("/fangwuxinxi")
public class FangwuxinxiController {
    @Autowired
    private FangwuxinxiService fangwuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangwuxinxiEntity fangwuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			fangwuxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangwuxinxiEntity> ew = new EntityWrapper<FangwuxinxiEntity>();

		PageUtils page = fangwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangwuxinxiEntity fangwuxinxi, 
		HttpServletRequest request){
        EntityWrapper<FangwuxinxiEntity> ew = new EntityWrapper<FangwuxinxiEntity>();

		PageUtils page = fangwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangwuxinxiEntity fangwuxinxi){
       	EntityWrapper<FangwuxinxiEntity> ew = new EntityWrapper<FangwuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangwuxinxi, "fangwuxinxi")); 
        return R.ok().put("data", fangwuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangwuxinxiEntity fangwuxinxi){
        EntityWrapper< FangwuxinxiEntity> ew = new EntityWrapper< FangwuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangwuxinxi, "fangwuxinxi")); 
		FangwuxinxiView fangwuxinxiView =  fangwuxinxiService.selectView(ew);
		return R.ok("查询房屋信息成功").put("data", fangwuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangwuxinxiEntity fangwuxinxi = fangwuxinxiService.selectById(id);
		fangwuxinxi = fangwuxinxiService.selectView(new EntityWrapper<FangwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangwuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangwuxinxiEntity fangwuxinxi = fangwuxinxiService.selectById(id);
		fangwuxinxi = fangwuxinxiService.selectView(new EntityWrapper<FangwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangwuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangwuxinxiEntity fangwuxinxi, HttpServletRequest request){
    	fangwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangwuxinxi);
        fangwuxinxiService.insert(fangwuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangwuxinxiEntity fangwuxinxi, HttpServletRequest request){
    	fangwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangwuxinxi);
        fangwuxinxiService.insert(fangwuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangwuxinxiEntity fangwuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuxinxi);
        fangwuxinxiService.updateById(fangwuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangwuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
