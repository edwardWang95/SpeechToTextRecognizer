package NeuralNetwork;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by edwardwang on 3/30/16.
 */
public class Perceptron {
    private ArrayList<Synapse> inputSynapses;
    private double activationThreshold;
    private double learningRate;

    public Perceptron(){
        Random random = new Random();
        activationThreshold = random.nextDouble();  //sets the

    }

    public void addPerceptronInput(Perceptron perceptron){
        Synapse synapse = new Synapse(perceptron, this);
        inputSynapses.add(synapse);
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double getActivationThreshold() {
        return activationThreshold;
    }

    public void setActivationThreshold(double activationThreshold) {
        this.activationThreshold = activationThreshold;
    }
}
