package src.main;

/**
* Implements player and enemy turns.
*/
public class Turns {
    Misses misses = new Misses();
    int x, y;

    // Combines coordinates given by player.
    public void turnPlayer() {
        //PlayerMap.makePlayerMap();
        x = Location.locX();
        y = Location.locY();
        misses.hitOrMiss(x, y);
    }

    // Calculates where computer will hit.
    public void turnEnemy() {
        x = (int)(9 * Math.random());
        y = (int)(9 * Math.random());
        misses.hitOrMissEnemy(x, y);
        PlayerMap.makePlayerMap();
    }
}
