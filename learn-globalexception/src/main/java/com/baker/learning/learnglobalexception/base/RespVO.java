package com.baker.learning.learnglobalexception.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@NoArgsConstructor
public class RespVO<T> implements Serializable {

    public static final int ERROR = 1;
    public static final int SUCCESS = 0;

    private Integer code;
    private String message;
    private T data;

}
