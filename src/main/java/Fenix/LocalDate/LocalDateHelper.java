package Fenix.LocalDate;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

public class LocalDateHelper {

	public static boolean isinBetweenDates (LocalDate date, YearMonth initYearMonth, YearMonth finalYearMonth) {
		Integer dateMonth = date.getMonthValue();
		Integer dateYear = date.getYear();
		boolean isAfterInitMonth = (dateMonth>=initYearMonth.getMonthValue() && dateYear>=initYearMonth.getYear());
		boolean isBeforeFinalMonth = (dateMonth<=finalYearMonth.getMonthValue() && dateYear<=finalYearMonth.getYear());
		return (isAfterInitMonth && isBeforeFinalMonth);
	}
	
	public static YearMonth toYearMonth (LocalDate date) {
		return YearMonth.of(date.getYear(), date.getMonthValue());
	}

	public static LocalDate returnLatest(LocalDate date1, LocalDate date2 ){
			return (date1.compareTo(date2)>0) ? date1 : date2;

	}
}

