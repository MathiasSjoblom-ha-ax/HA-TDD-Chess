package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

import static java.lang.Math.abs;

public class Queen extends ChessPiece{

    public Queen(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return String.valueOf(PieceType.QUEEN);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        Boolean moveable = false;
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

        if(x == destX && y < destY) {
            for(int i = (y + 1); i < destY; i++) {
                Coordinates coordChecker = new Coordinates(x, i);
                if(chessboard.getPiece(coordChecker) == null) {
                    moveable = true;
                }
                else if(!moveable) {
                    break;
                }
            }
        }
        else if(x == destX && y > destY) {
            for(int i = (y - 1); i > destY; i--) {
                Coordinates coordChecker = new Coordinates(x, i);
                if(chessboard.getPiece(coordChecker) == null) {
                    moveable = true;
                }
                else {
                    moveable = false;
                    break;
                }
            }
        }
        else if(y == destY && x < destX) {
            for(int i = (x + 1); i < destX; i++) {
                Coordinates coordChecker = new Coordinates(i, y);
                if(chessboard.getPiece(coordChecker) == null) {
                    moveable = true;
                }
                else {
                    moveable = false;
                    break;
                }
            }
        }
        else if(y == destY && x > destX) {
            for(int i = (x - 1); i > destX; i--) {
                Coordinates coordChecker = new Coordinates(i, y);
                if(chessboard.getPiece(coordChecker) == null) {
                    moveable = true;
                }
                else {
                    moveable = false;
                    break;
                }
            }
        }
        else if(abs(destX - x) == abs(destY - y)) {
            if(x < destX && y < destY) {
                for(int i = (x + 1), j = (y + 1); i < destX && j < destY; i++, j++) {
                    Coordinates coordChecker = new Coordinates(i, j);
                    if(chessboard.getPiece(coordChecker) == null) {
                        moveable = true;
                    }
                    else {
                        moveable = false;
                        break;
                    }
                }
            }
            else if(x < destX && y > destY) {
                for(int i = (x + 1), j = (y - 1); i < destX && j > destY; i++, j--) {
                    Coordinates coordChecker = new Coordinates(i, j);
                    if(chessboard.getPiece(coordChecker) == null) {
                        moveable = true;
                    }
                    else {
                        moveable = false;
                        break;
                    }
                }
            }
            else if(x > destX && y < destY) {
                for(int i = (x - 1), j = (y + 1); i > destX && j < destY; i--, j++) {
                    Coordinates coordChecker = new Coordinates(i, j);
                    if(chessboard.getPiece(coordChecker) == null) {
                        moveable = true;
                    }
                    else {
                        moveable = false;
                        break;
                    }
                }
            }
            else if(x > destX && y > destY) {
                for(int i = (x - 1), j = (y - 1); i > destX && j > destY; i--, j--) {
                    Coordinates coordChecker = new Coordinates(i, j);
                    if(chessboard.getPiece(coordChecker) == null) {
                        moveable = true;
                    }
                    else {
                        moveable = false;
                        break;
                    }
                }
            }
        }
        else {
            moveable = false;
        }

        return moveable;
    }
}
