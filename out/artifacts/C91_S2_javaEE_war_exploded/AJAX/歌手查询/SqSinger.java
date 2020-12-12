package com.yc.jee.web.分页查询.bean;

/**
 * 	歌手 实体类： 类名对应数据库 sq_singer 表，表名，属性名对应字段名
 * 	注意：字段名使用峰命名规则命名
 */
public class SqSinger {
	// 主键
    private Integer id;
    // 名称
    private String name;
    // 分类
    private String category;
    // 成员（专辑用）
    private String members;
    // 地区
    private String nation;
    // 生日、成立日期、年份，格式太多，使用字符串存储
    private String birthday;
    // 介绍
    private String intro;
    // 头像图片路径
    private String head;
    // 热度
    private Integer likes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members == null ? null : members.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}