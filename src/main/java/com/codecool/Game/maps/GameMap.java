package com.codecool.Game.maps;

public class GameMap {

    private char[][] map;

    public GameMap(int height, int width) {
        map = new char[width][height];
    }

    public char[][] getMap() {
        return map;
    }
}
