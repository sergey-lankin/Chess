public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int deltaLine = toLine - line;
        int deltaColumn = toColumn - column;
        if (deltaLine == 0 && deltaColumn == 0) return false;
        else if (toLine > 7 || toLine < 0 || toColumn < 0 || toColumn > 7) return false;
        else if (color.equals("White") && deltaLine == 1 && deltaColumn == 0 &&
                board.board[toLine][toColumn] == null) {
            if (toLine == 7) convertToQueen(board, toLine, toColumn);
            return true;
        }
        else if (color.equals("White") && line == 1 && deltaLine == 2 &&
                board.board[toLine - 1][toColumn] == null &&
                board.board[toLine][toColumn] == null) return true;
        else if (color.equals("White") && ((deltaLine == 1 && deltaColumn == 1) ||
                (deltaLine == 1 && deltaColumn == -1)) &&
                board.board[toLine][toColumn].getColor().equals("Black")) {
            if (toLine == 7) convertToQueen(board, toLine, toColumn);
            return true;
        }

        else if (color.equals("Black") && deltaLine == -1 && deltaColumn == 0 &&
                board.board[toLine][toColumn] == null) {
            if (toLine == 0) convertToQueen(board, toLine, toColumn);
            return true;
        }
        else if (color.equals("Black") && line == 6 && deltaLine == -2 &&
                board.board[line - 1][toColumn] == null &&
                board.board[toLine][toColumn] == null) return true;
        else if (color.equals("Black") && ((deltaLine == -1 && deltaColumn == -1) ||
                (deltaLine == -1 && deltaColumn == 1)) &&
                board.board[toLine][toColumn].getColor().equals("White")) {
            if (toLine == 0) convertToQueen(board, toLine, toColumn);
            return true;
        }
        else return false;
    }

    public void convertToQueen(ChessBoard board, int toLine, int toColumn) {
        board.board[toLine][toColumn] = new Queen(color);
    }
    @Override
    public String getSymbol() {
        return "P";
    }
}
