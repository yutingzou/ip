import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Task {
    private String description;
    private boolean isDone;
    protected String separator = " | ";
    protected LocalDateTime dateTime;

    public Task(String description) {
        this(description, false);
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.dateTime = null;
        this.isDone = isDone;
    }

    public Task(String description, String dateTime, boolean isDone) {
        this.description = description;
        this.dateTime = convertToTime(dateTime);
        this.isDone = isDone;
    }

    private String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public String getDescription() {
        return this.description;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public boolean isSameDay(LocalDate targetDate) {
//        return this.dateTime.truncatedTo(ChronoUnit.DAYS).isEqual(targetDate.truncatedTo(ChronoUnit.DAYS));
            return this.dateTime.toLocalDate().isEqual(targetDate);
//        }
//        return this.dateTime.isEqual(targetDate.truncatedTo(ChronoUnit.DAYS));
    }

    private LocalDateTime convertToTime(String time) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-M-d H:mm");
        LocalDateTime dateTime = LocalDateTime.parse(time, inputFormat);
        return dateTime;
    }

    @Override
    public String toString() {
        return this.getStatusIcon() + separator + this.getDescription();
    }
}