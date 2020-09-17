package cn.zlb.web;

import cn.zlb.service.ValidationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author libao.zheng
 * @date 2020/9/11 9:51 上午
 */
@RestController
@Validated
public class ValidationController {
    @Resource
    private ValidationService validationService;

    @GetMapping("testPrivate")
    private String testPrivate() {
        validationService.test();
        return "testPrivate";
    }

    @GetMapping("testPublic")
    public String testPublic() {
        validationService.test();
        return "testPublic";
    }
}
