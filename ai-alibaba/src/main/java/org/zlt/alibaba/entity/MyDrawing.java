package org.zlt.alibaba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 图纸信息表实体类
 */
@Data
@TableName("my_drawing")
public class MyDrawing implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 编号
     */
    private String drawingNo;

    /**
     * 图名
     */
    private String drawingName;

    /**
     * 材质
     */
    private String material;

    /**
     * 周长
     */
    private BigDecimal perimeter;

    /**
     * 面积
     */
    private BigDecimal area;

    /**
     * 标准重
     */
    private BigDecimal standardWeight;

    /**
     * 净重
     */
    private BigDecimal netWeight;

    /**
     * 未标示厚度
     */
    private String thicknessSpec;

    /**
     * 用途
     */
    private String usageScene;

    /**
     * 日期
     */
    private LocalDate drawingDate;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
}