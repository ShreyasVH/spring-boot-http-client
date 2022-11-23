package com.example.demo.services.impl;

import com.example.demo.services.ApiService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import utils.Utils;

import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService
{
    private final RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String get(String url, Map<String, String> additionalHeaders)
    {
        HttpHeaders headers = new HttpHeaders();
        for(Map.Entry<String, String> entry: additionalHeaders.entrySet())
        {
            headers.add(entry.getKey(), entry.getValue());
        }
        HttpEntity<String> request = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }

    public String post(String url, Object payload, Map<String, String> additionalHeaders)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        for(Map.Entry<String, String> entry: additionalHeaders.entrySet())
        {
            headers.add(entry.getKey(), entry.getValue());
        }
        HttpEntity<String> request = new HttpEntity<>(Utils.toJson(payload), headers);

        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        return response.getBody();
    }

    public String put(String url, Object payload, Map<String, String> additionalHeaders)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        for(Map.Entry<String, String> entry: additionalHeaders.entrySet())
        {
            headers.add(entry.getKey(), entry.getValue());
        }
        HttpEntity<String> request = new HttpEntity<>(Utils.toJson(payload), headers);

        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
        return response.getBody();
    }

    public String delete(String url, Map<String, String> additionalHeaders)
    {
        HttpHeaders headers = new HttpHeaders();
        for(Map.Entry<String, String> entry: additionalHeaders.entrySet())
        {
            headers.add(entry.getKey(), entry.getValue());
        }
        HttpEntity<String> request = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
        return response.getBody();
    }
}
