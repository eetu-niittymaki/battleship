package src.main;

interface Enemyable {
    void enemyMap();
}

/**
* Makes enemys map and adds ships to it.
*/
public class Enemy extends Battleship implements Enemyable {
    Placement placement = new Placement();
    
    // Makes the enemy's map.
    public void enemyMap() {
        for (int i = 0; i < gridEnemy.length; i++) {
            for (int j = 0; j < gridEnemy.length; j++) {
                gridEnemy[i][j] = sea;
            }
        }
         
        System.out.println();
    }

    // Adds enemy ships to the map.
    public void addEnemyShips() {
        int x;
        int y;
        String direction;

        for (int i : shipSize) {            // Calculates enemy ship 
            x = (int)(9 * Math.random());   // location and direction.
            y = (int)(9 * Math.random());
            direction = Direction.enemyDirection();
            String possible;
        
            while (true) {     // Checks if enemy ship can fit coordinates.
                possible = Direction.checkEnemyDirection(direction, i, x, y);

                if (possible.equals("true")) {
                    placement.placementEnemy(direction, i, x, y);
                    break;
                } else if (possible.equals("false")) { // Creates new 
                    x = (int)(9 * Math.random());      // coordinates and dire-
                    y = (int)(9 * Math.random());      // tion if unable 
                    direction = Direction.enemyDirection();      // to fit.
                }
            }
        }   
    }
}
