package com.example.JSP_FILES_LERNING.service;

import com.example.JSP_FILES_LERNING.model.User;
import com.example.JSP_FILES_LERNING.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public User login(String login, String password) {

        return userRepository.getByLoginAndPassword(login, password);

    }

    public boolean signUp(User user) {
        if (login(user.getLogin(), user.getPassword()) == null) {
            System.out.println("user" + user);
            User userForDb = reCorrectUser(user);
            userRepository.signUp(userForDb);
            return true;
        }
        return false;
    }

    private User reCorrectUser(User user) {
        if (user.getName().equals(""))
            user.setName("Not Defined");
        if (user.getSurname().equals(""))
            user.setSurname(("Not Defined"));
        if (user.getAddress().equals(""))
            user.setAddress("Not Defined");
        if (user.getContact().equals(""))
            user.setContact("Not Defined");
        return user;
    }
}
