package lift.wizard.community.service;

import lift.wizard.community.dao.User;
import lift.wizard.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public void createOrUpdate(User user) {
        User userDB = userMapper.findByAccountId(user.getAccountId());

        if (userDB == null){
            //插入新的user数据
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            //更新
            userDB.setGmtModified(System.currentTimeMillis());
            userDB.setAvatarUrl(user.getAvatarUrl());
            userDB.setName(user.getName());
            userDB.setToken(user.getToken());
            userMapper.update(userDB);
        }
        
    }
}
