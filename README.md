# NeuralNetwork
An artificial neural network consists of a sequence of layers each of which consists of one
or more neurons, or brain cells. Each neuron can be modelled as taking some number of inputs from the previous layer and
calculating a weighted sum of these inputs to produce a single output which is fed to the
neurons in the next layer.

 - We will also assume for the purposes of this assignment that every internal layer consists of
   exactly 5 neurons, while the input and output layers have 4 and 3 neurons respectively. 
 - Determine whether or not the neuron produces an output using an activation function. 
 - You may assume that for each neuron in one of the hidden layers, there is a random delay
   between 5 and 20 ms according to a uniform distribution function, between when the output
   is to be produced once all input signals to the neuron have been determined. 
 - For simplicity, we assume a ReLU activation function at each neuronal output, which is
   defined simply to be max(0, z), where z is the weighted sum of inputs to the neuron. 
 - You are to use Java's CyclicBarrier concurrency structure to program a neural network
   simulator which takes as input parameter the number of internal layers L (assumed to be
   between 3 and 20 inclusive), and a text file named weights.txt
 - Given an input vector x of length 4 over the non-negative real numbers, listed on one line in
   a file named inputs.txt, your program should output the index of the maximum output
   (between 1 and 3 inclusive) in the output layer.
 - This corresponds to the output class index of the input vector x to the given neural network.
 - Solution should use CountDownLatch or a similar synchronization mechanism, and each neuron in the
   above network diagram should run as a separate thread.
 - Can you reuse your synchronization mechanism? Why or why not?
 