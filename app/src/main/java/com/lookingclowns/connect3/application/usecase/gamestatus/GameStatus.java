package com.lookingclowns.connect3.application.usecase.gamestatus;

import com.lookingclowns.connect3.domain.valueobjects.gameboard.GameBoard;

public final class GameStatus {
    private GameBoard gameBoard;
    private int activePlayer;

    public GameStatus(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        activePlayer = 0;
    }

    public void addToken(int position) {

    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public int getGameBoardPlayerByPosition(int position) {
        return gameBoard.getGameBoardPlayerByPosition(position);
    }

    private void changeActivePlayer() {

    }
}
