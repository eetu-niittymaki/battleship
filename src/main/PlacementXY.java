package src.main;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

/**
* Asks player for X coordinate and makes sure its usable.
* 
* @param shipSize Size of the ship.
* @return Returns x.
*/
public class PlacementXY extends Battleship {
    static MsgMap msgMap = new MsgMap();

    public static int placementX(int shipSize) {
        Console console = System.console();
        int x;
        
        while (true) {
            try {
                String msg = "GIVE X COORDINATE FOR SHIP WITH THE SIZE OF (" + shipSize + "), BETWEEN THE NUMBERS 0 AND 9: ";
                String coordX = console.readLine(msg);
                x = Integer.parseInt(coordX);
                confirmNumber(x);
                break;
            } catch (NumberFormatException e) {
                System.out.println("WRONG INPUT");
            }
        }
       
         return x;
    }

    /**
     * Asks player for y coordinate and makes sure its usable.
     * 
     * @param shipSize Size of the ship.
     * @return Returns y.
     */
    public static int placementY(int shipSize) {
        Console console = System.console();
        
        // Create a map to directly map letters to integers
        Map<String, Integer> letterToInt = new HashMap<>();
        letterToInt.put("a", 0);
        letterToInt.put("b", 1);
        letterToInt.put("c", 2);
        letterToInt.put("d", 3);
        letterToInt.put("e", 4);
        letterToInt.put("f", 5);
        letterToInt.put("g", 6);
        letterToInt.put("h", 7);
        letterToInt.put("i", 8);
        letterToInt.put("j", 9);
        
        // Read the Y-coordinate input as a letter from A to J
        String coordY = console.readLine("GIVE Y COORDINATE, BETWEEN LETTERS A AND J: ").toLowerCase();
        
        // Default value in case of invalid input
        Integer y = letterToInt.get(coordY);
        
        // If the input is not valid, ask again
        while (y == null) {
            String wrong = msgMap.getData("wrong-number");
            coordY = console.readLine(wrong).toLowerCase();
            y = letterToInt.get(coordY);
        }
        return y;
    }
}
