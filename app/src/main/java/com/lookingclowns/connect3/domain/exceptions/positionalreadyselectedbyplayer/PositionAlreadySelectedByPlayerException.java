package com.lookingclowns.connect3.domain.exceptions.positionalreadyselectedbyplayer;

public final class PositionAlreadySelectedByPlayerException extends Exception {
    public PositionAlreadySelectedByPlayerException(int position, int playerId) {
        super(String.format("Player %s have already selected the position %s", playerId, position));
    }
}
