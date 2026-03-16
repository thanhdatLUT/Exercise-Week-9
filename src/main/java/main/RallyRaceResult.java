package main;
 
import java.util.HashMap;
 
/**
 * Concrete implementation of {@link RaceResult} for a standard WRC rally.
 *
 * <p>Converts finishing positions to championship points using the
 * official WRC points scale and stores the result for later retrieval.</p>
 *
 * <p><b>WRC Points Scale:</b></p>
 * <pre>
 *   1st = 25 pts | 2nd = 18 pts | 3rd = 15 pts | 4th = 12 pts
 *   5th = 10 pts | 6th =  8 pts | 7th =  6 pts | 8th =  4 pts
 *   9th =  2 pts | 10th = 1 pt  | other = 0 pts
 * </pre>
 *
 * <p><b>SOLID Principles:</b></p>
 * <ul>
 *   <li><b>Single Responsibility:</b> Responsible only for storing and
 *       converting race results — not for standings or statistics.</li>
 *   <li><b>Open/Closed:</b> Implements {@link RaceResult} without
 *       modifying the interface or any other class.</li>
 *   <li><b>Liskov Substitution:</b> Can replace any {@link RaceResult}
 *       reference transparently.</li>
 * </ul>
 *
 * @author  Doan Vu Thanh Dat
 * @version 1.0
 */
public class RallyRaceResult implements RaceResult {
 
    /** The name of this rally event. */
    private String raceName;
 
    /** Maps each driver to the championship points they earned. */
    private HashMap<Driver, Integer> results;
 
    /**
     * Constructs a new {@code RallyRaceResult} for the given event.
     *
     * @param raceName the full name of the rally event
     */
    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
        this.results = new HashMap<>();
    }
 
    /**
     * Records a driver's finishing position, converts it to WRC
     * championship points, updates the driver's total, and stores
     * the result internally.
     *
     * @param driver   the driver who finished in this position
     * @param position the finishing position (1 = first place)
     */
    @Override
    public void recordResult(Driver driver, int position) {
        int points;
        switch (position) {
            case 1:  points = 25; break;
            case 2:  points = 18; break;
            case 3:  points = 15; break;
            case 4:  points = 12; break;
            case 5:  points = 10; break;
            case 6:  points =  8; break;
            case 7:  points =  6; break;
            case 8:  points =  4; break;
            case 9:  points =  2; break;
            case 10: points =  1; break;
            default: points =  0; break;
        }
        driver.addPoints(points);
        results.put(driver, points);
    }
 
    /**
     * Returns the results map for this race.
     *
     * @return {@link HashMap} of {@link Driver} to points earned
     */
    @Override
    public HashMap<Driver, Integer> getResults() {
        return results;
    }
 
    /**
     * Returns the name of this rally event.
     *
     * @return race name string
     */
    @Override
    public String getRaceName() {
        return raceName;
    }
}