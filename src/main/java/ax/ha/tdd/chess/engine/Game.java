package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Game {

    Chessboard board = Chessboard.startingBoard();

    //Feel free to delete this stuff. Just for initial testing.
    boolean isNewGame = true;
    int round = -1;

    public int roundCounter() {
        return round = round + 1;
    }

    public Player getPlayerToMove() {
        //TODO this should reflect the current state.
        roundCounter();
        if((round % 2) == 0) {
            return Player.WHITE;
        } else {
            return Player.BLACK;
        }
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getLastMoveResult() {
        //TODO this should be used to show the player what happened
        //Illegal move, correct move, e2 moved to e4 etc.
        if (isNewGame) {
            return "Game hasn't begun";
        }
        return "Last move was successful (default reply, change this)";
    }

    public String move(String move) {
        //TODO this should trigger your move logic.
        if(move.length() > 5) {
            throw new IllegalArgumentException("Illegal input");
        }
        String moveFrom = "";
        String moveTo = "";
        for(int i = 0; i < move.length(); i++) {
            if(i != 2) {
                char ch = move.charAt(i);
                if(moveFrom.length() < 2) {
                    moveFrom = moveFrom + String.valueOf(ch);
                } else {
                    moveTo = moveTo + String.valueOf(ch);
                }
            }
        }
        //return moveTo;

        Coordinates newCoords = new Coordinates(moveFrom);
        Coordinates newCoords2 = new Coordinates(moveTo);
        ChessPiece piece = board.getPiece(newCoords);
        if(piece.canMove(board, newCoords2)) {

        }
        isNewGame = false;
        System.out.println("Player tried to perform move: " + move);
        return moveTo;

    }
}
