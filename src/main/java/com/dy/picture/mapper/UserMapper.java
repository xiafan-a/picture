package com.dy.picture.mapper;

import com.dy.picture.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yong
* @description 针对表【user(用户)】的数据库操作Mapper
* @createDate 2025-02-28 21:57:20
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




