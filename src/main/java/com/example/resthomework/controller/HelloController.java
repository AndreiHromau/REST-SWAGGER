package com.example.resthomework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController //сам REST контроллер
@RequestMapping("/api/hello") //маппинг по адресу
@Tag(name = "Hello Controller", description = "Простой контроллер") //для документации API в swagger
public class HelloController {

    @GetMapping
    @Operation(
        summary = "Получить приветственное сообщение",
        description = "Возвращает простое приветственное сообщение в формате JSON",
        responses = {
            @ApiResponse( //сам response с описанием для ендпоинта
                responseCode = "200",
                description = "Successful operation",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Map.class)
                )
            )
        }
    )
    public ResponseEntity<Map<String, String>> sayHello() { //возврат RESPONSE Entity
        return ResponseEntity.ok(Map.of(
            "message", "ПРИВЕТ МИР!",
            "status", "success"
        ));
    }
}
