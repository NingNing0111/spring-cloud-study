package org.ning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Project: org.ning.entity
 * @Author: pgthinker
 * @Date: 2024/1/6 19:13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "user",createIndex = true)
public class User {
    @Id
    private Integer id;
    @Field(name = "nickname", type = FieldType.Keyword)
    private String nickname;
    @Field(type = FieldType.Keyword)
    private String email;
    @Field(type = FieldType.Keyword)

    private String password;
    @Field(type = FieldType.Text)
    private String bio;
    @Field(name = "profile_image")
    private String profileImage;
    @Field(type = FieldType.Keyword)
    private Integer age;
    @Field(type = FieldType.Text)
    private String address;
}
