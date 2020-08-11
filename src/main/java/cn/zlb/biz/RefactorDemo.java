package cn.zlb.biz;

/**
 * 重构
 *
 * @author libao.zheng
 * @date 2020/8/10 7:08 下午
 */
public class RefactorDemo {
    private Integer id;
    private String name;
    private Integer addr1;
    private Integer addr2;
    private Integer addr3;
    private Integer addr4;

    public RefactorDemo() {
    }

    public RefactorDemo(Integer id, String name) {
        this(id, name, null, null, null, null);
    }

    public RefactorDemo(Integer id, String name, Integer addr1) {
        this(id, name, addr1, null, null, null);
    }

    public RefactorDemo(Integer id, String name, Integer addr1, Integer addr2) {
        this(id, name, addr1, addr2, null, null);
    }

    public RefactorDemo(Integer id, String name, Integer addr1, Integer addr2, Integer addr3) {
        this(id, name, addr1, addr2, addr3, null);
    }

    public RefactorDemo(Integer id, String name, Integer addr1, Integer addr2, Integer addr3, Integer addr4) {
        this.id = id;
        this.name = name;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.addr3 = addr3;
        this.addr4 = addr4;
    }
}
