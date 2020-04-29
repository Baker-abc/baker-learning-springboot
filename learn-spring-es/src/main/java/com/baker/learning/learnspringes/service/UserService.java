package com.baker.learning.learnspringes.service;

import com.baker.learning.learnspringes.model.UserAggVO;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

/**
 * @description
 * @date 2020/4/28 15:14
 */
@Service
public class UserService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public UserAggVO group(String name) {
        // 创建 ES 搜索条件
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withIndices("user");
        // 筛选
        nativeSearchQueryBuilder.withQuery(QueryBuilders.multiMatchQuery(name,
                "name"));
        // 聚合
        nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms("groupByAge").field("age")); // 商品分类
        // 执行查询
        UserAggVO vo = elasticsearchTemplate.query(nativeSearchQueryBuilder.build(), response -> {
            UserAggVO userAggVO = new UserAggVO();
            // categoryIds 聚合
            Aggregation categoryIdsAggregation = response.getAggregations().get("groupByAge");
            if (categoryIdsAggregation != null) {
                for (LongTerms.Bucket bucket : (((LongTerms) categoryIdsAggregation).getBuckets())) {
                    userAggVO.setAge(Integer.valueOf(bucket.getKey().toString()));
                    userAggVO.setCount(bucket.getKeyAsNumber().intValue());
                }
            }
            // 返回结果
            return userAggVO;
        });
        return vo;
    }
}
