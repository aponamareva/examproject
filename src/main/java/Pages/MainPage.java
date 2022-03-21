package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement cardButton() {
        return $("[data-id-product='2']").as("кнопка добавления в корзину");
    }

    public SelenideElement successWindow() {
        return $(".layer_cart_product").as("модалка успешного добавления");
    }

    public SelenideElement continueButton() {
        return $(".button-container .continue").as("кнопка продолжения шоппинга");
    }

    public SelenideElement mailInput() {
        return $("#newsletter-input").as("инпут ввода почты");
    }

    public SelenideElement submitButton() {
        return $("[name='submitNewsletter']").as("кнопка отправки");
    }

    public SelenideElement invalidMessage() {
        return $(".alert-danger").as("уведомление об ошибке");
    }
}
