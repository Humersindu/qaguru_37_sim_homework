package pages.components;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class DropDownComponent {

    private final List<String> districtNumbers = List.of (
            "#react-select-3-option-0",
            "#react-select-3-option-1",
            "#react-select-3-option-2",
            "#react-select-3-option-3");

    private final List<String> cityNumbers = List.of (
            "#react-select-4-option-0",
            "#react-select-4-option-1");

    public void selectState (int stateNumber) {
        $("#state").click();
        $(districtNumbers.get(stateNumber)).click();
    }

    public void selectCity (int cityNumber) {
        $("#city").click();
        $(cityNumbers.get(cityNumber)).click();
    }
}
