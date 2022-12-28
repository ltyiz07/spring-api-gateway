package com.stradvision.gate.auth.repositories;

import com.github.tomakehurst.wiremock.admin.NotFoundException;
import com.mongodb.MongoWriteException;
import com.stradvision.gate.auth.models.LoginInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginInfoRepositoryTest {

    @Autowired
    private LoginInfoRepository repo;

    @Test
    void testCRUD() throws Exception {

        LoginInfo newInfo = new LoginInfo();
        newInfo.setLoginId("test_id");
        newInfo.setLoginPw("test_pw");

        repo.save(newInfo);
        Optional<LoginInfo> optionalLoginInfo = repo.findById("test_id");
        LoginInfo foundInfo;
        if (optionalLoginInfo.isPresent()) {
            foundInfo = optionalLoginInfo.get();
            System.out.println(foundInfo.getLoginId());
        } else {
            throw new NotFoundException("LoginInfo not found!");
        }

        repo.delete(foundInfo);
        if (repo.findById("test_id").isPresent()) {
            throw new NotFoundException("LoginInfo not deleted!");
        }

    }

}