package org.ning.entity;

import lombok.Data;

/**
 * @Project: org.ning.entity
 * @Author: pgthinker
 * @Date: 2024/1/4 22:18
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
}
