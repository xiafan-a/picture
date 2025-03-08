package com.dy.picture.mapper;

import com.dy.picture.model.entity.SpaceUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yong
* @description 针对表【space_user(空间用户关联)】的数据库操作Mapper
* @createDate 2025-03-07 16:47:26
* @Entity com.dy.picture.model.entity.SpaceUser
*/
@Mapper
public interface SpaceUserMapper extends BaseMapper<SpaceUser> {

}




