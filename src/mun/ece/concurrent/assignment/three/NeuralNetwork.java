package mun.ece.concurrent.assignment.three;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class NeuralNetwork extends Thread
{
	int numlayers;
	public ArrayList<NeuralNetLayer> nnlayers;
	public static CyclicBarrier newBarrier;

	public NeuralNetwork(int L, ArrayList<NeuralNetLayer> nnlayers)
	{
		newBarrier = new CyclicBarrier(L+2);
		this.numlayers = L+2;
		this.nnlayers = nnlayers;		
	}	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < numlayers; i++)
		{
			nnlayers.get(i).start();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
	}
}
