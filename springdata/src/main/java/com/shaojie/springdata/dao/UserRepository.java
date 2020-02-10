package com.shaojie.springdata.dao;

import com.shaojie.springdata.model.User;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.Optional;

/**
 * @author 少杰
 */
//@Repository
@RepositoryDefinition(domainClass = User.class , idClass = Integer.class)
//extends JpaRepository<User,Integer>
public interface UserRepository  {

    // @Query(value = "select id,email from user where id = :id", nativeQuery = true)
    Optional<User> findById(Integer id);

    // @Modifying  com.shaojie.springdata.model.User
    // nativeQuery 设置是否使用原生的 SQL 语句
//    @Query(value = "select id,email from user where id = :id",nativeQuery = true)
    User queryAllById(Integer id);

//    @Modifying 在@Query注解中编写JPQL实现DELETE和UPDATE操作的时候必须加上@modifying注解，以通知Spring Data 这是一个DELETE或UPDATE操作。
//    @Query(value = "insert into user(email) value (:email)",nativeQuery = true)
    User save(User user);

}
