package main;
 
/**
 * A {@link RallyCar} optimised for asphalt-surface rally stages.
 *
 * <p>Asphalt cars use stiffer suspension and slick-pattern tyres,
 * giving higher grip reflected by a performance multiplier of <b>1.50</b>.</p>
 *
 * <p><b>SOLID Principles:</b></p>
 * <ul>
 *   <li><b>Open/Closed:</b> Extends {@link RallyCar} without modifying it.</li>
 *   <li><b>Liskov Substitution:</b> Can be used anywhere a {@link RallyCar}
 *       is expected.</li>
 *   <li><b>Single Responsibility:</b> Responsible only for asphalt-specific
 *       performance logic.</li>
 * </ul>
 *
 * @author  Doan Vu Thanh Dat
 * @version 1.0
 */
public class AsphaltCar extends RallyCar {
 
    /**
     * Constructs an asphalt-specification rally car.
     *
     * @param make       the manufacturer name
     * @param model      the model name
     * @param horsepower the engine horsepower
     */
    public AsphaltCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }
 
    /**
     * Calculates asphalt performance using a multiplier of 1.50.
     *
     * <p>Formula: {@code horsepower * 1.50}</p>
     *
     * @return asphalt performance rating
     */
    @Override
    public double calculatePerformance() {
        return horsepower * 1.50;
    }
}