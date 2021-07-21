package com.example.oauth2webservicesclientservice.controller;

import com.example.oauth2webservicesclientservice.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final OAuth2AuthorizedClientService authorizedClientService;
    private final RestTemplate restTemplate;
    private final WebClient webClient;

//    @GetMapping
//    public String getAll(Model model, OAuth2AuthenticationToken oauth2Token, @AuthenticationPrincipal OidcUser principal) {
//        OAuth2AuthorizedClient oauth2Client = authorizedClientService.loadAuthorizedClient(oauth2Token.getAuthorizedClientRegistrationId(), oauth2Token.getName());
//        String token = oauth2Client.getAccessToken().getTokenValue();
//        String url = "http://localhost:8088/api/albums";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer " + token);
//        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
//        ResponseEntity<List<Album>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Album>>() {
//        });
//        model.addAttribute("albums", responseEntity.getBody());
//        return "albums";
//    }

    @GetMapping
    public String getAll(Model model, OAuth2AuthenticationToken oauth2Token, @AuthenticationPrincipal OidcUser principal) {

        String url = "http://localhost:8088/api/albums";

        model.addAttribute("albums", webClient
                .get().uri(url)
                .retrieve().bodyToMono(new ParameterizedTypeReference<List<Album>>() {
                })
                .block());
        return "albums";
    }
}
