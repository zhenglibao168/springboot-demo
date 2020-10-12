package cn.zlb.dao;

import cn.zlb.biz.domain.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<StudentDO> getStudents();

    int insert(StudentDO studentDO);

    int update(StudentDO studentDO);

    StudentDO selectOne(StudentDO studentDO);

    List<StudentDO> findByStudentName(@Param("studentName") String studentName);

    List<StudentDO> findByStudentNameStartingWith(@Param("studentNamePrefix") String studentNamePrefix);

    int insertList(@Param("list") List<StudentDO> list);

    int updateStudentNameById(@Param("updatedStudentName") String updatedStudentName, @Param("id") Integer id);

    int deleteById(@Param("id") Integer id);

}
