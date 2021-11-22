package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name("Страница авито")
public class AvitoMainPage extends WebPage {

    @Name("список категорий")
    private SelenideElement category = $x("//div[contains(@class, 'category-select-select')]");

    @Name("оргтехника")
    private SelenideElement  equipment = $x("//option[@value = '99']");

    @Name("поле поиска")
    private SelenideElement searchForm = $x("//input[@data-marker='search-form/suggest']");

    @Name("список регионов")
    private SelenideElement buttonLocation = $x("//div[contains(@class, 'main-text')]");

    @Name("региона")
    private SelenideElement inputRegion = $x("//input[contains(@class, 'suggest-input')]");

    @Name("показать объявления")
    private SelenideElement buttonShow = $x("//button[contains(@data-marker, 'popup-location/save-button')]");
}