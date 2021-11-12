package me.guopop.ddd.application.service;

import me.guopop.ddd.domain.person.entity.Person;
import me.guopop.ddd.domain.person.service.PersonDomainService;
import me.guopop.ddd.infrastructure.client.AuthFeignClient;
import me.guopop.ddd.infrastructure.common.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guopop
 * @date 2021/10/25 11:24
 */
@Service
public class LoginApplicationService {

    @Autowired
    private AuthFeignClient authFeignClient;

    @Autowired
    private PersonDomainService personDomainService;

    public Response login(Person person) {
        // 调用鉴权微服务
        return authFeignClient.login(person);
    }

}