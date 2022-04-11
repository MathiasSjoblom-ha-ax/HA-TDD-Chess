package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Game {

    Chessboard board = Chessboard.startingBoard();
    String latestMove = "";
    String currentPlayerSymbole = "W";
    int round = 0;

    //Feel free to delete this stuff. Just for initial testing.
    boolean isNewGame = true;

    public int roundCounter() {
        return round = round + 1;
    }

    public Player getPlayerToMove() {
        if(latestMove.contains("Player successfully moved")) {
            roundCounter();
        }
        if((round % 2) == 0) {
            currentPlayerSymbole = "W";
            return Player.WHITE;
        } else {
            currentPlayerSymbole = "B";
            return Player.BLACK;
        }
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getLastMoveResult() {
        if (isNewGame) {
            return "Game hasn't begun";
        }
        return latestMove;
    }

    public void move(String move) {
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

        Coordinates fromCoords = new Coordinates(moveFrom);
        Coordinates tooCoords = new Coordinates(moveTo);
        ChessPiece piece = board.getPiece(fromCoords);
        if(piece.getPlayer().getSymbol() == currentPlayerSymbole) {
            if(piece.canMove(board, tooCoords)) { //This if statement doesnt work
                System.out.println(piece.getPlayer().getSymbol());
                board.removePiece(piece);
                piece.setLocation(tooCoords);
                board.addPiece(piece);
                latestMove = "Player successfully moved " + move;
            } else {
                latestMove = "Illegal move (" + move + ")";
            }
        }
        isNewGame = false;
        System.out.println("Player tried to perform move: " + move);
    }
}
