package automation.platforms.core.academic.sidemenu;

public enum MenuCoreOptions {

        //menu organization
        MANAGE_ORGANIZATION("organization"),
        MANAGE_ORGANIZATION_STRUCTURE("organizational-structure"),

        //menu academic framework
        MANAGE_BANK_FRAMEWORK("framework"),
        MANAGE_BANK_CLUSTER("cluster"),
        MANAGE_BANK_ELEMENT_MASTER("element/master"),
        MANAGE_BANK_ELEMENT_ORGANIZATION("element/org"),
        MANAGE_BANK_DIMENSION("dimension"),
        MANAGE_BANK_BEHAVIORAL_OBJECTIVE("behavioral-objective"),
        MANAGE_ITEM_ASSESSMENT("item"),

        //menu learning report
        CATEGORY_INTERPRETATION_SCORE("proficiency"),
        MANAGE_ACTIVITY("activity"),
        MANAGE_PROGRAM("program"),

        //menu assessment

        //menu bank content
        MANAGE_BANK_STUDY_CONTENT("content"),
        MANAGE_BANK_ACTIVITY_TYPE("activity-type"),

        //menu manage payment
        MANAGE_METHOD_PAYMENT("payment-configuration/platform-list");

        public final String getValue;
        MenuCoreOptions (String value) {
            this.getValue = value;
        }
}
