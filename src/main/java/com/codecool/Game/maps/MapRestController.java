package com.codecool.Game.maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapRestController {

    private GameMapGenerator mapGenerator;

    @Autowired
    public MapRestController(GameMapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    @GetMapping(path = "/map")
    private String getMap() {
        GameMap map = mapGenerator.createMap(80, 10, 0.35f, 2);
        System.out.println(map);
        return map.toJson();
    }
}
