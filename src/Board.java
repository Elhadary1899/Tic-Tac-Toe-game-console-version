public class Board extends Player{
    private char[][] board = {{' ',' ','|',' ',' ','|',' ',' '},
                              {'-','-','|','-','-','|','-','-'},
                              {' ',' ','|',' ',' ','|',' ',' '},
                              {'-','-','|','-','-','|','-','-'},
                              {' ',' ','|',' ',' ','|',' ',' '}
    };
    private String winner;
    protected int counterToTie =0;

    public void resetBoard(){
        board = new char[][]{{' ', ' ', '|', ' ', ' ', '|', ' ', ' '},
                {'-', '-', '|', '-', '-', '|', '-', '-'},
                {' ', ' ', '|', ' ', ' ', '|', ' ', ' '},
                {'-', '-', '|', '-', '-', '|', '-', '-'},
                {' ', ' ', '|', ' ', ' ', '|', ' ', ' '}
        };
        choices.clear();
    }

    public void updateBord(char symbol, int choice){
        switch (choice) {
            case 1:
                board[0][1] = symbol;
                break;
            case 2:
                board[0][4] = symbol;
                break;
            case 3:
                board[0][7] = symbol;
                break;
            case 4:
                board[2][1] = symbol;
                break;
            case 5:
                board[2][4] = symbol;
                break;
            case 6:
                board[2][7] = symbol;
                break;
            case 7:
                board[4][1] = symbol;
                break;
            case 8:
                board[4][4] = symbol;
                break;
            case 9:
                board[4][7] = symbol;
                break;
        }
    }

    public void displayBoard(){
        for (char[] row : board){
            for(char chars : row){
                System.out.print(chars);
            }
            System.out.println();
        }
    }

    public boolean checkWinner(){
        boolean[] winO = { ( (board[0][1]==(board[2][4])) && (board[0][1]==(board[4][7])) && (board[0][1]==('O')) ),
                          ( (board[0][7]==(board[2][4])) && (board[0][7]==(board[4][1])) && (board[0][7]==('O'))  ),
                          ( (board[0][1]==(board[0][4])) && (board[0][4]==(board[0][7])) && (board[0][1]==('O'))  ),
                          ( (board[2][1]==(board[2][4])) && (board[2][4]==(board[2][7])) && (board[2][1]==('O'))  ),
                          ( (board[4][1]==(board[4][4])) && (board[4][1]==(board[4][7])) && (board[4][1]==('O'))  ),
                          ( (board[0][1]==(board[2][1])) && (board[0][1]==(board[4][1])) && (board[0][1]==('O'))  ),
                          ( (board[0][4]==(board[2][4])) && (board[2][4]==(board[4][4])) && (board[0][4]==('O'))  ),
                          ( (board[0][7]==(board[2][7])) && (board[0][7]==(board[4][7])) && (board[0][7]==('O'))  )
        };
        boolean[] winX = { ( (board[0][1]==(board[2][4])) && (board[0][1]==(board[4][7])) && (board[0][1]==('X')) ),
                           ( (board[0][7]==(board[2][4])) && (board[0][7]==(board[4][1])) && (board[0][7]==('X'))  ),
                           ( (board[0][1]==(board[0][4])) && (board[0][4]==(board[0][7])) && (board[0][1]==('X'))  ),
                           ( (board[2][1]==(board[2][4])) && (board[2][4]==(board[2][7])) && (board[2][1]==('X'))  ),
                           ( (board[4][1]==(board[4][4])) && (board[4][1]==(board[4][7])) && (board[4][1]==('X'))  ),
                           ( (board[0][1]==(board[2][1])) && (board[0][1]==(board[4][1])) && (board[0][1]==('X'))  ),
                           ( (board[0][4]==(board[2][4])) && (board[2][4]==(board[4][4])) && (board[0][4]==('X'))  ),
                           ( (board[0][7]==(board[2][7])) && (board[0][7]==(board[4][7])) && (board[0][7]==('X'))  )
        };
        boolean win=false;
        for (int i=0;i<winX.length; i++) {
            counterToTie++;
            if(winX[i]){
                winner = "X";
                win=true;
                break;
            }else if(winO[i]) {
                winner = "O";
                win=true;
                break;
            }
        }
        return win;
    }

    public String getWinner(){
        return this.winner;
    }


}
