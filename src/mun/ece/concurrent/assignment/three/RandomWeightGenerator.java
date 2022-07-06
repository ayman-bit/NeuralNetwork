package mun.ece.concurrent.assignment.three;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// This class
public class RandomWeightGenerator {
	
	int numL;
	
	static String outputfilename;
	double lowerbound;
	double upperbound;

	// number of neurons in input layer
	static final int numneurons_inputlayer = 4;

	// number of neurons in any internal layer
	static final int numneurons_internallayer = 5;

	// number of neurons in output layer
	static final int numneurons_outputlayer = 3;

	// Probability that weight between two neurons is zero
	static double nolinkprob;

	// Class constructor	
	public RandomWeightGenerator(String outputfilename, int L, double lowerbound, double upperbound, double nolinkprob)
	{
		this.outputfilename = outputfilename;
		numL = L;
		this.lowerbound = lowerbound;		
		this.upperbound = upperbound;
		this.nolinkprob = nolinkprob;
	}

	// Generates random weights equal to zero with a probability of nolinkprob, and otherwise 
 	// uniformly distributed between lowerbound and upperbound.
	public void GenerateRandomWeightFile()
	{
		String separator = System.getProperty("line.separator");
		
		Writer Weightoutput = null;
		File WeightFile = new File("weights.txt");
		try {
			Weightoutput = new BufferedWriter(new FileWriter(WeightFile));
			Weightoutput.write(Integer.toString(numL)+separator);
			Double randweight;
			// input layer
			for (int i = 0; i < numneurons_inputlayer; i++)
			{
				for (int j = 0; j < numneurons_internallayer; j++)
				{
					if (Math.random() < nolinkprob)
					{
						randweight = (double) 0;
						Weightoutput.write("0");
					}
					else
					{					
						randweight = lowerbound + (upperbound-lowerbound)*Math.random();
						Weightoutput.write(randweight.toString());
					}					
					if (j < numneurons_internallayer-1)
					{
						Weightoutput.write(", ");
					}
					else
					{
						Weightoutput.write(separator);
					}
				}
			}
			
			//internal layers
			for (int l = 0; l < numL; l++)
			{
				for (int i = 0; i < numneurons_internallayer; i++)
				{
					for (int j = 0; j < numneurons_internallayer; j++)
					{
						if (Math.random() < nolinkprob)
						{
							randweight = (double) 0;
							Weightoutput.write("0");
						}
						else
						{					
							randweight = lowerbound + (upperbound-lowerbound)*Math.random();
							Weightoutput.write(randweight.toString());
						}		
						if (j < numneurons_internallayer-1)
						{
							Weightoutput.write(", ");
						}
						else
						{
							Weightoutput.write(separator);
						}
					}
				}
			}
			for (int i = 0; i < numneurons_internallayer; i++)
			{
				for (int j = 0; j < numneurons_outputlayer; j++)
				{

					if (Math.random() < nolinkprob)
					{
						randweight = (double) 0;
						Weightoutput.write("0");
					}
					else
					{					
						randweight = lowerbound + (upperbound-lowerbound)*Math.random();
						Weightoutput.write(randweight.toString());
					}						
					if (j < numneurons_outputlayer)
					{
						Weightoutput.write(", ");
					}
					else
					{
						Weightoutput.write(separator);
					}
				}
			}
			Weightoutput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
