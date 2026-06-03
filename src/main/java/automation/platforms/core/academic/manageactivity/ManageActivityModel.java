package automation.platforms.core.academic.manageactivity;

import automation.platforms.base.BaseModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManageActivityModel extends BaseModel {
    public String searchKeyword;
    public String filterName;
    public String filterLabel;
    public String filterOption;

    // Schedule fields
    public String startDate;
    public String endDate;
    public int startHour;
    public int startMinute;
    public int endHour;
    public int endMinute;
    public boolean enableSchedule;

    public ManageActivityModel searchByValidId(){
        searchKeyword = "78";
        return this;
    }

    public ManageActivityModel searchByValidName(){
        searchKeyword = "NSY - Smoketest Activity Platform";
        return this;
    }

    public ManageActivityModel searchByInvalidId(){
        searchKeyword = "000000";
        return this;
    }

    public ManageActivityModel searchByInvalidName(){
        searchKeyword = "#^@*()";
        return this;
    }

    public ManageActivityModel filterByOrganization(){
        filterLabel = "Organisasi Penyedia";
        filterName = "PT. Semesta Integrasi Digital (ID:0)";
        return this;
    }

    public ManageActivityModel filterByContentActivity(){
        filterName = "Konten Aktivitas";
        filterOption = "Audio";
        return this;
    }

    public ManageActivityModel filterByStatus(){
        filterName = "Status";
        filterOption = "Aktif";
        return this;
    }

    // ==================== SCHEDULE BUILDER METHODS ====================

    /**
     * Set schedule with specific start and end dates
     * @param startDate format: "yyyy-MM-dd" or "dd MMMM yyyy" or "dd/MM/yyyy"
     * @param endDate format: "yyyy-MM-dd" or "dd MMMM yyyy" or "dd/MM/yyyy"
     */
    public ManageActivityModel withSchedule(String startDate, String endDate) {
        this.enableSchedule = true;
        this.startDate = startDate;
        this.endDate = endDate;
        return this;
    }

    /**
     * Set schedule with specific dates and times
     */
    public ManageActivityModel withScheduleAndTime(String startDate, int startHour, int startMinute,
                                                    String endDate, int endHour, int endMinute) {
        this.enableSchedule = true;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        return this;
    }

    /**
     * Set schedule relative to today
     * @param startDaysFromToday days from today for start date (positive = future, negative = past)
     * @param endDaysFromToday days from today for end date
     */
    public ManageActivityModel withScheduleRelative(int startDaysFromToday, int endDaysFromToday) {
        this.enableSchedule = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.startDate = LocalDateTime.now().plusDays(startDaysFromToday).format(formatter);
        this.endDate = LocalDateTime.now().plusDays(endDaysFromToday).format(formatter);
        return this;
    }

    /**
     * Set schedule for activity starting today and ending after specified days
     */
    public ManageActivityModel withScheduleFromToday(int durationDays) {
        return withScheduleRelative(0, durationDays);
    }

    /**
     * Set schedule for activity starting tomorrow
     */
    public ManageActivityModel withScheduleFromTomorrow(int durationDays) {
        return withScheduleRelative(1, 1 + durationDays);
    }

    /**
     * Set schedule for next week (7 days from now)
     */
    public ManageActivityModel withScheduleNextWeek() {
        return withScheduleRelative(7, 14);
    }

    /**
     * Set schedule for next month
     */
    public ManageActivityModel withScheduleNextMonth() {
        this.enableSchedule = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.startDate = LocalDateTime.now().plusMonths(1).format(formatter);
        this.endDate = LocalDateTime.now().plusMonths(1).plusDays(7).format(formatter);
        return this;
    }
}