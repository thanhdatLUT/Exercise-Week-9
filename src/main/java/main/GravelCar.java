package main;
 
/**
 * A {@link RallyCar} optimised for gravel-surface rally stages.
 *
 * <p>Gravel cars use softer suspension and specific tyre compounds,
 * reflected here by a performance multiplier of <b>1.35</b>.</p>
 *
 * <p><b>SOLID Principles:</b></p>
 * <ul>
 *   <li><b>Open/Closed:</b> Extends {@link RallyCar} without modifying it.</li>
 *   <li><b>Liskov Substitution:</b> Can be used anywhere a {@link RallyCar}
 *       is expected.</li>
 *   <li><b>Single Responsibility:</b> Responsible only for gravel-specific
 *       performance logic.</li>
 * </ul>
 *
 * @author  Doan Vu Thanh Dat
 * @version 1.0
 */
public class GravelCar extends RallyCar {
 
    /**
     * Constructs a gravel-specification rally car.
     *
     * @param make       the manufacturer name
     * @param model      the model name
     * @param horsepower the engine horsepower
     */
    public GravelCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }
 
    /**
     * Calculates gravel performance using a multiplier of 1.35.
     *
     * <p>Formula: {@code horsepower * 1.35}</p>
     *
     * @return gravel performance rating
     */
    @Override
    public double calculatePerformance() {
        return horsepower * 1.35;
    }
}
 