import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SearchTest {

    @Owner("APonamareva")
    @DisplayName("Ввод")
    @MethodSource("negativeChecks")
    @ParameterizedTest(name = "{displayName} {0}")
    public void shouldNotSentTest(String type, String searchData, String message){
        step("Открыть страницу", () -> {
            open("http://automationpractice.com/index.php");
        });
        step("Ввести данные в поисковую строку", () -> {
            TestPages.mainPage.mailInput()
                    .setValue(searchData);
            TestPages.mainPage.submitButton()
                    .click();
        });
        step("Проверить, что появилось предупреждение", () -> {
            TestPages.mainPage.invalidMessage()
                    .shouldHave(text(message));
        });
    }

    static Stream<Arguments> negativeChecks() {
        return Stream.of(
                arguments(
                        "пустого значения",
                        "",
                        "Newsletter : Invalid email address."
                ),
                arguments(
                        "чисел",
                        "123",
                        "Newsletter : Invalid email address."
                ),
                arguments(
                        "только букв",
                        "abc",
                        "Newsletter : Invalid email address."
                ),
                arguments(
                        "значения только с @",
                        "test@test",
                        "Newsletter : Invalid email address."
                ),
                arguments(
                        "зарегистрированной почты",
                        "test@test.com",
                        " Newsletter : This email address is already registered."
                )
        );
    }
}
