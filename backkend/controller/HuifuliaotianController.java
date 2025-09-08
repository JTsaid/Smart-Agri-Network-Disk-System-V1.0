package com.controller;

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

import com.utils.ValidatorUtils;
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
import com.annotation.IgnoreAuth;

import com.entity.HuifuliaotianEntity;
import com.entity.view.HuifuliaotianView;

import com.service.HuifuliaotianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 回复聊天
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
@RestController
@RequestMapping("/huifuliaotian")
public class HuifuliaotianController {
    @Autowired
    private HuifuliaotianService huifuliaotianService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuifuliaotianEntity huifuliaotian,
		HttpServletRequest request){
        EntityWrapper<HuifuliaotianEntity> ew = new EntityWrapper<HuifuliaotianEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("wodezhanghao", (String)request.getSession().getAttribute("username"));
        }
		PageUtils page = huifuliaotianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huifuliaotian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuifuliaotianEntity huifuliaotian, 
		HttpServletRequest request){
        EntityWrapper<HuifuliaotianEntity> ew = new EntityWrapper<HuifuliaotianEntity>();

		PageUtils page = huifuliaotianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huifuliaotian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuifuliaotianEntity huifuliaotian){
       	EntityWrapper<HuifuliaotianEntity> ew = new EntityWrapper<HuifuliaotianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huifuliaotian, "huifuliaotian")); 
        return R.ok().put("data", huifuliaotianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuifuliaotianEntity huifuliaotian){
        EntityWrapper< HuifuliaotianEntity> ew = new EntityWrapper< HuifuliaotianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huifuliaotian, "huifuliaotian")); 
		HuifuliaotianView huifuliaotianView =  huifuliaotianService.selectView(ew);
		return R.ok("查询回复聊天成功").put("data", huifuliaotianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuifuliaotianEntity huifuliaotian = huifuliaotianService.selectById(id);
        return R.ok().put("data", huifuliaotian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuifuliaotianEntity huifuliaotian = huifuliaotianService.selectById(id);
        return R.ok().put("data", huifuliaotian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuifuliaotianEntity huifuliaotian, HttpServletRequest request){
    	huifuliaotian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huifuliaotian);
        huifuliaotianService.insert(huifuliaotian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuifuliaotianEntity huifuliaotian, HttpServletRequest request){
    	huifuliaotian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huifuliaotian);
        huifuliaotianService.insert(huifuliaotian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuifuliaotianEntity huifuliaotian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huifuliaotian);
        huifuliaotianService.updateById(huifuliaotian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huifuliaotianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
