package cn.zlb.dao;

import cn.zlb.biz.domain.StudentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<StudentDO> getStudents();

    int insert(StudentDO studentDO);

    StudentDO selectOne(StudentDO studentDO);
}
