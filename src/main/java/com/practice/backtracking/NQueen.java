package com.practice.backtracking;


import java.util.List;

public class NQueen
{

  public Position[] solve(int n){
    final NQueen nQueen = new NQueen();
    NQueen.Position[] positions = new NQueen.Position[n];
    nQueen.solveNQueensPosition(n, 0, positions);
    return positions;
  }

  private boolean solveNQueensPosition(int n, int row, Position[] positions)
  {
    if (n == row) {
      return true;
    } else {
      for (int col = 0; col < n; col++) {
        boolean foundPos = true;
        for (int queen = 0; queen < row; queen++) {
          if (positions[queen].col == col || ((positions[queen].row + positions[queen].col) == row + col)
              || ((positions[queen].row - positions[queen].col) == row - col)) {
            foundPos = false;
            break;
          }
        }
        if (foundPos) {
          positions[row] = new Position(row, col);
          if( solveNQueensPosition(n, row + 1, positions)){
            return true;
          }
        }
      }
    }
    return false;
  }

  static class Position
  {
    private final int row, col;

    Position(int x, int y)
    {
      this.row = x;
      this.col = y;
    }

    @Override
    public String toString()
    {
      final StringBuilder sb = new StringBuilder("Position{");
      sb.append("row=").append(row);
      sb.append(", col=").append(col);
      sb.append('}');
      return sb.toString();
    }
  }
}


