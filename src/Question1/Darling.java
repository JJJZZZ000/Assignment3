package Question1;

import java.util.Scanner;

public class Darling {
    private final int n; // the length of the room
    private boolean pen = false; // when pen is pulled down, the variable is true, otherwise is false
    private int dirc_idx = 0; // record the index of direction in the array below, showing the current facing of the dog
    private final String[] all_dirc = {"right", "down", "left", "up"}; // all_dirc[i] points out the current direction, if turn right, i++, if turn left, i--;
    private int x = 0; // record the horizontal coordinate
    private int y = 0; // record the vertical coordinate
    private final int[][] board; // represent the room


    // constructor, default length of each side is 20
    public Darling(){
        this.n = 20;
        board = new int[n][n];
        // create a input stream
        Scanner scan = new Scanner (System.in);

        // extract the command line by line
        while(scan.hasNext()){
            String line = scan.nextLine().trim();
            if(line.equals("9")) break; // stop reading
            else command(line); // use command method to deal with the command
        }
        scan.close();
    }

    // overload version, initialize the length of each side is n
    public Darling(int n){
        this.n = n;
        board = new int[n][n];
        Scanner scan = new Scanner (System.in);

        while(scan.hasNext()){
            String line = scan.nextLine().trim();
            if(line.equals("9")) break;
            else command(line);
        }
    }

    // identify and process the command
    private void command(String c){
        if(c == null) return;
        // to deal with the command line have more than one parameter, split it by comma
        String[] array_c = c.split(",");
        String cmd = array_c[0];
        String para = "";
        if(array_c.length > 1) para = array_c[1];

        // executed the command, different value of cmd have different action
        switch (cmd) {
            // put up pen
            case "1" -> pen = false;
            // put down pen
            case "2" -> {
                pen = true;
                board[x][y] = 1;
            }
            // change direction
            case "3", "4" -> change_direction(cmd);
            // move
            case "5" -> move(Integer.parseInt(para));
            // display
            case "6" -> display();
            default -> System.out.println("wrong command");
        }
    }

    private void change_direction(String cmd){
        // if cmd is "3", turn right, the next direction will be the right index in the global array all_dirc;
        if(cmd.equals("3")){
            dirc_idx++;
            // if the index come to the right bound, reset it to 0;
            if(dirc_idx > 3) dirc_idx = 0;
        }
        // if cmd is "4", turn left, the next direction will be the left index in the global array all_dirc;
        else if(cmd.equals("4")){
            dirc_idx--;
            // if the index come to the left bound, reset it to 3;
            if(dirc_idx < 0) dirc_idx = 3;
        }
        else System.out.println("wrong command");
    }

    private void display(){
        System.out.println();
        // create a new board with boundary
        String[][] show = new String[n+2][n+2];

        // set the boundary to be "---" in horizon or "|" in vertical
        for(int i = 0; i < n+2; i++){
            show[i][0] = "|";
            show[i][n+1] = "|";
        }
        for(int j = 0; j < n+2; j++){
            show[0][j] = "———";
            show[n+1][j] = "———";
        }

        // fill the inside of the new board with information of global variable board
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                // if the point was written by pen, the point will be "*"
                if(board[i-1][j-1] == 1) show[i][j] = " * ";
                // otherwise the point is blank
                else show[i][j] = "   ";
            }
        }

        // print the final version of board
        for(int i = 0; i < n+2; i++){
            for(int j = 0; j < n+2; j++){
                System.out.print(show[i][j]);
            }
            System.out.println();
        }
    }


    private void move(int step){
        // identify the current direction
        String direction = all_dirc[dirc_idx];
        // move forward toward different direction
        switch (direction) {
            case "up" -> {
                // make sure that the dog will always be within the boundary
                int x_end = Math.max(0, x - step);
                for (int i = x; i >= x_end; i--) {
                    if (pen) board[i][y] = 1;
                }
                // up date the new coordinate of the dog
                x = x_end;
            }
            // do the similar thing to other 3 directions.
            case "down" -> {
                int x_end = Math.min(x + step, n - 1);
                for (int i = x; i <= x_end; i++) {
                    if (pen) board[i][y] = 1;
                }
                x = x_end;
            }
            case "left" -> {
                int y_end = Math.max(0, y - step);
                for (int j = y; j >= y_end; j--) {
                    if (pen) board[x][j] = 1;
                }
                y = y_end;
            }
            case "right" -> {
                int y_end = Math.min(y + step, n - 1);
                for (int j = y; j <= y_end; j++) {
                    if (pen) board[x][j] = 1;
                }
                y = y_end;
            }
        }
    }
}
