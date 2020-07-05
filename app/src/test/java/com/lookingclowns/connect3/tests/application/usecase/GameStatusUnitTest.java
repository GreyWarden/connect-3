package com.lookingclowns.connect3.tests.application.usecase;

import com.lookingclowns.connect3.application.usecase.gamestatus.GameStatus;
import com.lookingclowns.connect3.domain.valueobjects.gameboard.GameBoard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class GameStatusUnitTest {
    GameStatus gameStatus;

    @Before
    public void setUp() {
        gameStatus = new GameStatus(new GameBoard());
    }

    @Test
    public void it_should_add_a_token() {
        int position = 0;
        int player = gameStatus.getActivePlayer();
        assertEquals(
                -1,
                gameStatus.getGameBoardPlayerByPosition(position)
        );
        gameStatus.addToken(position);
        assertEquals(
                player,
                gameStatus.getGameBoardPlayerByPosition(position)
        );
    }
}
