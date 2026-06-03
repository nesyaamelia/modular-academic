package automation.platforms.core.academic.bankcontent.list;

import automation.config.GlobalVariable;
import automation.config.Host;
import automation.platforms.core.BaseCore;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ListBankContentPage extends BaseCore<ListBankContentLocator> implements ListBankContentSteps {
    @Override
    public void setupLocator() {
        mLocator = new ListBankContentLocator();
    }

    public ListBankContentPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    @Override
    public boolean searchBankContent(ListBankContentModel data){
        element.setText(mLocator.INPUT_SEARCH, data.searchKeyword);
        element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        return element.verifyElementPresent(mLocator.TOTAL_ROW);
    }

    @Override
    public boolean filterByChips(ListBankContentModel data){
        element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.filterByChips(data.filterName));
        element.click(mLocator.getFilterOption(data.filterOption));
        String result = element.getText(mLocator.BUTTON_RESET);
        return result.contains("Reset");
    }

    @Override
    public boolean advancedFilter(ListBankContentModel data){
        element.click(mLocator.BUTTON_FILTER_GENERAL);
        element.handleElementPresent(mLocator.MODAL_FILTER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.advancedFilter(data.filterLabel, data.filterName));
        element.handleElementPresent(mLocator.BUTTON_APPLY, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_APPLY);
        String result = element.getText(mLocator.BUTTON_RESET);
        return result.contains("Reset");
    }

    @Override
    public boolean goToDetailBankContentLearning() {
        element.click(mLocator.BUTTON_DETAIL);
        element.handleElementPresent(mLocator.DETAIL_HEADER, globalVariable.FIVE_SEC_IN_MILLIS);
        String header = element.getText(mLocator.DETAIL_HEADER);
        return header.contains("Detail Konten Belajar");
    }

    @Override
    public boolean viewFileBankContentLearning() {
        String getHref = element.getAttributeFrom(mLocator.URL_FILE, "href");
        return !getHref.isEmpty();
    }

    private boolean isImageAccessible(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();

            int responseCode = connection.getResponseCode();
            String contentType = connection.getContentType();

            return responseCode == 200 && contentType.startsWith("image/");
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public void directUrlToClient() {
        element.navigateToUrl(Host.clientHost() + "admin/content");
        element.verifyElement(mLocator.INPUT_SEARCH);
    }
}
