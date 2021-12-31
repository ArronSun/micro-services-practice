package site.sunlong.userProvider.service;

import site.sunlong.userProvider.pojo.UserEntity;

/**
 * @Author: Sunlong
 * @date: 2021/11/26 16:02
 */
public interface UserService {


    String getUsername(String username) throws Exception;

    String save(UserEntity userEntity);




}
