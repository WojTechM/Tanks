package com.codecool.Game.bullets;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BulletContainer {

    private List<Bullet> bullets;

    public BulletContainer() {
        bullets = new LinkedList<>();
    }

    public void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }

    public void deleteBullet(byte playerId,String timeStamp) {
        bullets.removeIf(bullet -> bullet.getId() == playerId && bullet.getShotTime().equals(timeStamp));
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(new Data());
    }

    public Data asData() {
        return new Data();
    }

    public class Data {
        List<Bullet.Status> b;

        private Data() {
            b = new ArrayList<>(bullets.size());
            for(Bullet bullet : bullets) {
                b.add(bullet.getStatusToSend());
            }
        }

        public List<Bullet.Status> getB() {
            return b;
        }
    }
}
