/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Nov11,2016
 *PA6-This is a program that play Tic Tac Toe with user. The Rule is simple, try 
 *best to prevent user from connecting more than two point in a row in the 3X3 grid.
 *bugs: None
 */
import java.util.*;
public class TicTacToe{
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        Random rand=new Random();
        do {
            System.out.println("decide who's the first move(c/u)");
            String first=console.next();
            int[][] matrix=new int[3][3];//matrix represents game plate,0 means empty space that to be filled, 1 means computer's piece,2 means user's piece
            boolean end=false
            if (fisrt.equals("c")) {
                int[] decision={-1,-1};
                do {
                    int[] move=strategy(matrix);//get best move
                    int row=move[0];//best move row
                    int col=move[1];//best move col
                    matrix[row][col]=1;//put computer piece in the position
                    System.out.printf("I choose to go in row %d column %d\n", row,col);
                    System.out.println("Please enter the where you choose to go(row/col)");
                    print(matrix);
                    int userRow=console.nextInt();
                    int userCol=console.nextInt();
                    matrix[userRow][userCol]=2;
                } while (!=end);
            }
            System.out.println("Would you like to play again.(y/n)")
            String again=console.next();
        } while (again.equals("y"));
    }
    public static int[] findEmpty(int[][] matrix){
        int countEmpty=0;
        int[] temp=new int[matrix.length*matrix.length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    countEmpty++;
                    int position=countEmpty-1;
                    temp[2*position]=i;
                    temp[2*position+1]=j;
                }
            }
        }
        int[] empty=new int[countEmpty*2];
        for (int k=0;k<countEmpty*2;k++){
            empty[k]=temp[k];
        }
        return empty;
    }
    //the basic strategy is to find out every possible move(empty space) and calculate the 
    //score after that move. The highest move score is to achieve 3 in a row，then block a 
    //potential 3 in row of opponents get second highest score 
    public static int[] strategy(int[][] original){
        int[] possibleMoves=findEmpty(original);
        int bestScore=0;
        int bestRow=-1;
        int bestCol=-1;
        for (int i=0;i<possibleMoves.length-1;i+=2){
            int row=possibleMoves[i];
            int col=possibleMoves[i+1];
            original[row][col]=1;
            int score=score(original,row,col);
            if (score>bestScore){//update the highest score and it's corresponding move
                bestScore=score
                bestRow=row;
                bestCol=col;
            }
            original[row][col]==0;//undo the possible move preparing for the next test
        }
        return new int[] {bestRow,bestCol};
    }
    //determine the next move score, calcualting the score after move, say 100,10,1 for 3,2,1-in 
    //a row for computer and on the contrary,-100,-10,-1 for 3,2,1-in-row for user's pieces.
    public static int score(int[][] original,int row, int col){
        int score=0;
        score+=evaluateLines(original,0,0,0,1,0,2);//calc score for first row
        score+=evaluateLines(original,1,0,1,1,1,2);//calc score for second row
        score+=evaluateLines(original,2,0,2,1,2,2);//calc score for third row
        score+=evaluateLines(original,0,0,1,0,2,0);//calc score for first column
        score+=evaluateLines(original,0,1,1,1,2,1);//calc score for second column
        score+=evaluateLines(original,0,2,1,2,2,2);//calc score for third column
        score+=evaluateLines(original,0,0,1,1,2,2);//calc score for diagnol
        score+=evaluateLines(original,0,2,1,1,2,0);//calc score for another diagnol
        original[row][col]==0;//undo the potential move
        return score;
    }
    //calculate score for each lines
    public static int evaluateLines(int[][] matrix,int row1,int col1,int row2,int col2,int row3,int col3){
        //for the first cell
        int score=0;
        if (matrix[row1][col1]==1){//computer piece counts 1 
            score=1;
        } else if(matrix[row1][col1]==2){//user's piece counts -1
            score=-1;
        }//else if cell one is still empty, score remains
        //for the second cell
        if (matrix[row2][col2]==1){//cell2 is computer piece
            if (score==1){//cell1 is computer's
                score=10;
            } else if (score==-1){//we already block this line, don't care about the third one
                return 0;
            } else {//cell1 is empty
                score=1;
            }
        } else if (matrix[row2][col2]==2){//cell2 is user's
            if (score==1){//user has already block this line
                return 0;
            } else if (score==-1){//cell1 is also user's
                score=-10;
            } else {//cell1 is empty
                score=-1;
            }
        }
        //for third cell
        if (matrix[row3][col3]==1){
            if(score>0){// cell1 and/or cell2 is computer's
                score*=10;//that's why I set scores as 100,10,1
            } else if(score<0){//cell1 and/or cell2 is user's and computer block the line immediately
                return 0;
            } else {//cell1 and cell2 are empty
                score=1;
            }
        }else if (matrix[row3][col3]==2){
            if(score<0){//cell1 and/or cell2 is user's
                score*=10;
            } else if (score>1){//cell1 and/or cell2 is computer's and user block it
                return 0;
            } else {//cell1 and cell2 are empty
                score=-1;
            }
        }
        return score;
    }
    public static void print(int[][] array){
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                if (array[i][j]==0){
                    System.out.print("_ ");
                } else if (array[i][j]==1){
                    System.out.print("X ");//X stand for computer
                } else {
                    System.out.print("O ");//O stands for user
                }
            }
            System.out.print("\n");
        }
    }
    public static boolean win(int[][] array, String player){
        if (player.equals("computer")){
            int stand=1;
        } else {
            stand=2;
        }
        //check for rows
        for (int i=0;i<3;i++){
            int count=0;
            for (int j=0;j<3;j++){
                if (array[i][j]==stand){
                    count++;
                }
            }
            if (count==3){
                return true;
            }
        }
        //check for column
        for (int i=0;i<3;i++){
            int count=0;
            for (int j=0;j<3;j++){
                if (array[j][i]==stand){
                    count++;
                }
            }
            if (count==3){
                return true;
            }
        }
        //check for diagnols
        if (array[0][0]==stand&&array[1][1]==stand&&array[2][2]==stand){
            return true;
        }
        if (array[0][2]==stand&&array[1][1]==stand&&array[2][0]==stand){
            return true;
        }
    }
}
