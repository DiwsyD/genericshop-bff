package com.stepit.lecture.genericshop.user.service;

import com.stepit.lecture.genericshop.bff.feign.GenericShopApiClient;
import com.stepit.lecture.genericshop.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final GenericShopApiClient genericShopApiClient;


    public User getUser(String email) {
        return genericShopApiClient.getUserByEmail(email);
    }
}
