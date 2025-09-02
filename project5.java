import java.util.Scanner;
public class project5 {
    // tic toc game 
    public static void Main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] board= { "1","2","3","4","5","6","7","8","9" };
        String currentplayer="X";
        boolean gameend=false;
        while(!false){
            displayboard(board);
            System.out.println("enter number "+currentplayer+" between (1-9)");
            int move=sc.nextInt();

            // check the move is valid or not 
            if(move<1 || move>9){
                System.out.println("enter the valid number ");
            }
            if(board[move-1].equals("X") || board[move-1].equals("O")){
                System.out.println("This box is already filled ");
            }
            board[move-1]=currentplayer;
            // check win 
            if(checkwin(board, currentplayer)){
                displayboard(board);
                System.out.println("congo "+currentplayer+" WINS");
                gameend=true;
                break;
            }
            // check draw
            if(checkdraw(board)){
                displayboard(board);
                System.out.println("game is draw ");
                gameend=true;
                break;
            }
            // switch player
            if(currentplayer=="X"){
                currentplayer="O";
            }
            else{
                currentplayer="X";
            }
        }
}
// Display board
    public static void displayboard(String[] arr){
    int n=0;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            System.out.print(arr[n]+"    ");
            n++;
        }
        System.out.println();
        System.out.println("---+---+---");
    }
}
// check win 
    public static boolean checkwin(String b[],String player){
    // Rows
        if(b[0].equals(player) && b[1].equals(player) && b[2].equals(player)) return true;
        if(b[3].equals(player) && b[4].equals(player) && b[5].equals(player)) return true;
        if(b[6].equals(player) && b[7].equals(player) && b[8].equals(player)) return true;
    // Coloumns
        if(b[0].equals(player) && b[3].equals(player) && b[6].equals(player)) return true;
        if(b[1].equals(player) && b[4].equals(player) && b[7].equals(player)) return true;
        if(b[2].equals(player) && b[5].equals(player) && b[8].equals(player)) return true;  
    //Daigonals
        if(b[0].equals(player) && b[4].equals(player) && b[8].equals(player)) return true;
        if(b[2].equals(player) && b[4].equals(player) && b[6].equals(player)) return true;
        return false;
    }
    // check draw 
    public static boolean checkdraw(String b[]){
        for(String i:b){
            if(!b.equals("X") && !b.equals("O")){
                return false;
            }
        }
        return true;
    }

}