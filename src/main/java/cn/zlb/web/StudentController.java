package cn.zlb.web;

import cn.zlb.biz.domain.StudentDO;
import cn.zlb.dao.StudentMapper;
import cn.zlb.service.StudentService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * student
 *
 * @author libao.zheng
 * @date 2020/8/28 11:08 上午
 */
@RestController
@Transactional
public class StudentController {
    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentService studentService;

    @GetMapping("/test")
    public boolean test() {
        final StudentDO studentDO = new StudentDO("aaa");
        studentMapper.insert(studentDO);
        studentService.updateStudent(studentMapper.selectOne(studentDO));
        return true;
    }
}
