package com.codecool.Game.gameRoom;

import com.codecool.Game.bullets.Bullet;
import com.codecool.Game.bullets.BulletContainer;
import com.codecool.Game.maps.GameMap;
import com.codecool.Game.players.Player;
import com.google.gson.Gson;

import java.util.List;

public class GameRoom {

    private int roomId;
    private Players players;
    private GameMap gameMap;
    private BulletContainer bulletContainer;

    public GameRoom(int roomId, byte numberOfPlayers, GameMap map, BulletContainer bulletContainer) {
        this.roomId = roomId;
        this.players = new Players(numberOfPlayers);
        this.gameMap = map;
        this.bulletContainer = bulletContainer;
    }

    public void addPlayer(Player player) {
        if (players.hasAvailableSlots()) {
            players.addPlayer(player);
        }
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public String statusAsString() {
        return new Gson().toJson(new Status(players.players, bulletContainer.asData()));
    }

    private class Players {
        private byte nextId = 0;
        private byte numberOfPlayers;
        private Player[] players;

        Players(byte numberOfPlayers) {
            this.numberOfPlayers = numberOfPlayers;
            players = new Player[numberOfPlayers];
        }

        private boolean hasAvailableSlots() {
            return nextId < numberOfPlayers;
        }

        private void addPlayer(Player player) {
            player.setId(nextId);
            players[nextId] = player;
            nextId++;
        }

        public String toJson() {
            Gson gson = new Gson();
            return gson.toJson(players);
        }
    }

    private class Status {
        private Player[] p;
        private List<Bullet.Status> b;

        Status(Player[] p, BulletContainer.Data b) {
            this.p = p;
            this.b = b.getB();
        }
    }
}
