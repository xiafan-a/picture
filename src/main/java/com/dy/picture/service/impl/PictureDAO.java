package com.dy.picture.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dy.picture.mapper.PictureMapper;
import com.dy.picture.model.entity.Picture;
import org.springframework.stereotype.Service;

@Service
public class PictureDAO extends ServiceImpl<PictureMapper, Picture> {
    public Picture getById(Long id) {
        return this.query()
                .eq("id", id)
                .eq("isDeleted", 0).getEntity();
    }
}

