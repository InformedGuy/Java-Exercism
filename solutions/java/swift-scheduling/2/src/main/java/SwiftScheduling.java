import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwiftScheduling {

    public static LocalDateTime convertToDeliveryDate(LocalDateTime meetingStart, String description) {
        LocalDateTime meetingStartHour = meetingStart.truncatedTo(ChronoUnit.HOURS);
        LocalDateTime morningMeeting = meetingStartHour.withHour(8);

        if (description.endsWith("M")) {
            return getDeliveryMonthDate(morningMeeting, description);
        } else if (description.startsWith("Q")) {
            return getDeliveryQuarterDate(morningMeeting, description);
        }

        return switch (description) {
            case "NOW" -> meetingStart.plusHours(2);

            case "ASAP" -> (meetingStartHour.getHour() < 13) ?
                    meetingStartHour.withHour(17) :
                    meetingStartHour.plusDays(1).withHour(13);

            case "EOW" -> {
                DayOfWeek dayOfWeek = meetingStartHour.getDayOfWeek();

                if (isWeekend(dayOfWeek)) {
                    throw new IllegalArgumentException("Meeting can only be held on weekdays");
                }

                yield (dayOfWeek.compareTo(DayOfWeek.WEDNESDAY) > 0) ?
                        meetingStartHour.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).withHour(20) :
                        meetingStartHour.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withHour(17);
            }

            default -> throw new IllegalArgumentException("Invalid description!");
        };
    }

    private static LocalDateTime getDeliveryMonthDate(LocalDateTime meetingStart, String description) {
        Month meetingMonth = meetingStart.getMonth();
        Month descriptionMonth = Month.of(getNumberFromString(description));

        LocalDateTime firstDayOfMonth = (meetingMonth.compareTo(descriptionMonth) < 0) ?
                meetingStart.withMonth(descriptionMonth.getValue()).with(TemporalAdjusters.firstDayOfMonth()) :
                meetingStart.plusYears(1).withMonth(descriptionMonth.getValue()).with(TemporalAdjusters.firstDayOfMonth());

        return (isWeekend(firstDayOfMonth.getDayOfWeek())) ?
                firstDayOfMonth.with(TemporalAdjusters.next(DayOfWeek.MONDAY)) : firstDayOfMonth;
    }

    private static LocalDateTime getDeliveryQuarterDate(LocalDateTime meetingStart, String description) {
        int meetingQuarter = meetingStart.get(IsoFields.QUARTER_OF_YEAR);
        int descriptionQuarter = getNumberFromString(description);

        LocalDateTime lastDayOfQuarter = (meetingQuarter <= descriptionQuarter) ?
                meetingStart.withMonth(descriptionQuarter * 3).with(TemporalAdjusters.lastDayOfMonth()) :
                meetingStart.plusYears(1).withMonth(descriptionQuarter * 3).with(TemporalAdjusters.lastDayOfMonth());

        return (isWeekend(lastDayOfQuarter.getDayOfWeek())) ?
                lastDayOfQuarter.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)) : lastDayOfQuarter;
    }

    private static int getNumberFromString(String description) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(description);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Must provide number");
        }

        return Integer.parseInt(matcher.group());
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
