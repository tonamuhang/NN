import java.util.ArrayList;
import java.util.List;

public class Neuron {
    enum NeuronType {
        HIDDEN,
        OUTPUT
    }

    private final Weight weights;
    private final NeuronType type;
    private double S;
    private double E;
    private double y;
    private double p;
    private double C;
    private List<Neuron> inputs = new ArrayList<>();

    public Neuron(NeuronType type, double p) {
        this.weights = new Weight();
        this.type = type;
        this.p = p;
    }

    public Neuron(Weight weights, NeuronType type, double S, double E, double y, double p, double C, List<Neuron> inputs) {
        this.weights = weights;
        this.type = type;
        this.S = S;
        this.E = E;
        this.y = y;
        this.p = p;
        this.C = C;
        this.inputs = inputs;
    }

    public void connectToOutputNeuron(Neuron neuron) {
        if (type == NeuronType.OUTPUT) {
            return;
        }

        weights.addWeight(neuron);
        neuron.addToInput(this);
    }

    public void initializeWeights() {
        weights.initializeWeights();
    }

    private void addToInput(Neuron neuron) {
        inputs.add(neuron);
    }

    // Step 1: forward
    private void computeAndSetWeightedSum() {
        S = 0;
        for (Neuron input : inputs) {
            S += input.getY() * input.weights.getWeight(this);
        }
    }

    // Step 2: backward
    private void computeAndSetError() {
        E = 0;
        if (type == NeuronType.OUTPUT) {

        } else {

        }
    }

    // Step 3
    private void updateWeights() {
        for (Neuron neuron : weights.getOutputNeurons()) {
            double delta = p * neuron.E * weights.getWeight(neuron);
            weights.setWeight(neuron, weights.getWeight(neuron) + delta);
        }
    }

    public void computeAndSetOutput() {
        y = Utils.sigmoid(S);
    }

    public double getS() {
        return S;
    }

    public void setS(double S) {
        this.S = S;
    }

    public double getE() {
        return E;
    }

    public void setE(double E) {
        this.E = E;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public List<Neuron> getInputs() {
        return inputs;
    }

    public void setNeuron(List<Neuron> inputs) {
        this.inputs = inputs;
    }

    public double getC() {
        return C;
    }

    public void setC(double C) {
        this.C = C;
    }
}
