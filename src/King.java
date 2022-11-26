import java.util.ArrayList;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int deltaLine = Math.abs(toLine - line);
        int deltaColumn = Math.abs(toColumn - column);
        if (deltaLine == 0 && deltaColumn == 0) return false;
        else if (toLine > 7 || toLine < 0 || toColumn < 0 || toColumn > 7) return false;
        else if ((deltaLine == 1 && deltaColumn == 1) || (deltaLine == 0 && deltaColumn == 1) ||
                (deltaLine == 1 && deltaColumn == 0)) {
            if (board.board[toLine][toColumn].color.equals(color)) return false;
            else return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        int k = 0;
        for (int i = 7; i > -1; i--) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && !((board.board[i][j]).getColor()).equals(color)) {
                    if(board.board[i][j].canMoveToPosition(board, i, j, line, column)) return true;
                }
            }
        }
        return false;
    }
}

