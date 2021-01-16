package sda.finalproject.jgroup10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sda.finalproject.jgroup10.model.User;
import sda.finalproject.jgroup10.repository.UserRepository;

@Component
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        if (id == 13L) {
            throw new RuntimeException(id + "is not allowed");
        }
        return userRepository.
                findById(id).
                orElseThrow(() ->
                        new RuntimeException("user not found"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
