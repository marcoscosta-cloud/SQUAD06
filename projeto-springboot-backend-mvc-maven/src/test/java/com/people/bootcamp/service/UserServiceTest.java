package com.people.bootcamp.service;

import com.people.bootcamp.repository.ContentRepository;
import com.people.bootcamp.repository.UserRepository;
import com.people.bootcamp.repository.model.ContentModel;
import com.people.bootcamp.repository.model.UserModel;
import com.people.bootcamp.service.domain.User;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    UserRepository userRepo = mock(UserRepository.class);

    ContentRepository contentRepo = mock(ContentRepository.class);
    UserService cobaia = new UserService(userRepo);

    @Nested
    class FindByName {
        String name = "Ben Parvar";

        @Test
        void returnsUserWhenNameExistsInRepo() {
            when(userRepo.findByName(name)).thenReturn(UserModel.builder().name(name).build());
            Optional<User> user = cobaia.findByName(name);
            assertTrue(user.isPresent());
            assertEquals(name, user.get().getName());
        }

        @Test
        void returnsEmptyWhenNameDoesNotExistInRepo() {
            Optional<User> user = cobaia.findByName(name);
            verify(userRepo).findByName(name);
            assertFalse(user.isPresent());
        }
    }

    @Nested
    class FindByLoginAndPassword {
        String login = "benparvar";
        String password = "123";


        @Test
        void returnsUserWhenLoginAndPasswordMatch() {
            when(userRepo.findByLoginAndPassword(login, password)).thenReturn(UserModel.builder().login(login).build());
            Optional<User> user = cobaia.findByLoginAndPassword(login, password);
            assertTrue(user.isPresent());
            assertEquals(login, user.get().getLogin());
        }

        @Test
        void returnEmptyWhenLoginOrPasswordDoNotMatch() {
            Optional<User> user = cobaia.findByLoginAndPassword(login, password);
            verify(userRepo).findByLoginAndPassword(login, password);
            assertFalse(user.isPresent());
        }

    }

    }





