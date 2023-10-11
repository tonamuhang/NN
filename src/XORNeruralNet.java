import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XORNeruralNet extends AbstractNeuralNet {
    private List<Layer> layers = new ArrayList<>();
    private Gson gson = new Gson();
    private Layer hiddenLayer = new Layer();
    private Layer outputLayer = new Layer();

    // Training data
    double[][] trainingData = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
    };

    double[] trainingLabels = {0, 1, 1, 0};

    /**
     * * Constructor. (Cannot be declared in an interface, but your implementation will need one)
     *
     * @param argNumInputs    The number of inputs in your input vector
     * @param argNumHidden    The number of hidden neurons in your hidden layer. Only a single hidden layer is supported
     * @param argLearningRate The learning rate coefficient
     * @param argMomentumTerm The momentum coefficient
     * @param argA            Integer lower bound of sigmoid used by the output neuron only.
     * @param argB            Integer upper bound of sigmoid used by the output neuron only.
     */
    public XORNeruralNet(int argNumInputs, int argNumHidden, double argLearningRate, double argMomentumTerm, double argA, double argB) {
        super(argNumInputs, argNumHidden, argLearningRate, argMomentumTerm, argA, argB);
        layers.add(hiddenLayer);
        layers.add(outputLayer);
    }


    @Override
    public void initializeWeights() {
        for (Layer layer : layers) {
            layer.initializeWeights();
        }
    }

    @Override
    public void zeroWeights() {
        Arrays.fill(weights, 0.f);
    }

    @Override
    public double outputFor(double[] X) {
        for (Layer layer : layers) {
            for (Neuron neuron : layer.getNeurons()) {
                neuron.computeAndSetOutput();
            }
        }
        return 0;
    }

    @Override
    public double train(double[] X, double argValue) {
        // while total error < accepted error
        // forward, backward
        // log total error

        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < trainingData.length; j++) {
                double[] input = trainingData[j];
                double target = trainingLabels[j];

                laye
            }
        }
        return 0;
    }

    public void save(String argFileName) {
        try {
            gson.toJson(layers, new FileWriter(argFileName));
        } catch (Exception e) {
            throw new RuntimeException("error writing to file");
        }
    }

    @Override
    public void load(String argFileName) {
        try (FileReader reader = new FileReader(argFileName)) {
            this.layers = gson.fromJson(reader, ArrayList.class);
        } catch (IOException e) {
            throw new RuntimeException("error reading from file");
        }
    }
}
