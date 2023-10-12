import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public abstract class AbstractNeuron {
    enum NeuronType {
        HIDDEN,
        OUTPUT
    }

    private NeuronType neuronType;
    private double S;
    private Weight[] weights;
    private AbstractNeuron[] inputs;
    private int numInputs;
    private final double bias = 1.0d;

    public AbstractNeuron(final NeuronType neuronType, final int numInputs) {
        this.neuronType = neuronType;
        this.numInputs = numInputs + 1; // +1 for bias
        this.weights = new Weight[numInputs];
        this.inputs = new AbstractNeuron[numInputs];
    }

    public NeuronType getNeuronType() {
        return neuronType;
    }

    public void computeWeightedSum() {
        S = 0;
    }

    public double computeError() {
        if (this.neuronType == NeuronType.OUTPUT) {

        } else {
            // weighted sum of the errors at the units above
        }
        return 0;
    }

    public void resetWeights() {
        for (int i = 0; i < weights.length; i++) {
            weights[i].resetWeights();
        }
    }

    public void initializeWeights() {
        for (int i = 0; i < weights.length; i++) {
            weights[i].initializeWeights();
        }
    }

}
