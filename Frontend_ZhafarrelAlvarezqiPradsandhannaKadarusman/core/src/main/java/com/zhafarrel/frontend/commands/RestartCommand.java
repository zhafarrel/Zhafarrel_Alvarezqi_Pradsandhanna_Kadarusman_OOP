package com.zhafarrel.frontend.commands;

import com.zhafarrel.frontend.GameManager;
import com.zhafarrel.frontend.Player;

public class RestartCommand implements Command {
    private Player player;
    private GameManager gameManager;

    public RestartCommand(Player player, GameManager gameManager){
        this.player = player;
        this.gameManager = gameManager;
    }

    @Override
    public void execute() {
        player.reset();
        gameManager.setScore(0);
    }
}
