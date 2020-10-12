package cn.zlb.service;

import cn.zlb.biz.domain.StudentDO;
import cn.zlb.dao.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * service
 *
 * @author libao.zheng
 * @date 2020/10/12 9:37 上午
 */
@Service
public class StudentService {
    @Resource
    private StudentMapper studentMapper;

    public PageInfo<StudentDO> findByStudentNamewithPage(int page, int pageSize, String studentName) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(studentMapper.findByStudentName(studentName));
    }
}
