package com.baker.learning.learnspringes.model;

import com.baker.learning.learnspringes.constant.FieldAnalyzer;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @description
 * @date 2020/4/27 17:07
 */

@Document(indexName = "user", // 索引名
        type = "base", // 类型。未来的版本即将废弃
        shards = 1, // 默认索引分区数
        replicas = 1, // 每个分区的备份数
        refreshInterval = "-1" // 刷新间隔
)
@Data
@ToString
public class UserDO implements Serializable {

    @Id
    private Integer id;

    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Integer)
    private Integer userId;

    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Text)
    private String name;

    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Integer)
    private Integer age;
}
