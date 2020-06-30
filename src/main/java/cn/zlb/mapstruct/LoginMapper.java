package cn.zlb.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author libao.zheng
 * @description login对象转换
 * @date 2020/6/30 10:04 上午
 */
@Mapper(componentModel = "spring")
public interface LoginMapper {
    @Mapping(source = "userName", target = "name")
    LoginBO toLoginBO(LoginDO loginDO);
}
