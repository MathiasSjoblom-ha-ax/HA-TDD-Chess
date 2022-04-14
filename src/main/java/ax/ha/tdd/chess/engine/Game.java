package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Game {

    Chessboard board = Chessboard.startingBoard();
    String latestMove = "";
    String currentPlayerSymbol = "W";
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
        ChessPiece piece = board.getPiece(fromCoords);
        ChessPiece destinationPiece = board.getPiece(fromCoords);
        if(piece == null) {
            latestMove = "Please input coordinates for a valid piece";
            isNewGame = false;
        }
        if(piece.canMove(board, tooCoords) && piece.getPlayer().getSymbol().equals(currentPlayerSymbol)) {
            if(destinationPiece.getPieceType() == PieceType.KING) {
                board.removePiece(destinationPiece);
                board.removePiece(piece);
                piece.setLocation(tooCoords);
                board.addPiece(piece);
                latestMove = getPlayerToMove() + " Won!";
                isNewGame = false;
                return true;
            }
            board.removePiece(destinationPiece);
            board.removePiece(piece);
            piece.setLocation(tooCoords);
            board.addPiece(piece);
            latestMove = "Player successfully moved " + move;
            isNewGame = false;
            return true;
            } else {
            latestMove = "Illegal move (" + move + ")";
        }
        isNewGame = false;
        return false;
    }
}
