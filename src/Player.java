import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String playerName;
    private char symbol;
    protected static ArrayList<Integer> choices= new ArrayList();

    Player(){}

    Player(String playerName, char symbol){
        this.setPlayerName(playerName);
        this.setSymbol(symbol);
    }

    public void setPlayerName(String playerName) {
            this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setSymbol(char symbol) {
        if(symbol!='O' && symbol!='X'){
            System.out.println("invalid symbol");
        }else {
            this.symbol = symbol;
        }
    }
    public char getSymbol() {
        return symbol;
    }

    public int playerInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("Make your move from 1 to 9: ");
        int choice=-1;
        while(choice<0 || choice>9){
            choice = in.nextInt();
            if (choice<0 || choice>9 || choices.contains(choice)) {
                System.out.println("Invalid choice, try again: ");
                choice = -1;
            }
        }
        choices.add(choice);
        return choice;
    }

    public int AiInput(){
        int choice = (int)(Math.random()*10);
        while(choice<1 || choice>9 || choices.contains(choice)){
            choice = (int)(Math.random()*10);
        }
        choices.add(choice);
        return choice;
    }

    public int getChoice(){
        return choices.get(choices.size()-1);
    }

}
