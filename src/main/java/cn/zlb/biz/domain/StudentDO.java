package cn.zlb.biz.domain;

public class StudentDO {
    private String id;
    private String studentName;

    public StudentDO() {
    }

    public StudentDO(String id) {
        this.id = id;
    }

    public StudentDO(String id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
