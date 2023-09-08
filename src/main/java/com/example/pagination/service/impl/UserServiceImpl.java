package com.example.pagination.service.impl;

import com.example.pagination.domain.User;
import com.example.pagination.repo.UserRepo;
import com.example.pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor @Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public Page<User> getUsers(String name, int page, int size) {
        log.info("Fetching users from page {} of size {}",page,size);
        return userRepo.findByNameContaining(name, PageRequest.of(page,size));
    }
}
