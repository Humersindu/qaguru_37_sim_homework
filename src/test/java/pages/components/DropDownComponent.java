package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static utils.Constant.CITY_NUMBERS;
import static utils.Constant.DISTRICT_NUMBERS;

public class DropDownComponent {

    public void selectState (int stateNumber) {
        $("#state").click();
        $(DISTRICT_NUMBERS.get(stateNumber)).click();
    }

    public void selectCity (int cityNumber) {
        $("#city").click();
        $(CITY_NUMBERS.get(cityNumber)).click();
    }
}
