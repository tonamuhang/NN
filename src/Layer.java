import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Neuron> neurons;
    private int inputSize;
    private NeuronType type;

    public Layer(NeuronType type) {
        this.neurons = new ArrayList<>();
        this.type = type;
    }

    public Layer(List<Neuron> neurons, NeuronType type) {
        this.neurons = neurons;
        this.type = type;
    }

    public void connectToLayer(Layer layer) {
        for (Neuron neuron : neurons) {
            for (Neuron outputNeuron : layer.neurons) {
                neuron.connectToOutputNeuron(outputNeuron);
            }
        }
    }

    public void initializeWeights() {
        for (Neuron neuron : neurons) {
            neuron.initializeWeights();
        }
    }

    public void addNeuron(Neuron neuron) {
        neurons.add(neuron);
    }

    public void setNeurons(List<Neuron> neurons) {
        this.neurons = neurons;
    }

    public List<Neuron> getNeurons() {
        return this.neurons;
    }

    public NeuronType getType() {
        return type;
    }

    public void setType(NeuronType type) {
        this.type = type;
    }

    public void forwardPropagation(double[] inputs) {
        for (Neuron neuron : neurons) {
            neuron.computeAndSetWeightedSum();
            neuron.computeAndSetOutput();
        }
    }

    public void backwardPropagation() {
        for (Neuron neuron : neurons) {
            
        }
    }

    public void updateWeights() {
        for (Neuron neuron : neurons) {
            neuron.updateWeights();
        }
    }


    // Only works for one neuron outputs
    public double getOutput() {
        if (type != NeuronType.OUTPUT) {
            throw new RuntimeException("Layer is not output layer");
        }
        return neurons.get(0).getY();
    }

    public void setInputNeurons(double[] X) {
        for (int i = 0; i < neurons.size(); i++) {
            neurons.get(i).setY(X[i]);
        }
    }
}
