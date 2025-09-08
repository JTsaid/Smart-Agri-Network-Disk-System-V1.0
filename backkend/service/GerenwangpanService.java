package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GerenwangpanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GerenwangpanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GerenwangpanView;


/**
 * 个人网盘
 *
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
public interface GerenwangpanService extends IService<GerenwangpanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GerenwangpanVO> selectListVO(Wrapper<GerenwangpanEntity> wrapper);
   	
   	GerenwangpanVO selectVO(@Param("ew") Wrapper<GerenwangpanEntity> wrapper);
   	
   	List<GerenwangpanView> selectListView(Wrapper<GerenwangpanEntity> wrapper);
   	
   	GerenwangpanView selectView(@Param("ew") Wrapper<GerenwangpanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GerenwangpanEntity> wrapper);
   	

}

