package pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Авито результат поиска")
public class AvitoResultPage extends WebPage {

    @Name("чекбокс")
    private SelenideElement checkBoxWithImage = $x("//label[child::input][@style='vertical-align:middle'][2]");

    @Name("список сортировка")
    private SelenideElement sortinList = $x("//div[@class='select-select-box-jJiQW select-size-s-VX5kS']");

    @Name("Дороже")
    private SelenideElement selectExpensive = $x("//select/option[text() = 'Дороже']");

    @Name("значение названия")
    private SelenideElement productName = $x("//h3[@itemprop='name']");

    @Name("цены")
    private SelenideElement productPrice = $x("//span[@class='price-text-E1Y7h text-text-LurtD text-size-s-BxGpL']");

    public SelenideElement getSearchName(int num) {
        SelenideElement name = $x(String.format("(//*[@data-marker='catalog-serp']" +
                "/div/div/div/div/a/h3[@itemprop='name'])[%d]", num));
        return name;
    }

    public SelenideElement getProductPrice(int num) {
        SelenideElement price = $x(String.format("(//*[@data-marker='catalog-serp']" +
                "/div/div/div/div/span/span/meta[@itemprop='price'])[%d]", num));
        return price;
    }
}