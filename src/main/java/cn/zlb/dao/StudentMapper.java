package cn.zlb.dao;

import cn.zlb.biz.domain.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    List<StudentDO> getStudents();
}
