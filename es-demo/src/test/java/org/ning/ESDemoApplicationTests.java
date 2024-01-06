package org.ning;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import org.junit.jupiter.api.Test;
import org.ning.entity.User;
import org.ning.repository.UserRepository;
import org.ning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.client.elc.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.*;

import java.util.List;

/**
 * @Project: org.ning
 * @Author: pgthinker
 * @Date: 2024/1/6 18:09
 * @Description:
 */
@SpringBootTest
public class ESDemoApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private ElasticsearchClient elasticsearchClient;
    @Autowired
    ElasticsearchOperations operations;

    @Test
    public void esTest(){
        System.out.println(elasticsearchClient.cat());
    }

    @Test
    public void addUserTest(){
        User user = new User();
        user.setId(1);
        user.setNickname("ningning0111");
        user.setPassword("123456");
        user.setEmail("qwe@gmail.com");
        user.setAddress("HFUT,An hui,He fei");
        user.setProfileImage("https://example.com/1.png");
        user.setBio("我是ningning011,我来自 HFUT");
        user.setAge(20);
        userService.add(user);
    }

    @Test
    public void findAllTest(){
        List<User> users = userService.findAll();
        System.out.println(users);
    }

    @Test
    public void deleteTest(){
        User user = new User();
        user.setId(1);
        userService.delete(user);
    }

    @Test
    public void findAllDocTest(){
        // 条件查询
        Criteria fuzzy = new Criteria("nickname").is("ningning0111");
        CriteriaQuery criteriaQuery = new CriteriaQuery(fuzzy);
        SearchHits<User> search = operations.search(criteriaQuery, User.class);
        System.out.println(search);
        List<SearchHit<User>> searchHits = search.getSearchHits();
        searchHits.forEach(e -> {
            User content = e.getContent();
            System.out.println(content);
        });
    }

}
