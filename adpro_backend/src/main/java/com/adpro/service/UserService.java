package com.adpro.service;

import java.util.List;

import com.adpro.entity.User;

public interface UserService {
List<User>list();
User getById(int id);
User save(User user);
void deleteById(int id);
}
