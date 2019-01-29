package com.codecool.Game.players;

public class Player {

    private String name;
    private byte id;
    private Point p;

    public Player(String name) {
        this.name = name;
        this.id = -1;
    }

    public class Point {
        public final short x;
        public final short y;

        public Point(short x, short y) {
            this.x = x;
            this.y = y;
        }
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }
}
