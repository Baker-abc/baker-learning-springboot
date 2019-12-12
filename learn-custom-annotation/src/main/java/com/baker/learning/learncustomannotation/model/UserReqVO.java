package com.baker.learning.learncustomannotation.model;

import com.baker.learning.learncustomannotation.aspect.CheckParam;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description
 * @date 2019/12/11 11:52
 */
@Data
@ToString
@NoArgsConstructor
public class UserReqVO implements Serializable {

    private String name;

    @CheckParam(paramValues = {"man", "woman"})
    private String sex;
}
