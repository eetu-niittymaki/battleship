package src.main;

import java.util.LinkedHashMap;

public class MsgMap {
    public LinkedHashMap<String, String> map;
    
        public MsgMap() {
            map = new LinkedHashMap<>();
    
            map.put("start", "Add your ships, they are: carrier (5), battleship (4), destroyer (3), submarine (3) and patrol boat (2).");
            map.put("ship-touch", "Ships can touch eachother.");
            map.put("game-start", "You and the enemy will now take turns trying to destroy eachother." + "\n" + "First one to sink all boats wins.");
            map.put("wrong-number", "WRONG INPUT, GIVE A NUMBER BETWEEN 0 AND 9: ");
            map.put("wrong-letter", "WRONG INPUT, ENTER A LETTER BETWEEN A AND J: ");
            map.put("ship-direction", "CHOOSE YOUR SHIP'S DIRECTION: UP, DOWN, LEFT OR RIGHT: ");
            map.put("ship-exists", "A SHIP IS ALREADY THERE.");
            map.put("outside-grid", "OUTSIDE OF THE GRID, TRY AGAIN.");
        }
    
        public void addData(String key, String value) {
            map.put(key, value);
        }
    
        public String getData(String key) {
            return map.get(key);
    }
}
