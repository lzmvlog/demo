package com.shaojie.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 少杰
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.shaojie.springdata.model"})
// CREATE：直接根据方法名进行创建。规则是根据方法名称的构 造进行尝试，
//          一般的方法是从方法名中删除给定的一组已知前 缀，并解析该方法的其余部分。
//          如果方法名不符合规则，启动 的时候就会报异常。
// USE_DECLARED_QUERY：声明方式创建，即本书说的注解方式。
//                      启动的时候会尝试找到一个声明的查询，如果没有找到就将抛 出一个异常。查询可以由某处注释或其他方法声明。
// CREATE_IF_NOT_FOUND：这个是默认的，以上两种方式的结合 版。
//                      先用声明方式进行查找，如果没有找到与方法相匹配的查 询，就用create的方法名创建规则创建一个查询。
@EnableJpaRepositories(basePackages = {"com.shaojie.springdata.dao"},
                        queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
@ComponentScan(basePackages = {"com.shaojie.springdata.controller"})
@EnableJpaAuditing
@EnableScheduling
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

}
