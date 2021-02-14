package top.lzmvlog.ssodemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.lzmvlog.ssodemo.model.User;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2021年02月13日 17:10
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
