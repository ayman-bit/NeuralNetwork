package mun.ece.concurrent.assignment.three;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// Class to generate random inputs to neural network
// and output them to CSV file 
public class RandomInputGenerator {

	// Name of file to output inputs of neural network to	
	static String outputfilename;

	// number of random inputs to generate
	int numinputs;

	// assume random inputs are uniformly distributed between lowerbound and upperbound
	double lowerbound;
	double upperbound;

	// Constructor	
	public RandomInputGenerator(String outputfilename, int numinputs, double lowerbound, double upperbound)
	{
		this.numinputs = numinputs;
		this.outputfilename = outputfilename;
		this.lowerbound = lowerbound;		
		this.upperbound = upperbound;
	}

	// Generate text file (CSV) with random inputs	
	public void GenerateRandomInputsFile()
	{
		String separator = System.getProperty("line.separator");
		
		Writer inputs = null;
		File InputsFile = new File(outputfilename);
		try {
			inputs = new BufferedWriter(new FileWriter(InputsFile));			
			Double randinput;
			// input layer
			for (int i = 0; i < numinputs; i++)
			{				
					randinput = lowerbound + (upperbound-lowerbound)*Math.random();
					inputs.write(Double.toString(randinput));
					if (i < numinputs-1)
					{
						inputs.write(", ");						
					}
					else
					{
						inputs.write(separator);
					}
			}				
			inputs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
