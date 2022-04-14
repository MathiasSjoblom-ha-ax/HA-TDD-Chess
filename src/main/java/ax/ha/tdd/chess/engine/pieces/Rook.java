package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Rook extends ChessPiece{

    public Rook(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return String.valueOf(PieceType.ROOK);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        Boolean notMoveable = false;

        if(destination == location) {
            return notMoveable;
        }

        ChessPiece pieceCheck = chessboard.getPiece(destination);
        if(pieceCheck != null && pieceCheck.getPlayer().getSymbol().equals(this.player.getSymbol())) {
            return notMoveable;
        }

        int x = location.getX();
        int y = location.getY();
        int destX = destination.getX();
        int destY = destination.getY();

        boolean moveable = true;

        if(x == destX && y < destY) {
            for(int i = (y + 1); i < destY; i++) {
                Coordinates testCoords = new Coordinates(x, i);
                if(chessboard.getPiece(testCoords) == null) {
                    moveable = true;
                } else {
                    moveable = false;
                    break;
                }
            }
        }
        else if(x == destX && y > destY) {
            for(int i = (y - 1); i > destY; i--) {
                Coordinates testCoords = new Coordinates(x, i);
                if(chessboard.getPiece(testCoords) == null) {
                    moveable = true;
                } else {
                    moveable = false;
                    break;
                }
            }
        }
        else if(y == destY && x < destX) {
            for(int i = (x + 1); i < destX; i++) {
                Coordinates testCoords = new Coordinates(i, y);
                if(chessboard.getPiece(testCoords) == null) {
                    moveable = true;
                } else {
                    moveable = false;
                    break;
                }
            }
        }
        else if(y == destY && x > destX) {
            for(int i = (x - 1); i > destX; i--) {
                Coordinates testCoords = new Coordinates(i, y);
                if(chessboard.getPiece(testCoords) == null) {
                    moveable = true;
                } else {
                    moveable = false;
                    break;
                }
            }
        }
        else {
            moveable = false;
        }
        return moveable;
    }
}
