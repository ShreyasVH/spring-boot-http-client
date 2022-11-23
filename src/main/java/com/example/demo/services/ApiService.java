package com.example.demo.services;

import java.util.Map;

public interface ApiService
{
    String get(String url, Map<String, String> headers);

    String post(String url, Object payload, Map<String, String> additionalHeaders);

    String put(String url, Object payload, Map<String, String> additionalHeaders);

    String delete(String url, Map<String, String> additionalHeaders);
}
