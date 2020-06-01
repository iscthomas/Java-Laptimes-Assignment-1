package pLaptimesAssignment;
/**
 * @author Isaac Thomas
 * @date 1/6/2020
 * The type enum is used to store the type of vehicle used for each record,
 * production cars are street legal, racing cars did the lap time during a race and 
 * Special cars did a laptime in a non-street-legal closed environment. 
 * This prevents un-needed excessive string usage for repeated data.
 */
public enum Type {
	Production, Racing, Special;
}
