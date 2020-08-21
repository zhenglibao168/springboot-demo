package cn.zlb.refactor;

/**
 * 重构demo
 *
 * @author libao.zheng
 * @date 2020/8/14 11:34 上午
 */
public class RefactorDemo {
    private String name;

    public static void main(String[] args) {
        RefactorDemo refactorDemo = new RefactorDemo();
      // System.out.println(refactorDemo.getAddress());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HomeAddress getAddress() {
      // System.out.println("10086");
        return new HomeAddress();
    }

    private class HomeAddress {
        private String homeAddress = "hangzhou";

        public String getAddress() {
            return homeAddress;
        }

        @Override
        public String toString() {
            return "HomeAddress{" +
                    "homeAddress='" + homeAddress + '\'' +
                    '}';
        }
    }

    private class CompanyAddress {
        private String companyAddress = "beijing";

        public String getAddress() {
            return companyAddress;
        }

        @Override
        public String toString() {
            return "CompanyAddress{" +
                    "companyAddress='" + companyAddress + '\'' +
                    '}';
        }
    }
}
