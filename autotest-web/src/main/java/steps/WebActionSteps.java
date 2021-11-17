package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.Category;
import enums.Sorted;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AvitoResultPage;
import ru.lanit.at.web.pagecontext.Environment;
import ru.lanit.at.web.pagecontext.PageManager;
import ru.lanit.at.web.pagecontext.WebPage;

public class WebActionSteps {
    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebActionSteps.class);

    public WebActionSteps(PageManager manager) {
        this.pageManager = manager;
    }

    @ParameterType(".*")
    public Category category(String categoryName) {
        return Category.valueOf(categoryName.toUpperCase());
    }

    @Когда("инициализация страницы {string}")
    public void setPage(String pageName) {
        WebPage page = Environment.getPage(pageName);
        pageManager.setCurrentPage(page);
    }

    @И("в выпадающем {string} выбрана {category}")
    public void selectCategory(String elementName, Category category) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible).click();
        SelenideElement element2 = pageManager
                .getCurrentPage()
                .getElement(category.getName());
        element2.shouldBe(Condition.visible).click();
        LOGGER.info("в выпадающем '{}' выбрана '{}'", elementName, category);
    }

    @И("в {string} введено значение {string}")
    public void searchField(String field, String value) {
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        fieldElement
                .shouldBe(Condition.visible)
                .setValue(value);
        LOGGER.info("в поле '{}' введено значение '{}'", field, value);
    }

    @Тогда("кликнуть по выпадающему {string}")
    public void clickOnRegion(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик по '{}'", elementName);
    }

    @Тогда("в поле {string} введено значение {string}")
    public void regionField(String field, String value) {
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        fieldElement
                .shouldBe(Condition.visible)
                .setValue(value);
        LOGGER.info("в '{}' введено значение '{}'", field, value);
    }

    @И("нажата кнопка {string}")
    public void clickOnRegionButton(String elementName) throws InterruptedException {
        Thread.sleep(3000);
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик по '{}'", elementName);
    }

    @И("активирован {string} только с фотографией")
    public void clickOnCheckbox(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик по '{}' только с фотографией", elementName);
    }

    @ParameterType(".*")
    public Sorted sorted(String sortedValue) {
        return Sorted.valueOf(sortedValue.toUpperCase());
    }

    @И("в выпадающем {string} выбрано значение {sorted}")
    public void selectSortedList(String elementName, Sorted sorted) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible).click();
        SelenideElement element2 = pageManager
                .getCurrentPage()
                .getElement(sorted.getValue());
        element2.shouldBe(Condition.visible).click();
        LOGGER.info("в выпадающем '{}' выбрано значение '{}'", elementName, sorted);
    }

    @И("в консоль выведено значение названий и цен {int} первых товаров")
    public void priceAndNameOfPrinter(int num) {
        AvitoResultPage avitoResultPage = new AvitoResultPage();
        for (int i = 1; i <= num; i++) {
            LOGGER.info("название принтера '{}' и цена {}", avitoResultPage.getSearchName(i).getText(), avitoResultPage.getProductPrice(i).getAttribute("content"));
        }
    }
}