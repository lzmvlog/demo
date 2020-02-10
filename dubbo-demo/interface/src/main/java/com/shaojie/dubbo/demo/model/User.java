package com.shaojie.dubbo.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： ShaoJie
 * @data： 2019年12月07日 21:58
 * @Description：
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -4622399084610308777L;

    private Integer id;

    private String name;

    private Date date;

}
