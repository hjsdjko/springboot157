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

import com.cl.entity.RenlianshibiechuruEntity;
import com.cl.entity.view.RenlianshibiechuruView;

import com.cl.service.RenlianshibiechuruService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 人脸识别出入
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 09:08:22
 */
@RestController
@RequestMapping("/renlianshibiechuru")
public class RenlianshibiechuruController {
    @Autowired
    private RenlianshibiechuruService renlianshibiechuruService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenlianshibiechuruEntity renlianshibiechuru,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			renlianshibiechuru.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RenlianshibiechuruEntity> ew = new EntityWrapper<RenlianshibiechuruEntity>();

		PageUtils page = renlianshibiechuruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renlianshibiechuru), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenlianshibiechuruEntity renlianshibiechuru, 
		HttpServletRequest request){
        EntityWrapper<RenlianshibiechuruEntity> ew = new EntityWrapper<RenlianshibiechuruEntity>();

		PageUtils page = renlianshibiechuruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renlianshibiechuru), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenlianshibiechuruEntity renlianshibiechuru){
       	EntityWrapper<RenlianshibiechuruEntity> ew = new EntityWrapper<RenlianshibiechuruEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renlianshibiechuru, "renlianshibiechuru")); 
        return R.ok().put("data", renlianshibiechuruService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenlianshibiechuruEntity renlianshibiechuru){
        EntityWrapper< RenlianshibiechuruEntity> ew = new EntityWrapper< RenlianshibiechuruEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renlianshibiechuru, "renlianshibiechuru")); 
		RenlianshibiechuruView renlianshibiechuruView =  renlianshibiechuruService.selectView(ew);
		return R.ok("查询人脸识别出入成功").put("data", renlianshibiechuruView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenlianshibiechuruEntity renlianshibiechuru = renlianshibiechuruService.selectById(id);
		renlianshibiechuru = renlianshibiechuruService.selectView(new EntityWrapper<RenlianshibiechuruEntity>().eq("id", id));
        return R.ok().put("data", renlianshibiechuru);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenlianshibiechuruEntity renlianshibiechuru = renlianshibiechuruService.selectById(id);
		renlianshibiechuru = renlianshibiechuruService.selectView(new EntityWrapper<RenlianshibiechuruEntity>().eq("id", id));
        return R.ok().put("data", renlianshibiechuru);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RenlianshibiechuruEntity renlianshibiechuru, HttpServletRequest request){
    	renlianshibiechuru.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renlianshibiechuru);
        renlianshibiechuruService.insert(renlianshibiechuru);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RenlianshibiechuruEntity renlianshibiechuru, HttpServletRequest request){
    	renlianshibiechuru.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renlianshibiechuru);
        renlianshibiechuruService.insert(renlianshibiechuru);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RenlianshibiechuruEntity renlianshibiechuru, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renlianshibiechuru);
        renlianshibiechuruService.updateById(renlianshibiechuru);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        renlianshibiechuruService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
