package site.sunlong.userProvider.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import site.sunlong.userProvider.pojo.UserEntity;

/**
 * @Author: Sunlong
 * @date: 2021/11/26 16:34
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getUsername(String username) throws Exception {
        if ("username".equals(username)) {
            throw new Exception();
        }
        return "username="+username;
    }


    @Override
    public String save(UserEntity userEntity) {
        return userEntity.toString();
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        final String originalFilename = multipartFile.getOriginalFilename();
        return originalFilename;
    }
}
