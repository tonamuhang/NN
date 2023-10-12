import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private final Weight weights;
    private final NeuronType type;
    private double S;
    private double E;
    private double y;
    private double p;
    private double C;
    private double a;
    private List<Neuron> inputs = new ArrayList<>();

    public Neuron(NeuronType type, double p, double a) {
        this.weights = new Weight();
        this.type = type;
        this.p = p;
        this.a = a;
    }

    public Neuron(double x, NeuronType type, double p, double a) {
        if (type != NeuronType.INPUT) {
            throw new RuntimeException("Type must be INPUT when provided x");
        }
        this.weights = new Weight();
        this.type = type;
        this.y = x;
        this.p = p;
        this.a = a;
    }

    public Neuron(Weight weights, NeuronType type, double S, double E, double y, double p, double C, double a, List<Neuron> inputs) {
        this.weights = weights;
        this.type = type;
        this.S = S;
        this.E = E;
        this.y = y;
        this.p = p;
        this.C = C;
        this.a = a;
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
    public void computeAndSetWeightedSum() {
        S = 0;
        if (type == NeuronType.INPUT) {
            S = y;
        } else {
            for (Neuron input : inputs) {
                S += input.getY() * input.weights.getWeight(this);
            }
        }
    }

    public void computeAndSetActivation() {
        if (type != NeuronType.INPUT) {
            y = Utils.sigmoid(S);
        }
    }

    // Step 2: backward
    public void computeAndSetErrorSignal(double C) {
        E = 0;
//        double fSi = y * (1 - y);
        double fSi = (1 - Math.pow(y, 2)) / 2;
        if (type == NeuronType.OUTPUT) {
            E = (C - y) * fSi;
        } else if (type == NeuronType.INPUT) {
            E = 0;
        } else {
            for (Neuron outputNeuron : weights.getOutputNeurons()) {
                E += weights.getWeight(outputNeuron) * outputNeuron.E * fSi;
            }
        }
    }

    // Step 3
    public void updateWeights() {
        for (Neuron outputNeuron : weights.getOutputNeurons()) {
            double delta = p * outputNeuron.E * this.y;
            double momentum = a * weights.getLastChanges().get(outputNeuron);
            weights.setWeight(outputNeuron, weights.getWeight(outputNeuron) + delta + momentum);
        }
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
        if (this.y == 0 && type == NeuronType.INPUT) {
            this.y = y;
        }
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

    public NeuronType getType() {
        return type;
    }

}
