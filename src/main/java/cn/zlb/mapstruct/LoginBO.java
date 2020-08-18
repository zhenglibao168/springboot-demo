package cn.zlb.mapstruct;

/**
 * @author libao.zheng
 * @description login业务对象
 * @date 2020/6/30 9:58 上午
 */
public class LoginBO {
    private Integer id;
    private String name;
    private String passWord;

    public LoginBO() {
    }

    public LoginBO(Integer id, String name, String passWord) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
    }

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "LoginBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
