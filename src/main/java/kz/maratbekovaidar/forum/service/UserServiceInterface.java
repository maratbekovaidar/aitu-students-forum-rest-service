package kz.maratbekovaidar.forum.service;

import kz.maratbekovaidar.forum.model.Role;
import kz.maratbekovaidar.forum.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
