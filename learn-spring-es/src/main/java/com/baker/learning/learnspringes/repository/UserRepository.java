package com.baker.learning.learnspringes.repository;

import com.baker.learning.learnspringes.model.UserDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description
 * @date 2020/4/27 17:18
 */
public interface UserRepository extends ElasticsearchRepository<UserDO, Integer> {

    Iterable<UserDO> findByName(String name);

}
