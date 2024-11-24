package src.main;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

/*
* Validates player give x and y coordinates.
*/
public class Location extends Battleship {
    static MsgMap msgMap = new MsgMap();
    /**
     * Stores X coordinate given by player.
     *
     * @return Returns X coordinate.
     */
    public static int locX() {
        Console console = System.console();
        int x;
        
        while (true) {
            try {
                String coordX = console.readLine("GIVE X COORDINATE: ");
                x = Integer.parseInt(coordX);
                confirmNumber(x);
                break;
            } catch (Exception error) {
                System.out.println(msgMap.getData("wrong-number"));
        }
    }
        return x;
    }
   
    /**
     * Stores Y coordinate given by player.
     *
     * @return Returns Y coorinate.
     */
    public static int locY() {
        Console console = System.console();
        
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

        String coordY = console.readLine("GIVE Y COORDINATE, "
                                        + "BETWEEN LETTERS A AND J: ").toLowerCase();
        Integer y = letterToInt.get(coordY);

        // If the input is not valid, ask again
        while (y == null) {
            String wrong = msgMap.getData("wrong-letter");
            coordY = console.readLine(wrong).toLowerCase();
            y = letterToInt.get(coordY);
        }
        return y;
    }    
}
