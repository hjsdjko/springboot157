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

import com.cl.entity.CheweigoumaiEntity;
import com.cl.entity.view.CheweigoumaiView;

import com.cl.service.CheweigoumaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 车位购买
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
@RestController
@RequestMapping("/cheweigoumai")
public class CheweigoumaiController {
    @Autowired
    private CheweigoumaiService cheweigoumaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheweigoumaiEntity cheweigoumai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			cheweigoumai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CheweigoumaiEntity> ew = new EntityWrapper<CheweigoumaiEntity>();

		PageUtils page = cheweigoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheweigoumai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheweigoumaiEntity cheweigoumai, 
		HttpServletRequest request){
        EntityWrapper<CheweigoumaiEntity> ew = new EntityWrapper<CheweigoumaiEntity>();

		PageUtils page = cheweigoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheweigoumai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheweigoumaiEntity cheweigoumai){
       	EntityWrapper<CheweigoumaiEntity> ew = new EntityWrapper<CheweigoumaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheweigoumai, "cheweigoumai")); 
        return R.ok().put("data", cheweigoumaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheweigoumaiEntity cheweigoumai){
        EntityWrapper< CheweigoumaiEntity> ew = new EntityWrapper< CheweigoumaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheweigoumai, "cheweigoumai")); 
		CheweigoumaiView cheweigoumaiView =  cheweigoumaiService.selectView(ew);
		return R.ok("查询车位购买成功").put("data", cheweigoumaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheweigoumaiEntity cheweigoumai = cheweigoumaiService.selectById(id);
		cheweigoumai = cheweigoumaiService.selectView(new EntityWrapper<CheweigoumaiEntity>().eq("id", id));
        return R.ok().put("data", cheweigoumai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheweigoumaiEntity cheweigoumai = cheweigoumaiService.selectById(id);
		cheweigoumai = cheweigoumaiService.selectView(new EntityWrapper<CheweigoumaiEntity>().eq("id", id));
        return R.ok().put("data", cheweigoumai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheweigoumaiEntity cheweigoumai, HttpServletRequest request){
    	cheweigoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheweigoumai);
        cheweigoumaiService.insert(cheweigoumai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheweigoumaiEntity cheweigoumai, HttpServletRequest request){
    	cheweigoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheweigoumai);
        cheweigoumaiService.insert(cheweigoumai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheweigoumaiEntity cheweigoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheweigoumai);
        cheweigoumaiService.updateById(cheweigoumai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheweigoumaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
