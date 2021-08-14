package me.guopop.springbootjpa.model;

import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.dsl.StringPath;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guopop
 * @date 2021/5/29 11:02
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstname;

    private String name;
}
