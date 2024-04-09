package lab_20240408.level1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateRange {
    private final Calendar startDate;
    private final Calendar endDate;

    public DateRange(Calendar startDate, Calendar endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isInRange(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return startDate.before(cal) && endDate.after(cal);
    }

    public Calendar getStartDate() {
        return (Calendar) startDate.clone();
    }

    public Calendar getEndDate() {
        return (Calendar) endDate.clone();
    }

    @Override
    public String toString() {
        String format = "MM/dd/yyyy";
        SimpleDateFormat sdf =new SimpleDateFormat(format);

        Date sDate = startDate.getTime();
        Date eDate = endDate.getTime();

        return String.format("%s - %s", sdf.format(sDate), sdf.format(eDate));
    }

    public static int getFirstDayOfMonth(Date date) {
        Date firstDate = new Date(date.getYear(), date.getMonth(), 1);

        return firstDate.getDate();
    }

    public static int getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();

        cal.set(date.getYear(), date.getMonth(), 1);

        return cal.getActualMinimum(Calendar.DAY_OF_MONTH);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !obj.getClass().getName().equals(DateRange.class.getName())) return  false;
        DateRange r = (DateRange) obj;

        return startDate.equals(((DateRange) obj).startDate) && endDate.equals(((DateRange) obj).endDate);
    }
}
