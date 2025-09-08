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

import com.entity.HaoyouliebiaoEntity;
import com.entity.view.HaoyouliebiaoView;

import com.service.HaoyouliebiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 好友列表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
@RestController
@RequestMapping("/haoyouliebiao")
public class HaoyouliebiaoController {
    @Autowired
    private HaoyouliebiaoService haoyouliebiaoService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HaoyouliebiaoEntity haoyouliebiao,
		HttpServletRequest request){
        EntityWrapper<HaoyouliebiaoEntity> ew = new EntityWrapper<HaoyouliebiaoEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("wodezhanghao", (String)request.getSession().getAttribute("username"));
        }
		PageUtils page = haoyouliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, haoyouliebiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HaoyouliebiaoEntity haoyouliebiao, 
		HttpServletRequest request){
        EntityWrapper<HaoyouliebiaoEntity> ew = new EntityWrapper<HaoyouliebiaoEntity>();

		PageUtils page = haoyouliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, haoyouliebiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HaoyouliebiaoEntity haoyouliebiao){
       	EntityWrapper<HaoyouliebiaoEntity> ew = new EntityWrapper<HaoyouliebiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( haoyouliebiao, "haoyouliebiao")); 
        return R.ok().put("data", haoyouliebiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HaoyouliebiaoEntity haoyouliebiao){
        EntityWrapper< HaoyouliebiaoEntity> ew = new EntityWrapper< HaoyouliebiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( haoyouliebiao, "haoyouliebiao")); 
		HaoyouliebiaoView haoyouliebiaoView =  haoyouliebiaoService.selectView(ew);
		return R.ok("查询好友列表成功").put("data", haoyouliebiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HaoyouliebiaoEntity haoyouliebiao = haoyouliebiaoService.selectById(id);
        return R.ok().put("data", haoyouliebiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HaoyouliebiaoEntity haoyouliebiao = haoyouliebiaoService.selectById(id);
        return R.ok().put("data", haoyouliebiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HaoyouliebiaoEntity haoyouliebiao, HttpServletRequest request){
    	haoyouliebiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(haoyouliebiao);
        haoyouliebiaoService.insert(haoyouliebiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HaoyouliebiaoEntity haoyouliebiao, HttpServletRequest request){
    	haoyouliebiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(haoyouliebiao);
        haoyouliebiaoService.insert(haoyouliebiao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HaoyouliebiaoEntity haoyouliebiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(haoyouliebiao);
        haoyouliebiaoService.updateById(haoyouliebiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        haoyouliebiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
