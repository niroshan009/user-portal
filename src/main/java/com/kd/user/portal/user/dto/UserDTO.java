package com.kd.user.portal.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private String nickname;

    private String comment;

}
