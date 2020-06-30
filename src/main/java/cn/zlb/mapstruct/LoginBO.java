package cn.zlb.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author libao.zheng
 * @description login业务对象
 * @date 2020/6/30 9:58 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginBO {
    private Integer id;
    private String name;
    private String passWord;
}
