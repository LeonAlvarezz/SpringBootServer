package com.example.SpringBootTest.DAO;

import com.example.SpringBootTest.repository.UserRepo;
import com.example.SpringBootTest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAO {
    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user)
    {
        return userRepo.save(user);
    }

    public List<User> getAllUser()
    {
        List<User> users = new ArrayList<>();
        Streamable.of(userRepo.findAll()).forEach(users::add);
        return users;
    }

    public void deleteUser(User user)
    {
        userRepo.delete(user);
    }


}
