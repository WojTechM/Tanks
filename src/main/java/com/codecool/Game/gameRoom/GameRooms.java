package com.codecool.Game.gameRoom;

import com.codecool.Game.GameServerConfig;
import com.codecool.Game.bullets.BulletContainer;
import com.codecool.Game.maps.GameMap;
import com.codecool.Game.maps.GameMapGenerator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameRooms {

    private Map<Byte, GameRoom> gameRoomMap;
    private GameMapGenerator mapGenerator;

    public GameRooms(GameMapGenerator mapGenerator) {
        gameRoomMap = new HashMap<>();
        this.mapGenerator = mapGenerator;
    }

    public GameRoom getGameRoomWithId(Byte id) {
        GameRoom room = gameRoomMap.get(id);
        if (room == null) {
            GameMap map = mapGenerator.createMap(
                    GameServerConfig.GameMapWidth,
                    GameServerConfig.GameMapHeight,
                    GameServerConfig.GameMapFillPercentage,
                    GameServerConfig.GameMapSmoothRounds);
            room = new GameRoom(id, GameServerConfig.PlayersPerGame, map, new BulletContainer());
            gameRoomMap.put(id, room);
        }
        return room;
    }
}
