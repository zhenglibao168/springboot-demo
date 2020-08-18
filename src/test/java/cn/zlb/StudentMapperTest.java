package cn.zlb;

import cn.zlb.biz.domain.StudentDO;
import cn.zlb.dao.StudentMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testSelectAll() {
        List<StudentDO> studentDOList = studentMapper.getStudents();
        Assert.assertTrue(studentDOList.size() > 0);
    }

    @Test
    public void testSelectOne() {
        StudentDO studentDO = studentMapper.selectOne(new StudentDO(1, null));
        Assert.assertEquals("Jame", studentDO.getStudentName());
    }

    @Test
    public void testInsert() {
        studentMapper.insert(new StudentDO(null, "zhenglibao"));
        StudentDO studentDO = studentMapper.selectOne(new StudentDO(null, "zhenglibao"));
        Assert.assertNotNull(studentDO);

    }
}