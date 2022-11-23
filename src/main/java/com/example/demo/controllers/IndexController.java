package com.example.demo.controllers;

import com.example.demo.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController
{
    @Autowired
    private ApiService apiService;

    @GetMapping("/get")
    public String get()
    {
        return this.apiService.get("https://localhost:9008/api?input=abc", new HashMap<String, String>(){
            {
                put("a", "A");
            }
        });
    }

    @GetMapping("/post")
    public String post()
    {
        return this.apiService.post("https://localhost:9008/api", new HashMap<String, String>(){
            {
                put("a", "A");
            }
        }, new HashMap<String, String>(){
            {
                put("b", "B");
            }
        });
    }

    @GetMapping("/put")
    public String put()
    {
        return this.apiService.put("https://localhost:9008/api", new HashMap<String, String>(){
            {
                put("a", "A");
            }
        }, new HashMap<String, String>(){
            {
                put("b", "B");
            }
        });
    }

    @GetMapping("/delete")
    public String delete()
    {
        return this.apiService.delete("https://localhost:9008/api", new HashMap<String, String>(){
            {
                put("a", "A");
            }
        });
    }
}
