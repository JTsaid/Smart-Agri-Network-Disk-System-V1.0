package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HaoyouliebiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HaoyouliebiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HaoyouliebiaoView;


/**
 * 好友列表
 *
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
public interface HaoyouliebiaoService extends IService<HaoyouliebiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HaoyouliebiaoVO> selectListVO(Wrapper<HaoyouliebiaoEntity> wrapper);
   	
   	HaoyouliebiaoVO selectVO(@Param("ew") Wrapper<HaoyouliebiaoEntity> wrapper);
   	
   	List<HaoyouliebiaoView> selectListView(Wrapper<HaoyouliebiaoEntity> wrapper);
   	
   	HaoyouliebiaoView selectView(@Param("ew") Wrapper<HaoyouliebiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HaoyouliebiaoEntity> wrapper);
   	

}

