package com.baker.learning.learnspringes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @description
 * @date 2020/4/28 15:23
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAggVO {
    private Integer age;
    private Integer count;
}
