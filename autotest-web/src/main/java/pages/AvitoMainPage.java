package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name("Страница авито")
public class AvitoMainPage extends WebPage {

    @Name("список категорий")
    private SelenideElement category = $x("//div[@class='category-select-select-_riJZ select-select-box-jJiQW select-size-s-VX5kS']");

    @Name("оргтехника")
    private SelenideElement  equipment = $x("//option[@data-marker='option(99)']");

    @Name("поле поиска")
    private SelenideElement searchForm = $x("//input[@data-marker='search-form/suggest']");

    @Name("список регионов")
    private SelenideElement buttonLocation = $x("//div[@class='main-text-g_qrO']");

    @Name("региона")
    private SelenideElement inputRegion = $x("//input[@class='suggest-input-rORJM']");

    @Name("показать объявления")
    private SelenideElement buttonShow = $x("//button[@class='button-button-CmK9a button-size-m-LzYrF button-primary-x_x8w']");
}