package com.dy.picture.mapper;

import com.dy.picture.model.entity.Picture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yong
* @description 针对表【picture(图片)】的数据库操作Mapper
* @createDate 2025-03-02 14:17:33
* @Entity com.dy.picture.model.entity.Picture
*/
@Mapper
public interface PictureMapper extends BaseMapper<Picture> {

}




