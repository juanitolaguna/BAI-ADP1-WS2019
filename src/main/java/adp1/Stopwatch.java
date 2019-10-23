package adp1;

public class Stopwatch {

    private final long start;
    /**
     * Start timer on new
     */
    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start);
    }
}
