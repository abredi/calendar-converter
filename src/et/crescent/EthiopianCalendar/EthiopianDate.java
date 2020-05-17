package et.crescent.EthiopianCalendar;

import java.time.LocalDate;

public class EthiopianDate {

    private int year, month, day;

    private LocalDate localDate;

    public EthiopianDate(int year, int month, int day) throws Exception {
        localDate = EthiopianDateConverter.ToGregorianDate(year, month, day);
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public EthiopianDate(LocalDate dateTime) throws Exception {
        EthiopianDate ethiopianDate = EthiopianDateConverter.ToEthiopianDate(dateTime);
        localDate = ethiopianDate.getLocalDate();
        month = ethiopianDate.getMonth();
        day = ethiopianDate.getDay();
        year = ethiopianDate.getYear();
    }

    public void FromGregorianDate(LocalDate dateTime) throws Exception {
        EthiopianDate ethiopianDate = EthiopianDateConverter.ToEthiopianDate(dateTime);

        setYear(ethiopianDate.getYear());
        setMonth(ethiopianDate.getMonth());
        setDay(ethiopianDate.getDay());
    }

    public LocalDate ToGregorianDate() {
        return localDate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
