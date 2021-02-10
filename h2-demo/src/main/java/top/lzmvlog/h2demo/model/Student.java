package top.lzmvlog.h2demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2021年02月08日 15:39
 * @Description:
 */
@Entity
@Data
@Accessors(chain = true)
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    /**
     * 学生id
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 学生名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 学生年纪
     */
    @Column(name = "age")
    private Integer age;

}
