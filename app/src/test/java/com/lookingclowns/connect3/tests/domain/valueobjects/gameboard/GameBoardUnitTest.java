package com.lookingclowns.connect3.tests.domain.valueobjects.gameboard;

import com.lookingclowns.connect3.domain.exceptions.playerisnotallowed.PlayerIsNotAllowedException;
import com.lookingclowns.connect3.domain.exceptions.positionalreadyselectedbyplayer.PositionAlreadySelectedByPlayerException;
import com.lookingclowns.connect3.domain.exceptions.positionistaken.PositionIsTakenException;
import com.lookingclowns.connect3.domain.valueobjects.gameboard.GameBoard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class GameBoardUnitTest {

    private GameBoard gameBoard;

    @Before
    public void setUp() {
        this.gameBoard = new GameBoard();
    }

    @Test
    public void it_should_create_create_token_in_correct_place_of_array()
            throws PlayerIsNotAllowedException,
            PositionIsTakenException,
            PositionAlreadySelectedByPlayerException {
        int position = 3;
        int playerId = 1;
        gameBoard.addToken(position, playerId);
        assertEquals(
                playerId,
                gameBoard.getGameBoardPlayerByPosition(position)
        );
    }

    @Test(expected = PlayerIsNotAllowedException.class)
    public void it_should_throw_an_exception_if_player_is_not_allowed()
            throws PlayerIsNotAllowedException,
            PositionIsTakenException,
            PositionAlreadySelectedByPlayerException {
        int position = 3;
        int playerId = 2;
        gameBoard.addToken(position, playerId);
    }

    @Test(expected = PositionIsTakenException.class)
    public void it_should_throw_an_exception_if_position_is_taken()
            throws PositionIsTakenException,
            PlayerIsNotAllowedException,
            PositionAlreadySelectedByPlayerException {
        int position = 3;
        int playerId = 0;
        int anotherPlayerId = 1;
        gameBoard.addToken(position, playerId);
        gameBoard.addToken(position, anotherPlayerId);
    }

    @Test(expected = PositionAlreadySelectedByPlayerException.class)
    public void it_should_throw_an_exception_if_active_player_is_trying_to_reselect_a_position()
            throws PlayerIsNotAllowedException,
            PositionIsTakenException,
            PositionAlreadySelectedByPlayerException {
        int position = 3;
        int playerId = 0;
        gameBoard.addToken(position, playerId);
        gameBoard.addToken(position, playerId);
    }
}
