package com.shaojie.springdata.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 少杰
 */
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Data
public class User implements Serializable {

    // strategy = GenerationType.IDENTITY 定义该属性自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String password;

}
