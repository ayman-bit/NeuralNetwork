package mun.ece.concurrent.assignment.three;

import java.io.*;
import java.util.*;


public class Main {
    static String inputFile = "input.csv";
    static String weightsFile = "weights.txt";

    public static void main(String[] args) throws IOException {
        // write your code here
        RandomInputGenerator inputGenerator = new RandomInputGenerator("input.csv", 4, 1.0, 3.0);
        inputGenerator.GenerateRandomInputsFile();

        RandomWeightGenerator weightGenerator = new RandomWeightGenerator("weight.txt", 4, 1.0, 5.0, 0.1);
//        weightGenerator.GenerateRandomWeightFile();
        Map<String, double[][]> inputArray = loadFile(inputFile);
        inputArray.get("lines");

        Map<String, double[][]> weightArray = loadFile(weightsFile);
        weightArray.get("inputArray");


    }

    public static double[][] transposeMatrix(double [][] m){
        double[][] temp = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }


    public static Map<String, double[][]> loadFile (String fileName) throws IOException{
        String thisLine;
        BufferedReader file  = new BufferedReader(new FileReader(fileName));

        List<double[]> lines = new ArrayList<>();
        while ((thisLine = file.readLine()) != null){
            lines.add(Arrays.stream(thisLine.split(",")).mapToDouble(Double::parseDouble).toArray());
        }
        double[][] array = new double[lines.size()][0];
        lines.toArray(array);
        int size = (lines.size()-2)/5;

        Map<String, double[][]> map =new HashMap();

        if (size != 1){
            double[][] inputArray = transposeMatrix(Arrays.copyOfRange(array,0,5));
            double[][] innerArray = transposeMatrix(Arrays.copyOfRange(array,5,lines.get(5).length*size));
            double[][] outputArray = transposeMatrix(Arrays.copyOfRange(array,lines.get(5).length*size,lines.get(5).length*size+5));
            map.put("inputArray",inputArray);
            map.put("innerArray",innerArray);
            map.put("outputArray",outputArray);
            return map;
        }
        else {
            map.put("lines",array);
            return map;
        }
    }

    public static ArrayList<Neuron> createOutputLayers(Integer nodes){
        ArrayList<Neuron> neurons = new ArrayList<>();

        for(int i = 0; i < 3; i++)
        {
            // TODO
        }

        return neurons;
    }

    public static ArrayList<Neuron> createInputLayers(Integer nodes, List<double[]> weights, double[] inputValues){
        ArrayList<Neuron> neurons = new ArrayList<>();

        for(int i = 0; i < nodes; i++)
        {
            // TODO
        }

        return neurons;
    }
}
