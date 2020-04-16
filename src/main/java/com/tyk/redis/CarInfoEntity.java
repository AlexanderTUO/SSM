package com.tyk.redis;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @Author: hcb
 * @Description: 车辆基本信息实体
 * @Date: 2018/8/2
 */
@Data
public class CarInfoEntity implements Serializable {
    private String carId;//车辆id

    private String carNumber;//车牌号
    private String recordNum;//档案编号
    private String chargedeptId;//车辆使用人
    private Integer carProperty;//车辆使用性质

    private Integer carType;//车辆类型 0：轿车、1：越野车、2：中巴车、3	：商务车、4：SUV
    private String deptId;//车辆所有人
    private String carModelBrand;//品牌型号
    private String vin;//车辆识别代码
    private String engineNo;//发动机号码
    private Double displacement;//排量
    private Integer fuelType;//燃油类型
    private Date registerTime;//注册登记时间
    private Date buyTime;//车辆购买时间
    private Double acquisitionExpenses;//购置费
    private Integer comeFrom;//车辆来源 0	：购置、1：捐赠、2：调拨
    private Date yearCheckTime;//年检日期
    private Integer gearBox;//变速箱
    private Integer seatingNum;//核定载人数
    private Integer colour;//车身颜色
    private String carCompilingTypeId;//车辆编制类型  普通公务用车：car_general、执法执勤用车：car_office
    private Integer compilestatus;//编制状态
    private String terminalId;//终端id
    private String terminalNo;//终端号
    private String simNo;//终端sim号
    private Integer status;//车辆状态 0：可用、 1：已派、2：维修、3：禁用、4：报废、5：拍卖
    private String carRemarks;//备注
    private String carSrc;//车辆照片
    private List<String> carSrcIds;//车辆照片中间表
    private String driverSrc;//行驶证照片
    private List<String> driverSrcIds;//行驶证照片中间表
    private Integer bonding;//绑定状态 0：未绑定、1：已绑定
    private Integer carNature;//车辆性质
    private Integer failureState; //车辆故障状态
    private String deptName;//部门名字---
    private String chargedeptName;//使用人部门名字

    /*zxl 2019-03-25 车辆驾驶员绑定*/
    private String driverId; //驾驶员id
    private String driverName; //驾驶员姓名

    /*zxl 2019-04-18 车辆信息添加批准文号字段*/
    private String titanic; //批准文号

    private Double bookPrice; //账面价格
    private Integer isMarked; // 是否粘贴标识（0：否，1：是）
    private String compileSn; // 下达编制文号
    private String carNumberHis; // 好牌历史
    private String transferHis; // 过户历史
    private String maintainFeeHis; // 大修经费安排历史

}
