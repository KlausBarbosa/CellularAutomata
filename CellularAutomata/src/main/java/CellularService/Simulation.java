package CellularService;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Simulation {
    public static void main(String[] args) {
        Generation generation = new Generation(5, 10);
        generation.populateBoard();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int numGenerations = 13;
        for (int i = 0; i < numGenerations; i++) {
            int susceptibleCount = generation.susceptibleCounter();
            int infectedCount = generation.infectedCounter();
            int recoveredCount = generation.recoveredCounter();

            generation.showGeneration();

            dataset.addValue(susceptibleCount, "Susceptible", "Generation " + i);
            dataset.addValue(infectedCount, "Infected", "Generation " + i);
            dataset.addValue(recoveredCount, "Recovered", "Generation " + i);

            generation.nextGeneration();
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Cell State Evolution",
                "Generation",
                "Cell Count",
                dataset
        );

        ChartFrame frame = new ChartFrame("Cell State Evolution", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
