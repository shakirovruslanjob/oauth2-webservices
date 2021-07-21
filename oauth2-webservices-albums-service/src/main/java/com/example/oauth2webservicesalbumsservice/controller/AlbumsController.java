package com.example.oauth2webservicesalbumsservice.controller;

import com.example.oauth2webservicesalbumsservice.entity.Album;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {
    @GetMapping
    public List<Album> getAll() {
        return List.of(new Album("Album1", 12), new Album("Album2", 10));
    }
}
