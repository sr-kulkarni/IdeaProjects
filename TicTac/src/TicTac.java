import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by kulkarn1 on 5/2/2016.
 */
public class TicTac {

    public char[][] board;

    public TicTac(){
        this.board = new char[3][3];
        System.out.println("Board is set up!");
    }

    private boolean isValid(char el){
        if(el == 'X')
            return true;
        if(el == 'O')
            return true;
        return false;
    }

    private boolean scanRow(int rowNumber){
        int i;
        char firstElement = this.board[rowNumber][0];
        if(!isValid(firstElement))
            return false;

        for(i=1;i<3;i++){
            if(this.board[rowNumber][i] != firstElement)
                return false;
        }
        return true;
    }

    private boolean scanCol(int colNumber){
        int i;
        char firstElement = this.board[0][colNumber];
        if(!isValid(firstElement))
            return false;
        for(i=1;i<3;i++){
            if(this.board[i][colNumber] != firstElement)
                return false;
        }
        return true;
    }

    private boolean diagCheck(){
        if(!isValid(this.board[1][1])){
            return false;
        }
        char midElement = this.board[1][1];

        if(midElement == this.board[0][0] && midElement == this.board[2][2]){
               return true;
        }
        else if(midElement == this.board[0][2] && midElement == this.board[2][0]){
            return true;
        }
        return false;
    }


    public boolean hasWon(){
        /*We first check the diagonals*/
        /*Building a non scalable solution first. we know TTT is 3x3*/
        boolean diagCheck = diagCheck();
        if(diagCheck){
            System.out.println("Diagonal match found! Somebody won.");
            System.out.println("This guy did:"+this.board[1][1]);
            return true;
        }
        /*Checking the rows and columns */
        int i;
        for(i=0;i<3;i++){
            boolean result = scanRow(i);
            if(result){
                    System.out.println("Somebody won!");
                    System.out.println("It's Row Match : "+this.board[i][0]);
                    return true;
            }
            result = scanCol(i);
            if(result){
                System.out.println("Somebody won!");
                System.out.println("It's Column Match : "+this.board[0][i]);
                return true;
            }
        }
        System.out.println("No one's game. Yet.");
        return false;
    }

    public boolean makeMoveandCheck(int row,int col,char symb){

        if(row > 2 || row < 0 ){
            System.out.println("Invalid Row Parameters!");
            return false;
        }
        if(col <0 || col > 2){
            System.out.println("Invalid Column parameters!");
            return false;
        }
        if(symb == 'X' || symb == 'O'){
            System.out.println("Putting in "+symb);
        }
        else
            return false;

        
        this.board[row][col] = symb;
        return this.hasWon();
    }

    public static void main(String args[]){
        System.out.println("Welcome to Triple-T");
        TicTac b1 = new TicTac();
        System.out.println("This is v1, so you'll be X and you'll play first.");
        ArrayList<Integer> availablePositions = new ArrayList<Integer>();
        int i;
        for(i=0;i<9;i++)
            availablePositions.add(i);




        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Enter your number [0-8]");
            int number = input.nextInt();
            int rem_index = availablePositions.indexOf(number);
            availablePositions.remove(rem_index);
            int row = number/3;
            int col = number%3;

            boolean result = b1.makeMoveandCheck(row,col,'X');
            if(result)
                break;

            System.out.println("Now its my turn!");


            Random r = new Random(System.currentTimeMillis());
            int random_seed = r.nextInt(availablePositions.size());
            int random_number = availablePositions.get(random_seed);

            System.out.println("I have picked :"+random_number);
            rem_index = availablePositions.indexOf(random_number);
            availablePositions.remove(rem_index);


            int c_row = random_number/3;
            int c_col = random_number%3;

            boolean result2 = b1.makeMoveandCheck(c_row,c_col,'O');
            if(result2){
                System.out.println("I have won!! Goodluck next time. :D");
                break;
            }
        }
        System.out.println("Game over!");

    }

}
