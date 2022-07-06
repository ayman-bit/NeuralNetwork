package mun.ece.concurrent.assignment.three;

import java.util.ArrayList;

public class Neuron {

    // Number of Inputs. If is 0, it means the neuron wasn't initialized yet.
    private int numberOfInputs = 0;

    //Weights associated with this Neuron
    protected ArrayList<Double> weight;

    // Inputs of this neuron
    private ArrayList<Double> input;

    // Neuron dummy constructor
    public Neuron(){}

    /**
     * Neuron constructor
     * @param numberofinputs Number of inputs
     */
    public Neuron(int numberofinputs){
        numberOfInputs=numberofinputs;
        weight=new ArrayList<>(numberofinputs+1);
        input=new ArrayList<>(numberofinputs);
    }

    /**
     * init
     * This method initializes the neuron by setting randomly its weights
     */
    public void init(){
        if(numberOfInputs>0){
            for(int i=0;i<=numberOfInputs;i++){
                double newWeight = RandomWeightGenerator.GenerateNext();
                try{
                    this.weight.set(i, newWeight);
                }
                catch(IndexOutOfBoundsException iobe){
                    this.weight.add(newWeight);
                }
            }
        }
    }

    /**
     * setInputs
     * Sets a vector of double-precision values to the neuron input
     * @param values vector of values applied at the neuron input
     */
    public void setInputs(double [] values){
        if(values.length==numberOfInputs){
            for(int i=0;i<numberOfInputs;i++){
                try{
                    input.set(i, values[i]);
                }
                catch(IndexOutOfBoundsException iobe){
                    input.add(values[i]);
                }
            }
        }
    }

    /**
     * setInputs
     * Sets an array of values to the neuron's input
     * @param values
     */
    public void setInputs(ArrayList<Double> values){
        if(values.size()==numberOfInputs){
            input=values;
        }
    }

    public void setInputLayer(boolean b) {
    }

    public void start() {
    }
}
