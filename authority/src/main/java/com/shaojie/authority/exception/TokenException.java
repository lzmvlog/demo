package com.shaojie.authority.exception;

/**
 * @author： ShaoJie
 * @data： 2020年03月23日 13:39
 * @Description： token 验证失败
 * <p>
 * 验证码验证失败
 */
public class TokenException extends Exception {

    /**
     * 授权失败
     */
    public TokenException() {
        super("token 错误，重新授权！");
    }
}
