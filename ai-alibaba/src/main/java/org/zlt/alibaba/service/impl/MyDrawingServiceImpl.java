package org.zlt.alibaba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zlt.alibaba.entity.MyDrawing;
import org.zlt.alibaba.mapper.MyDrawingMapper;
import org.zlt.alibaba.service.MyDrawingService;

/**
 * 图纸信息表 Service 实现类
 */
@Service
public class MyDrawingServiceImpl extends ServiceImpl<MyDrawingMapper, MyDrawing> implements MyDrawingService {

}