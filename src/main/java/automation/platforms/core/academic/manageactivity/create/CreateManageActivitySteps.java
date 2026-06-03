package automation.platforms.core.academic.manageactivity.create;

import automation.platforms.base.BaseSteps;

public interface CreateManageActivitySteps extends BaseSteps {
    boolean navigateToCreateManageActivityPage();

    boolean tabBasicSetting(CreateManageActivityModel model);

    boolean fillNameActivity(CreateManageActivityModel name);

    boolean fillOrganization(CreateManageActivityModel organization);

    boolean fillPlatform(CreateManageActivityModel platform);

    boolean fillCategoryActivity(CreateManageActivityModel category);

    boolean fillTypeActivity(CreateManageActivityModel type);

    boolean fillContentActivity(CreateManageActivityModel content);

    boolean fillDesignerActivity(CreateManageActivityModel designer);

    boolean fillFacilitatorActivity(CreateManageActivityModel facilitator);

    boolean addBehavioralObjective();

    boolean saveManageActivityStep1();

    boolean tabGeneralSetting(CreateManageActivityModel model);

    boolean toggleActivityDsicussion();

    boolean fillEstimatedActivityDuration(CreateManageActivityModel duration);

    boolean toggleLockedActivity();

    boolean fillGroupsActivity(CreateManageActivityModel groups);

    boolean fillQuotaActivity(CreateManageActivityModel quota);

    boolean fillScheduleActivity(CreateManageActivityModel schedule);

    boolean saveManageActivityStep2();

    /* Step 3 */
    boolean fillContent(CreateManageActivityModel content);

    boolean fillSourceContent(CreateManageActivityModel source);

    boolean saveManageActivityStep3();

    /* Step 4 */
    boolean fillReportActivity(CreateManageActivityModel report);

    boolean fillCertificateActivity(CreateManageActivityModel certificate);

    boolean saveManageActivityStep4();

    boolean tabOperationalSetting(CreateManageActivityModel model);

    /* Step 5 */
    boolean fillPaidActivity(CreateManageActivityModel paid);

    boolean fillMarketingActivity(CreateManageActivityModel marketing);

    boolean fillDetailPlatform(CreateManageActivityModel tags);

    boolean fillOrganizationAndFacilitator(CreateManageActivityModel details);

    boolean fillParticipantDetails(CreateManageActivityModel participant);

    boolean fillNotification(CreateManageActivityModel notification);

    boolean saveManageActivityStep5();
}
