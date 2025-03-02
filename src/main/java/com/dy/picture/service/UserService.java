package com.dy.picture.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dy.picture.model.dto.user.UserQueryRequest;
import com.dy.picture.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dy.picture.model.vo.LoginUserVO;
import com.dy.picture.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author yong
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-02-28 21:57:20
*/
public interface UserService extends IService<User> {
    long userRegister(String userAccount,String userPassword,String checkPassword);
    String getEncryptPassword(String userPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request httpRequest 请求方便设置 cookie
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);
    /**
     * 获取脱敏的已登录用户信息
     *
     * @return 脱敏的已登录用户信息
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 用户注销
     *
     * @param request request
     * @return  注销结果
     */
    boolean userLogout(HttpServletRequest request);
    /**
     * 获取用户脱敏信息
     * @param user 脱敏前的信息
     * @return 脱敏后的信息
     */
    UserVO getUserVO(User user);

    /**
     * 批量获取用户脱敏信息
     * @param userList 脱敏前的信息
     * @return 脱敏后的 List 列表
     */
    List<UserVO> getUserVOList(List<User> userList);

    /**
     * 获取查询条件
     *
     * @param userQueryRequest 查询条件
     * @return 查询条件
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);


    /**
     * 获取当前登录用户
     *
     * @param request request
     * @return 当前登录用户
     */
    User getLoginUser(HttpServletRequest request);



}
