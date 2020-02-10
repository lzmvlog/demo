package com.shaojie.authority.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author： ShaoJie
 * @data： 2020年01月06日 20:22
 * @Description： 用户的权限
 */
@Data
@Entity
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "authority")
public class Authority implements Serializable {

    private static final long serialVersionUID = 7929414303616665569L;

    /**
     * 用户的自增 id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户的账号
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 用户的权限
     */
    @Column(name = "authority")
    private String authority;

    public Authority() {

    }
}
