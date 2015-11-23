import java.util.*;
import java.awt.*;
import gpdraw.*;
public class Piece{
    int pieceNum;
    
    char side1, side2, side3, side4;
    
    char[][] variant1, variant2, variant3, variant4;
    
    ArrayList<char[][]> variants = new ArrayList<char[][]>();
    /*This is the constructor. Top, right, bottom, left, all represent
     * the connector pieces. In order to keep things organized, the
     * uppercase character means the outie, lowercase character means
     * the innie.
     */
    public Piece(char top, char right, char bottom, char left, int pieceNumber){
        pieceNum = pieceNumber;
        
        side1 = top;
        side2 = right;
        side3 = bottom;
        side4 = left;
        
        variant1 = new char[][]{{'-',side1,'-'}, 
                                {side4,'-',side2}, 
                                {'-',side3,'-'}
                                                };
        variant2 = new char[][]{{'-',side4,'-'}, 
                                {side3,'-',side1}, 
                                {'-',side2,'-'}
                                                };
        variant3 = new char[][]{{'-',side3,'-'}, 
                                {side2,'-',side4}, 
                                {'-',side1,'-'}
                                                };
        variant4 = new char[][]{{'-',side2,'-'}, 
                                {side1,'-',side3}, 
                                {'-',side4,'-'}
                                                };
        variants.add(variant1);
        variants.add(variant2);
        variants.add(variant3);
        variants.add(variant4);
    }
    public int getNumber(){
        return pieceNum;
    }
    public void drawPiece(int variant, DrawingTool pen, SketchPad paper, double xPos, double yPos){
        //xPos and yPos are the centers of the square
        char[][] thePiece = getVariant(variant);
        pen.up();
        pen.move(xPos,yPos);
        pen.down();
        pen.drawRect(100,100);
        pen.up();
        pen.setDirection(90);//top
        pen.forward(50);
        pen.down();
        drawConnector(thePiece[0][1], pen, paper);
        pen.up();
        pen.move(xPos, yPos);
        pen.setDirection(0);//right
        pen.forward(50);
        pen.down();
        drawConnector(thePiece[1][2], pen, paper);
        pen.up();
        pen.move(xPos, yPos);
        pen.setDirection(270);//bottom
        pen.forward(50);
        pen.down();
        drawConnector(thePiece[2][1], pen, paper);
        pen.up();
        pen.move(xPos, yPos);
        pen.setDirection(180);//left
        pen.forward(50);
        pen.down();
        drawConnector(thePiece[1][0], pen, paper);
        
    }
    
    public void drawConnector(char type, DrawingTool pen, SketchPad paper){
        //pen should be at the center of the side its drawing on
        if(type == 'A'){
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(26);
            pen.turnRight(135);
            pen.forward(18.5);
            pen.turnLeft(90);
            pen.forward(13);
            pen.turnRight(90);
            pen.forward(20);
            pen.turnRight(90);
            pen.forward(13);
            pen.turnLeft(90);
            pen.forward(18.5);
            pen.turnRight(135);
            pen.forward(26);
            pen.turnRight(45);
            pen.setColor(Color.white);
            pen.forward(20);
            pen.setColor(Color.black);
        }
        else if(type == 'a'){
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnLeft(45);
            pen.forward(26);
            pen.turnLeft(135);
            pen.forward(18.5);
            pen.turnRight(90);
            pen.forward(13);
            pen.turnLeft(90);
            pen.forward(20);
            pen.turnLeft(90);
            pen.forward(13);
            pen.turnRight(90);
            pen.forward(18.5);
            pen.turnLeft(135);
            pen.forward(26);
            pen.turnLeft(45);
            pen.setColor(Color.white);
            pen.forward(20);
            pen.setColor(Color.black);
        }
        else if(type == 'B'){
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(15);
            pen.turnRight(135);
            pen.forward(25*Math.sqrt(2));
            pen.turnRight(90);
            pen.forward(25*Math.sqrt(2));
            pen.turnRight(135);
            pen.forward(15);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.setColor(Color.white);
            pen.forward(20);
            pen.setColor(Color.black);
        }
        else if(type == 'b'){
            pen.turnRight(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(15);
            pen.turnRight(135);
            pen.forward(25*Math.sqrt(2));
            pen.turnRight(90);
            pen.forward(25*Math.sqrt(2));
            pen.turnRight(135);
            pen.forward(15);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.setColor(Color.white);
            pen.forward(20);
            pen.setColor(Color.black);
        }
        else if(type == 'C'){
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(20);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.setColor(Color.white);
            pen.forward(20);
            pen.setColor(Color.black);
        }
        else if(type == 'c'){
            pen.turnRight(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(20);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.forward(10);
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(90);
            pen.setColor(Color.white);
            pen.forward(20);
            pen.setColor(Color.black);
        }
        else if(type == 'D'){
            pen.turnLeft(90);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(20);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.setColor(Color.white);
            pen.forward(20);
            pen.setColor(Color.black);
        }
        else if(type == 'd'){
            pen.turnRight(90);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(20);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.forward(10);
            pen.turnRight(45);
            pen.setColor(Color.white);
            pen.forward(20);
            pen.setColor(Color.black);
        }
    }
    
    
    public char[][] getVariant(int variant){
        if(variant == 1){ 
            return variant1;
        }
        else if(variant == 2){
            return variant2;
        }
        else if(variant == 3){
            return variant3;
        }
        else if(variant == 4){
            return variant4;
        }
        else{
            System.out.println("you tried to grab a variant that does not exist");
            return null;
        }
    }
}