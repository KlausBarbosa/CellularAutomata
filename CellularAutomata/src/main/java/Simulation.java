import CellularService.Generation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Simulation {
    public static void main(String[] args) {
        int matrixSize = 5;
        double Pv = 0.03;
        double Ps = 0.01;
        double Pc = 0.6;
        double Pd = 0.3;
        double Po = 0.1;
        double k = 1;

        Generation generation = new Generation(matrixSize);
        generation.populateBoard();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        int totalCells = matrixSize * matrixSize;
        int numGenerations = 100;
        for (int i = 0; i < numGenerations; i++) {
            int susceptibleCount = generation.susceptibleCounter();
            int infectedCount = generation.infectedCounter();
            int recoveredCount = generation.recoveredCounter();

            generation.showGeneration();

            double susceptiblePercentage = (double) susceptibleCount / totalCells * 100;
            double infectedPercentage = (double) infectedCount / totalCells * 100;
            double recoveredPercentage = (double) recoveredCount / totalCells * 100;

            dataset.addValue(susceptiblePercentage, "Susceptible", "Generation " + i);
            dataset.addValue(infectedPercentage, "Infected", "Generation " + i);
            dataset.addValue(recoveredPercentage, "Recovered", "Generation " + i);

            generation.nextGeneration(Pv, Ps, Pc, Pd, Po, k);
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Cell State Evolution",
                "Generation",
                "Cell Percentage",
                dataset
        );


        ChartFrame frame = new ChartFrame("Cell State Evolution", chart);
        frame.pack();
        frame.setVisible(true);
    }
}