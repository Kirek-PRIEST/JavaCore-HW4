package hw;

import java.time.LocalDate;
import java.util.Random;

import static java.time.Month.*;

public class Main {
    public static void main(String[] args) {
        /*
         создаём массив сотрудников
         */
        Employee[] staff = new Employee[5];
        Random rnd = new Random();
        staff[0] = new Supervisor(
                "Руководитель",
                "Max",
                rnd.nextInt(1950, 2001) + "-" + rnd.nextInt(1, 13) + "-" + rnd.nextInt(1, 28),
                40000, Gender.FEMALE);

        for (int i = 1; i < staff.length; i++) {
            staff[i] = new Employee(
                    "Планктон",
                    "Bill " + i,
                    rnd.nextInt(1950, 2001) + "-" + rnd.nextInt(1, 13) + "-" + rnd.nextInt(1, 28),
                    rnd.nextInt(10000, 25000),
                    Gender.MALE);
        }
        //проверка работы метода printCelebrations
        System.out.println("Проверка Нового года:");
        printCelebrations(LocalDate.of(2025, 1, 1), staff);
        System.out.println("-------");
        System.out.println("Проверка 8 Марта:");
        printCelebrations(LocalDate.of(2025, 3, 8), staff);
        System.out.println("-------");
        System.out.println("Проверка 23 Февраля:");
        printCelebrations(LocalDate.of(2025, 2, 23), staff);
        System.out.println("-------");
        System.out.println("Проверка текущей даты:");
        printCelebrations(LocalDate.now(), staff);

    }

    /**
     * Метод проверяет через switch каким объектом из перечисления является переданная дата и выводит список сотрудников
     * для поздравления в соостветствии с полом.
     * @param date принимает дату в формате LocalDate
     * @param staff список сотрудников
     */
    public static void printCelebrations(LocalDate date, Employee[] staff) {
        Holidays h = celebrating(date);
        switch (h) {
            case MAR_8 -> {
                System.out.println("Сегодня " + h.getHoliday() + ". Давайте поздравим этих девушек:");
                for (Employee emp : staff) {
                    if (emp.getGender() == Gender.FEMALE) {
                        System.out.println(emp.getName());
                    }
                }
            }
            case FEB_23 -> {
                System.out.println("Сегодня " + h.getHoliday() + ". Давайте поздравим этих молодых людей:");
                for (Employee emp : staff) {
                    if (emp.getGender() == Gender.MALE) {
                        System.out.println(emp.getName());
                    }
                }
            }
            case NEW_YEAR -> System.out.println("Поздравляем всех с Новым Годом!");
            default -> System.out.println("Сегодня нет праздников, но не унывайте - они уже торопятся к вам и будут совсем скоро!");
        }


    }

    /**
     * Метод для определения к какому празднику отнсится переданная дата
     * @param date принимает дату в формате LocalDate
     * @return возвращает объект Holidays
     */
    public static Holidays celebrating(LocalDate date) {

        if (date.getDayOfMonth() == 8 && date.getMonth() == MARCH) {
            return Holidays.MAR_8;
        } else if (date.getDayOfMonth() == 23 && date.getMonth() == FEBRUARY) {
            return Holidays.FEB_23;
        } else if (date.getDayOfMonth() == 1 && date.getMonth() == JANUARY) {
            return Holidays.NEW_YEAR;
        }
        return Holidays.NONE;
    }

    public static void printStaff(Employee[] staff) {
        for (Employee e : staff) {
            System.out.println(e);
        }
    }
}