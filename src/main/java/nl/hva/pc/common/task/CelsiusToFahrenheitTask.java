package nl.hva.pc.common.task;

// TODO 02: Take a look at one example of "Task"
public class CelsiusToFahrenheitTask implements Task<Double,Double> {

    @Override
    public Double execute(Double celsius) {
        return celsius * 1.8 + 32;
    }
}
