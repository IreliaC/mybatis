package com.joyowo.mybatis.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Author: chenby
 * Date: 2017-12-27
 */
@Data
public class Article {
    private Integer articleId;
    private Integer catId;      //分类ID
    private String title;       //标题
    private String oImage;      //原图
    private String sImage;      //小图
    private String author;      //作者
    private Byte source;        //来源：0，原创；1，采集
    private String pageUrl;     //来源地址
    private Integer sortOrder;  //排序
    private Byte isFeatured;    //是否推荐 0 否 1 是
    private Byte isNewest;      //是否推荐到最新 0 否 1 是
    private Byte isColumn;      //是否推荐到栏目页 0 否 1 是
    private Byte isHomePage;    //是否推荐到首页 0 否 1 是
    private Byte status;        //状态：0，未发布；1，发布；2，等待定时发布
    private Integer clickCnt;   //点击数
    private Date releaseDate;   //发布日期
    private Date createTime;    //创建日期
    private Date updateTime;    //更新日期
    private Integer linkActivityId; //关联活动id(shopnc_activity)
    private Integer id;
    private String summary;     //摘要
    private Integer parentCatId;//上级分类ID
    private String parentCatCode;//上级分类代码
    private String catCode;      //分类代码
    private Integer siteId;     //站点ID
}
