package com.lookingclowns.connect3.domain.exceptions.playerisnotallowed;

public final class PlayerIsNotAllowedException extends Exception {
    public PlayerIsNotAllowedException(int playerId) {
        super(String.format("Player with id %s is not allowed to add tokens", playerId));
    }
}
