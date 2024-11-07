package com.wadajo.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import static org.springframework.security.oauth2.client.web.client.RequestAttributeClientRegistrationIdResolver.clientRegistrationId;

@RestController
public class HotelsController {

    private final RestClient restClient;

    public HotelsController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping(value = "/hotels")
    public String[] fetchHotels() {
        return this.restClient
                .get()
                .uri("http://localhost:8081/hotels")
                /*
                If you set a breakpoint inside the authenticate method of JwtAuthenticationProvider class,
                you will see the actual JWT token that's being validated
                 */
                .attributes(clientRegistrationId("hotels-client"))
                .retrieve()
                .body(String[].class);
    }
}