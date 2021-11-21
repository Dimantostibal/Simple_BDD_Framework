package steps;

import actions.WebChecks;
import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AvitoResultPage;
import ru.lanit.at.web.pagecontext.PageManager;

import java.util.List;

public class WindowStepsWithDataTable {

    private PageManager pageManager;
    private final Logger LOGGER = LoggerFactory.getLogger(WindowSteps.class);

    public WindowStepsWithDataTable(PageManager manager) {
        this.pageManager = manager;
    }

    @И("в {string} введено значение:")
    public void searchField(String field, DataTable table) {
        List<String> list = table.asList();
        pageManager
                .getCurrentPage()
                .getElement(field)
                .shouldBe(Condition.visible)
                .setValue(list.get(0));
        LOGGER.info("в поле '{}' введено значение: {}", field, list.get(0));
    }

    @Тогда("в поле {string} введено значение:")
    public void regionField(String field, DataTable table) {
        List<String> list = table.asList();
        pageManager
                .getCurrentPage()
                .getElement(field)
                .shouldBe(Condition.visible)
                .setValue(list.get(2));
        LOGGER.info("в '{}' введено значение: {}", field, list.get(2));
    }

    @Тогда("открылась страница результаты по запросу:")
    public void searchTextOnPage(DataTable table) {
        List<List<String>> list = table.asLists();
        WebChecks.textVisibleOnPage(list.get(1).get(2), 2);
        LOGGER.info("открылась страница '{}' по запросу {}", pageManager.getCurrentPage().name(), list.get(1).get(2));
    }

    @И("в консоль выведено значение названий и цен первых товаров")
    public void priceAndNameOfPrinter(DataTable table) {
        List<String> list = table.asList();
        AvitoResultPage avitoResultPage = new AvitoResultPage();
        for (int i = 1; i <= Integer.parseInt(list.get(3)); i++) {
            LOGGER.info("название принтера '{}' и цена {}", avitoResultPage.getSearchName(i).getText(), avitoResultPage.getProductPrice(i).getAttribute("content"));
        }
    }
}
