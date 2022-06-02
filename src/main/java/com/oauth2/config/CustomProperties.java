package com.oauth2.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author maody
 * @date 2022/6/2 15:33
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "zm.jwt")
public class CustomProperties {
    private long expire;
    private String secret;
    private String header;
    private String privateKey;
}
