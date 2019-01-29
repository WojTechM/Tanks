package com.codecool.Game.bullets;

public class Bullet {

    private byte playerId;
    private Point startPos;
    private float angle;
    private String shotTime;

    public Bullet(byte id, Point startPos, float angle, String time) {
        this.playerId = id;
        this.startPos = startPos;
        this.angle = angle;
        this.shotTime = time;
    }

    byte getId() {
        return playerId;
    }

    String getShotTime() {
        return shotTime;
    }

    Status getStatusToSend() {
        return new Status(playerId, startPos, angle, shotTime);
    }

    private class Point {
        private float x;
        private float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Status {

        private byte id;
        private Point s;
        private float a;
        private String t;

        public Status(byte id, Point s, float a, String t) {
            this.id = id;
            this.s = s;
            this.a = a;
            this.t = t;
        }


    }
}
