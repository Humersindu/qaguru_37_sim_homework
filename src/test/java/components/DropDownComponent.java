package components;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
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
        $(byXpath("//*[contains(text(), 'Select State')]")).click();
        $(districtNumbers.get(stateNumber)).click();
    }

    public void selectCity (int cityNymber) {
        $(byXpath("//*[contains(text(), 'Select City')]")).click();
        $(cityNumbers.get(cityNymber)).click();
    }
}
