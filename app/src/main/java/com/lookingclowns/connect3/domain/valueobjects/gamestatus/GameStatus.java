package com.lookingclowns.connect3.domain.valueobjects.gamestatus;

import com.lookingclowns.connect3.domain.valueobjects.gameboard.GameBoard;

public final class GameStatus {
    GameBoard gameBoard;

    public GameStatus(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void addToken(int position, int tokenId) {

    }
}
