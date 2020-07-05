package com.lookingclowns.connect3.tests.domain.valueobjects.gameboard;

import com.lookingclowns.connect3.domain.valueobjects.gameboard.GameBoard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class GameBoardUnitTest {

    @Test
    public void it_should_create_create_token_in_correct_place_of_array() {
        GameBoard gameBoard = new GameBoard();
        int position = 3;
        int playerId = 1;
        gameBoard.addToken(position, playerId);
        assertEquals(
                playerId,
                gameBoard.getGameBoardPlayerByPosition(position)
        );
    }
}
