package net.dmfe.sandboxspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/greeting")
@SpringBootApplication
public class SandboxApplication {

    @GetMapping
    public ResponseEntity<Map<String, String>> handleGetGreeting(
            @RequestParam(required = false, defaultValue = "user") String name
    ) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("greeting", "Hello, %s!".formatted(name)));
    }

    public static void main(String[] args) {
        SpringApplication.run(SandboxApplication.class, args);
    }

}

