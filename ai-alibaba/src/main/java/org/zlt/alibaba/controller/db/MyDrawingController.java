package org.zlt.alibaba.controller.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.zlt.alibaba.entity.MyDrawing;
import org.zlt.alibaba.service.MyDrawingService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 图纸信息表 Controller
 */
@RestController
@RequestMapping("/api/drawing")
public class MyDrawingController {

    @Autowired
    private MyDrawingService myDrawingService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
     * 批量新增图纸
     */
    @PostMapping("/batchSave")
    public boolean batchSave(@RequestBody List<MyDrawing> drawingList) {
        return myDrawingService.saveBatch(drawingList);
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

    /**
     * 执行SQL查询（仅支持SELECT语句）
     */
    @PostMapping("/queryBySql")
    public List<Map<String, Object>> queryBySql(@RequestBody String sql) {
        String trimmedSql = sql.trim();
        if (!trimmedSql.toLowerCase().startsWith("select")) {
            throw new IllegalArgumentException("仅支持SELECT查询语句");
        }
        return jdbcTemplate.queryForList(trimmedSql);
    }

    /**
     * 过滤JSON中的空值
     */
    @PostMapping("/filterEmpty")
    public String filterEmpty(@RequestBody Map<String, String> jsonMap) {
        LinkedHashMap<String, String> map =  jsonMap.entrySet().stream()
                .filter(entry -> entry.getValue() != null && !"".equals(entry.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));

        String result = map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "：" + entry.getValue())
                .collect(Collectors.joining("\n"));

        System.out.println(result);
        return result;
    }
}