package top.lzmvlog.ssodemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2021年02月13日 17:07
 * @Description:
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * username
     */
    @Column(name = "username")
    private String username;

    /**
     * password
     */
    @Column(name = "password")
    private String password;
}
