/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze;

import java.util.Scanner;


/**
 *
 * @author Adelard
 */
public class Maze {
    
    Scanner scan = new Scanner(System.in);
    String maze[][] = new String[10][10];
    IStack<String> undo = new StackArray<String>();
    IStack<String> redo = new StackArray<String>();
    int cx = 0;
    int cy = 0;
    
    
    
    public static void main(String[] args) {
	Maze tester = new Maze();
        
        tester.control();
   
	}
    
        public void control(){
            generateMaze();
            
            boolean exit = false;
            while(!exit){

                System.out.println(undo.toString());
                System.out.println(redo.toString());
                printMaze();
                
                String n = scan.nextLine();
                
                if(test(n.toUpperCase()) == true)
                    exit = true;
           
            }
        }
    
	/*Contains all the functions for movment, maze generation and print, undo and redo.
        While loop ensures continued use until the user wishes to exit*/
    
	public boolean test(String n){
            

                switch (n) {
                    case "n":
                        goNorth();
                        break;
                    case "north":
                        goNorth();
                        break;
                    case "N":
                        goNorth();
                        undo.push("S");
                        while (!redo.isEmpty()){
                            redo.pop();
                        }
                        break;
                    case "NORTH":
                        goNorth();
                        undo.push("S");
                        while (!redo.isEmpty()){
                            redo.pop();
                        }
                        break;
                    case "s":
                        goSouth();
                        break;
                    case "south":
                        goNorth();
                        break;
                    case "S":
                        goSouth();
                        undo.push("N");
                        while (!redo.isEmpty()){
                            redo.pop();
                        }
                        break;
                    case "SOUTH":
                        goSouth();
                        undo.push("N");
                        while (!redo.isEmpty()){
                            redo.pop();
                        }
                        break;
                    case "e":
                        goEast();
                        break;
                    case "east":
                        goNorth();
                        break;
                    case "E":
                        goEast();
                        undo.push("W");
                        while (!redo.isEmpty()){
                            redo.pop();
                        }
                        break;
                    case "EAST":
                        goEast();
                        undo.push("W");
                        while (!redo.isEmpty()){
                            redo.pop();
                        }
                        break;
                    case "w":
                        goWest();
                        break;
                    case "west":
                        goNorth();
                        break;
                    case "W":
                        goWest();
                        undo.push("E");
                        while (!redo.isEmpty()){
                            redo.pop();
                        }
                        break;
                    case "WEST":
                        goWest();
                        undo.push("E");
                        while (!redo.isEmpty()){
                            redo.pop();
                        }
                        break;
                    case "GROG":
                        drink();
                        break;
                    case "sick":
                        upChuck();
                        break;
                    case "UNDO":
                        Undo();
                        break;
                    case "REDO":
                        Redo();
                        break;
                    case "EXIT":
                        return true;
                    default:
                        System.out.println("Please try a differnt input. That one didn't seem to work.");
                        break;
                
                
            }
                return false;
            
        }
        
        /*Generates the maze with all "-" in place, and places "*" at the top left corner*/
        public void generateMaze(){
            for (int i = 0; i < 10; i++){
                for (int j = 0; j < 10; j++){
                    maze[i][j] = "-";
                }
            }
            maze[0][0] = "*";	
        }

        /*Prints the maze with all "-" in place, and shows where the "*" is*/
        public void printMaze(){
            for (int k = 0; k < 10; k++){
                for (int l = 0; l < 10; l++){
                    System.out.print(maze[k][l] + " ");
                }
                    System.out.println();
            }
            System.out.println();
            System.out.println("What have you mage?");
            System.out.println("N: North");
            System.out.println("S: South");
            System.out.println("E: East");
            System.out.println("W: West");
            System.out.println("Grog");
            System.out.println("Undo");
            System.out.println("Redo");
            System.out.println("Exit");
        }
        public void goNorth(){
            
            cx = cx - 1;
            
            if (cx < 0){
                System.out.println("Ouch!");
                cx = cx + 1;
            }
            else{
                maze[cx + 1][cy] = "-";
                maze[cx][cy] = "*";
            }          
        }
        public void goSouth(){
            cx = cx + 1;
            
            if (cx > 9){
                System.out.println("Ouch!");
                cx = cx - 1;
            }
            else{
                maze[cx - 1][cy] = "-";
                maze[cx][cy] = "*";
            }          
        }
        public void goEast(){
            cy = cy + 1;
            
            if (cy > 9){
                System.out.println("Ouch!");
                cy = cy - 1;
            }
            else{
                maze[cx][cy - 1] = "-";
                maze[cx][cy] = "*";
            }          
        }
        public void goWest(){
            cy = cy - 1;
            
            if (cy < 0){
                System.out.println("Ouch!");
                cy = cy + 1;
            }
            else{
                maze[cx][cy + 1] = "-";
                maze[cx][cy] = "*";
            }          
        }
        public void drink(){
            System.out.println("Gulp!");
            undo.push("sick");
            while (!redo.isEmpty()){
                redo.pop();
            }
        }
        public void upChuck(){
            System.out.println("Bluh!");
        }
        public void Undo(){
            
            String p = undo.pop();
            test(p.toLowerCase());
            if (p.equals("N"))
                redo.push("S");
            else if (p.equals("S"))
                redo.push("N");
            else if (p.equals("E"))
                redo.push("W");
            else if (p.equals("W"))
                redo.push("E");
            
        }
        public void Redo(){
            String p = redo.pop();
            if (p.equals("N")){
                test("north");
                undo.push("S");
            }
            else if (p.equals("S")){
                test("south");
                undo.push("N");
            }
            else if (p.equals("E")){
                test("east");
                undo.push("W");
            }
            else if (p.equals("W")){
                test("west");
                undo.push("E");
            }
        }
}
