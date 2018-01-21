package server.model;
/**
 * Visitor interface is main part of the visitor design pattern
 * @author Mateusz Kapiszewski
 * @version 1.0
 */
public interface Visitor {

    /**
     *Methods created to automatically use the right code based on the Object sent
     * @param location Location to check heating value
     * @return heating value
     */
    public double visit(Location location);
}
