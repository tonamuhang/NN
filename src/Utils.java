public class Utils {
    public static double sigmoid(double x, boolean bipolar) {
        return bipolar ? (2 / (1 + Math.pow(Math.E, -x))) - 1 : (1 / (1 + Math.pow(Math.E, -x)));
    }

    public static double sigmoid(double x, double a, double b) {
        // b_minus_a / (1 + e(-x)) - minus_a
        return (b - a) / (1 + Math.pow(Math.E, -x)) - a;
    }
}
