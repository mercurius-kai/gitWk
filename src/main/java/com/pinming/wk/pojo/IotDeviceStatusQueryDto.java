package com.pinming.wk.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wl
 * @date 2020/04/15 10:40
 */
@Data
public class IotDeviceStatusQueryDto implements Serializable {

    /**
     * 设备类型：1，塔机；2，升降机；3，扬尘
     */
    private Integer deviceType;
    /**
     * 监控设备序列号
     */
    private String deviceSn;
    /**
     * 厂商ID
     */
    private Integer dataSourceType;
}
