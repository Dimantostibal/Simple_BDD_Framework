package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import enums.Category;
import enums.Sorted;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AvitoResultPage;
import ru.lanit.at.utils.Sleep;
import ru.lanit.at.web.pagecontext.PageManager;

import static com.codeborne.selenide.Selenide.$;

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

//  Для DataTable feature file вместо метода выше

//    @И("в {string} введено значение:")
//    public void searchField(String field, DataTable table) {
//        List<String> list = table.asList();
//        SelenideElement fieldElement = pageManager
//                .getCurrentPage()
//                .getElement(field);
//        fieldElement
//                .shouldBe(Condition.visible)
//                .setValue(list.get(0));
//        LOGGER.info("в поле '{}' введено значение: {}", field, list.get(0));
//    }

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

//  Для DataTable feature file вместо метода выше

//    @Тогда("в поле {string} введено значение:")
//    public void regionField(String field, DataTable table) {
//        List<String> list = table.asList();
//        SelenideElement fieldElement = pageManager
//                .getCurrentPage()
//                .getElement(field);
//        fieldElement
//                .shouldBe(Condition.visible)
//                .setValue(list.get(2));
//        LOGGER.info("в '{}' введено значение: {}", field, list.get(2));
//    }

    @И("подождать {int} секунд" )
    public void expectation(int second){
        Sleep.pauseSec(second);
    }

    @И("нажата кнопка {string}")
    public void clickOnRegionButton(String elementName){
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
//  Для DataTable feature file вместо метода выше

//    @И("в консоль выведено значение названий и цен первых товаров")
//    public void priceAndNameOfPrinter(DataTable table) {
//        List<String> list = table.asList();
//        AvitoResultPage avitoResultPage = new AvitoResultPage();
//        for (int i = 1; i <= Integer.parseInt(list.get(3)); i++) {
//            LOGGER.info("название принтера '{}' и цена {}", avitoResultPage.getSearchName(i).getText(), avitoResultPage.getProductPrice(i).getAttribute("content"));
//        }
//    }

    //------------------------------------------

    /**
     * нажимает на элемент по тексту
     *
     * @param text текст элемента
     */
    @Когда("кликнуть на элемент по тексту {string}")
    public void clickElementWithText(String text) {
        $(Selectors.byText(text))
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент по тексту '{}'", text);
    }

    @Если("кликнуть на элемент {string}")
    public void clickOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент '{}'", elementName);
    }

    /**
     * скролл до элемента
     *
     * @param elementName наименование элемента
     */
    @Когда("проскроллить страницу до элемента {string}")
    public void scrollToElement(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до элемента '{}'", elementName);
    }

    /**
     * скролл до текста
     *
     * @param text текст
     */
    @Когда("проскроллить страницу до текста {string}")
    public void scrollToText(String text) {
        SelenideElement element = $(Selectors.byText(text));
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до текста '{}'", text);
    }

    @И("подождать {int} сек")
    public void waitSeconds(int timeout) {
        Sleep.pauseSec(timeout);
    }

    /**
     * Ввод значения в элемент
     *
     * @param field - наименование элемента
     * @param value - значение
     */
    @Когда("ввести в поле {string} значение {string}")
    public void fillTheField(String field, String value) {
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        fieldElement
                .shouldBe(Condition.visible)
                .setValue(value);
        LOGGER.info("в поле '{}' введено значение '{}'", field, value);
    }

    /**
     * Очистка поля
     *
     * @param elementName наименование элемента
     */
    @Если("очистить поле {string}")
    public void clearFiled(String elementName) {
        pageManager
                .getCurrentPage()
                .getElement(elementName)
                .shouldBe(Condition.visible)
                .clear();
    }
}