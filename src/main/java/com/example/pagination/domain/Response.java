package com.example.pagination.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_DEFAULT) @Data
public class Response {

    protected LocalDateTime timeStamp;
    protected HttpStatus httpStatus;
    protected int statusCode;
    protected String message;
    protected Map<?,?> data;
}
