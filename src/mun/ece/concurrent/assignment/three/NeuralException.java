package mun.ece.concurrent.assignment.three;

public class NeuralException extends Throwable {
    public NeuralException(String invalid_weight_index) {
        super(invalid_weight_index);
    }
}
