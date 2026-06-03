package automation.platforms.core.academic.manageactivity.create;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;

public class CreateManageActivityPage extends BaseCore<CreateManageActivityLocator>
        implements CreateManageActivitySteps {
    @Override
    public void setupLocator() {
        mLocator = new CreateManageActivityLocator();
    }

    public CreateManageActivityPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    @Override
    public boolean navigateToCreateManageActivityPage() {
        element.click(mLocator.BUTTON_ADD_NEW_ACTIVITY);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return element.verifyTextPresent("Tambah Aktivitas");
    }

    /* Step 1 */

    @Override
    public boolean tabBasicSetting(CreateManageActivityModel model) {
        fillNameActivity(model);
        fillOrganization(model);
        fillPlatform(model);
        fillCategoryActivity(model);
        fillTypeActivity(model);
        fillContentActivity(model);
        fillDesignerActivity(model);
        fillFacilitatorActivity(model);
        addBehavioralObjective();
        saveManageActivityStep1();
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillNameActivity(CreateManageActivityModel name) {
        element.click(mLocator.INPUT_ACTIVITY_NAME);
        element.setText(mLocator.INPUT_ACTIVITY_NAME, name.nameActivity);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillOrganization(CreateManageActivityModel organization) {
        element.selectDropdown(mLocator.ORGANIZATION_FIELD, organization.organizationActivity, true);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillPlatform(CreateManageActivityModel platform) {
        element.selectDropdown(mLocator.PLATFORM_FIELD, platform.platformActivity, true);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillCategoryActivity(CreateManageActivityModel category) {
        element.selectDropdown(mLocator.CATEGORY_ACTIVITY_FIELD, category.categoryActivity);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillTypeActivity(CreateManageActivityModel type) {
        element.selectDropdown(mLocator.TYPE_ACTIVITY_FIELD, type.typeActivity, true);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillContentActivity(CreateManageActivityModel content) {
        element.selectDropdown(mLocator.CONTENT_ACTIVITY_FIELD, content.contentActivity, false);
        element.clickBlankSpace();
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillDesignerActivity(CreateManageActivityModel designer) {
        element.selectDropdown(mLocator.DESIGNER_ACTIVITY_FIELD, designer.designerActivity, true);
        element.clickBlankSpace();
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillFacilitatorActivity(CreateManageActivityModel facilitator) {
        element.selectDropdown(mLocator.FACILITATOR_ACTIVITY_FIELD, facilitator.facilitatorActivity, true);
        element.clickBlankSpace();
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean addBehavioralObjective() {
        element.click(mLocator.BUTTON_ADD_BO);
        element.handleElementPresent(mLocator.MODAL_ADD_BEHAVIOR, GlobalVariable.THREE_SEC_IN_MILLIS);
        element.click(mLocator.SELECT_BEHAVIOR);
        element.click(mLocator.BUTTON_SAVE_BO);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean saveManageActivityStep1() {
        element.setDelay(5000);
        element.click(mLocator.BUTTON_SAVE);

        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TITLE_STEP_GENERAL_SETTING, GlobalVariable.FIVE_SEC_IN_MILLIS))
                return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, GlobalVariable.FIVE_SEC_IN_MILLIS))
                return false;
        }
        return false;
    }

    /* Step 2 */

    @Override
    public boolean tabGeneralSetting(CreateManageActivityModel model) {
        toggleActivityDsicussion();
        fillEstimatedActivityDuration(model);
        toggleLockedActivity();
        fillGroupsActivity(model);
        fillQuotaActivity(model);
        fillScheduleActivity(model);
        saveManageActivityStep2();
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean toggleActivityDsicussion() {
        element.scrollToElement(mLocator.TOGGLE_DISCUSSION_ACTIVITY);
        element.click(mLocator.TOGGLE_DISCUSSION_ACTIVITY);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillEstimatedActivityDuration(CreateManageActivityModel duration) {
        element.click(mLocator.INPUT_ESTIMATED_ACTIVITY_DURATION);
        element.setText(mLocator.INPUT_ESTIMATED_ACTIVITY_DURATION, duration.durationActivity);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean toggleLockedActivity() {
        element.scrollToElement(mLocator.TOGGLE_LOCKED_ACTIVITY);
        element.click(mLocator.TOGGLE_LOCKED_ACTIVITY);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillGroupsActivity(CreateManageActivityModel groups) {
        element.selectDropdown(mLocator.GROUPS_ACTIVITY_FIELD, groups.groupActivity);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillQuotaActivity(CreateManageActivityModel quota) {
        element.selectDropdown(mLocator.QUOTA_ACTIVITY_FIELD, quota.quotaActivity);
        element.clickBlankSpace();
        if (quota.quotaActivity != null && quota.quotaActivity.equalsIgnoreCase("Terbatas")) {
            element.handleElementPresent(mLocator.INPUT_QUOTA_VALUE, GlobalVariable.THREE_SEC_IN_MILLIS);
            if (quota.quotaValue != null && !quota.quotaValue.isEmpty()) {
                element.click(mLocator.INPUT_QUOTA_VALUE);
                element.setText(mLocator.INPUT_QUOTA_VALUE, quota.quotaValue);
            }
        }
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillScheduleActivity(CreateManageActivityModel schedule) {
        element.click(mLocator.SCHEDULE_ACTIVITY_FIELD);
        element.setDelay(GlobalVariable.FIVE_SEC_IN_MILLIS);
        element.selectDate(mLocator.INPUT_START_DATE, schedule.startDateActivity);
        element.selectDate(mLocator.INPUT_END_DATE, schedule.endDateActivity);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean saveManageActivityStep2() {
        element.setDelay(5000);
        element.click(mLocator.BUTTON_SAVE);

        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TITLE_STEP_CONTENT_SETTING, GlobalVariable.FIVE_SEC_IN_MILLIS))
                return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, GlobalVariable.FIVE_SEC_IN_MILLIS))
                return false;
        }
        return false;
    }

    /* Step 3 */
    @Override
    public boolean fillContent(CreateManageActivityModel content) {
        element.selectDropdown(mLocator.CONTENT_FIELD, content.content, false);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillSourceContent(CreateManageActivityModel source) {
        element.selectDropdown(mLocator.SOURCE_CONTENT_FIELD, source.sourceContent);
        element.setDelay(GlobalVariable.THREE_SEC_IN_MILLIS);

        if (source.sourceContent != null && source.sourceContent.equalsIgnoreCase("Ambil dari Bank Konten")) {
            element.handleElementPresent(mLocator.ADD_CONTENT_FROM_BANK_FIELD, GlobalVariable.FIVE_SEC_IN_MILLIS);
            element.click(mLocator.ADD_CONTENT_FROM_BANK_FIELD);
            element.handleElementPresent(mLocator.MODAL_BANK_CONTENT, GlobalVariable.FIVE_SEC_IN_MILLIS);
            element.click(mLocator.SELECT_BANK_CONTENT);
            element.click(mLocator.BUTTON_SELECT_BANK_CONTENT);
            element.handleElementPresent(mLocator.INSTRUCTION_FOR_PARTICIPANTS_FIELD,
                    GlobalVariable.THREE_SEC_IN_MILLIS);
            element.click(mLocator.INSTRUCTION_FOR_PARTICIPANTS_FIELD);
            element.setText(mLocator.INSTRUCTION_FOR_PARTICIPANTS_FIELD, source.instructionContent);
        } else if (source.sourceContent != null && source.sourceContent.equalsIgnoreCase("Buat konten baru")) {
            element.handleElementPresent(mLocator.UPLOAD_CONTENT_FIELD, GlobalVariable.FIVE_SEC_IN_MILLIS);
            element.dropFile(mLocator.UPLOAD_CONTENT_FIELD, source.fileContent);
            element.handleElementPresent(mLocator.INSTRUCTION_FOR_PARTICIPANTS_FIELD,
                    GlobalVariable.THREE_SEC_IN_MILLIS);
            element.setText(mLocator.INSTRUCTION_FOR_PARTICIPANTS_FIELD, source.instructionContent);
        }
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean saveManageActivityStep3() {
        element.setDelay(5000);
        element.click(mLocator.BUTTON_SAVE);

        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TITLE_STEP_REPORT_SETTING, GlobalVariable.FIVE_SEC_IN_MILLIS))
                return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, GlobalVariable.FIVE_SEC_IN_MILLIS))
                return false;
        }
        return false;
    }

    /* Step 4 */
    @Override
    public boolean fillReportActivity(CreateManageActivityModel report) {
        element.click(mLocator.USE_REPORT_ACTIVITY_TOGGLE);
        element.selectDropdown(mLocator.LEARNING_REPORT_FACILITATOR, report.facilitatorReport, true);
        element.clickBlankSpace();
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillCertificateActivity(CreateManageActivityModel certificate) {
        element.click(mLocator.USE_CERTIFICATE_TOGGLE);
        element.selectDropdown(mLocator.CERTIFICATE_TEMPLATE, certificate.certificateTemplate);
        element.clickBlankSpace();
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean saveManageActivityStep4() {
        element.setDelay(5000);
        element.click(mLocator.BUTTON_SAVE);

        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TITLE_STEP_OPERATIONAL_SETTING,
                    GlobalVariable.FIVE_SEC_IN_MILLIS))
                return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, GlobalVariable.FIVE_SEC_IN_MILLIS))
                return false;
        }
        return false;
    }

    /* Step 5 */

    @Override
    public boolean tabOperationalSetting(CreateManageActivityModel model) {
        fillPaidActivity(model);
        fillMarketingActivity(model);
        fillDetailPlatform(model);
        fillOrganizationAndFacilitator(model);
        fillParticipantDetails(model);
        fillNotification(model);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillPaidActivity(CreateManageActivityModel paid) {
        element.click(mLocator.PAID_ACTIVITIES_TOGGLE);
        element.click(mLocator.ABOUT_ACTIVITY);
        element.setText(mLocator.ABOUT_ACTIVITY, paid.aboutActivity);
        element.click(mLocator.ACTIVITY_SELLING_PRICE);
        element.setText(mLocator.ACTIVITY_SELLING_PRICE, paid.sellingPriceActivity);
        element.click(mLocator.ACTIVITY_CROSSOUT_PRICE);
        element.setText(mLocator.ACTIVITY_CROSSOUT_PRICE, paid.crossoutPriceActivity);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillMarketingActivity(CreateManageActivityModel marketing) {
        element.selectDropdown(mLocator.ACTIVITY_COVER_FIELD, marketing.activityCover);
        element.dropFile(mLocator.UPLOAD_IMAGE, marketing.coverImage);
        element.click(mLocator.TEASER_TOGGLE);
        element.dropFile(mLocator.UPLOAD_IMAGE, marketing.teaserImage);
        element.dropFile(mLocator.UPLOAD_VIDEO, marketing.teaserVideo);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillDetailPlatform(CreateManageActivityModel tags) {
        element.scrollToElement(mLocator.SELECT_PAID_PLATFORM);
        element.selectDropdown(mLocator.SELECT_PAID_PLATFORM, tags.paidPlatformActivity, true);
        element.click(mLocator.BUTTON_ADD_PAID_PLATFORM);
        element.scrollToElement(mLocator.TAG_ACTIVITY);
        element.setText(mLocator.TAG_ACTIVITY, tags.tagActivity);
        element.sendKeys(mLocator.TAG_ACTIVITY, "Enter");
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillOrganizationAndFacilitator(CreateManageActivityModel details) {
        element.scrollToElement(mLocator.ABOUT_ORGANIZATION);
        element.setText(mLocator.ABOUT_ORGANIZATION, details.aboutOrganization);
        element.setText(mLocator.ABOUT_FACILITATOR, details.aboutFacilitator);
        element.click(mLocator.SHOW_FACILITATOR_TOGGLE);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillParticipantDetails(CreateManageActivityModel participant) {
        element.scrollToElement(mLocator.PARTICIPANT_CHARACTERISTICS);
        element.setText(mLocator.PARTICIPANT_CHARACTERISTICS, participant.characteristicParticipants);
        element.click(mLocator.LIMIT_PARTICIPANTS_TOGGLE);
        element.selectDropdown(mLocator.LIMIT_USER_GROUP, participant.userGroups, true);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillNotification(CreateManageActivityModel notification) {
        element.scrollToElement(mLocator.NOTIFICATION_OF_PARTICIPANT_ACTIVITY_TOGGLE);
        element.click(mLocator.NOTIFICATION_OF_PARTICIPANT_ACTIVITY_TOGGLE);
        element.scrollToElement(mLocator.EMAIL_PERSONALIZATION_TOGGLE);
        element.click(mLocator.EMAIL_PERSONALIZATION_TOGGLE);
        element.setText(mLocator.EMAIL_SUBJECT, notification.emailSubject);
        element.setText(mLocator.EMAIL_MESSAGE, notification.emailMessage);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean saveManageActivityStep5() {
        element.setDelay(5000);
        element.click(mLocator.BUTTON_SAVE);
        element.handleElementPresent(mLocator.POPUP_SAVE_ACTIVITY, GlobalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_SAVE_POPUP);

        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TOAST_SUCCESS, GlobalVariable.FIVE_SEC_IN_MILLIS))
                return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, GlobalVariable.FIVE_SEC_IN_MILLIS))
                return false;
        }
        return false;
    }
}