import java.util.*;

public class TicTacToe extends Board{
    private boolean won;

    TicTacToe(){
        won=false;
    }

    public void start(){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the TicTacToe game😊");

        System.out.println("Press '1' for Single player or '2' for Multi player: ");
        int mode = 0;
        try {
            while (mode!=1 && mode!=2) {
                mode = in.nextInt();
                if (mode!=1 && mode!=2){
                    System.out.println("Invalid input, please try again!");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input, please try again!");
        }
        if(mode==1){
            SinglePlayer();
        }else if(mode==2){
            MultiPlayer();
        }
        if(won){
            System.out.println(getWinner()+" is the winner🎉");
        }else if(choices.containsAll(Arrays.asList(1,2,3,4,5,6,7,8,9))){
            System.out.println("The game ended with a tie!🔥");
        }

        System.out.println("\nDo you want to play again? 'y' for yes or 'n' for no");
        char playAgain='a';
        try {
            playAgain = in.next().charAt(0);
            while (playAgain!='y' && playAgain!='n'){
                System.out.println("Invalid input, please try again!");
                playAgain = in.next().charAt(0);
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input!\nThanks for playing our game😊");
        }
        if (playAgain=='y'){
            resetBoard();
            start();
        }else{
            System.out.println("Invalid input!\nThanks for playing our game😊");
        }
    }

    public void SinglePlayer(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name;
        try {
            while (true) {
                name = in.nextLine();
                if (!name.isEmpty()){
                    break;
                }
                System.out.println("Invalid input, please try again!");
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input! name is set to Alex");
            name = "Alex";
        }

        System.out.println("Choose your symbol. 'O' for O or 'X' for X: ");
        char symbol='A';
        try {
            while (symbol!='O' && symbol!='X') {
                symbol = in.next().charAt(0);
                if (symbol!='O' && symbol!='X') {
                    System.out.println("Invalid input, please try again!");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input! symbol is set to 'O'");
            symbol = 'O';
        }

        Player player = new Player(name,symbol);

        char AiSymbol;
        if(player.getSymbol()=='O'){
            AiSymbol='X';
        }else {
            AiSymbol='O';
        }

        displayBoard();
        int rounds =0;

        while(rounds!=9){
            rounds++;
            if(choices.containsAll(Arrays.asList(1,2,3,4,5,6,7,8,9))){
                break;
            }
            int playerChoice = player.playerInput();
            updateBord(player.getSymbol(), playerChoice);
            displayBoard();
            if (checkWinner()){
                won=true;
                break;
            }
            if(choices.containsAll(Arrays.asList(1,2,3,4,5,6,7,8,9))){
                break;
            }
            System.out.println("Ai's turn: ");
            int aiChoice = player.AiInput();
            updateBord(AiSymbol, aiChoice);
            displayBoard();
            if (checkWinner()){
                won=true;
                break;
            }
        }

    }

    public void MultiPlayer(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the first player name: ");
        String firstName;
        try {
            while (true) {
                firstName = in.nextLine();
                if (!firstName.isEmpty()){
                    break;
                }
                System.out.println("Invalid input, please try again!");
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input! first player's name is set to Alex");
            firstName = "Alex";
        }

        System.out.println("Choose your symbol. 'O' for O or 'X' for X: ");
        char symbol='A';
        try {
            while (symbol!='O' && symbol!='X') {
                symbol = in.next().charAt(0);
                if (symbol!='O' && symbol!='X') {
                    System.out.println("Invalid input, please try again!");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input! symbol is set to 'O'");
            symbol = 'O';
        }

        Player player1 = new Player(firstName,symbol);

        System.out.println("Enter the second player name: ");
        String secName;
        in.skip("\n");
        try {
            do {
                secName = in.nextLine();
            } while (secName.isEmpty());
        }catch (InputMismatchException e){
            System.out.println("Invalid input! second player's name is set to Mark");
            secName = "Mark";
        }

        char secSymbol;
        if(player1.getSymbol()=='O'){
            secSymbol='X';
        }else {
            secSymbol='O';
        }

        Player player2 = new Player(secName,secSymbol);

        displayBoard();
        int rounds=0;

        while(rounds<=4){
            rounds++;
            if(choices.containsAll(Arrays.asList(1,2,3,4,5,6,7,8,9))){
                break;
            }
            System.out.println("First player turn: ");
            player1.playerInput();
            updateBord(player1.getSymbol(), player1.getChoice());
            displayBoard();
            if (checkWinner()){
                won=true;
                break;
            }
            if(choices.containsAll(Arrays.asList(1,2,3,4,5,6,7,8,9))){
                break;
            }
            System.out.println("Second player turn: ");
            player2.playerInput();
            updateBord(player2.getSymbol(), player2.getChoice());
            displayBoard();
            if (checkWinner()){
                won=true;
                break;
            }
        }

    }



}
