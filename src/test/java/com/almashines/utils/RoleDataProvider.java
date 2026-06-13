package com.almashines.utils;

import org.testng.annotations.DataProvider;

public class RoleDataProvider {

    @DataProvider(name = "validRoleData")
    public Object[][] validRoleData() {

        return new Object[][] {

                {
                        "Alumni (Past Student)",
                        "2018",
                        "2022"
                }
        };
    }
}