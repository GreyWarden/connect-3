package com.lookingclowns.connect3.domain.valueobjects.gameboard;

import com.lookingclowns.connect3.domain.exceptions.playerisnotallowed.PlayerIsNotAllowedException;
import com.lookingclowns.connect3.domain.exceptions.positionalreadyselectedbyplayer.PositionAlreadySelectedByPlayerException;
import com.lookingclowns.connect3.domain.exceptions.positionistaken.PositionIsTakenException;

import java.util.Arrays;

public final class GameBoard {
    private final int[] allowedPlayerIds;
    private int[] gameBoard;

    public GameBoard() {
        this.allowedPlayerIds = new int[]{0, 1};
        this.gameBoard = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    public void addToken(int position, int playerId)
            throws PlayerIsNotAllowedException,
            PositionIsTakenException,
            PositionAlreadySelectedByPlayerException {
        assertPlayerIsAllowed(playerId);
        assertPositionIsTaken(position, playerId);
        assertPlayerHasNotSelectedThePosition(playerId, position);
        this.gameBoard[position] = playerId;
    }

    private void assertPlayerHasNotSelectedThePosition(int playerId, int position)
            throws PositionAlreadySelectedByPlayerException {
        if (gameBoard[position] != -1 && gameBoard[position] == playerId) {
            throw new PositionAlreadySelectedByPlayerException(position, playerId);
        }
    }

    private void assertPositionIsTaken(int position, int playerId) throws PositionIsTakenException {
        if (gameBoard[position] != -1 && gameBoard[position] != playerId) {
            throw new PositionIsTakenException(position);
        }
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
