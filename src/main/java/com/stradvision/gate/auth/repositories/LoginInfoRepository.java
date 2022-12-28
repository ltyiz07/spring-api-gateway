package com.stradvision.gate.auth.repositories;

import com.stradvision.gate.auth.models.LoginInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginInfoRepository extends MongoRepository<LoginInfo, String> {
}
