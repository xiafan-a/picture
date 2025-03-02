package com.dy.picture.service;

import com.dy.picture.model.dto.picture.PictureUploadRequest;
import com.dy.picture.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dy.picture.model.entity.User;
import com.dy.picture.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

/**
* @author yong
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-03-02 14:17:33
*/
public interface PictureService extends IService<Picture> {
    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);


}
