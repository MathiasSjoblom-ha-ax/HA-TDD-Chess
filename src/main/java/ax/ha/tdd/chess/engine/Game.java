package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.PieceType;

import java.util.Objects;

public class Game {

    Chessboard board = Chessboard.startingBoard();
    String latestMove = "";
    String currentPlayerSymbol = "W";
    int round = 0;
    boolean isNewGame = true;

    public int roundCounter() {
        return round = round + 1;
    }

    public Player getPlayerToMove() {
        if(latestMove.contains("Player successfully moved")) {
            roundCounter();
        }
        if((round % 2) == 0) {
            currentPlayerSymbol = "W";
            return Player.WHITE;
        } else {
            currentPlayerSymbol = "B";
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

    public boolean move(String move) {
        //TODO this should trigger your move logic.
        if(latestMove.contains(" Won!")) {
            return false;
        }
        if(move.length() > 5 || move.isEmpty()) {
            latestMove = "Illegal move";
            isNewGame = false;
            return false;
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
        ChessPiece fromPiece = board.getPiece(fromCoords);
        ChessPiece destinationPiece = board.getPiece(tooCoords);
        if(fromPiece == null) {
            latestMove = "Please input coordinates for a valid piece";
            isNewGame = false;
        }

        if(board.getPiece(fromCoords) != null) {
            if(board.getPiece(fromCoords).getPlayer().getSymbol().equals(currentPlayerSymbol)) {
                latestMove = "Cant move opponents pieces";
                isNewGame = false;
                return false;
            }
        }

        if (fromPiece != null) {
            if(fromPiece.canMove(getBoard(), tooCoords)) {
                System.out.println(fromPiece.canMove(board, tooCoords));
                if(destinationPiece != null && destinationPiece.getPieceType().equals(PieceType.KING)) {
                    board.removePiece(destinationPiece);
                    board.removePiece(fromPiece);
                    fromPiece.setLocation(tooCoords);
                    board.addPiece(fromPiece);
                    latestMove = getPlayerToMove() + " Won!";
                    isNewGame = false;
                    return true;
                }
                if (destinationPiece != null) {
                    board.removePiece(destinationPiece);
                }
                board.removePiece(fromPiece);
                fromPiece.setLocation(tooCoords);
                board.addPiece(fromPiece);
                latestMove = "Player successfully moved " + move;
                isNewGame = false;
                return true;
                } else {
                latestMove = "Illegal move (" + move + ")";
            }
        }
        isNewGame = false;
        return false;
    }
}
