package com.lookingclowns.connect3.tests.application.usecase;

import com.lookingclowns.connect3.application.usecase.gamestatus.GameStatus;
import com.lookingclowns.connect3.domain.exceptions.playerisnotallowed.PlayerIsNotAllowedException;
import com.lookingclowns.connect3.domain.exceptions.positionalreadyselectedbyplayer.PositionAlreadySelectedByPlayerException;
import com.lookingclowns.connect3.domain.exceptions.positionistaken.PositionIsTakenException;
import com.lookingclowns.connect3.domain.valueobjects.gameboard.GameBoard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class GameStatusUnitTest {
    private GameStatus gameStatus;
    private int position;

    @Before
    public void setUp() {
        gameStatus = new GameStatus(new GameBoard());
        position = 0;
    }

    @Test
    public void it_should_add_a_token() throws PlayerIsNotAllowedException, PositionIsTakenException, PositionAlreadySelectedByPlayerException {
        int player = gameStatus.getActivePlayer();
        assertEquals(
                -1,
                gameStatus.getGameBoardPlayerByPosition(this.position)
        );
        gameStatus.addToken(this.position);
        assertEquals(
                player,
                gameStatus.getGameBoardPlayerByPosition(this.position)
        );
    }

    @Test
    public void it_should_change_the_active_player() throws PlayerIsNotAllowedException, PositionIsTakenException, PositionAlreadySelectedByPlayerException {
        int currentActivePlayer = 0;
        int nextActivePlayer = 1;
        assertEquals(
                currentActivePlayer,
                gameStatus.getActivePlayer()
        );
        gameStatus.addToken(this.position);
        assertEquals(
                nextActivePlayer,
                gameStatus.getActivePlayer()
        );
    }
}
