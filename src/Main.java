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
            for (int i = 0; i < nn.trainingData.length; i++) {
                double[] X = nn.trainingData[i];
                double y = nn.trainingLabels[i];

                E += nn.train(X, y);
            }
            E = E / 2;
            epoch += 1;
            System.out.printf("Epoch: %d Error: %f%n", epoch, E);
        } while (E > 0.05d);
    }
}
