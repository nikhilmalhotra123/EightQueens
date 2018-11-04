public class eightQueens {
  /* 
  A1 --> [1][1]
  B1 --> [2][1]
  C3 --> [3][3]
  */
  public static void main(String[] args) {
    boolean[][] board = new boolean[8][8];
    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        board [i][j] = false;
      }
    }
    int row = 3; //can be between -1 and 6 depending where you want first square (row - 2)
    int count = 1;
    int column = 1;
    int addedTrue = 0;
    
    while (count < 9) {
      for(int i = row + 1; i < 8; i++) {  
        if(horizontal(board, i) && diagonal(board, column - 1, i)) {
             board[column - 1][i] = true;
             addedTrue++;
             break;
        }             
      }
      if(addedTrue == 0) {
         column--;
         count--;
         for(int z = 0; z < 8; z++) {
           if(board[column - 1][z]) {
             row = z;
             board[column - 1][z] = false;
           }
         }
       }
      if(addedTrue == 1) {
        column++;
        count++;
        addedTrue = 0;
        row = -1;
      } 
     /*printBoard(board);
     System.out.println("\n\n");*/
    }
    printBoard(board);
  }
  
  public static boolean horizontal(boolean[][] square, int row) {
    for(int i = 0; i < 8; i++) {
      if(square[i][row])
        return false;
    }
    return true;
  }
  
  public static boolean diagonal(boolean[][] square, int column, int row) {
    for(int i = 0; i < 8; i++) {
      for(int k = 0; k < 8; k++) {
        if(((i + k) == (column + row) && square[i][k]) || ((i - k) == (column - row) && square[i][k]))
          return false;
      }
    }
    return true;
  }
  
  public static void printBoard(boolean[][] square) {
    for(int i = 7; i >= 0; i--) {
      for(int j = 0; j < 8; j++) {
        if(square[j][i])
          System.out.print("1 ");
        else
          System.out.print("0 ");
      }
      System.out.println();
    }
  }  
}
