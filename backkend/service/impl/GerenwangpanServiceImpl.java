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


import com.dao.GerenwangpanDao;
import com.entity.GerenwangpanEntity;
import com.service.GerenwangpanService;
import com.entity.vo.GerenwangpanVO;
import com.entity.view.GerenwangpanView;

@Service("gerenwangpanService")
public class GerenwangpanServiceImpl extends ServiceImpl<GerenwangpanDao, GerenwangpanEntity> implements GerenwangpanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GerenwangpanEntity> page = this.selectPage(
                new Query<GerenwangpanEntity>(params).getPage(),
                new EntityWrapper<GerenwangpanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GerenwangpanEntity> wrapper) {
		  Page<GerenwangpanView> page =new Query<GerenwangpanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GerenwangpanVO> selectListVO(Wrapper<GerenwangpanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GerenwangpanVO selectVO(Wrapper<GerenwangpanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GerenwangpanView> selectListView(Wrapper<GerenwangpanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GerenwangpanView selectView(Wrapper<GerenwangpanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
