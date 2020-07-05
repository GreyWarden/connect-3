package com.lookingclowns.connect3.application.usecase.gamestatus;

import com.lookingclowns.connect3.domain.exceptions.playerisnotallowed.PlayerIsNotAllowedException;
import com.lookingclowns.connect3.domain.exceptions.positionalreadyselectedbyplayer.PositionAlreadySelectedByPlayerException;
import com.lookingclowns.connect3.domain.exceptions.positionistaken.PositionIsTakenException;
import com.lookingclowns.connect3.domain.valueobjects.gameboard.GameBoard;

public final class GameStatus {
    private GameBoard gameBoard;

    // RED = 0, YELLOW = 1
    private int activePlayer;
    private int winnerPlayer;
    private boolean gameFinished;

    public GameStatus(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        activePlayer = 0;
        winnerPlayer = -1;
    }

    public void addToken(int position)
            throws PlayerIsNotAllowedException,
            PositionIsTakenException,
            PositionAlreadySelectedByPlayerException {
        gameBoard.addToken(position, activePlayer);
        setWinnerPlayer();
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

    private void setWinnerPlayer() {
        if (
                (gameBoard.getGameBoardPlayerByPosition(0) == gameBoard.getGameBoardPlayerByPosition(1)) && (gameBoard.getGameBoardPlayerByPosition(1) == gameBoard.getGameBoardPlayerByPosition(2)) && gameBoard.getGameBoardPlayerByPosition(2) == activePlayer ||
                        (gameBoard.getGameBoardPlayerByPosition(0) == gameBoard.getGameBoardPlayerByPosition(3)) && (gameBoard.getGameBoardPlayerByPosition(3) == gameBoard.getGameBoardPlayerByPosition(6)) && gameBoard.getGameBoardPlayerByPosition(6) == activePlayer ||
                        (gameBoard.getGameBoardPlayerByPosition(1) == gameBoard.getGameBoardPlayerByPosition(4)) && (gameBoard.getGameBoardPlayerByPosition(4) == gameBoard.getGameBoardPlayerByPosition(7)) && gameBoard.getGameBoardPlayerByPosition(7) == activePlayer ||
                        (gameBoard.getGameBoardPlayerByPosition(2) == gameBoard.getGameBoardPlayerByPosition(5)) && (gameBoard.getGameBoardPlayerByPosition(5) == gameBoard.getGameBoardPlayerByPosition(8)) && gameBoard.getGameBoardPlayerByPosition(8) == activePlayer ||
                        (gameBoard.getGameBoardPlayerByPosition(3) == gameBoard.getGameBoardPlayerByPosition(4)) && (gameBoard.getGameBoardPlayerByPosition(4) == gameBoard.getGameBoardPlayerByPosition(5)) && gameBoard.getGameBoardPlayerByPosition(5) == activePlayer ||
                        (gameBoard.getGameBoardPlayerByPosition(6) == gameBoard.getGameBoardPlayerByPosition(7)) && (gameBoard.getGameBoardPlayerByPosition(7) == gameBoard.getGameBoardPlayerByPosition(8)) && gameBoard.getGameBoardPlayerByPosition(8) == activePlayer ||
                        (gameBoard.getGameBoardPlayerByPosition(0) == gameBoard.getGameBoardPlayerByPosition(4)) && (gameBoard.getGameBoardPlayerByPosition(4) == gameBoard.getGameBoardPlayerByPosition(8)) && gameBoard.getGameBoardPlayerByPosition(8) == activePlayer ||
                        (gameBoard.getGameBoardPlayerByPosition(2) == gameBoard.getGameBoardPlayerByPosition(4)) && (gameBoard.getGameBoardPlayerByPosition(4) == gameBoard.getGameBoardPlayerByPosition(6)) && gameBoard.getGameBoardPlayerByPosition(6) == activePlayer
        ) {
            winnerPlayer = activePlayer;
            gameFinished = true;
        }
    }

    public int getWinnerPlayer() {
        return winnerPlayer;
    }

    public boolean isGameFinished() {
        return gameFinished || this.gameBoard.isBoardFull();
    }
}
