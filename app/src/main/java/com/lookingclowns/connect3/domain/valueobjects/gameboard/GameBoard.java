package com.lookingclowns.connect3.domain.valueobjects.gameboard;

import com.lookingclowns.connect3.domain.exceptions.playerisnotallowed.PlayerIsNotAllowedException;

import java.util.Arrays;

public final class GameBoard {
    private final int[] allowedPlayerIds;
    private int[] gameBoard;

    public GameBoard() {
        this.allowedPlayerIds = new int[]{0, 1};
        this.gameBoard = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    public void addToken(int position, int playerId) throws PlayerIsNotAllowedException {
        assertPlayerIsAllowed(playerId);
        this.gameBoard[position] = playerId;
    }

    private void assertPlayerIsAllowed(int playerId) throws PlayerIsNotAllowedException {
        if (Arrays.binarySearch(allowedPlayerIds, playerId) < 0) {
            throw new PlayerIsNotAllowedException(playerId);
        }
    }

    public int getGameBoardPlayerByPosition(int position) {
        return gameBoard[position];
    }
}
