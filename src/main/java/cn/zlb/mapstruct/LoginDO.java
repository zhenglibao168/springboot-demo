package cn.zlb.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author libao.zheng
 * @description login数据对象
 * @date 2020/6/30 9:58 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDO {
    private Integer id;
    private String userName;
    private String passWord;
}
