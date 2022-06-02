package com.oauth2.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * @author maody
 * @date 2022/6/2 14:27
 */
public class CaptchaException extends AuthenticationException {
    public CaptchaException(String msg) {
        super(msg);
    }
}
