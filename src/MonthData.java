public class MonthData {
    public int[] day = new int [30];
    public int step;
    public int stepGoals = 1000;


    void createCalendarNumber(){
        for (int i = 0; i < day.length; i++) {
            day[i] = 0;
        }
    }
}
