package com.shaojie.authority.util;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author： ShaoJie
 * @data： 2020年02月23日 15:45
 * @Description： 返回数据
 */
@Data
@NoArgsConstructor
public class ResponseData {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;

    /**
     * 响应成功应返回 响应码 - 响应信息 - 响应数据
     *
     * @param code 响应码
     * @param msg  响应信息
     * @param data 响应数据
     */
    public ResponseData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 若返回不成功 则不会返回响应数据
     *
     * @param code 响应信息
     * @param msg  响应数据
     */
    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
