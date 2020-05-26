package et.crescent.EthiopianCalendar;

import java.time.LocalDate;

public class EthiopianDateConverter {

    private static int JdOffset = 1723856;

    public static EthiopianDate ToEthiopianDate(LocalDate localDate) throws Exception {
        int jdn = toJDN(localDate);
        return ToEthiopianDate( jdn);

    }

    private static int toJDN(LocalDate localDate)
    {
        int a, y, m;
        a = (14 - localDate.getMonthValue())/12;
        y = localDate.getYear() + 4800 - a;
        m = localDate.getMonthValue() + 12 * a - 3;

        return localDate.getDayOfMonth() + (153 * m + 2)/5 + 365 * y + y/4 - y / 100 + y /400 - 32045;
    }

    private static  EthiopianDate ToEthiopianDate(int jdn) throws Exception {
        //Formula from Dr. Berhanu Beyene and Manfred Kudlek
        int year, month, day,r,n;


        r = (jdn - JdOffset) % 1461;
        n = r%365 + 365*(r/1460);

        year = 4 * ((jdn - JdOffset) / 1461) + r / 365 - r / 1460;
        month = n/30 + 1;
        day = n%30 + 1;
        return new EthiopianDate(year,month,day);

    }

    public static LocalDate ToGregorianDate(int year, int month, int day) throws Exception {

        validate(year, month, day);
        int jdn = fromEthiopianDateToJDN(year, month, day);
        return toGregorianDate(jdn);
    }

    public static LocalDate ToGregorianDate(EthiopianDate localDate) throws Exception {
        int year = localDate.getYear();
        int month = localDate.getMonth();
        int day = localDate.getDay();
        validate(year, month, day);
        int jdn = fromEthiopianDateToJDN(year, month, day);
        return toGregorianDate(jdn);
    }

    private static LocalDate toGregorianDate(int jdn)
    {
        int year, month, day;

        int r = jdn + 68569;
        int n = 4*r/146097;

        r = r - (146097*n + 3)/4;
        year = 4000*(r + 1)/1461001;
        r = r - 1461*year/4 + 31;
        month = 80*r/2447;
        day = r - 2447*month/80;
        r = month/11;
        month = month + 2 - 12*r;
        year = 100*(n - 49) + year + r;

        return LocalDate.of(year, month, day);
    }

    private static void validate(int year, int month, int day) throws Exception {
        if (month < 1 || month > 13 || (month == 13 && year % 4 == 3 && day > 6) || (month == 13 && year % 4 != 3 && day > 5) || day < 1 || day > 30)
        {
            throw new Exception("Year, Month, and Day parameters describe an un-representable EthiopianDateTime.");
        }
    }

    private static int fromEthiopianDateToJDN(int year, int month, int day)
    {
        return (JdOffset + 365) + 365 * (year - 1) + year / 4 + 30 * month + day - 31;
    }
}
