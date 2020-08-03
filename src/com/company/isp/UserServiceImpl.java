package com.company.isp;

public class UserServiceImpl implements UserService,RestrictedUserService{
    boolean register(String cellphone, String password){};
    boolean login(String cellphone, String password){};
    UserInfo getUserInfoById(long id){};
    UserInfo getUserInfoByCellphone(String cellphone){};
    boolean deleteUserByCellphone(String cellphone){};
    boolean deleteUserById(long id){};
}
