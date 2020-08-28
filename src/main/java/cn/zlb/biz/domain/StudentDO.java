package cn.zlb.biz.domain;

public class StudentDO {
    private Integer id;
    private String studentName;

    public StudentDO() {
    }

    public StudentDO(Integer id) {
        this.id = id;
    }

    public StudentDO(String studentName) {
        this.studentName = studentName;
    }

    public StudentDO(Integer id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "StudentDO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
