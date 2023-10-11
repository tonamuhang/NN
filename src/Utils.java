public class Utils {
    public static double sigmoid(double x) {
        return 2 / (1 + Math.pow(Math.E, -x)) - 1;
    }
}
