package cn.zlb.service;

import cn.zlb.biz.domain.StudentDO;
import cn.zlb.dao.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author libao.zheng
 * @date 2020/8/28 11:10 上午
 */
@Service
public class StudentService {
    @Resource
    private StudentMapper studentMapper;

    public void updateStudent(StudentDO studentDO) {
        studentMapper.update(studentDO);
    }
}
