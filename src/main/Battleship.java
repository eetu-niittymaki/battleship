package src.main;

interface Variables {
    public static final String ship = "S";      // Symbol for the ship.
    public static final String shipEnemy = "E"; // Symbol for the ship.
    public static final String hit = "X";       // Symbol for hits.
    public static final String hitEnemy = "*";  // Symbol for enemys hits.
    public static final String miss = "M";      // Symbol for misses.
    public static final String missEnemy = "O"; // Symbol for enemys misses.
    public static final String sea = "~";       // Symbol for empty sea tiles.
    public static final int boardSize = 10;     // Size of the game board
    public static final int shipSize[] = {5, 4, 3, 3, 2}; // Size of the ships.

     /**
     *  Saves the player's map in a grid.
     *  @param gridPlayer Array that holds info about the player's map.
     */
    public String[][] gridPlayer = new String[boardSize][boardSize];

    /**
     * Saves the computers's map in a grid.
     * @param gridEnemy Array that holds info about the computers's map.
     */
    public String[][] gridEnemy = new String[boardSize][boardSize];

    public String[][] misses = new String[boardSize][boardSize];  // Maps misses.
}

/**
 * A simple battleship game.
 * @author Eetu Niittymäki eetu945@gmail.com
 */
class Battleship implements Variables {
    public int enemyPoints = 17;  // Enemys remaining hitpoints.
    public int playerPoints = 17; // Players remaining hitpoints.
    MsgMap msgMap = new MsgMap();

    // Adds players ships to the map.
    public void addPlayerShips() {
        Placement placement = new Placement();

        int x, y;
        String direction;
        
        for (int i : shipSize) {
            x = PlacementXY.placementX(i);
            y = PlacementXY.placementY(i);
            direction = Direction.playerDirection();
            
            while (true) {
                if (direction.equalsIgnoreCase("up") || 
                    direction.equalsIgnoreCase("down") ||
                    direction.equalsIgnoreCase("right") || 
                    direction.equalsIgnoreCase("left")) {
                    break;    
                } else {
                    direction = Direction.playerDirection();
                }
            }
            
            String possible; 
            
            while (true) {
                possible = checkIfPossiblePlayer(direction, i, x, y);
                
                if (possible.equals("true")) {
                    placement.placementPlayer(direction, i, x, y);
                    break;
                } else if (possible.equals("false")){
                    x = PlacementXY.placementX(i);
                    y = PlacementXY.placementY(i);
                    direction = Direction.playerDirection();
                }
            }
        }
    }
    
    /**
     * Checks if there is space for players ship at desired location.
     *
     * @param direction Direction given by player
     * @param size Size of the ship.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @return Returns if possible.
     */
    public String checkIfPossiblePlayer(String direction, int size,
                                           int x, int y) {
        String grid;
        String possible = "true";
        
        if (direction.equalsIgnoreCase("up") && y - size + 1 >= 0) {
            for (int a = 0; a < size; a++) {
                grid = gridPlayer[y - a][x];
                
                if (grid.equals(sea)) {
                    possible = "true";
                } else if (grid.equals(ship)) {
                    System.out.println(msgMap.getData("ship-exists"));
                    possible = "false";
                    break;
                }
            }
        } else if (direction.equalsIgnoreCase("down") && y + size - 1 <= 9) {
            for (int b = 0; b < size; b++) {
                grid = gridPlayer[y + b][x];
                
                if (grid.equals(sea)) {
                    possible = "true";
                } else if (grid.equals(ship)) {
                    System.out.println(msgMap.getData("ship-exists"));
                    possible = "false";
                    break;
                }
            }
        } else if (direction.equalsIgnoreCase("left") && x - size + 1 >= 0) {
            for (int c = 0; c < size; c++) {
                grid = gridPlayer[y][x - c];
                
                if (grid.equals(sea)) {
                    possible = "true";
                } else if (grid.equals(ship)) {
                    System.out.println(msgMap.getData("ship-exists"));
                    possible = "false";
                    break;
                }
            }
        } else if (direction.equalsIgnoreCase("right") && x + size - 1 <= 9) {
            for (int d = 0; d < size; d++) {
                grid = gridPlayer[y][x + d];
                
                if (grid.equals(sea)) {
                    possible = "true";
                } else if (grid.equals(ship)) {
                    System.out.println(msgMap.getData("ship-exists"));
                    possible = "false";
                    break;
                }
            }    
        } else {
            System.out.println(msgMap.getData("outside-grid"));
                possible = "false";
        }
        
        return possible;
    }
   
    //Begins the game and varies player and computer turns.
    public void startGame() {
        Turns turns = new Turns();
        
        while (enemyPoints > 0 && playerPoints > 0) {
            turns.turnPlayer();
            turns.turnEnemy();
        }
    }

    /**
     * Confirms that player given number is feasible.
     *
     * @param number Number to be checked.
     * @return Returns number.
     */
    public static int confirmNumber(int number) {
        while (number < 0 || number > 9) {
            number = Integer.parseInt("INSERT A NUMBER BETWEEN 0 AND 9");
        }
        return number;
    }

    // Ends the game when computer or players points reach zero.
    public void endGame() {
        if (enemyPoints == 0) {
            System.out.println("YOU WON!");
        } else if (playerPoints == 0) {
            System.out.println("YOU LOSE!");
        }
    }
   
    public static void main(String[] args) {
        Battleship bs = new Battleship();
        Misses misses = new Misses();
        Enemy enemy = new Enemy ();
        MsgMap msgMap = new MsgMap();
        
        PlayerMap.initializeGrid();
        misses.mapMisses();
        PlayerMap.makePlayerMap();
        enemy.enemyMap();
        enemy.addEnemyShips();
        
        System.out.println(msgMap.getData("start"));
        System.out.println(msgMap.getData("ship-touch"));

        bs.addPlayerShips();

        System.out.println(msgMap.getData("game-start"));
        System.out.println(hit + " = YOU HIT");
        System.out.println(miss + " = YOU MISS");
        System.out.println(hitEnemy + " = ENEMY HIT");
        System.out.println(missEnemy + " = ENEMY MISS");

        bs.startGame();
        bs.endGame();
    }
}
