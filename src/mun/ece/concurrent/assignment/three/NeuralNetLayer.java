package mun.ece.concurrent.assignment.three;

import java.util.ArrayList;
import java.util.List;

// Class representing a layer in an artificial neural network
public class NeuralNetLayer extends Thread
{
	// Number of Neurons in this Layer
	protected int numberOfNeuronsInLayer;

	// Previous Layer that feeds values to this Layer
	protected NeuralNetLayer previousLayer;

	// Next Layer which this Layer will feed values to
	protected NeuralNetLayer nextLayer;

	// List of neurons in this layer
	ArrayList<Neuron> neurons;

	// Any layer is either an input layer to the neural network, an internal layer, or an output layer
	// to the network
	public enum LayerType  {INPUT, INTERNAL, OUTPUT};
	LayerType layertype;

	// Constructor for neural network layer	
	public NeuralNetLayer(ArrayList<Neuron> neurons, LayerType layertype)
	{
		this.neurons = neurons;
		this.layertype = layertype;
	}

	public int getNumberOfNeuronsInLayer(){
		return numberOfNeuronsInLayer;
	}

	// getListOfNeurons
	// @return Returns the whole array of neurons of this layer
	public ArrayList<Neuron> getListOfNeurons(){
		return neurons;
	}

	// getPreviousLayer
	// @return Returns the reference to the previous lay
	protected NeuralNetLayer getPreviousLayer(){
		return previousLayer;
	}

	protected NeuralNetLayer getNextLayer(){
		return nextLayer;
	}

	// setPreviousLayer
	// @param layer Sets the reference to the previous layer
	protected void setPreviousLayer(NeuralNetLayer layer){
		previousLayer=layer;
	}

	 // setNextLayer
	 // @param layer Sets the reference to the next layer
	protected void setNextLayer(NeuralNetLayer layer){
		nextLayer=layer;
	}
		
	@Override
	public void run() {
		for (int i = 0; i < neurons.size(); i++)
		{
			// Neurons should know whether they expect their inputs from
			// the inputs to entire network or from outputs of previous layer
			if (layertype == NeuralNetLayer.LayerType.INPUT)
			{
				neurons.get(i).setInputLayer(true);
			}
			else
			{
				neurons.get(i).setInputLayer(false);
			}

			// Start threads for neurons in this layer
			neurons.get(i).start();
			try {
				// This may not be necesary - good to slow things down a bit
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
