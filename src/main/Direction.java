package src.main;

import java.io.Console;

interface Directable {
    public String directions[] = {"up", "down", "left", "right"};
    Console console = System.console();
}

/**
* Validates player and enemy direction.
*/
public class Direction implements Directable {
    static MsgMap msgMap = new MsgMap();

    /**
     * Calculate's computers ships directions.
     *
     * @return Returns direction.
     */
    public static String enemyDirection() {
        int dir = (int)(3 * Math.random());
        String direction = directions[dir];
        return direction;
    }

    /**
     * Checks if enemy ship direction is ok.
     * 
     * @param direction Random direction.
     * @param size Size of the ship.
     * @param x X Coordinate.
     * @param y Y coordinate.
     * @return Returns true or false.
     */
    public static String checkEnemyDirection(String direction, int size,
                                        int x, int y) {
        String grid;
        String possible = "true";
                // Checks if up is a feasible direction
        if (direction.equalsIgnoreCase("up") && y - size + 1 >= 0) {
            for (int a = 0; a < size; a++) {
                grid = Battleship.gridEnemy[y - a][x];
                
                if (grid.equals(Battleship.sea)) {
                    possible = "true";
                } else if (grid.equals(Battleship.ship) || grid.equals(Battleship.shipEnemy)) {
                    possible = "false";
                    break;
                }
            }   // Checks if down is a feasible direction
        } else if (direction.equalsIgnoreCase("down") && y + size <= 8) {   
            for (int b = 0; b < size; b++) {
                grid = Battleship.gridEnemy[y + b][x];
                
                if (grid.equals(Battleship.sea)) {           
                    possible = "true";
                } else if (grid.equals(Battleship.ship) || grid.equals(Battleship.shipEnemy)) {
                    possible = "false";
                    break;
                }
            }   // Checks if left is a feasible direction
        } else if (direction.equalsIgnoreCase("left") && x - size 
                                              + 1 >= 0) {
            for (int c = 0; c < size; c++) {
                grid = Battleship.gridEnemy[y][x - c];
                
                if (grid.equals(Battleship.sea)) {
                    possible = "true";
                } else if (grid.equals(Battleship.ship) || grid.equals(Battleship.shipEnemy)) {
                    possible = "false";
                    break;
                }
            }   // Checks if right is a feasible direction
        } else if (direction.equalsIgnoreCase("right") && x + size <= 8) {  
            for (int d = 0; d < size; d++) {
                grid = Battleship.gridEnemy[y][x + d];
                
                if (grid.equals(Battleship.sea)) {
                    possible = "true";
                } else if (grid.equals(Battleship.ship) || grid.equals(Battleship.shipEnemy)) {
                    possible = "false";
                    break;
                }
            }    
        } else {
            possible = "false";
        }
        
        return possible;
    }

    /**
     * Asks the player for direction of the ship.
     *
     * @return Returns direction.
     */
    public static String playerDirection() {
        String direction = console.readLine(msgMap.getData("ship-direction"));
        return direction;
    }

    /**
     * Checks if direction given in method playerDirection() is feasible.
     *
     * @param direction Gives direction given by player.
     * @return Returns direction.
     */
    public static String checkPlayerDirection(String direction) {
        while (true) {
            if (direction.equalsIgnoreCase("up") || 
                direction.equalsIgnoreCase("down") ||
                direction.equalsIgnoreCase("right") || 
                direction.equalsIgnoreCase("left")) {
                break;
             } else {
                System.out.println("WRONG INPUT.");
                direction = playerDirection();
            }
        }
        
        return direction;
    }
}
