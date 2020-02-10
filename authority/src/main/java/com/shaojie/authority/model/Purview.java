package com.shaojie.authority.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author： ShaoJie
 * @data： 2020年02月10日 14:55
 * @Description： 权限范围及路径
 */
@Data
@Entity
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "purview")
public class Purview implements Serializable {

    private static final long serialVersionUID = 8025367145943417425L;

    /**
     * 路径自增 id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 路径
     */
    @Column(name = "url")
    private String url;

    /**
     * 路径权限
     */
    @Column(name = "authority")
    private String authority;

    public Purview() {

    }
}
