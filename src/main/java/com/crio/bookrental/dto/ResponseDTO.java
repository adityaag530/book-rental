package com.crio.bookrental.dto;
/*
 * @author adityagupta
 * @date 05/04/24
 */

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class ResponseDTO {
    private String message;

    public ResponseDTO(String msg){
        message = msg;
    }
}
