package com.oglcnkrty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    private T payload;

    private String errorMessage;

    private int status;

    public static <T> BaseResponse<T> ok(T payload) {
        BaseResponse response = new BaseResponse();
        response.setPayload(payload);
        response.setErrorMessage("");
        response.setStatus(HttpStatus.OK.value());
        return response;
    }

    public static BaseResponse error(String message) {
        BaseResponse response = new BaseResponse();
        response.setErrorMessage(message);
        response.setStatus(HttpStatus.OK.value());
        return response;
    }
}
