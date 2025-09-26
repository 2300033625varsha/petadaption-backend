package com.example.petvora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5176") // React frontend
public class AuthController {

    @Autowired
    private UserService userService;

    // ✅ REGISTER
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            User registeredUser = userService.register(user);

            response.put("success", true);
            response.put("message", "Registration successful!");
            // Don’t send password back!
            response.put("user", Map.of(
                    "id", registeredUser.getId(),
                    "username", registeredUser.getUsername(),
                    "email", registeredUser.getEmail()
            ));

        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        boolean success = userService.loginByEmail(user.getEmail(), user.getPassword());

        if (success) {
            response.put("success", true);
            response.put("message", "Login successful!");
            // 🔑 Placeholder for token (later you can implement JWT)
            response.put("token", "dummy-token-12345");
        } else {
            response.put("success", false);
            response.put("message", "Invalid email or password");
        }
        return response;
    }
}
