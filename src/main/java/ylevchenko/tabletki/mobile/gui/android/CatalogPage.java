package ylevchenko.tabletki.mobile.gui.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.android.components.SearchItem;
import ylevchenko.tabletki.mobile.gui.common.CatalogPageBase;
import ylevchenko.tabletki.mobile.gui.enums.SortingOrder;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_title']")
    ExtendedWebElement searchTitle;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/cl']//*[@resource-id='com.tabletkiua.tabletki:id/main_layout']")
    List<SearchItem> searchItemsList;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_spinner']")
    ExtendedWebElement sortingDropdownBtn;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_spinner'][@text='%s']")
    ExtendedWebElement sortingOption;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_show_more']")
    ExtendedWebElement showMoreBtn;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/tv_select_count']")
    ExtendedWebElement resultsCount;

    LinkedHashSet<Double> pricesSet;

    LinkedHashSet<String> titlesSet;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogPageBase sortBy(SortingOrder order) {
        sortingDropdownBtn.click();
        sortingOption.format(order.getText()).click();
        return initPage(getDriver(), CatalogPageBase.class);
    }

    public List<Double> getPricesSet() {
        pricesSet = new LinkedHashSet<>();
        int resultPages = Integer.parseInt(resultsCount.getText().replaceAll("[^0-9.]", "")) / SEARCH_ITEMS_PER_PAGE;

        for (int i = 0; i < resultPages; i++) {
            for (int j = 0; j < SEARCH_ITEMS_PER_PAGE / 2; j++) {
                pricesSet.addAll(searchItemsList.stream()
                        .map(SearchItem::getPrice)
                        .filter(price -> price != 0)
                        .collect(Collectors.toList()));
                swipeUp(ATTEMPTS_ONE, SWIPE_DURATION_LONG);
            }
            if (showMoreBtn.isVisible(TIMEOUT_SHORT)) {
                showMoreBtn.click();
            }
        }

        return new ArrayList<>(pricesSet);
    }

    public List<String> getTitlesSet() {
        titlesSet = new LinkedHashSet<>();
        int resultPages = Integer.parseInt(resultsCount.getText().replaceAll("[^0-9.]", "")) / SEARCH_ITEMS_PER_PAGE;

        for (int i = 0; i < resultPages; i++) {
            for (int j = 0; j < SEARCH_ITEMS_PER_PAGE / 2; j++) {
                titlesSet.addAll(searchItemsList.stream()
                        .map(SearchItem::getTitle)
                        .filter(item -> !Objects.equals(item, ""))
                        .collect(Collectors.toList()));
                swipeUp(ATTEMPTS_ONE, SWIPE_DURATION_LONG);
                if (showMoreBtn.isVisible(TIMEOUT_SHORT)) {
                    showMoreBtn.click();
                    i++;
                }
            }
        }
        return new ArrayList<>(titlesSet);
    }

    public boolean isSortedBy(SortingOrder order) {
        List<Double> prices;
        List<String> titles;
        switch (order) {
            case PRICE_ASC:
                prices = getPricesSet();
                return IntStream.range(0, prices.size() - 1).
                        allMatch(i -> prices.get(i) <= prices.get(i + 1));
            case PRICE_DESC:
                prices = getPricesSet();
                return IntStream.range(0, prices.size() - 1).
                        allMatch(i -> prices.get(i) >= prices.get(i + 1));
            case ALPHABET_ASC:
                titles = getTitlesSet();
                return IntStream.range(0, titles.size() - 1).
                        allMatch(i -> titles.get(i).compareTo(titles.get(i + 1)) <= 0);
            case ALPHABET_DESC:
                titles = getTitlesSet();
                return IntStream.range(0, titles.size() - 1).
                        allMatch(i -> titles.get(i).compareTo(titles.get(i + 1)) >= 0);
            default:
                return false;
        }
    }

    public String getTitle() {
        return searchTitle.getText();
    }

}
