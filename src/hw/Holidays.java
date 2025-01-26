package hw;
    /*
    нет праздника, Новый Год, 8 марта, 23 февраля
    написать метод, принимающий массив сотрудников,
    поздравляющий всех сотрудников с Новым Годом, женщин с 8 марта, а мужчин с 23 февраля, если сегодня соответствующий день.
     */

/**
 * Перечисление праздников
 */
public enum Holidays {

    NONE("нет праздника"), NEW_YEAR("Новый год"), MAR_8("8 марта"), FEB_23("23 Февраля");
    private String holiday;

    Holidays(String holiday) {
        this.holiday = holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getHoliday() {
        return holiday;
    }
}
