package main;
 
/**
 * Abstract base class representing a rally car.
 *
 * <p><b>SOLID Principles:</b></p>
 * <ul>
 *   <li><b>Single Responsibility:</b> Holds only car data and enforces
 *       the performance contract — nothing else.</li>
 *   <li><b>Open/Closed:</b> Closed for modification; subclasses extend
 *       behaviour by overriding {@link #calculatePerformance()}.</li>
 *   <li><b>Liskov Substitution:</b> Any subclass can replace a
 *       {@code RallyCar} reference without breaking the program.</li>
 * </ul>
 *
 * @author  Doan Vu Thanh Dat
 * @version 1.0
 */
public abstract class RallyCar {
 
    /** The manufacturer of the car (e.g. "Toyota"). */
    protected String make;
 
    /** The model name of the car (e.g. "GR Yaris"). */
    protected String model;
 
    /** Engine output in horsepower. */
    protected int horsepower;
 
    /**
     * Constructs a new {@code RallyCar} with the given specifications.
     *
     * @param make       the manufacturer name
     * @param model      the model name
     * @param horsepower the engine horsepower
     */
    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }
 
    /**
     * Calculates a numeric performance rating for this car.
     * Each subclass applies its own surface-specific multiplier.
     *
     * @return the calculated performance rating
     */
    public abstract double calculatePerformance();
 
    /**
     * Returns the manufacturer name.
     *
     * @return car make
     */
    public String getMake() {
        return make;
    }
 
    /**
     * Returns the model name.
     *
     * @return car model
     */
    public String getModel() {
        return model;
    }
 
    /**
     * Returns the engine horsepower.
     *
     * @return horsepower value
     */
    public int getHorsepower() {
        return horsepower;
    }
 
    /**
     * Returns a human-readable summary of this car.
     *
     * @return formatted string, e.g. {@code "Toyota GR Yaris (380hp)"}
     */
    @Override
    public String toString() {
        return make + " " + model + " (" + horsepower + "hp)";
    }
}