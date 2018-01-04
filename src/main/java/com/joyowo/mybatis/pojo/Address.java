package com.joyowo.mybatis.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Author: chenby
 * Date: 2018-01-02
 */
@Data
public class Address {
    private String id;
    @NotNull(message = "企业id不能为空")
    @Digits(integer = 10, fraction = 0, message = "企业ID数据格式不正确")
    private Integer cId; //企业ID
    @Digits(integer = 10, fraction = 0, message = "客户ID数据格式不正确")
    private Integer customerId;//客户ID
    @Digits(integer = 1, fraction = 0, message = "数据格式不正确")
    private Integer country;//是否境外
    @NotNull(message = "省ID不能为空")
    @Pattern(regexp = "^\\+?[1-9][0-9]*$", message = "省ID数据格式不正确")
    private String province;//省
/*    @NotNull(message = "市id不能为空")
    @Pattern(regexp = "^\\+?[1-9][0-9]*$", message = "市id数据格式不正确")
    private String city;//市*/
/*    @NotNull(message = "区id不能为空")
    @Pattern(regexp = "^\\+?[1-9][0-9]*$", message = "区id数据格式不正确")
    private String district;//区
    @NotBlank(message = "城市地址不能为空")
    private String cityName;//地区名称
    private String zip;//邮编
    @NotBlank(message = "地址不能为空")
    private String address;//地址
    @NotBlank(message = "联系人不能为空")
    private String contacts;//联系人
    private String isDefault;//是否为默认
    private String tel;//固定电话
    @NotBlank(message = "手机号不能为空")
    private String mobile;//手机号
    private String _user_name;
    private String isDelete;*/
}
