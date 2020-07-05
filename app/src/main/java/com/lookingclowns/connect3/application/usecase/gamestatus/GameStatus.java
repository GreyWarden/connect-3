package com.lookingclowns.connect3.application.usecase.gamestatus;

import com.lookingclowns.connect3.domain.exceptions.playerisnotallowed.PlayerIsNotAllowedException;
import com.lookingclowns.connect3.domain.exceptions.positionalreadyselectedbyplayer.PositionAlreadySelectedByPlayerException;
import com.lookingclowns.connect3.domain.exceptions.positionistaken.PositionIsTakenException;
import com.lookingclowns.connect3.domain.valueobjects.gameboard.GameBoard;

public final class GameStatus {
    private GameBoard gameBoard;

    // RED = 0, YELLOW = 1
    private int activePlayer;

    public GameStatus(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        activePlayer = 0;
    }

    public void addToken(int position)
            throws PlayerIsNotAllowedException,
            PositionIsTakenException,
            PositionAlreadySelectedByPlayerException {
        gameBoard.addToken(position, activePlayer);
        changeActivePlayer();
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public int getGameBoardPlayerByPosition(int position) {
        return gameBoard.getGameBoardPlayerByPosition(position);
    }

    private void changeActivePlayer() {
        activePlayer = activePlayer == 0 ? 1 : 0;
    }
}
