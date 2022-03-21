import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class CardTest {

    @Test
    @Owner("APonamareva")
    @Feature("Корзина")
    @DisplayName("Добавление в корзину")
    public void shouldAddCardTest() {
        open("http://automationpractice.com/index.php");
        getWebDriver().manage().window().setSize(new Dimension(1073,673));
        step("Добавить товар в корзину", () -> {
            TestPages.mainPage.cardButton()
                    .click();
            TestPages.mainPage.successWindow()
                    .shouldBe(visible);
        });
        step("Продолжить шоппинг", () -> {
            TestPages.mainPage.continueButton()
                    .click();
            TestPages.mainPage.successWindow()
                    .shouldNotBe(visible);
        });
    }
}
