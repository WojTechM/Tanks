package com.codecool.Game.players;

import com.codecool.Game.gameRoom.GameRoom;
import com.codecool.Game.gameRoom.GameRooms;
import org.springframework.stereotype.Service;

@Service
public class PlayerRegistration {
    public void register(Player player, byte roomId, GameRooms gameRooms) {
        GameRoom gameRoom = gameRooms.getGameRoomWithId(roomId);
        gameRoom.addPlayer(player);
    }
}
