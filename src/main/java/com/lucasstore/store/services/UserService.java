package com.lucasstore.store.services;

import com.lucasstore.store.models.User;
import com.lucasstore.store.repositories.UserRepository;
import com.lucasstore.store.services.exceptions.DatabaseException;
import com.lucasstore.store.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Integer id){
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        try{
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
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
