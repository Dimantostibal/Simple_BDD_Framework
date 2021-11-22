package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Авито результат поиска")
public class AvitoResultPage extends WebPage {

    @Name("чекбокс")
    private SelenideElement checkBoxWithImage = $x("//div[contains(@class, 'filters-root')]/label[2]");

    @Name("список сортировка")
    private SelenideElement sortinList = $x("//div[contains(@class, 'index-topPanel')]/div[2]");

    @Name("Дороже")
    private SelenideElement selectExpensive = $x("//select/option[text() = 'Дороже']");

    public SelenideElement getSearchName(int num) {
        SelenideElement name = $x(String.format("(//h3[@itemprop='name'])[%d]", num));
        return name;
    }

    public SelenideElement getProductPrice(int num) {
        SelenideElement price = $x(String.format("(//span[contains(@class, 'price-text')])[%d]", num));
        return price;
    }
}