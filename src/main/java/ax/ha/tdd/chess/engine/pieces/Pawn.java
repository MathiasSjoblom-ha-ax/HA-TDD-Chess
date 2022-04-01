package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Pawn extends ChessPiece{

    public Pawn(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return String.valueOf(PieceType.PAWN);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        Boolean notMoveable = false;
        Boolean moveable = true;

        if(destination == location) {
            return notMoveable;
        }

        ChessPiece pieceCheck = chessboard.getPiece(destination);
        if(pieceCheck != null && pieceCheck.getPlayer().getSymbol() == this.player.getSymbol()) {
            return notMoveable;
        }

        int x = location.getX();
        int y = location.getY();
        int destX = destination.getX();
        int destY = destination.getY();
        boolean firstMove = true;

        if(player.getSymbol() == "WHITE") {
            if(destX == x && destY == (y + 1) && chessboard.getPiece(destination) == null) {
                return moveable;
            }
            else if(destX == x && destY == (y + 2) && chessboard.getPiece(destination) == null) {
                Coordinates testCoords = new Coordinates(x, y + 1);
                if(chessboard.getPiece(testCoords) == null && firstMove) {
                    return moveable;
                }
            }
            else if((destX == (x + 1) || destX == (x - 1)) && destY == (y + 1)) {
                Coordinates testCoords = new Coordinates(x, y + 1);
                if(chessboard.getPiece(destination) != null && chessboard.getPiece(destination).getPlayer().getSymbol() == "BLACK") {
                    return moveable;
                }
            }
            return notMoveable;
        }

        // Check relevant moves if the pawn in black.
        else  {
            if(destX == x && destY == (y - 1) && chessboard.getPiece(destination) == null) {
                return moveable;
            }
            else if(destX == x && destY == (y - 2) && chessboard.getPiece(destination) == null) {
                Coordinates testCoords = new Coordinates(x, y - 1);
                if(chessboard.getPiece(testCoords) == null && firstMove) {
                    return moveable;
                }
            }
            else if((destX == (x + 1) || destX == (x - 1)) && destY == (y - 1)) {
                if(chessboard.getPiece(destination) != null && chessboard.getPiece(destination).getPlayer().getSymbol() == "BLACK") {
                    return moveable;
                }
            }
            return notMoveable;
        }

    }
}
