package automation.platforms.core.academic.manageactivity.create;

import automation.platforms.base.BaseLocator;

public class CreateManageActivityLocator extends BaseLocator {
    public final String INPUT_ACTIVITY_NAME = "#activity-name-input";
    public final String ORGANIZATION_FIELD = "#activity-organization-dropdown";
    public final String PLATFORM_FIELD = "#activity-platform-dropdown";
    public final String CATEGORY_ACTIVITY_FIELD = "#activity-category-dropdown";
    public final String BUTTON_ADD_NEW_ACTIVITY = "#create-activity-type-btn";
    public final String BUTTON_SAVE = "#next-or-save-create-btn";
    public final String INPUT_ORGANIZATION = "#//span[text()= 'Lembaga QA 1 (ID: 437)']";
    public final String TYPE_ACTIVITY_FIELD = "#activity-type-dropdown";
    public final String CONTENT_ACTIVITY_FIELD = "#activity-content-type-dropdown";
    public final String DESIGNER_ACTIVITY_FIELD = "#activity-designer-dropdown";
    public final String FACILITATOR_ACTIVITY_FIELD = "#activity-facilitator-dropdown";
    public final String PIC_ACTIVITY_FIELD = "#activity-pic-dropdown";
    public final String BUTTON_ADD_BO = "#add-bo-button";
    public final String SELECT_BEHAVIOR = "(//table//tbody//label[contains(@class, 'cursor-pointer')]/span)[1] ";
    public final String MODAL_ADD_BEHAVIOR = "//div[text()='Daftar Behavioral Objective']";
    public final String BUTTON_SAVE_BO = "#modal-primary-button";
    public final String TOAST_SUCCESS = "//*[contains(text(),'Aktivitas berhasil ditambahkan.')]";
    public final String ALERT_ERROR = "//img[contains(@src,'error.svg')]";
    public final String TITLE_STEP_GENERAL_SETTING = "#content-list-general-general-content-list";
    public final String TOGGLE_DISCUSSION_ACTIVITY = "label#activity-general-discussion-toggle";
    public final String INPUT_ESTIMATED_ACTIVITY_DURATION = "#activity-general-duration";
    public final String TOGGLE_LOCKED_ACTIVITY = "label#activity-general-locked-toggle";
    public final String GROUPS_ACTIVITY_FIELD = "#activity-general-group-dropdown";
    public final String QUOTA_ACTIVITY_FIELD = "#activity-general-capacity-type";
    public final String INPUT_QUOTA_VALUE = "#activity-general-quota";
    public final String SCHEDULE_ACTIVITY_FIELD = "label#activity-schedule-toggle";
    public final String INPUT_START_DATE = "#activity-schedule-start-date";
    public final String INPUT_END_DATE = "#activity-schedule-end-date";
    public final String CONTENT_FIELD = "#content-availability-dropdown";
    public final String SOURCE_CONTENT_FIELD = "#data-source-dropdown";
    public final String ADD_CONTENT_FROM_BANK_FIELD = "#select-bank-button";
    public final String UPLOAD_CONTENT_FIELD = "#input-file-document";
    public final String MODAL_BANK_CONTENT = "#content-bank-modal";
    public final String SELECT_BANK_CONTENT = "(//table//tbody//label[contains(@class, 'cursor-pointer')]/span)[1]";
    public final String BUTTON_SELECT_BANK_CONTENT = "#modal-primary-button";
    public final String INSTRUCTION_FOR_PARTICIPANTS_FIELD = "//div[@role='textbox']";
    public final String TITLE_STEP_CONTENT_SETTING = "#content-list-content-content-content-list";
    public final String TITLE_STEP_REPORT_SETTING = "#content-list-report-report-content-list";
    public final String USE_REPORT_ACTIVITY_TOGGLE = "label#form-use-activity-report";
    public final String LEARNING_REPORT_FACILITATOR = "#form-pic-report";
    public final String USE_CERTIFICATE_TOGGLE = "label#form-use-certificate";
    public final String CERTIFICATE_TEMPLATE = "#form-certificate-template";
    public final String TITLE_STEP_OPERATIONAL_SETTING = "#content-list-operational-paid_activity-content-list";
    public final String PAID_ACTIVITIES_TOGGLE = "label#activity-paid-is_paid";
    public final String ABOUT_ACTIVITY = "#activity-paid-about";
    public final String ACTIVITY_SELLING_PRICE = "#activity-paid-original-price";
    public final String ACTIVITY_CROSSOUT_PRICE = "#activity-paid-discounted-price";
    public final String ACTIVITY_COVER_FIELD = "#activity-paid-cover";
    public final String UPLOAD_IMAGE = "#input-file-image";
    public final String UPLOAD_VIDEO = "#input-file-video";
    public final String TEASER_TOGGLE = "label#activity-paid-has_teaser";
    public final String SELECT_PAID_PLATFORM = "#activity-paid-platform";
    public final String BUTTON_ADD_PAID_PLATFORM = "#activity-paid-add-platform";
    public final String TAG_ACTIVITY = "#input-activity-paid-tags";
    public final String ABOUT_ORGANIZATION = "(//textarea[@id='activity-organizer-about'])[1]";
    public final String ABOUT_FACILITATOR = "(//textarea[@id='activity-organizer-about'])[2]";
    public final String SHOW_FACILITATOR_TOGGLE = "label#activity-organizer-showFacilitator";
    public final String PARTICIPANT_CHARACTERISTICS = "#activity-participant-characteristic";
    public final String LIMIT_PARTICIPANTS_TOGGLE = "label#activity-participant-limited";
    public final String LIMIT_USER_GROUP = "#activity-participant-limited-by-user-group";
    public final String NOTIFICATION_OF_PARTICIPANT_ACTIVITY_TOGGLE = "label#activity-notification-added";
    public final String EMAIL_PERSONALIZATION_TOGGLE = "label#activity-notification-customEmail";
    public final String EMAIL_SUBJECT = "#activity-notification-email-subject";
    public final String EMAIL_MESSAGE = "//div[@role='textbox']";
    public final String POPUP_SAVE_ACTIVITY = "#popup-submit-activity";
    public final String BUTTON_SAVE_POPUP = "(//button[@id='popup-submit-button'])[4]";

    public String selectContent(String content){
        return "//span[text()= '"+content+"']";
    }

    public String selectSourceContent(String source){
        return "//span[text()= '"+source+"']";
    }
}
