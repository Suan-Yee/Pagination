package com.example.pagination.response;

import com.example.pagination.domain.Response;
import com.example.pagination.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserResponse {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Response> getUsers(@RequestParam Optional<String> name,
                                             @RequestParam Optional<Integer> page,
                                             @RequestParam Optional<Integer> size){
        return ResponseEntity.ok()
                .body(
                        Response.builder()
                                .timeStamp(LocalDateTime.now())
                                .httpStatus(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .message("Retrieving users")
                                .data(Map.of("Users",userService.getUsers(name.orElse(""),page.orElse(0),page.orElse(10))))
                                .build()
                );

    }

}
