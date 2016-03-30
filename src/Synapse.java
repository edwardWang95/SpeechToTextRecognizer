import java.util.Random;

/**
 * Creates a connection between an inputPerceptron and its outputPerceptron with a given weight when doing computations.
 * Created by edwardwang on 3/30/16.
 */
public class Synapse {
    private Perceptron inputPerceptron;
    private Perceptron outputPerceptron;
    private double weight;

    public Synapse(Perceptron inputPerceptron, Perceptron outputPerceptron){
        this.inputPerceptron = inputPerceptron;
        this.outputPerceptron = outputPerceptron;
        Random random = new Random();
        weight = random.nextDouble();   //Sets a random weight to the given synapse when initially created
    }

    public Perceptron getInputPerceptron() {
        return inputPerceptron;
    }

    public void setInputPerceptron(Perceptron inputPerceptron) {
        this.inputPerceptron = inputPerceptron;
    }

    public Perceptron getOutputPerceptron() {
        return outputPerceptron;
    }

    public void setOutputPerceptron(Perceptron outputPerceptron) {
        this.outputPerceptron = outputPerceptron;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
