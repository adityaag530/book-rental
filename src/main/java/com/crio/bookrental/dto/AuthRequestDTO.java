package com.crio.bookrental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author adityagupta
 * @date 05/04/24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDTO {
    private String email;
    private String password;
}
