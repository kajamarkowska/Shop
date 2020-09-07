package com.kaja.shop.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Version;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long id;
    @Email(message ="Invalid email" )
    private String email;
    @Length(min = 8, max = 255, message = "Invalid length password")
    @Pattern(regexp = "[a-zA-Z0-9!?]")
    private String password;
    private Long version;
}
