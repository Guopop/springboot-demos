package me.guopop.ddd.infrastructure.client;

import me.guopop.ddd.domain.person.entity.Person;
import me.guopop.ddd.infrastructure.common.api.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author guopop
 * @date 2021/10/25 11:17
 */
@FeignClient(name = "auth-service", path = "/demo/auth")
public interface AuthFeignClient {

    @PostMapping("/login")
    Response login(Person person);
}