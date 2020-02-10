package com.shaojie.authority.exception;

import javax.security.sasl.AuthenticationException;

/**
 * @author： ShaoJie
 * @data： 2020年02月09日 16:38
 * @Description： 校验失败异常
 * <p>
 * 定义一个验证码校验失败的异常
 */
public class VerificationCodeException extends AuthenticationException {

    public VerificationCodeException() {
        super("图形验证码校验失败");
    }

}
