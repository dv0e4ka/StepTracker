public class StepTracker {
    int stepGoal = 10000;
    MonthData[] monthToData;
    Converter converter = new Converter();

    public StepTracker(int calendarMonth) {
        monthToData = new MonthData[calendarMonth];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
            monthToData[i].createCalendarNumber();
        }
    }

    public void addSteps(int calendarMonth, int calendarNumber, int steps) {
        monthToData[calendarMonth].day[calendarNumber] = steps;
    }

    public void printStat(int monthData) {
        int sum = 0;
        int maxStepsInDay = 0;
        for (int i = 0; i < 30; i++) {
            System.out.println(monthToData[monthData].day[i]);
            sum += monthToData[monthData].day[i];
            if(monthToData[monthData].day[i] > maxStepsInDay) maxStepsInDay = monthToData[monthData].day[i];
        }
        System.out.println("Сумма шагов за " + (monthData + 1) + " месяц равна: "+ sum);
        System.out.println("Максимальное пройденное количество шагов за " + (monthData + 1) + " месяц равна: " + maxStepsInDay + " шагов");
        System.out.println("Среднее количество шагов за день составило: " + sum / 30);
        System.out.println("Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого значение (" + stepGoal + "), за " + (monthData) + " месяц равна: " + findMaxSeries(monthData));
        System.out.println("Количество сожжённых килокалорий: " + converter.ConvectkCal(sum));
        System.out.println("Пройденная дистанция (в км): " + converter.convectDistance(sum));
    }

    public void changeStepGoal (int userChange) {
        stepGoal = userChange;
        System.out.println("Теперь стоит цель пройти " + stepGoal + " шагов в день");
    }

    public int findMaxSeries(int monthData) {
        int maxSeries = 0;
        int curSeries = 0;

        for (int i = 0; i < monthToData[monthData].day.length; i++) {
            if(monthToData[monthData].day[i] >= stepGoal) {
                curSeries++;
            } else {
                if(curSeries >= maxSeries) {
                    maxSeries = curSeries;
                }
                curSeries = 0;
            }
            if (curSeries > maxSeries) {
                maxSeries = curSeries;
            }
        }
        return maxSeries;
    }
}
