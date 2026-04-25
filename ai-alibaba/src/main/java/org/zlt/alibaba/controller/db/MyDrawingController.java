package org.zlt.alibaba.controller.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zlt.alibaba.entity.MyDrawing;
import org.zlt.alibaba.service.MyDrawingService;

import java.util.List;

/**
 * 图纸信息表 Controller
 */
@RestController
@RequestMapping("/api/drawing")
public class MyDrawingController {

    @Autowired
    private MyDrawingService myDrawingService;

    /**
     * 查询所有图纸
     */
    @GetMapping("/list")
    public List<MyDrawing> list() {
        return myDrawingService.list();
    }

    /**
     * 根据ID查询图纸
     */
    @GetMapping("/{id}")
    public MyDrawing getById(@PathVariable String id) {
        return myDrawingService.getById(id);
    }

    /**
     * 根据图名查询图纸
     */
    @GetMapping("/name/{drawingName}")
    public List<MyDrawing> getByName(@PathVariable String drawingName) {
        QueryWrapper<MyDrawing> wrapper = new QueryWrapper<>();
        wrapper.like("drawing_name", drawingName);
        return myDrawingService.list(wrapper);
    }

    /**
     * 新增图纸
     */
    @PostMapping("/save")
    public boolean save(@RequestBody MyDrawing myDrawing) {
        return myDrawingService.save(myDrawing);
    }

    /**
     * 更新图纸
     */
    @PutMapping("/update")
    public boolean update(@RequestBody MyDrawing myDrawing) {
        return myDrawingService.updateById(myDrawing);
    }

    /**
     * 根据ID删除图纸
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return myDrawingService.removeById(id);
    }
}