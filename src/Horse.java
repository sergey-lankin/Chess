public class Horse extends ChessPiece {
    public Horse(String color) {
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
        else if (((deltaColumn == 2 && deltaLine == 1) || (deltaColumn == 1 && deltaLine == 2))
                && (board.board[toLine][toColumn] == null || !board.board[toLine][toColumn].getColor().equals(color))) {
            return true;
        }
        else return false;
    }
    @Override
    public String getSymbol() {
        return "H";
    }
}