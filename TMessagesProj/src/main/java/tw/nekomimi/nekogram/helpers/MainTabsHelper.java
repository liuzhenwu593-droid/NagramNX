package tw.nekomimi.nekogram.helpers;

import org.telegram.ui.MainTabsActivity;

import xyz.nextalone.nagram.NaConfig;

public final class MainTabsHelper {
    public static final int MAIN_TABS_HEIGHT = 56;
    public static final int MAIN_TABS_MARGIN = 8;
    public static final int MAIN_TABS_MARGIN_COMPACT = 4;
    public static final int FILTER_TABS_HEIGHT = 36;
    public static final int TAB_WIDTH = 80;
    public static final int TAB_PADDING = 4;

    private MainTabsHelper() {
    }

    public static boolean isMainTabsHideTitleStyle() {
        return NaConfig.INSTANCE.getMainTabsHideTitles().Bool();
    }

    public static int getMainTabsHeight() {
        return isMainTabsHideTitleStyle() ? FILTER_TABS_HEIGHT : MAIN_TABS_HEIGHT;
    }

    public static int getMainTabsMargin() {
        return isMainTabsHideTitleStyle() ? MAIN_TABS_MARGIN_COMPACT : MAIN_TABS_MARGIN;
    }

    public static int getMainTabsHeightWithMargins() {
        return getMainTabsHeight() + getMainTabsMargin() * 2;
    }

    public static boolean isContactsTabHidden() {
        return NaConfig.INSTANCE.getMainTabsHideContacts().Bool();
    }

    // iOS tab order: Contacts / Calls / Chats / Settings. Profile is not a tab;
    // it lives as the account card at the top of Settings.
    public static int getContactsPosition() {
        return 0;
    }

    public static int getCallsPosition() {
        return isContactsTabHidden() ? 0 : 1;
    }

    public static int getChatsPosition() {
        return isContactsTabHidden() ? 1 : 2;
    }

    public static int getSettingsPosition() {
        return isContactsTabHidden() ? 2 : 3;
    }

    /** @deprecated Calls and Settings are separate tabs now; kept for old callers. */
    public static int getCallsOrSettingsPosition() {
        return getCallsPosition();
    }

    public static int getProfilePosition() {
        return -1;
    }

    public static int getFragmentsCount() {
        return isContactsTabHidden() ? 3 : MainTabsActivity.TABS_COUNT;
    }

    public static int getTabsViewWidth() {
        return TAB_WIDTH * getFragmentsCount() + (getMainTabsMargin() + TAB_PADDING) * 2;
    }
}
