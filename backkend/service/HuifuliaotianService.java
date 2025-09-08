package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuifuliaotianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuifuliaotianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuifuliaotianView;


/**
 * 回复聊天
 *
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
public interface HuifuliaotianService extends IService<HuifuliaotianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuifuliaotianVO> selectListVO(Wrapper<HuifuliaotianEntity> wrapper);
   	
   	HuifuliaotianVO selectVO(@Param("ew") Wrapper<HuifuliaotianEntity> wrapper);
   	
   	List<HuifuliaotianView> selectListView(Wrapper<HuifuliaotianEntity> wrapper);
   	
   	HuifuliaotianView selectView(@Param("ew") Wrapper<HuifuliaotianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuifuliaotianEntity> wrapper);
   	

}

