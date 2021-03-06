package Controller.StatisticsController;

import Controller.Interfaces.ControllerInterface;
import Controller.Interfaces.RemoveItemObserver;
import Controller.Interfaces.RemoveItemSubject;
import StairwayInterfaces.iEntry;
import Model.EntryLogic.EntryHandler;
import Model.Interfaces.EntrySubject;
import Model.Interfaces.EntryObserver;
import View.EntryView.EntryListItemView;
import View.StatisticsView.StatisticsOverviewView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * @author : Oscar Forsberg
 * Responsibility: A controller class for handling the page for overview statistics. It listens to what happens to
 *                 entries by implementing EntryObserver and RemoveItemObserver
 * Used by: PaneFactory
 * Uses: ControllerInterface, StatisticsOverviewView, EntryObserver, RemoveItemObserver
 */
public class StatisticsOverViewController implements EntryObserver, RemoveItemObserver, ControllerInterface {

    //________________________________________________ VARIABLES _______________________________________________________

    private final StatisticsOverviewView statisticsOverviewView = StatisticsOverviewView.getInstance();
    private final EntryHandler entryHandler = EntryHandler.getInstance();

    //_________________________________________________ METHODS ________________________________________________________

    /**
     * Constructor
     */
    public StatisticsOverViewController() {
        setAllViewListeners();
        EntrySubject.add(this);
        RemoveItemSubject.add(this);
    }

    /**
     * A function that shows different texts on the detailStatisticsPage depending on which button you press
     *
     * @param text that is either "Daily", "Monthly" or "Weekly"
     */
    private void detailedStatistics(final String text) {
        statisticsOverviewView.showDetailStatisticsPage(text);
    }

    //__________ THIS PART IS NOT IMPLEMENTED YET, JUST SOME HARD CODED EXAMPLES TO ILLUSTRATE IN OUR PROGRAM __________

    /**
     * When implemented: should update category values and then call upon pieCharts to be updated according to daily
     * (entries today), weekly (entries the past 7 days) and monthly (the past 30 months) time-span.
     */
    private void updateStatisticsPiechart(final iEntry entry) {
        entryHandler.updateTotalCategoryValues();
        updateDailyStatistics();
        updateWeeklyStatistics();
        updateMonthlyStatistics();
    }
    /**
     * When implemented: should update dailyStatistics PieChart using entries from the same day
     */
    private void updateDailyStatistics() {
        final ObservableList<PieChart.Data> pieChartData1 = FXCollections.observableArrayList(
                new PieChart.Data("Food", entryHandler.getFoodAmount()),
                new PieChart.Data("Transportation", entryHandler.getTransportationAmount()),
                new PieChart.Data("Household", entryHandler.getHouseholdAmount()),
                new PieChart.Data("Shopping", entryHandler.getShoppingAmount()),
                new PieChart.Data("Other", entryHandler.getOtherAmount()));
        if (statisticsOverviewView.chart1 == null) {
            statisticsOverviewView.chart1 = new PieChart(pieChartData1);
            statisticsOverviewView.dailyAnchor.getChildren().add(statisticsOverviewView.chart1);
        } else {
            statisticsOverviewView.chart1.setData(pieChartData1);
        }
    }
    /**
     * When implemented: should update dailyStatistics PieChart using entries from the past 7 days
     */
    private void updateWeeklyStatistics() {
        final ObservableList<PieChart.Data> pieChartData2 = FXCollections.observableArrayList(
                new PieChart.Data("Food", entryHandler.getFoodAmount() + 205),
                new PieChart.Data("Transportation", entryHandler.getTransportationAmount() + 200),
                new PieChart.Data("Household", entryHandler.getHouseholdAmount() + 50),
                new PieChart.Data("Shopping", entryHandler.getShoppingAmount() + 10),
                new PieChart.Data("Other", entryHandler.getOtherAmount() + 222));
        if (statisticsOverviewView.chart2 == null) {
            statisticsOverviewView.chart2 = new PieChart(pieChartData2);
            statisticsOverviewView.weeklyAnchor.getChildren().add(statisticsOverviewView.chart2);
        } else {
            statisticsOverviewView.chart2.setData(pieChartData2);
        }
    }
    /**
     * When implemented: should update dailyStatistics PieChart using entries from the past 30 days
     */
    private void updateMonthlyStatistics() {
        final ObservableList<PieChart.Data> pieChartData3 = FXCollections.observableArrayList(
                new PieChart.Data("Food", entryHandler.getFoodAmount() + 115),
                new PieChart.Data("Transportation", entryHandler.getTransportationAmount() + 10),
                new PieChart.Data("Household", entryHandler.getHouseholdAmount() + 50),
                new PieChart.Data("Shopping", entryHandler.getShoppingAmount() + 20),
                new PieChart.Data("Other", entryHandler.getOtherAmount() + 100));
        if (statisticsOverviewView.chart3 == null) {
            statisticsOverviewView.chart3 = new PieChart(pieChartData3);
            statisticsOverviewView.monthlyAnchor.getChildren().add(statisticsOverviewView.chart3);
        } else {
            statisticsOverviewView.chart3.setData(pieChartData3);
        }
    }

    //__________________________________________________________________________________________________________________

    /**
     * Method that says what should happen when pressing different buttons. Sends that information to the view.
     */
    @Override
    public void setAllViewListeners() {
        statisticsOverviewView.toDailyStatistics.setOnAction(event -> detailedStatistics("Daily"));
        statisticsOverviewView.toWeeklyStatistics.setOnAction(event -> detailedStatistics("Weekly"));
        statisticsOverviewView.toMonthlyStatistics.setOnAction(event -> detailedStatistics("Monthly"));

    }

    /**
     * Update method when an object gets added
     */

    @Override
    public void update(final iEntry entry) {
        updateStatisticsPiechart(entry);
    }

    /**
     * Update method when an object gets deleted
     */
    @Override
    public void update(final iEntry entry, final EntryListItemView controller) {
        updateStatisticsPiechart(entry);
    }


}
