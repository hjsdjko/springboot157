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

import com.cl.entity.TousuxinxiEntity;
import com.cl.entity.view.TousuxinxiView;

import com.cl.service.TousuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 投诉信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
@RestController
@RequestMapping("/tousuxinxi")
public class TousuxinxiController {
    @Autowired
    private TousuxinxiService tousuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TousuxinxiEntity tousuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tousuxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TousuxinxiEntity> ew = new EntityWrapper<TousuxinxiEntity>();

		PageUtils page = tousuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TousuxinxiEntity tousuxinxi, 
		HttpServletRequest request){
        EntityWrapper<TousuxinxiEntity> ew = new EntityWrapper<TousuxinxiEntity>();

		PageUtils page = tousuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TousuxinxiEntity tousuxinxi){
       	EntityWrapper<TousuxinxiEntity> ew = new EntityWrapper<TousuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tousuxinxi, "tousuxinxi")); 
        return R.ok().put("data", tousuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TousuxinxiEntity tousuxinxi){
        EntityWrapper< TousuxinxiEntity> ew = new EntityWrapper< TousuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tousuxinxi, "tousuxinxi")); 
		TousuxinxiView tousuxinxiView =  tousuxinxiService.selectView(ew);
		return R.ok("查询投诉信息成功").put("data", tousuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TousuxinxiEntity tousuxinxi = tousuxinxiService.selectById(id);
		tousuxinxi = tousuxinxiService.selectView(new EntityWrapper<TousuxinxiEntity>().eq("id", id));
        return R.ok().put("data", tousuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TousuxinxiEntity tousuxinxi = tousuxinxiService.selectById(id);
		tousuxinxi = tousuxinxiService.selectView(new EntityWrapper<TousuxinxiEntity>().eq("id", id));
        return R.ok().put("data", tousuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TousuxinxiEntity tousuxinxi, HttpServletRequest request){
    	tousuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tousuxinxi);
        tousuxinxiService.insert(tousuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TousuxinxiEntity tousuxinxi, HttpServletRequest request){
    	tousuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tousuxinxi);
        tousuxinxiService.insert(tousuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TousuxinxiEntity tousuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousuxinxi);
        tousuxinxiService.updateById(tousuxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TousuxinxiEntity> list = new ArrayList<TousuxinxiEntity>();
        for(Long id : ids) {
            TousuxinxiEntity tousuxinxi = tousuxinxiService.selectById(id);
            tousuxinxi.setSfsh(sfsh);
            tousuxinxi.setShhf(shhf);
            list.add(tousuxinxi);
        }
        tousuxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tousuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
