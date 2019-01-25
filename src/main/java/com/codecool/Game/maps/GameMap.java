package com.codecool.Game.maps;

import com.google.gson.Gson;

public class GameMap {

    private final char[][] map;
    final int width;
    final int height;

    public GameMap(int width, int height) {
        map = new char[width][height];
        this.width = width;
        this.height = height;
    }

    public void setField(int x, int y, char symbol) {
        validateCoordinates(x, y);
        map[x][y] = symbol;
    }

    public char getField(int x, int y) {
        validateCoordinates(x, y);
        return map[x][y];
    }

    private void validateCoordinates(int x, int y) {
        if (x < 0 || x > width - 1 || y < 0 || y > height - 1) {
            throw new IllegalArgumentException("Coordinates out of bounds");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(width * height + 1);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                builder.append(map[x][y]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
