package main;
 
/**
 * Represents a rally driver competing in the championship.
 *
 * <p>Each driver holds a reference to their assigned {@link RallyCar}
 * and accumulates championship points across races.</p>
 *
 * <p><b>SOLID Principles:</b></p>
 * <ul>
 *   <li><b>Single Responsibility:</b> Manages only driver identity,
 *       car assignment, and point accumulation.</li>
 *   <li><b>Dependency Inversion:</b> Depends on the abstract
 *       {@link RallyCar} type, not a concrete subclass.</li>
 * </ul>
 *
 * @author  Doan Vu Thanh Dat
 * @version 1.0
 */
public class Driver {
 
    /** Full name of the driver. */
    private String name;
 
    /** Nationality / country the driver represents. */
    private String country;
 
    /** Cumulative championship points earned across all races. */
    private int totalPoints;
 
    /** The rally car currently assigned to this driver. */
    private RallyCar car;
 
    /**
     * Constructs a new {@code Driver} with zero points.
     *
     * @param name    the driver's full name
     * @param country the driver's country / nationality
     * @param car     the {@link RallyCar} assigned to this driver
     */
    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.totalPoints = 0;
    }
 
    /**
     * Returns the driver's full name.
     *
     * @return driver name
     */
    public String getName() {
        return name;
    }
 
    /**
     * Returns the driver's country / nationality.
     *
     * @return country string
     */
    public String getCountry() {
        return country;
    }
 
    /**
     * Returns the total championship points accumulated so far.
     *
     * @return total points
     */
    public int getTotalPoints() {
        return totalPoints;
    }
 
    /**
     * Returns the rally car currently assigned to this driver.
     *
     * @return assigned {@link RallyCar}
     */
    public RallyCar getCar() {
        return car;
    }
 
    /**
     * Adds points to this driver's championship tally.
     * Called automatically by {@link RallyRaceResult#recordResult(Driver, int)}.
     *
     * @param points the points to add (must be non-negative)
     */
    public void addPoints(int points) {
        this.totalPoints += points;
    }
 
    /**
     * Replaces the driver's current car with a new one.
     *
     * @param car the new {@link RallyCar} to assign
     */
    public void setCar(RallyCar car) {
        this.car = car;
    }
}