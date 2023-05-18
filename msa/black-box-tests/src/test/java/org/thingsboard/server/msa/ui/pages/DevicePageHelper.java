/**
 * Copyright © 2016-2023 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.msa.ui.pages;

import org.openqa.selenium.WebDriver;

public class DevicePageHelper extends DevicePageElements {
    public DevicePageHelper(WebDriver driver) {
        super(driver);
    }

    private String description;
    private String label;

    public void openDeviceAlarms(String deviceName) {
        if (!deviceDetailsView().isDisplayed()) {
            device(deviceName).click();
        }
        deviceDetailsAlarmsBtn().click();
    }

    public void assignToCustomer(String customerTitle) {
        chooseCustomerForAssignField().click();
        entityFromDropdown(customerTitle).click();
        submitAssignToCustomerBtn().click();
    }

    public void openCreateDeviceView() {
        plusBtn().click();
        addDeviceBtn().click();
    }

    public void enterName(String deviceName) {
        enterText(nameField(), deviceName);
    }

    public void enterDescription(String description) {
        enterText(descriptionFieldCreateField(), description);
    }

    public void enterLabel(String label) {
        enterText(deviceLabelFieldCreate(), label);
    }

    public void deleteDeviceByRightSideBtn(String deviceName) {
        deleteBtn(deviceName).click();
        warningPopUpYesBtn().click();
    }

    public void deleteDeviceFromDetailsTab() {
        deleteBtnDetailsTab().click();
        warningPopUpYesBtn().click();
    }

    public void setDescription() {
        scrollToElement(descriptionEntityView());
        description = descriptionEntityView().getAttribute("value");
    }

    public void setLabel() {
        label = deviceLabelDetailsField().getAttribute("value");
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public void changeDeviceProfile(String deviceProfileName) {
        clearProfileFieldBtn().click();
        entityFromDropdown(deviceProfileName).click();
    }

    public void assignOnCustomer(String customerTitle) {
        customerOptionBtn().click();
        assignOnCustomerField().click();
        entityFromList(customerTitle).click();
        sleep(2); //waiting for the action to count
    }
}
