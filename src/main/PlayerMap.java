package src.main;

/**
* Makes the player's map.
*/
public class PlayerMap extends Battleship {
    Battleship bs = new Battleship();
    public static void initializeGrid() {
        for (int i = 0; i < gridPlayer.length; i++) {
            for (int j = 0; j < gridPlayer[i].length; j++) {
                gridPlayer[i][j] = sea; // Default value
            }
        }
    }

    public static void makePlayerMap() {
        System.out.println();
    
        // Print the header
        System.out.println("---------------------------");
        System.out.println("        PLAYER MAP  ");
        System.out.println("---------------------------");
    
        // Print the top row (column headers)
        System.out.print("   ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    
        // Print the middle section of the map
        for (int x = 0; x < Battleship.gridPlayer.length; x++) {
            String letters = "ABCDEFGHIJ";
            char letterAt = letters.charAt(x);
            System.out.print(letterAt + "|");
    
            for (int y = 0; y < gridPlayer[x].length; y++) {
                // Prioritize displaying hits/misses
                String cell;
                if (!misses[x][y].equals(sea)) {
                    cell = misses[x][y]; // Show player's hits/misses on the enemy
                } else {
                    cell = gridPlayer[x][y]; // Show player's ships and enemy hits/misses
                }
    
                System.out.print(" " + cell);
            }
    
            System.out.println(" |" + letterAt);
        }
    
        // Print the bottom row (column headers again)
        System.out.print("   ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
