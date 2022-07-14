import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker(12);

        while (true) {
            if(userInput == 1) {
                System.out.println("Введите номер месяца, в котором хотите внести шаги, от 0 до 11, где 0 - январь, а 11 - декабрь");
                int month = scanner.nextInt();
                while (month < 0 || month > 11) {
                    System.out.println("Введите, пожалуйста, корректный номер месяца от 0 до 11, где 0 - январь, а 11 - декабрь");
                    month = scanner.nextInt();
                }
                System.out.println("Введите число, за какое хотите внести шаги от 1 до 30");
                int day = scanner.nextInt() - 1;
                while (day < 0 || day > 29) {
                    System.out.println("Введите, пожалуйста, корректное число");
                    day = scanner.nextInt();
                }
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.println("Введите, пожалуйста, не отрицательное значение количества шагов");
                    steps = scanner.nextInt();
                }
                stepTracker.addSteps(month, day, steps);
            } else if (userInput == 2) {
                System.out.println("Введите номер мясяца, статистику которого требуется распечать, от 0 до 11, где 0 - январь, а 11 - декабрь");
                int monthNumber = scanner.nextInt();
                while (monthNumber < 0 || monthNumber > 11){
                    System.out.println("Введите, пожалуйста, корректный номер мясяца, статистику которого требуется распечать, от 0 до 11, где 0 - январь, а 11 - декабрь");
                    monthNumber = scanner.nextInt();
                }
                stepTracker.printStat(monthNumber);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель количества шагов в день");
                int userChange = scanner.nextInt();
                while (userChange < 0) {
                    System.out.println("К сожалению, Вы ввели отрицательно значение, введите положительное значение количества шагов");
                    userChange = scanner.nextInt();
                }
                stepTracker.changeStepGoal(userChange);
            }

            if(userInput == 0) {
                break;
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя

        }

        System.out.println("Программа завершена");
        scanner.close();
    }
    private static void printMenu() {
        System.out.println("1 - ввести количество шагов за определённый день\n2 - напечатать статистику за месяц\n3 - изменить цель по количеству шагов за день\n0 - чтобы завершить программу");
    }
}