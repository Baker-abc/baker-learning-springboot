package com.baker.learning.learnspringredis.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description
 * @date 2020/3/26 10:26
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    private Long id;
    private String name;
    private Integer age;
}
