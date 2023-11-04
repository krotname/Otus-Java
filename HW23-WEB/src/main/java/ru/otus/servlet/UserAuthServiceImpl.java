package ru.otus.servlet;


public class UserAuthServiceImpl implements UserAuthService {

    public UserAuthServiceImpl() {

    }

    @Override
    public boolean authenticate(String login, String password) {
        return true;
//        return userDao.findByLogin(login)
//                .map(user -> user.getPassword().equals(password))
//                .orElse(false);
    }

}
