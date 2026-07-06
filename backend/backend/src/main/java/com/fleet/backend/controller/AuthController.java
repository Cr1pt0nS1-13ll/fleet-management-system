package com.fleet.backend.controller;


import com.fleet.backend.service.JwtService;
import com.fleet.backend.dto.LoginRequestDTO;
import com.fleet.backend.dto.LoginResponseDTO;
import com.fleet.backend.entity.User;
import com.fleet.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO dto
    ) {

        User user = authService.autenticar(dto);

        // Ainda não estamos gerando JWT.
        // Apenas confirmando que o login foi realizado.

        String token = jwtService.generateToken(user.getUsername());

        return ResponseEntity.ok(
                new LoginResponseDTO(token)
        );
    }

}