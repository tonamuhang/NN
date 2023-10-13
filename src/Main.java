import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        XORNeruralNet nn = new XORNeruralNet(2, 4, 0.2, 0, 0, 0);

        nn.initializeWeights();

        double E = 0;
        int epoch = 0;
        do {
            // for each pattern, calculate error
            for (int i = 0; i < nn.trainingDataBipolar.length; i++) {
                double[] X = nn.trainingDataBipolar[i];
                double y = nn.trainingLabelsBipolar[i];

                E += nn.train(X, y);
                if (i == 3) {
                    System.out.println(nn.outputFor(X));
                }
            }
            E = E / 2;
            epoch += 1;
            System.out.printf("Epoch: %d Error: %f%n", epoch, E);
        } while (E > 0.05d);
    }
}
