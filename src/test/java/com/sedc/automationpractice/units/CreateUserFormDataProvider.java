package com.sedc.automationpractice.units;

import org.testng.annotations.DataProvider;

public class CreateUserFormDataProvider {


    @DataProvider(name = "Gender (0 = Mr, 1 = Mrs), Name, LastName, Password, DateOfBirth (dd,mm,yyyy), address, City, State (int), Zip, Number")
    public Object[][] getData() {
        Object[][] data = {{0, "Rik", "Rikov", "12345", 14, 12, 1989, "Rudo", "Gostivar", 7, "12345", "+1234567890"},
                            {0, "Bre", "Rot", "     ", 10, 6, 2002, "123", "Tetovo", 2, "123456", "+0123456789"}};
        return data;
    }

}
