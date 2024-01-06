package org.ning.repository;

import org.ning.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Project: org.ning.repository
 * @Author: pgthinker
 * @Date: 2024/1/6 19:39
 * @Description:
 */

public interface UserRepository extends ElasticsearchRepository<User,Integer> {
}
