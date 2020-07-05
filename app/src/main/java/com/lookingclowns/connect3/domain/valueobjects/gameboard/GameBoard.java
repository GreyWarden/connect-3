package com.lookingclowns.connect3.domain.valueobjects.gameboard;

public final class GameBoard {
    private final int[] allowedPlayerIds;
    private int[] gameBoard;

    public GameBoard() {
        this.allowedPlayerIds = new int[]{0, 1};
        this.gameBoard = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    public void addToken(int position, int playerId) {
        this.gameBoard[position] = playerId;
    }

    public int getGameBoardPlayerByPosition(int position) {
        return gameBoard[position];
    }
}
