import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Weight {
    private Map<Neuron, Double> weights;
    private Map<Neuron, Double> lastChanges;

    public Weight() {
        this.weights = new HashMap<>();
    }

    public Weight(Map<Neuron, Double> weights, Map<Neuron, Double> lastChanges) {
        this.weights = weights;
        this.lastChanges = lastChanges;
    }

    public void resetWeights() {
        for (Neuron n : weights.keySet()) {
            weights.put(n, 0d);
            lastChanges.put(n, 0d);
        }
    }

    public void initializeWeights() {
        for (Neuron n : weights.keySet()) {
            weights.put(n, ThreadLocalRandom.current().nextDouble(-0.5d, 0.5d));
            lastChanges.put(n, 0d);
        }
    }

    public void addWeight(Neuron neuron) {
        weights.put(neuron, ThreadLocalRandom.current().nextDouble(-0.5d, 0.5d));
        lastChanges.put(neuron, 0d);
    }

    public double getWeight(Neuron neuron) {
        return weights.get(neuron);
    }

    public Map<Neuron, Double> getWeights() {
        return weights;
    }

    public Set<Neuron> getOutputNeurons() {
        return weights.keySet();
    }

    public void setWeight(Neuron neuron, double weight) {
        double oldWeight = weights.get(neuron);
        weights.put(neuron, weight);
        lastChanges.put(neuron, weight - oldWeight);
    }

    public void setWeights(Map<Neuron, Double> weights) {
        this.weights = weights;
    }

    public void setLastChanges(Map<Neuron, Double> lastChanges) {
        this.lastChanges = lastChanges;
    }

    public Map<Neuron, Double> getLastChanges() {
        return lastChanges;
    }
}
