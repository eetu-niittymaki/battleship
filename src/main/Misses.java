package src.main;

/**
 * Handles player and enemy misses and hits.
 */
public class Misses extends Battleship {
    /**
     * Keeps track of the misses and hits and adds them to the board.
     */
    public void mapMisses() {
        for (int i = 0; i < misses.length; i++) {
            for (int j = 0; j < misses.length; j++) {
                misses[i][j] = sea;
            }
        }
        System.out.println();
    }
    /**
     * Checks if computer hits or misses.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     */
    public void hitOrMissEnemy(int x, int y) {
        String input;
        
        while (enemyPoints > 0 && playerPoints > 0) {
            input = gridPlayer[y][x];

            if (input.equals(sea)) {
                System.out.println("ENEMY MISSED.");
                gridPlayer[y][x] = missEnemy;
                break;
            } else if (input.equals(ship)) {
                System.out.println("ENEMY HIT YOU");
                gridPlayer[y][x] = hitEnemy;
                playerPoints--;
                break;
            } else if (input.equals(hit) || input.equals(miss) || input.equals(missEnemy)) {
                x = (int)(9 * Math.random());
                y = (int)(9 * Math.random());
            }
        }
    }
    
    /**
     * Checks if player hits or misses.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     */
    public void hitOrMiss(int x, int y) {
        String input;
        try {
            while ( enemyPoints > 0 && playerPoints > 0) {
                input = gridEnemy[y][x];

                if (gridPlayer[y][x].equals(ship)) {
                    System.out.println("THAT'S YOUR OWN SHIP!");
                    x = Location.locX();
                    y = Location.locY();
                } else if (input.equals(sea)) {
                    System.out.println("\n" + "YOU MISSED.");
                    gridEnemy[y][x] = miss;
                    misses[y][x] = miss;
                    break;
                } else if (input.equals(shipEnemy)) {
                    System.out.println("A HIT!");
                    gridEnemy[y][x] = hit;
                    misses[y][x] = hit;
                    enemyPoints--;
                    break;
                } else if (input.equals(hit) || input.equals(hitEnemy) || input.equals(miss)) {
                    System.out.println("PLACE ALREADY HIT, TRY AGAIN.");
                    x = Location.locX();
                    y = Location.locY();
                }
            }
        } catch (Exception error) {
            System.out.println(error);
        }
    }
}
