package cn.zlb;

/**
 * 重构
 *
 * @author libao.zheng
 * @date 2020/8/10 7:08 下午
 */
public class UserDTO {
    public static final int ID_NUMBER = 123;
    private Integer id;
    private String name;
    private Integer addr1;
    private Integer addr2;
    private Integer addr3;
    private Integer addr4;
    private String newAddress;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name) {
        this(id, name, null, null, null, null);
    }

    public UserDTO(Integer id, String name, Integer addr1) {
        this(id, name, addr1, null, null, null);
    }

    public UserDTO(Integer id, String name, Integer addr1, Integer addr2) {
        this(id, name, addr1, addr2, null, null);
    }

    public UserDTO(Integer id, String name, Integer addr1, Integer addr2, Integer addr3) {
        this(id, name, addr1, addr2, addr3, null);
    }

    public UserDTO(Integer id, String name, Integer addr1, Integer addr2, Integer addr3, Integer addr4) {
        this.id = id;
        this.name = name;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.addr3 = addr3;
        this.addr4 = addr4;
    }

    public String test(String address, String name, String newAddress) {
        newAddress = address + name;
        return this.newAddress;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO(123, "name");
        addA(userDTO);
        System.out.println(userDTO);
    }

    private static void addA(UserDTO a) {
        a.addr1 = 456;
        System.out.println(a);
    }

    static class AddressDTO {
        private final String address;
        private final String name;

        private AddressDTO(String address, String name) {
            this.address = address;
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr1=" + addr1 +
                ", addr2=" + addr2 +
                ", addr3=" + addr3 +
                ", addr4=" + addr4 +
                ", newAddress='" + newAddress + '\'' +
                '}';
    }
}
