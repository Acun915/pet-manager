package com.petmanager.jwtHandling.payload.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String accessToken;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
    private Long familyId;

    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles, Long familyId) {
        this.accessToken = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.familyId = familyId;
    }

}
