package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.HaoyouliaotianDao;
import com.entity.HaoyouliaotianEntity;
import com.service.HaoyouliaotianService;
import com.entity.vo.HaoyouliaotianVO;
import com.entity.view.HaoyouliaotianView;

@Service("haoyouliaotianService")
public class HaoyouliaotianServiceImpl extends ServiceImpl<HaoyouliaotianDao, HaoyouliaotianEntity> implements HaoyouliaotianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HaoyouliaotianEntity> page = this.selectPage(
                new Query<HaoyouliaotianEntity>(params).getPage(),
                new EntityWrapper<HaoyouliaotianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HaoyouliaotianEntity> wrapper) {
		  Page<HaoyouliaotianView> page =new Query<HaoyouliaotianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HaoyouliaotianVO> selectListVO(Wrapper<HaoyouliaotianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HaoyouliaotianVO selectVO(Wrapper<HaoyouliaotianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HaoyouliaotianView> selectListView(Wrapper<HaoyouliaotianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HaoyouliaotianView selectView(Wrapper<HaoyouliaotianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
