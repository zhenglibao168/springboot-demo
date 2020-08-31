package cn.zlb.dao;

import cn.zlb.biz.domain.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<StudentDO> getStudents();

    int insert(StudentDO studentDO);

    int update(StudentDO studentDO);

    StudentDO selectOne(StudentDO studentDO);
}
