public abstract class AbstractNeuralNet implements INeuralNetInterface{
    private int argNumHidden;
    private double argLearningRate;
    private double argMomentumterm;
    private double argA;
    private double argB;
    int argNumInputs;
    float[] weights;

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
    public AbstractNeuralNet(int argNumInputs,
            int argNumHidden,
            double argLearningRate,
            double argMomentumTerm,
            double argA,
            double argB) {
        this.argNumInputs = argNumInputs;
        this.argNumHidden = argNumHidden;
        this.argLearningRate = argLearningRate;
        this.argMomentumterm = argMomentumTerm;
        this.argA = argA;
        this.argB = argB;
        this.weights = new float[argNumHidden];
    }

    @Override
    public double sigmoid(double x) {
        return 2 / (1 + Math.pow(Math.E, -x)) - 1;
    }

    @Override
    public double customSigmoid(double x) {
//        b_minus_a / (1 + e(-x)) - minus_a

        return 0;
    }

    public double getArgMomentumterm() {
        return argMomentumterm;
    }

}

