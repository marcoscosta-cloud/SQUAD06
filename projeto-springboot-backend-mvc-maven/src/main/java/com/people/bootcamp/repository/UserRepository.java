package com.people.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people.bootcamp.repository.model.UserModel;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByName(String name);
    UserModel findByLoginAndPassword(String login, String password);

    Optional<UserModel> findById(Long userId);
}
