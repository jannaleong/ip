package others;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter{
    private String date;

    public DateFormatter(String date) {
        this.date = date;
    }

    public Boolean isValidDate() {
        try {
            LocalDate currdate = LocalDate.parse(this.date);
            return true;
        } catch (DateTimeException e) {
            // don't change the date in this case
        }
        return false;
    }

    public String convertDate() {
        LocalDate currdate = LocalDate.parse(this.date);
        return currdate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
}