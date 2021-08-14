package me.guopop.springbootconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author guopop
 * @date 2021/6/3 15:39
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "name")
@Validated
public class NameConfig {

    @NotBlank
    private String firstname;
    private String lastname;
}
