package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.ru.Если;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.web.pagecontext.Environment;
import ru.lanit.at.web.pagecontext.PageManager;

public class WindowSteps {

    private PageManager pageManager;
    private final Logger LOGGER = LoggerFactory.getLogger(WindowSteps.class);

    public WindowSteps(PageManager manager) {
        this.pageManager = manager;
    }
    /**
     * открывает страницу по ссылке
     *
     * @param url url
     */
    @Если("открыт url {string}")
    public void open(String url) {
        Selenide.open(url);
        WebDriver driver = Environment.getDriver();
        if (driver == null) {
            WebDriver currentThreadWebDriver = WebDriverRunner.getWebDriver();
            Environment.setThreadDriver(currentThreadWebDriver);
        }
        LOGGER.info("init webdriver for thread: {}", Thread.currentThread().getId());
    }
}