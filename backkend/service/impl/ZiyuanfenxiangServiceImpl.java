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


import com.dao.ZiyuanfenxiangDao;
import com.entity.ZiyuanfenxiangEntity;
import com.service.ZiyuanfenxiangService;
import com.entity.vo.ZiyuanfenxiangVO;
import com.entity.view.ZiyuanfenxiangView;

@Service("ziyuanfenxiangService")
public class ZiyuanfenxiangServiceImpl extends ServiceImpl<ZiyuanfenxiangDao, ZiyuanfenxiangEntity> implements ZiyuanfenxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiyuanfenxiangEntity> page = this.selectPage(
                new Query<ZiyuanfenxiangEntity>(params).getPage(),
                new EntityWrapper<ZiyuanfenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiyuanfenxiangEntity> wrapper) {
		  Page<ZiyuanfenxiangView> page =new Query<ZiyuanfenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZiyuanfenxiangVO> selectListVO(Wrapper<ZiyuanfenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZiyuanfenxiangVO selectVO(Wrapper<ZiyuanfenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZiyuanfenxiangView> selectListView(Wrapper<ZiyuanfenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiyuanfenxiangView selectView(Wrapper<ZiyuanfenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
