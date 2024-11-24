package src.main;

/**
 * Checks if player ship placement is ok.
 *
 * @param direction Direction chosen by player.
 * @param size Size of the ship.
 * @param x X coordinate.
 * @param y Y coordinate.
 */
class Placement extends Battleship {
    public void placementPlayer(String direction, int size, 
                                    int x, int y) {
        if (direction.equalsIgnoreCase("up")) {
            for (int a = 0; a < size; a++) {
                gridPlayer[y - a][x] = ship;
            }
        }
    
        if (direction.equalsIgnoreCase("down")) {
            for (int b = 0; b < size; b++) {
                gridPlayer[y + b][x] = ship;
            }
        }
    
        if (direction.equalsIgnoreCase("left")) {
            for (int c = 0; c < size; c++) {
                gridPlayer[y][x - c] = ship;
            }
        }

        if (direction.equalsIgnoreCase("right")) {
            for (int d = 0; d < size; d++) {
                gridPlayer[y][x + d] = ship;
            }
        }     
        PlayerMap.makePlayerMap();   
        }

    public void placementEnemy(String direction, int size, 
                                    int x, int y) {
        if (direction.equalsIgnoreCase("up")) {
            for (int a = 0; a < size; a++) {
                gridEnemy[y - a][x] = shipEnemy;
            }
        }
    
        if (direction.equalsIgnoreCase("down")) {
            for (int b = 0; b < size; b++) {
                gridEnemy[y + b][x] = shipEnemy;
            }
        }
    
        if (direction.equalsIgnoreCase("left")) {
            for (int c = 0; c < size; c++) {
                gridEnemy[y][x - c] = shipEnemy;
            }
        }

        if (direction.equalsIgnoreCase("right")) {
            for (int d = 0; d < size; d++) {
                gridEnemy[y][x + d] = shipEnemy;
            }
        }     
    }
}
