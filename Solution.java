/* PSEUDOCODE
 * 
 * solve method is recursive:
 * try each piece at position 1, run through all 4 variations of piece 1 before moving on to piece 2.
 * once matched, remove the "fitted" piece from arraylist, put the piece number into a solution int[][],
 * first row, and then put the variant number into the second number.
 * place the piece into the current board being run.
 * current board passed through recursion levels.
 * int[][] solution is passed through the recursion levels.
 * method called at next position, pass in the current arraylist of pieces, current int[][] 
 * solution and current board.
 * 
 * inside the solve method, a for-loop runs through every possible remaining piece at the specified
 * position, calling the next step only when the piece fits. Therefore, if the next step(s) fail, the
 * for loop will continue, running every permutation of possible solutions.
 * 
 * solve method arguments: int position, ArrayList<Piece> availablePieces, int[][] solution, 
 * char[][] currentBoard.
 * 
 * if the position is 16, and the method finds a piece that fits, print the solution from the
 * solution int[][].
 * also, local variable in the solve method will keep track of the piece variant. it will be a for-loop
 * inside a for-loop. Outside for-loop loops through each item of availablePieces, inside for-loop loops
 * through each variant at each item.
 * 
 * Attributes:
 * int[][] board
 * ArrayList<Piece> masterList
 * 
 * in constructor, initialize each piece as an object and pass into the masterList
 * 
 * 
 */


/*Things to remember:
 * board without stuff will have a '*'
 * unconnected pieces will be A/a, B/b, C/c, D/d
 * uppercase letters are for the outward parts, lowercase for inward
 */

import java.util.*;
import gpdraw.*;
import java.awt.*;
public class Solution{
    
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    ArrayList<Piece> globalPieces = new ArrayList<Piece>();
    int solutionNum = 0;
    
    
    public static void main(String[] args){
        Solution yay = new Solution();
        /*
        Piece temp = new Piece('D', 'D', 'D', 'D', 1);
        SketchPad paper = new SketchPad(800,800);
        DrawingTool pen = new DrawingTool(paper);
        temp.drawPiece(1, pen, paper,0,0);
        */
        //int[][] debug = { {1,16,10,2,7,13,5,9,11,6,8,4,15,12,14,3 }, 
        //                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 } };
        //yay.printBoard(debug,1);
        
        //yay.printBoard(fake);
    }
    
    public Solution(){
        
        //intialize each piece
        
        pieces.add(new Piece('A', 'd', 'c', 'D', 1));
        pieces.add(new Piece('c', 'a', 'D', 'A', 2));
        pieces.add(new Piece('b', 'a', 'A', 'C', 3));
        pieces.add(new Piece('d', 'A', 'B', 'b', 4));
        pieces.add(new Piece('b', 'd', 'C', 'B', 5));
        pieces.add(new Piece('d', 'D', 'C', 'a', 6));
        pieces.add(new Piece('C', 'c', 'd', 'D', 7));
        pieces.add(new Piece('c', 'B', 'D', 'd', 8));
        pieces.add(new Piece('d', 'b', 'D', 'D', 9));
        pieces.add(new Piece('d', 'a', 'B', 'B', 10));
        pieces.add(new Piece('D', 'A', 'a', 'b', 11));
        pieces.add(new Piece('c', 'a', 'C', 'B', 12));
        pieces.add(new Piece('b', 'b', 'D', 'C', 13));
        pieces.add(new Piece('d', 'c', 'A', 'A', 14));
        pieces.add(new Piece('A', 'b', 'c', 'A', 15));
        pieces.add(new Piece('d', 'b', 'B', 'D', 16));
        
        globalPieces.add(new Piece('A', 'd', 'c', 'D', 1));
        globalPieces.add(new Piece('c', 'a', 'D', 'A', 2));
        globalPieces.add(new Piece('b', 'a', 'A', 'C', 3));
        globalPieces.add(new Piece('d', 'A', 'B', 'b', 4));
        globalPieces.add(new Piece('b', 'd', 'C', 'B', 5));
        globalPieces.add(new Piece('d', 'D', 'C', 'a', 6));
        globalPieces.add(new Piece('C', 'c', 'd', 'D', 7));
        globalPieces.add(new Piece('c', 'B', 'D', 'd', 8));
        globalPieces.add(new Piece('d', 'b', 'D', 'D', 9));
        globalPieces.add(new Piece('d', 'a', 'B', 'B', 10));
        globalPieces.add(new Piece('D', 'A', 'a', 'b', 11));
        globalPieces.add(new Piece('c', 'a', 'C', 'B', 12));
        globalPieces.add(new Piece('b', 'b', 'D', 'C', 13));
        globalPieces.add(new Piece('d', 'c', 'A', 'A', 14));
        globalPieces.add(new Piece('A', 'b', 'c', 'A', 15));
        globalPieces.add(new Piece('d', 'b', 'B', 'D', 16));
        
        int[][] fake = new int[2][16];
        char[][] bleh = new char[9][9];
        for(int r = 0; r<9; r++){
            for(int c = 0; c<9; c++){
                bleh[r][c] = '*';
            }
        }
        
        //let the magic begin
        solve(bleh,1,pieces,fake);
    }
    
    //recursive method
    public void solve(char[][] board, int position, ArrayList<Piece> availablePieces, int[][] solution){
        
        char[][] boardCopy = new char[9][9];
        for(int r = 0; r<9; r++){
            for(int c = 0; c<9; c++){
                boardCopy[r][c] = board[r][c];
            }
        }
        
        for(int pieceNum = 0; pieceNum<availablePieces.size(); pieceNum++){
            Piece currentPiece = pieces.get(pieceNum);
            for(int variantNum = 1; variantNum<5; variantNum++){
                char[][] currentVariant = currentPiece.getVariant(variantNum);
                
                //dbugging
                /*
                System.out.println("Position: " + position + " outer for loop: " + pieceNum +
                                    " piece number: " + currentPiece.getNumber() + 
                                    " variant number: " +  variantNum);
                printArray(board);
                printArray(currentVariant);
                */
                
                if(fits(currentVariant, position, board)){
                    if(position == 16){//last piece has been fitted, print solution!
                        boardCopy = fitPiece(currentVariant,position,board);
                        solution[0][position-1] = currentPiece.getNumber();
                        solution[1][position-1] = variantNum;
                        solutionNum++;
                        printBoard(solution,solutionNum);
                        //System.out.println("Solution number " + solutionNum);
                        //System.out.println(Arrays.deepToString(solution));
                    }
                    else{
                        boardCopy = fitPiece(currentVariant,position,board);
                        solution[0][position-1] = currentPiece.getNumber();
                        solution[1][position-1] = variantNum;
                        /*
                        System.out.println(Arrays.deepToString(solution));
                        printArray(boardCopy);
                        */
                        availablePieces.remove(pieceNum);
                        solve(boardCopy, position+1, availablePieces, solution);
                        availablePieces.add(pieceNum, currentPiece);
                    }
                    
                }
                else{
                    //does not fit here :(
                }
                
            }
            
        }
    }
    
    
    public boolean fits(char[][] piece, int pos, char[][] inputBoard){
        //center row/col of the piece:
        int row = ( (pos-1)/4 + 1 )*2 -1;
        int col = ( (pos-1)%4 + 1 )*2 -1;
        
        char[][] board = new char[9][9];
        for(int r = 0; r<9; r++){
            for(int c = 0; c<9; c++){
                board[r][c] = inputBoard[r][c];
            }
        }
        
        //check top right bot left
        if(Character.isLowerCase(piece[0][1]) && Character.isUpperCase(board[row-1][col])){ // top
            if(Character.toUpperCase(piece[0][1]) == board[row-1][col]){
                //fits!
            }
            else{
                return false;
            }
        }
        else if(Character.isUpperCase(piece[0][1]) && Character.isLowerCase(board[row-1][col])){
            if(Character.toLowerCase(piece[0][1]) == board[row-1][col]){
                //fits!
            }
            else{
                return false;
            }
        }
        else if(board[row-1][col] == '*'){
            //fits!
        }
        else{
            return false; //does NOT fit
        }
        
        if(Character.isLowerCase(piece[1][2]) && Character.isUpperCase(board[row][col+1])){ // right
            if(Character.toUpperCase(piece[1][2]) == board[row][col+1]){
                //fits!
            }
            else{
                return false;
            }
        }
        else if(Character.isUpperCase(piece[1][2]) && Character.isLowerCase(board[row][col+1])){
            if(Character.toLowerCase(piece[1][2]) == board[row][col+1]){
                //fits!
            }
            else{
                return false;
            }
        }
        else if(board[row][col+1] == '*'){
            //fits!
        }
        else{
            return false; //does NOT fit
        }
        
        if(Character.isLowerCase(piece[2][1]) && Character.isUpperCase(piece[2][1])){ // bottom
            if(Character.toUpperCase(piece[2][1]) == board[row+1][col]){
                //fits!
            }
            else{
                return false;
            }
        }
        else if(Character.isUpperCase(piece[2][1]) && Character.isLowerCase(board[row+1][col])){
            if(Character.toLowerCase(piece[2][1]) == board[row+1][col]){
                //fits!
            }
            else{
                return false;
            }
        }
        else if(board[row+1][col] == '*'){
            //fits!
        }
        else{
            return false; //does NOT fit
        }
        
        if(Character.isLowerCase(piece[1][0]) && Character.isUpperCase(board[row][col-1])){ // left
            if(Character.toUpperCase(piece[1][0]) == board[row][col-1]){
                //fits!
            }
            else{
                return false;
            }
        }
        else if(Character.isUpperCase(piece[1][0]) && Character.isLowerCase(board[row][col-1])){
            if(Character.toLowerCase(piece[1][0]) == board[row][col-1]){
                //fits!
            }
            else{
                return false;
            }
        }
        else if(board[row][col-1] == '*'){
            //fits!
        }
        else{
            return false; //does NOT fit
        }
        
        
        return true;
    }
    
    public char[][] fitPiece(char[][] piece, int pos, char[][] inputBoard){
        //center row/col of the piece:
        int row = ( (pos-1)/4 + 1 )*2 -1;
        int col = ( (pos-1)%4 + 1 )*2 -1;
        
        char[][] board = new char[9][9];
        for(int r = 0; r<9; r++){
            for(int c = 0; c<9; c++){
                board[r][c] = inputBoard[r][c];
            }
        }
        
        
        board[row-1][col] = piece[0][1];//top
        board[row][col+1] = piece[1][2];//right
        board[row+1][col] = piece[2][1];//bottom
        board[row][col-1] = piece[1][0];//left
        
        return board;
        
    }
    
    public void printBoard(int[][] solution, int solNum){
        SketchPad paper = new SketchPad(800,800,0);
        DrawingTool pen = new DrawingTool(paper);
        
        pen.setWidth(2);
        
        pen.up();
        pen.move(-50,250);
        pen.down();
        pen.drawString("Solution number: " + solNum);
        
        pen.up();
        pen.move(-150,150);
        pen.down();
        for(int i = 0; i<16; i++){
            
            int row = i/4;
            int col = i%4;
            double midX = pen.getXPos();
            double midY = pen.getYPos();
            
            Piece pizza = globalPieces.get(solution[0][i]-1);
            pen.up();
            pen.move(midX - 5, midY - 5);
            pen.down();
            pen.drawString(pizza.getNumber() + "");
            pen.up();
            pen.move(midX, midY);
            pen.down();
            pizza.drawPiece(solution[1][i], pen, paper, midX, midY);
            
            
            if(col == 3){
                pen.up();
                pen.move(-150, midY-100);
                pen.down();
                
            }
            else{
                pen.up();
                pen.move(midX+100, midY);
                pen.down();
            }
        }
    }
    
    public void printArray(char[][] array){
        for(int i = 0; i<array.length; i++){
            System.out.println(Arrays.toString(array[i]));
        }
    }
    
    
}