import java.util.Calendar;
import java.util.Scanner;

public class AttendanceCalculator {

    public static int countSundays(int year, int month) {
        int sundayCount = 0;
        Calendar calendar = Calendar.getInstance();
        
        // Iterate through all days of the month
        for (int day = 1; day <= 31; day++) {
            calendar.set(year, month - 1, day);  // month is 0-based in Calendar
            
            // Check if the date is within the correct month
            if (calendar.get(Calendar.MONTH) != month - 1) {
                break;
            }
            
            // Check if the day is a Sunday
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                sundayCount++;
            }
        }
        
        return sundayCount;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input year and month
        System.out.print("Enter year (e.g., 2024): ");
        int year = scanner.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        // Validate month
        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Please enter a number between 1 and 12.");
            return;
        }

        // Calculate the number of Sundays
        int numSundays = countSundays(year, month);

        // Input extra holidays
        System.out.print("Enter number of days of extra holidays like festivals, bunds, or national holidays: ");
        int extraDays = scanner.nextInt();
        System.out.print("Enter number of leave days applied: ");
        int leaves = scanner.nextInt();

        int totalHolidays = numSundays + extraDays;

        // Input periods per day
        System.out.print("Enter number of periods per day: ");
        int periods = scanner.nextInt();

        // Determine the number of days in the month
        int daysInMonth;
        switch (month) {
            case 2:
                daysInMonth = 28;  // Consider leap years if necessary
                break;
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;
            default:
                daysInMonth = 31;
                break;
        }

        int workdays = daysInMonth - totalHolidays;
        int totalPeriods = periods * workdays;

        int studentPresent = workdays - leaves;
        int presentPeriods = studentPresent * periods;

        float attendance = ((float) presentPeriods / totalPeriods) * 100;

        System.out.printf("Your attendance is: %.2f%%\n", attendance);

        scanner.close();
    }
}
