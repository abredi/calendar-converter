package et.crescent;

import et.crescent.EthiopianCalendar.EthiopianDate;
import et.crescent.EthiopianCalendar.EthiopianDateConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws Exception {
        EthiopianDate ethiopianDate = new EthiopianDate(1896, 3, 1);
//        EthiopianDate ethiopianDate = new EthiopianDate(LocalDate.now());
        System.out.println("GC " + ethiopianDate.getLocalDate());
        System.out.println("EC " + ethiopianDate.getYear() + "-" + ethiopianDate.getMonth() + "-" + ethiopianDate.getDay());
        System.out.println(EthiopianDateConverter.ToGregorianDate(1896, 3, 1));
        LocalDate et = EthiopianDateConverter.ToGregorianDate(new EthiopianDate(1888, 6, 23));
        System.out.println(et);
    }
}
