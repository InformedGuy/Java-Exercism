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
        LocalDateTime meetingStartTruncated = meetingStart.truncatedTo(ChronoUnit.HOURS);

        return switch (description) {
            case "NOW" -> meetingStart.plusHours(2);

            case "ASAP" -> {
                if (meetingStartTruncated.getHour() < 13) {
                    yield meetingStartTruncated.withHour(17);
                }

                yield meetingStartTruncated.plusDays(1).withHour(13);
            }

            case "EOW" -> {
                DayOfWeek dayOfWeek = meetingStartTruncated.getDayOfWeek();

                if (dayOfWeek.compareTo(DayOfWeek.FRIDAY) <= 0) {
                    if (dayOfWeek.compareTo(DayOfWeek.WEDNESDAY) > 0) {
                        yield meetingStartTruncated.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).withHour(20);
                    }
                    yield meetingStartTruncated.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withHour(17);
                }
                throw new IllegalArgumentException("Meeting can only be held on weekdays");
            }

            default -> convertVariableDescriptions(meetingStartTruncated.withHour(8), description);
        };
    }

    private static LocalDateTime convertVariableDescriptions(LocalDateTime meetingStart, String description) {
        if (description.endsWith("M")) {
            Month meetingMonth = meetingStart.getMonth();
            Month descriptionMonth = Month.of(getNumberFromString(description));

            LocalDateTime firstDayOfMonth = meetingStart.withMonth(descriptionMonth.getValue()).with(TemporalAdjusters.firstDayOfMonth());

            if (meetingMonth.compareTo(descriptionMonth) < 0) {
                return getFirstWorkingDayOfTheMonth(firstDayOfMonth);
            }

            return getFirstWorkingDayOfTheMonth(firstDayOfMonth.plusYears(1));
        }

        int meetingQuarter = meetingStart.get(IsoFields.QUARTER_OF_YEAR);
        int descriptionQuarter = getNumberFromString(description);

        LocalDateTime lastMonthOfQuarter = meetingStart.withMonth(descriptionQuarter * 3).with(TemporalAdjusters.lastDayOfMonth());

        if (meetingQuarter <= descriptionQuarter) {
            return getLastWorkingDayOfTheQuarter(lastMonthOfQuarter);
        }

        return getLastWorkingDayOfTheQuarter(lastMonthOfQuarter.plusYears(1));

    }

    private static int getNumberFromString(String description) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(description);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Must provide number");
        }

        return Integer.parseInt(matcher.group());
    }

    private static LocalDateTime getFirstWorkingDayOfTheMonth(LocalDateTime deliveryTime) {
        DayOfWeek dayOfWeek = deliveryTime.getDayOfWeek();

        if (isWeekend(dayOfWeek)) {
            return deliveryTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }

        return deliveryTime;
    }

    private static LocalDateTime getLastWorkingDayOfTheQuarter(LocalDateTime deliveryTime) {
        DayOfWeek dayOfWeek = deliveryTime.getDayOfWeek();

        if (isWeekend(dayOfWeek)) {
            return deliveryTime.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }

        return deliveryTime;
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
