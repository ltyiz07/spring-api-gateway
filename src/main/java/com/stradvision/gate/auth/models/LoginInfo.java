package com.stradvision.gate.auth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class LoginInfo {

    @Id
    private String loginId;
    private String loginPw;
    private Date createDate = new Date();
    private ArrayList<String> services = new ArrayList<>(Arrays.asList("test-service-1", "test-service-2"));

}
