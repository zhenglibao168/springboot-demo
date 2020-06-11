package cn.zlb.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户信息")
@Data
public class UserBO {
    @ApiModelProperty(value = "身份证", position = 0, example = "342423198701017777")
    private final Long id;
    @ApiModelProperty(value = "姓名", position = 1, example = "张三")
    private final String name;
    @ApiModelProperty(value = "手机号码", position = 2, example = "13688881111")
    private final String mobile;
    @ApiModelProperty(value = "电子邮件", position = 3, example = "test123@qq.com")
    private final String email;

    public UserBO(Long id, String name, String mobile, String email) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }
}
