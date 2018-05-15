package com.test.many_to_one_test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.many_to_one_test.domain.PhoneNumbers;
import com.test.many_to_one_test.domain.User;
import com.test.many_to_one_test.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private ObjectMapper objectMapper;

    private UserDao userDao;

    @Autowired
    public TestService(ObjectMapper objectMapper, UserDao userDao) {
        this.objectMapper = objectMapper;
        this.userDao = userDao;
    }

    public void testMapping() {
        User user1 = new User("Shaun");
        User user2 = new User("Elizabeth");

        PhoneNumbers phone1 = new PhoneNumbers("1234567");
        PhoneNumbers phone2 = new PhoneNumbers("76543217");

        user1.getPhoneNumbers().add(phone1);
        user2.getPhoneNumbers().add(phone2);

        List<User> users = new ArrayList<>(2);
        users.add(user1);
        users.add(user2);

        userDao.save(user1);
        userDao.save(user2);


    }

}
