package cn.zlb.dao;

import cn.zlb.bo.StudentBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    List<StudentBO> getStudents();
}
