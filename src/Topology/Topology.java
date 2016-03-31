package Topology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Maps the topology of a given neural network
 * Created by edwardwang on 3/31/16.
 */
public class Topology {
    private int INITIAL_NUMBER_OF_LAYERS = 5;
    private int INITIAL_NUMBER_OF_PERCEPTRONS_PER_LAYER = 5;

    //Mutations involving adding a new perceptron or synapse
    private final int ADD_NEW_PERCEPTRON = 0;
    private final int ADD_NEW_SYNAPSE = 1;
    private final int ADD_NEW_LAYER = 2;

    //Mutations involving removing existing perceptrons or synapses
    private final int REMOVE_PERCEPTRON = 3;
    private final int REMOVE_SYNAPSE = 4;

    private Random random;
    //The number of input and output for each neural network is 1
    private final int inputAmount = 1;
    private final int outputAmount = 1;
    private int numberOfLayers;
    private List<Integer> layerList;

    public Topology(){
        initLayers();
    }

    /**
     * Setup the arbitrary number of perceptrons for each layer. Initial setup for a layer must have minimum 1 perceptron.
     */
    private void initLayers(){
        random = new Random();
        layerList = new ArrayList<Integer>();
        numberOfLayers = random.nextInt(INITIAL_NUMBER_OF_LAYERS);
        for(int i=1;i<numberOfLayers;i++){
            layerList.add(i,random.nextInt(INITIAL_NUMBER_OF_PERCEPTRONS_PER_LAYER));
        }
    }

    /**
     * This method will mutate the given set of different mutations based on a random choice, and produce a total of
     * 9 new neural network, making a total of 10 neural networks including itself.
     */
    public void mutateList(){

    }


    public int getOutputAmount() {
        return outputAmount;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public List<Integer> getLayerList() {
        return layerList;
    }
}
