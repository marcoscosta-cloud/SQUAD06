package com.people.bootcamp.service;

import com.people.bootcamp.repository.ContentRepository;
import com.people.bootcamp.repository.UserRepository;
import com.people.bootcamp.repository.model.UserModel;
import com.people.bootcamp.service.domain.User;
import com.people.bootcamp.service.domain.UserModelMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private ContentRepository contentRepository;


    public Optional<User> findByName(String name) {
        return Optional.ofNullable(UserModelMapper.INSTANCE.modelToEntity(userRepository.findByName(name)));
    }

    public Optional<User> findByLoginAndPassword(String login, String password) {
        return Optional.ofNullable(UserModelMapper.INSTANCE.modelToEntity(userRepository.findByLoginAndPassword(login, password)));
    }

    public Optional<UserModel> findById(Long userId) {
        return userRepository.findById(userId);
    }

    }







