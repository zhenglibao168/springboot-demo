package cn.zlb.web;

import cn.zlb.biz.domain.StudentDO;
import cn.zlb.dao.StudentMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * student
 *
 * @author libao.zheng
 * @date 2020/8/28 11:08 上午
 */
@RestController
public class StudentController {
    @Resource
    public StudentMapper studentMapper;

    /**
     * 模拟死锁
     *
     * @return
     */
    @GetMapping("/test")
    @Transactional
    public boolean test() throws InterruptedException {
        final StudentDO studentDO = new StudentDO("aaa");
        studentMapper.insert(studentDO);
        final StudentDO sd = studentMapper.selectOne(studentDO);
//        studentMapper.update(sd);//不会产生死锁
        new Thread(() -> studentMapper.update(sd)).start();
        TimeUnit.HOURS.sleep(24);
        return true;
    }
}
