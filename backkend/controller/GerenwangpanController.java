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

import com.entity.GerenwangpanEntity;
import com.entity.view.GerenwangpanView;

import com.service.GerenwangpanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 个人网盘
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
@RestController
@RequestMapping("/gerenwangpan")
public class GerenwangpanController {
    @Autowired
    private GerenwangpanService gerenwangpanService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GerenwangpanEntity gerenwangpan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			gerenwangpan.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GerenwangpanEntity> ew = new EntityWrapper<GerenwangpanEntity>();

		PageUtils page = gerenwangpanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gerenwangpan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GerenwangpanEntity gerenwangpan, 
		HttpServletRequest request){
        EntityWrapper<GerenwangpanEntity> ew = new EntityWrapper<GerenwangpanEntity>();

		PageUtils page = gerenwangpanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gerenwangpan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GerenwangpanEntity gerenwangpan){
       	EntityWrapper<GerenwangpanEntity> ew = new EntityWrapper<GerenwangpanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gerenwangpan, "gerenwangpan")); 
        return R.ok().put("data", gerenwangpanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GerenwangpanEntity gerenwangpan){
        EntityWrapper< GerenwangpanEntity> ew = new EntityWrapper< GerenwangpanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gerenwangpan, "gerenwangpan")); 
		GerenwangpanView gerenwangpanView =  gerenwangpanService.selectView(ew);
		return R.ok("查询个人网盘成功").put("data", gerenwangpanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GerenwangpanEntity gerenwangpan = gerenwangpanService.selectById(id);
        return R.ok().put("data", gerenwangpan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GerenwangpanEntity gerenwangpan = gerenwangpanService.selectById(id);
        return R.ok().put("data", gerenwangpan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GerenwangpanEntity gerenwangpan, HttpServletRequest request){
    	gerenwangpan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gerenwangpan);
        gerenwangpanService.insert(gerenwangpan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GerenwangpanEntity gerenwangpan, HttpServletRequest request){
    	gerenwangpan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gerenwangpan);
        gerenwangpanService.insert(gerenwangpan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GerenwangpanEntity gerenwangpan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gerenwangpan);
        gerenwangpanService.updateById(gerenwangpan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gerenwangpanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
