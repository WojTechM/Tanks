package com.codecool.Game;

import com.codecool.Game.gameRoom.GameRoom;
import com.codecool.Game.gameRoom.GameRooms;
import com.codecool.Game.players.Player;
import com.codecool.Game.players.PlayerRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameServerController {

    private GameRooms gameRooms;
    private PlayerRegistration playerRegistration;

    @Autowired
    public GameServerController(GameRooms gameRooms, PlayerRegistration playerRegistration) {
        this.gameRooms = gameRooms;
        this.playerRegistration = playerRegistration;
    }

    /**
     * Method registers new player to a game room.
     *
     * @param playerName players nickname
     * @param roomId     id of a room user wants to join
     * @return id of new user (positive) or -1 if registration failed
     */
    @PostMapping(path = "/register/{playerName}/{roomId}")
    private byte registerNewPlayer(@PathVariable String playerName, @PathVariable byte roomId) {
        Player player = new Player(playerName);
        playerRegistration.register(player, roomId, gameRooms);
        return player.getId();
    }

    @GetMapping(path = "/tanks/{roomId}")
    private String getRoomData(@PathVariable byte roomId) {
        GameRoom room = gameRooms.getGameRoomWithId(roomId);
        if (room == null) {
            return null;
        }
        return room.statusAsString();
    }

}
