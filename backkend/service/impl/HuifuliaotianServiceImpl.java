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


import com.dao.HuifuliaotianDao;
import com.entity.HuifuliaotianEntity;
import com.service.HuifuliaotianService;
import com.entity.vo.HuifuliaotianVO;
import com.entity.view.HuifuliaotianView;

@Service("huifuliaotianService")
public class HuifuliaotianServiceImpl extends ServiceImpl<HuifuliaotianDao, HuifuliaotianEntity> implements HuifuliaotianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuifuliaotianEntity> page = this.selectPage(
                new Query<HuifuliaotianEntity>(params).getPage(),
                new EntityWrapper<HuifuliaotianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuifuliaotianEntity> wrapper) {
		  Page<HuifuliaotianView> page =new Query<HuifuliaotianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuifuliaotianVO> selectListVO(Wrapper<HuifuliaotianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuifuliaotianVO selectVO(Wrapper<HuifuliaotianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuifuliaotianView> selectListView(Wrapper<HuifuliaotianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuifuliaotianView selectView(Wrapper<HuifuliaotianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
