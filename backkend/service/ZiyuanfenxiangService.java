package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZiyuanfenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZiyuanfenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiyuanfenxiangView;


/**
 * 资源分享
 *
 * @author 
 * @email 
 * @date 2023-06-27 17:05:46
 */
public interface ZiyuanfenxiangService extends IService<ZiyuanfenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiyuanfenxiangVO> selectListVO(Wrapper<ZiyuanfenxiangEntity> wrapper);
   	
   	ZiyuanfenxiangVO selectVO(@Param("ew") Wrapper<ZiyuanfenxiangEntity> wrapper);
   	
   	List<ZiyuanfenxiangView> selectListView(Wrapper<ZiyuanfenxiangEntity> wrapper);
   	
   	ZiyuanfenxiangView selectView(@Param("ew") Wrapper<ZiyuanfenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiyuanfenxiangEntity> wrapper);
   	

}

