package nl.hva.pc.common.task;

// TODO 03: Take a look at another example of "Task"
public class GregorySeriesTask implements Task<Integer, Double> {

    @Override
    public Double execute(Integer k) {
        double result = 0;

        for(int i = 1; i <= k; i++) {
            double temp = (Math.pow(-1, (i + 1))) / ((2 * i) -  1);
            result += temp;
        }

        return result * 4;
    }
}
