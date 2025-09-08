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


import com.dao.HaoyouliebiaoDao;
import com.entity.HaoyouliebiaoEntity;
import com.service.HaoyouliebiaoService;
import com.entity.vo.HaoyouliebiaoVO;
import com.entity.view.HaoyouliebiaoView;

@Service("haoyouliebiaoService")
public class HaoyouliebiaoServiceImpl extends ServiceImpl<HaoyouliebiaoDao, HaoyouliebiaoEntity> implements HaoyouliebiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HaoyouliebiaoEntity> page = this.selectPage(
                new Query<HaoyouliebiaoEntity>(params).getPage(),
                new EntityWrapper<HaoyouliebiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HaoyouliebiaoEntity> wrapper) {
		  Page<HaoyouliebiaoView> page =new Query<HaoyouliebiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HaoyouliebiaoVO> selectListVO(Wrapper<HaoyouliebiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HaoyouliebiaoVO selectVO(Wrapper<HaoyouliebiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HaoyouliebiaoView> selectListView(Wrapper<HaoyouliebiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HaoyouliebiaoView selectView(Wrapper<HaoyouliebiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
