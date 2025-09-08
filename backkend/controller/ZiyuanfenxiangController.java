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

import com.entity.ZiyuanfenxiangEntity;
import com.entity.view.ZiyuanfenxiangView;

import com.service.ZiyuanfenxiangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 资源分享
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
@RestController
@RequestMapping("/ziyuanfenxiang")
public class ZiyuanfenxiangController {
    @Autowired
    private ZiyuanfenxiangService ziyuanfenxiangService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiyuanfenxiangEntity ziyuanfenxiang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			ziyuanfenxiang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZiyuanfenxiangEntity> ew = new EntityWrapper<ZiyuanfenxiangEntity>();

		PageUtils page = ziyuanfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanfenxiang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiyuanfenxiangEntity ziyuanfenxiang, 
		HttpServletRequest request){
        EntityWrapper<ZiyuanfenxiangEntity> ew = new EntityWrapper<ZiyuanfenxiangEntity>();

		PageUtils page = ziyuanfenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanfenxiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiyuanfenxiangEntity ziyuanfenxiang){
       	EntityWrapper<ZiyuanfenxiangEntity> ew = new EntityWrapper<ZiyuanfenxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziyuanfenxiang, "ziyuanfenxiang")); 
        return R.ok().put("data", ziyuanfenxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiyuanfenxiangEntity ziyuanfenxiang){
        EntityWrapper< ZiyuanfenxiangEntity> ew = new EntityWrapper< ZiyuanfenxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziyuanfenxiang, "ziyuanfenxiang")); 
		ZiyuanfenxiangView ziyuanfenxiangView =  ziyuanfenxiangService.selectView(ew);
		return R.ok("查询资源分享成功").put("data", ziyuanfenxiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiyuanfenxiangEntity ziyuanfenxiang = ziyuanfenxiangService.selectById(id);
        return R.ok().put("data", ziyuanfenxiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiyuanfenxiangEntity ziyuanfenxiang = ziyuanfenxiangService.selectById(id);
        return R.ok().put("data", ziyuanfenxiang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuanfenxiangEntity ziyuanfenxiang, HttpServletRequest request){
    	ziyuanfenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanfenxiang);
        ziyuanfenxiangService.insert(ziyuanfenxiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuanfenxiangEntity ziyuanfenxiang, HttpServletRequest request){
    	ziyuanfenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanfenxiang);
        ziyuanfenxiangService.insert(ziyuanfenxiang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiyuanfenxiangEntity ziyuanfenxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanfenxiang);
        ziyuanfenxiangService.updateById(ziyuanfenxiang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziyuanfenxiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
