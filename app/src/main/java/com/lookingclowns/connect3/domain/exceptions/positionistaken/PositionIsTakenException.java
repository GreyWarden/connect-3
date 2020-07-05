package com.lookingclowns.connect3.domain.exceptions.positionistaken;

public final class PositionIsTakenException extends Exception {
    public PositionIsTakenException(int position) {
        super(String.format("Position %s is already taken", position));
    }
}
