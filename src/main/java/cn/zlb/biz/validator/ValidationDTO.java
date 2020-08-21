package cn.zlb.biz.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * 校验类
 *
 * @author libao.zheng
 * @date 2020/8/11 7:05 下午
 */
public class ValidationDTO {
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Pattern(regexp = "/^1[3-9]\\d{9}$/", message = "手机号码不合法")
    private String mobile;

    public ValidationDTO() {
    }

    public ValidationDTO(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<ValidationDTO>> violationSet = validatorFactory.getValidator().validate(new ValidationDTO("", "123"));
        violationSet.forEach(userDTOConstraintViolation -> {
          // System.out.println(userDTOConstraintViolation.getPropertyPath());
          // System.out.println(userDTOConstraintViolation.getMessage());
        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
