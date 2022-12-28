package com.stradvision.gate.auth.controllers;

import com.stradvision.gate.auth.models.LoginInfo;
import com.stradvision.gate.auth.repositories.LoginInfoRepository;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/local-test")
public class TestController {

    private final LoginInfoRepository loginInfoRepository;

    public TestController(LoginInfoRepository loginInfoRepository) {
        this.loginInfoRepository = loginInfoRepository;
    }

    @GetMapping("/test")
    public String testController() {

        Optional<LoginInfo> optionalLoginInfo = loginInfoRepository.findById("test_id");
        if (optionalLoginInfo.isPresent()) {
            String idAndPw;
            idAndPw = "id: "
                    + optionalLoginInfo.get().getLoginId()
                    + ", pw: "
                    + optionalLoginInfo.get().getLoginPw();
            return idAndPw;
        }

        return "this is test";
    }

}
