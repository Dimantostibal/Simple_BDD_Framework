package steps;

import actions.WebChecks;
import io.cucumber.java.ru.Тогда;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.web.pagecontext.PageManager;

public class WebCheckSteps {

    private PageManager pageManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebCheckSteps.class);

    public WebCheckSteps(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    /**
     * проверка присутствия текста на странице
     *
     * @param text текст
     */
    @Тогда("^открылась страница результаты по запросу \"(.*\\b\\b.*)\"$")
    public void searchTextOnPage(String text) {
        WebChecks.textVisibleOnPage(text, 2);
        LOGGER.info("открылась страница '{}' по запросу '{}'", pageManager.getCurrentPage().name(), text);
    }
}
