package com.sedc.automationpractice.units;

import org.testng.annotations.DataProvider;

public class EndToEndDataProvider {

    @DataProvider(name = "Gender (0 = Mr, 1 = Mrs), Name, LastName, Password, DateOfBirth (dd,mm,yyyy), address, City, State (int), Zip, Number, Quantity, Size")
    public Object[][] getData() {
        Object[][] data = {{0, "Rik", "Rikov", "12345", 14, 12, 1989, "Rudo", "Gostivar", 10, "00120", "+1234567890", "7", "L"}
                /*{0, "Damjan", "Prozor", "Space", 10, 6, 2002, "123", "-2", 2, "07120", "+0123456789", "3", "M"},
                {0, "Rik", "Rikov", "12345", 14, 12, 1989, "Rudo", "Gostivar", 10, "12345", "+1234567890", "7", "L"}*/};
        return data;
    }

}
