package site.sunlong.userProvider.service;

import org.springframework.stereotype.Service;

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
}
