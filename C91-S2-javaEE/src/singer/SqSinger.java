package singer;

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
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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
        this.intro = intro;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "SqSinger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", members='" + members + '\'' +
                ", nation='" + nation + '\'' +
                ", birthday='" + birthday + '\'' +
                ", intro='" + intro + '\'' +
                ", head='" + head + '\'' +
                ", likes=" + likes +
                '}';
    }

    public SqSinger(Integer id, String name, String category, String members, String nation, String birthday, String intro, String head, Integer likes) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.members = members;
        this.nation = nation;
        this.birthday = birthday;
        this.intro = intro;
        this.head = head;
        this.likes = likes;
    }

    public SqSinger() {
    }
}