public class MonthData {
    public int[] day = new int [30];
    public int step;

    void createCalendarNumber(){
        for (int i = 0; i < day.length; i++) {
            day[i] = 0;
        }
    }
}
