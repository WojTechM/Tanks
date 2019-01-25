package com.codecool.Game.maps;

import com.google.gson.Gson;

public class GameMap {

    private final char[][] map;
    final int width;
    final int height;

    GameMap(int width, int height) {
        map = new char[width][height];
        this.width = width;
        this.height = height;
    }

    void setField(int x, int y, char symbol) {
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

    String toJson() {
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    int getSurroundingElementCount(int x, int y, char symbol) {
        int result = 0;
        for (int neighbourX = x - 1; neighbourX <= x + 1; neighbourX++) {
            for (int neighbourY = y - 1; neighbourY <= y + 1; neighbourY++) {
                if (neighbourX >= 0 && neighbourX < width && neighbourY >= 0 && neighbourY < height) {
                    if ((neighbourX != x || neighbourY != y) && map[neighbourX][neighbourY] == symbol) {
                        result++;
                    }
                } else {
                    result++;
                }
            }
        }
        return result;
    }
}
