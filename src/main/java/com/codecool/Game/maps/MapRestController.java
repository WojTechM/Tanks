package com.codecool.Game.maps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapRestController {

    @GetMapping(path = "/map")
    private String getMap() {
        return "map";
    }
}
