package com.dy.picture.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dy.picture.exception.BusinessException;
import com.dy.picture.exception.ErrorCode;
import com.dy.picture.exception.ThrowUtils;
import com.dy.picture.manager.FileManager;
import com.dy.picture.model.dto.file.UploadPictureResult;
import com.dy.picture.model.dto.picture.PictureUploadRequest;
import com.dy.picture.model.entity.Picture;
import com.dy.picture.model.entity.User;
import com.dy.picture.model.vo.PictureVO;
import com.dy.picture.service.PictureService;
import com.dy.picture.mapper.PictureMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author yong
* @description 针对表【picture(图片)】的数据库操作Service实现
* @createDate 2025-03-02 14:17:33
*/
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture>
        implements PictureService {

    @Resource
    private FileManager fileManager;

    @Resource
    private PictureDAO pictureDAO;

    @Override
    public PictureVO uploadPicture(MultipartFile multipartFile, PictureUploadRequest pictureUploadRequest, User loginUser) {
        checkParam(pictureUploadRequest, loginUser, multipartFile);
        // 判断是新增还是更新
        Picture picture = null;
        Long pictureId = pictureUploadRequest.getId();
        String uploadPathPrefix = String.format("public/%s", loginUser.getId());
        UploadPictureResult uploadPictureResult = fileManager.uploadPicture2(multipartFile, uploadPathPrefix);
        if (pictureId == null) {
            // 新增
            picture = buildPicture(uploadPictureResult, null, loginUser.getId());
        }
        if (pictureId != null) {
            // 更新
            Picture oldPicture = pictureDAO.getById(pictureId);
            ThrowUtils.throwIf(ObjectUtils.isEmpty(oldPicture), ErrorCode.NOT_FOUND_ERROR);
            picture = buildPicture(uploadPictureResult, oldPicture, loginUser.getId());
        }
        // 更新或者插入
        ThrowUtils.throwIf(!pictureDAO.saveOrUpdate(picture), ErrorCode.SYSTEM_ERROR, "保存失败");
        return PictureVO.objToVo(picture);
    }

    private Picture buildPicture(UploadPictureResult result, Picture oldPicture, Long userId) {
        return Picture.builder()
                .id(oldPicture != null ? oldPicture.getId() : null)
                .editTime(oldPicture != null ? new Date() : null)
                .url(result.getUrl())
                .name(result.getPicName())
                .picScale(result.getPicScale())
                .picFormat(result.getPicFormat())
                .picHeight(result.getPicHeight())
                .userId(userId)
                .picSize(result.getPicSize())
                .build();
    }


    private void checkParam(PictureUploadRequest pictureUploadRequest, User loginUser, MultipartFile multipartFile) {
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        if (pictureUploadRequest == null || multipartFile == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
    }
}





