package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private static final SelenideElement header = $(".text-center"),
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputName = $("#output").$("#name"),
            outputEmail = $("#output").$("#email"),
            outputCurrentAddress = $("#output").$("#currentAddress"),
            outputPermanentAddress = $("#output").$("#permanentAddress"),
            resultTable = $("#output");




    public TextBoxPage openPage() {
        open("/text-box");
        header.shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setEmail (String email) {
        userEmail.setValue(email);

        return this;
    }

    public TextBoxPage setCurrentAddress (String address) {
        currentAddress.setValue(address);

        return this;
    }

    public TextBoxPage setPermanentAddress (String address) {
        permanentAddress.setValue(address);

        return this;
    }

    public TextBoxPage setName (String name) {
        userName.setValue(name);

        return this;
    }

    public TextBoxPage submitClick () {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkResultForFullFields (String name, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text(name));
        outputEmail.shouldHave(text(email));
        outputCurrentAddress.shouldHave(text(currentAddress));
        outputPermanentAddress.shouldHave(text(permanentAddress));

        return this;
    }

    public TextBoxPage checkResult (String name, String value) {
        resultTable.$$("p").findBy(text(name))
                .shouldHave(text(name + ":" + value));

        return this;
    }
}
