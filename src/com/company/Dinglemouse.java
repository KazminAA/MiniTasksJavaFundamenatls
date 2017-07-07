package com.company;

public class Dinglemouse {
    public static int snakesAndLadders(final int[] board, final int[] dice) {
        int fSquare = board.length - 1;
        int currentSquare = 0;
        for (int i = 0; i < dice.length; i++) {
            if ((currentSquare + dice[i]) > fSquare) continue;
            currentSquare += dice[i];
            if (currentSquare == fSquare) break;
            currentSquare += board[currentSquare];

        }
        return currentSquare;
    }
}
