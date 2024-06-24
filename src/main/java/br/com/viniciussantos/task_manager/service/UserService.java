package br.com.viniciussantos.task_manager.service;


import br.com.viniciussantos.task_manager.model.User;
import br.com.viniciussantos.task_manager.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        var userEntity = this.findById(user.getId());
        BeanUtils.copyProperties(user, userEntity, "id");
        return userRepository.save(userEntity);
    }
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
