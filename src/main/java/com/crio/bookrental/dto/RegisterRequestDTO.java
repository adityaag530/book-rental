package com.crio.bookrental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.crio.bookrental.entity.Role;

/*
 * @author adityagupta
 * @date 05/04/24
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
