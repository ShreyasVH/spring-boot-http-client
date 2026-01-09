package com.example.demo.services.impl;

import com.example.demo.services.ApiService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestClient restClient;

    public ApiServiceImpl(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    @Override
    public String get(String url, Map<String, String> additionalHeaders) {
        return restClient
                .get()
                .uri(url)
                .headers(headers -> headers.setAll(additionalHeaders))
                .retrieve()
                .body(String.class);
    }

    @Override
    public String post(String url, Object payload, Map<String, String> additionalHeaders) {
        return restClient
                .post()
                .uri(url)
                .headers(headers -> {
                    headers.setAll(additionalHeaders);
                    headers.setContentType(MediaType.APPLICATION_JSON);
                })
                .body(payload)
                .retrieve()
                .body(String.class);
    }

    @Override
    public String put(String url, Object payload, Map<String, String> additionalHeaders) {
        return restClient
                .put()
                .uri(url)
                .headers(headers -> {
                    headers.setAll(additionalHeaders);
                    headers.setContentType(MediaType.APPLICATION_JSON);
                })
                .body(payload)
                .retrieve()
                .body(String.class);
    }

    @Override
    public String delete(String url, Map<String, String> additionalHeaders) {
        return restClient
                .delete()
                .uri(url)
                .headers(headers -> headers.setAll(additionalHeaders))
                .retrieve()
                .body(String.class);
    }
}
