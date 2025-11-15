package com.lucasstore.store.services;

import com.lucasstore.store.models.User;
import com.lucasstore.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public User update(Integer id, User user){
        User userUpdate = userRepository.getReferenceById(id);
        updateData(userUpdate, user);
        return userRepository.save(userUpdate);
    }

    public void updateData(User userUpdate, User user){
        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPhone(user.getPhone());
    }
}
