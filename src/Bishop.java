public class Bishop extends ChessPiece {
    public Bishop(String color) {
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
        else if (deltaLine == deltaColumn && ((board.board[toLine][toColumn] == null ||
                !board.board[toLine][toColumn].getColor().equals(color)))) {
            if (deltaColumn > 1 && (line < toLine && column < toColumn)) {
                for (int i = 1; i < deltaColumn; i++) {
                    if (board.board[line + i][column + i] != null) return false;
                }
                return true;
            } else if (deltaColumn > 1 && (line > toLine && column < toColumn)) {
                for (int i = 1; i < deltaColumn; i++) {
                    if (board.board[line - i][column + i] != null) return false;
                }
                return true;
            } else if (deltaColumn > 1 && (line > toLine && column > toColumn)) {
                for (int i = 1; i < deltaColumn; i++) {
                    if (board.board[line - i][column - i] != null) return false;
                }
                return true;
            } else if (deltaColumn > 1 && (line < toLine && column > toColumn)) {
                for (int i = 1; i < deltaColumn; i++) {
                    if (board.board[line + i][column - i] != null) return false;
                }
                return true;
            } else return true;
        }
        else return false;
    }
    @Override
    public String getSymbol() {
        return "B";
    }
}

