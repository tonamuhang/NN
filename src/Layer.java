import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Neuron> neurons;
    private int inputSize;

    public Layer() {
        neurons = new ArrayList<>();
    }

    public Layer(List<Neuron> neurons) {
        this.neurons = neurons;
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

    public void forwardPropagation() {
        for (Neuron neuron : neurons) {
            neuron.
        }
    }

    public void backwardPropagation() {
    }


}
