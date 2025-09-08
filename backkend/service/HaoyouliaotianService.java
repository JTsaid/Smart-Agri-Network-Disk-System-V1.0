package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HaoyouliaotianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HaoyouliaotianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HaoyouliaotianView;


/**
 * 好友聊天
 *
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
public interface HaoyouliaotianService extends IService<HaoyouliaotianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HaoyouliaotianVO> selectListVO(Wrapper<HaoyouliaotianEntity> wrapper);
   	
   	HaoyouliaotianVO selectVO(@Param("ew") Wrapper<HaoyouliaotianEntity> wrapper);
   	
   	List<HaoyouliaotianView> selectListView(Wrapper<HaoyouliaotianEntity> wrapper);
   	
   	HaoyouliaotianView selectView(@Param("ew") Wrapper<HaoyouliaotianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HaoyouliaotianEntity> wrapper);
   	

}

