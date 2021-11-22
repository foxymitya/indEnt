package space.mitya;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");
            int earnings = 0;
            int spendings = 0;
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String incomeStr = scanner.nextLine();
                    int income = Integer.parseInt(incomeStr);
                    earnings += income;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String expenseStr = scanner.nextLine();
                    int expense = Integer.parseInt(expenseStr);
                    spendings += expense;
                    break;
                case 3:
                    System.out.println("Выберете систему налогооблажения:");
                    int tax1 = taxEarningsSpendings(earnings, spendings);
                    int tax2 = taxEarnings(earnings);
                    System.out.println(tax1 + " -> " + tax2);
                    if (tax1 > tax2) {
                        System.out.println("Мы советуем вам УСН доходы * 6% ");
                        System.out.println("Ваш налог составит: " + tax1);
                        System.out.println("Налог на другой системе: " + tax2);
                        System.out.println("Экономия: " + (tax2 - tax1));
                    } else if (tax1 < tax2) {
                        System.out.println("Мы советуем вам УСН доходы - расходы * 15%");
                        System.out.println("Ваш налог составит: " + tax2);
                        System.out.println("Налог на другой системе: " + tax1);
                        System.out.println("Экономия: " + (tax1 - tax2));
                    } else if (tax1 == tax2) {
                        System.out.println("Налоги при разных системах равны");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");

            }
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsSpendings(int earnings, int spendings) {
        int tax1 = (earnings - spendings) * 15 / 100;
        if (tax1 >= 0) {
            return tax1;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax2 = earnings * 6 / 100;
        if (tax2 >= 0) {
            return tax2;
        } else {
            return 0;
        }
    }
}
