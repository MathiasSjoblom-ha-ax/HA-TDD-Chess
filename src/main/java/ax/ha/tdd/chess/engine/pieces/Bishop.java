package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import static java.lang.Math.abs;

public class Bishop extends ChessPiece{

    public Bishop(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return String.valueOf(PieceType.BISHOP);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        boolean notMoveable = false;
        boolean moveable = true;

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

        // Destination is diagonally in line with the current location.
        if(abs(destX - x) == abs(destY - y)) {
            // Destination is up and to the right of the current location.
            if(x < destX && y < destY) {
                for(int i = (x + 1), j = (y + 1); i < destX && j < destY; i++, j++) {
                    Coordinates testCoords = new Coordinates(i, j);
                    moveable = (chessboard.getPiece(testCoords) == null);
                    if(!moveable) {
                        break;
                    }
                }
            }
            // Destination is down and to the right of the current location.
            else if(x < destX && y > destY) {
                for(int i = (x + 1), j = (y - 1); i < destX && j > destY; i++, j--) {
                    Coordinates testCoords = new Coordinates(i, j);
                    moveable = (chessboard.getPiece(testCoords) == null);
                    if(!moveable) {
                        break;
                    }
                }
            }
            // Destination is up and to the left of the current location.
            else if(x > destX && y < destY) {
                for(int i = (x - 1), j = (y + 1); i > destX && j < destY; i--, j++) {
                    Coordinates testCoords = new Coordinates(i, j);
                    moveable = (chessboard.getPiece(testCoords) == null);
                    if(!moveable) {
                        break;
                    }
                }
            }
            // Destination is down and to the left of the current location.
            else if(x > destX && y > destY) {
                for(int i = (x - 1), j = (y - 1); i > destX && j > destY; i--, j--) {
                    Coordinates testCoords = new Coordinates(i, j);
                    moveable = (chessboard.getPiece(testCoords) == null);
                    if(!moveable) {
                        break;
                    }
                }
            }
        }
        // Destination is some other tile on the board (can't move there).
        else {
            moveable = false;
        }

        return moveable;

    }
}
