package easyui;

public class SqShare {
    private int id;
    private String name;
    private String singers;
    private String type;
    private String src_type;
    private String format;
    private String into;
    private int heat;
    private String down_url;
    private String member;
    private String create_time;
    private String status;

    @Override
    public String toString() {
        return "SqShare{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singers='" + singers + '\'' +
                ", type='" + type + '\'' +
                ", src_type='" + src_type + '\'' +
                ", format='" + format + '\'' +
                ", into='" + into + '\'' +
                ", heat=" + heat +
                ", down_url='" + down_url + '\'' +
                ", member='" + member + '\'' +
                ", create_time='" + create_time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingers() {
        return singers;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc_type() {
        return src_type;
    }

    public void setSrc_type(String src_type) {
        this.src_type = src_type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getInto() {
        return into;
    }

    public void setInto(String into) {
        this.into = into;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public String getDown_url() {
        return down_url;
    }

    public void setDown_url(String down_url) {
        this.down_url = down_url;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
