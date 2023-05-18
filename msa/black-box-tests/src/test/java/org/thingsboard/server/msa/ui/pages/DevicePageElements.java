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
import org.openqa.selenium.WebElement;

public class DevicePageElements extends OtherPageElementsHelper {
    public DevicePageElements(WebDriver driver) {
        super(driver);
    }

    private static final String DEVICE = "//table//span[text()='%s']";
    private static final String DEVICE_DETAILS_VIEW = "//tb-details-panel";
    private static final String DEVICE_DETAILS_ALARMS = DEVICE_DETAILS_VIEW + "//span[text()='Alarms']";
    private static final String ASSIGN_TO_CUSTOMER_BTN = "//mat-cell[contains(@class,'name')]/span[text()='%s']" +
            "/ancestor::mat-row//mat-icon[contains(text(),'assignment_ind')]/parent::button";
    private static final String CHOOSE_CUSTOMER_FOR_ASSIGN_FIELD = "//input[@formcontrolname='entity']";
    private static final String ENTITY_FROM_DROPDOWN = "//div[@role = 'listbox']//span[text() = '%s']";
    private static final String CLOSE_DEVICE_DETAILS_VIEW = "//header//mat-icon[contains(text(),'close')]/parent::button";
    private static final String SUBMIT_ASSIGN_TO_CUSTOMER_BTN = "//button[@type='submit']";
    private static final String ADD_DEVICE_BTN = "//mat-icon[text() = 'insert_drive_file']/parent::button";
    private static final String CREATE_DEVICE_NAME_FIELD = "//tb-device-wizard//input[@formcontrolname='name']";
    private static final String HEADER_NAME_VIEW = "//header//div[@class='tb-details-title']/span";
    private static final String DESCRIPTION_FIELD_CREATE_VIEW = "//tb-device-wizard//textarea[@formcontrolname='description']";
    private static final String ADD_DEVICE_VIEW = "//tb-device-wizard";
    private static final String DELETE_BTN_DETAILS_TAB = "//span[contains(text(),'Delete device')]/parent::button";
    private static final String CHECKBOX_GATEWAY_EDIT = "//mat-checkbox[@formcontrolname='gateway']//label";
    private static final String CHECKBOX_GATEWAY_CREATE = "//tb-device-wizard//mat-checkbox[@formcontrolname='gateway']//label";
    private static final String CHECKBOX_OVERWRITE_ACTIVITY_TIME_EDIT = "//mat-checkbox[@formcontrolname='overwriteActivityTime']//label";
    private static final String CHECKBOX_OVERWRITE_ACTIVITY_TIME_CREATE = "//tb-device-wizard//mat-checkbox[@formcontrolname='overwriteActivityTime']//label";
    private static final String CHECKBOX_GATEWAY_DETAILS = "//mat-checkbox[@formcontrolname='gateway']//input";
    private static final String CHECKBOX_GATEWAY_PAGE = DEVICE + "/ancestor::mat-row//mat-cell[contains(@class,'cdk-column-gateway')]//mat-icon[text() = 'check_box']";
    private static final String CHECKBOX_OVERWRITE_ACTIVITY_TIME_DETAILS = "//mat-checkbox[@formcontrolname='overwriteActivityTime']//input";
    private static final String CLEAR_PROFILE_FIELD_BTN = "//button[@aria-label='Clear']";
    private static final String DEVICE_PROFILE_REDIRECTED_BTN = "//a[@aria-label='Open device profile']";
    private static final String DEVICE_LABEL_FIELD_CREATE = "//tb-device-wizard//input[@formcontrolname='label']";
    private static final String DEVICE_LABEL_PAGE = DEVICE + "/ancestor::mat-row//mat-cell[contains(@class,'cdk-column-label')]/span";
    private static final String DEVICE_CUSTOMER_PAGE = DEVICE + "/ancestor::mat-row//mat-cell[contains(@class,'cdk-column-customerTitle')]/span";
    private static final String CUSTOMER_OPTION_BNT = "//div[text() = 'Customer']/ancestor::mat-step-header";
    private static final String ASSIGN_ON_CUSTOMER_FIELD = "//input[@formcontrolname='entity']";
    private static final String DEVICE_LABEL_EDIT = "//input[@formcontrolname='label']";

    public WebElement device(String deviceName) {
        return waitUntilElementToBeClickable(String.format(DEVICE, deviceName));
    }

    public WebElement deviceDetailsAlarmsBtn() {
        return waitUntilElementToBeClickable(DEVICE_DETAILS_ALARMS);
    }

    public WebElement deviceDetailsView() {
        return waitUntilPresenceOfElementLocated(DEVICE_DETAILS_VIEW);
    }

    public WebElement assignToCustomerBtn(String deviceName) {
        return waitUntilElementToBeClickable(String.format(ASSIGN_TO_CUSTOMER_BTN, deviceName));
    }

    public WebElement chooseCustomerForAssignField() {
        return waitUntilElementToBeClickable(CHOOSE_CUSTOMER_FOR_ASSIGN_FIELD);
    }

    public WebElement entityFromDropdown(String customerTitle) {
        return waitUntilElementToBeClickable(String.format(ENTITY_FROM_DROPDOWN, customerTitle));
    }

    public WebElement closeDeviceDetailsViewBtn() {
        return waitUntilElementToBeClickable(CLOSE_DEVICE_DETAILS_VIEW);
    }

    public WebElement submitAssignToCustomerBtn() {
        return waitUntilElementToBeClickable(SUBMIT_ASSIGN_TO_CUSTOMER_BTN);
    }

    public WebElement addDeviceBtn() {
        return waitUntilElementToBeClickable(ADD_DEVICE_BTN);
    }

    public WebElement nameField() {
        return waitUntilElementToBeClickable(CREATE_DEVICE_NAME_FIELD);
    }

    public WebElement headerNameView() {
        return waitUntilVisibilityOfElementLocated(HEADER_NAME_VIEW);
    }

    public WebElement descriptionFieldCreateField() {
        return waitUntilElementToBeClickable(DESCRIPTION_FIELD_CREATE_VIEW);
    }

    public WebElement addDeviceView() {
        return waitUntilPresenceOfElementLocated(ADD_DEVICE_VIEW);
    }

    public WebElement deleteBtnDetailsTab() {
        return waitUntilElementToBeClickable(DELETE_BTN_DETAILS_TAB);
    }

    public WebElement checkboxGatewayEdit() {
        return waitUntilElementToBeClickable(CHECKBOX_GATEWAY_EDIT);
    }

    public WebElement checkboxGatewayCreate() {
        return waitUntilElementToBeClickable(CHECKBOX_GATEWAY_CREATE);
    }

    public WebElement checkboxOverwriteActivityTimeEdit() {
        return waitUntilElementToBeClickable(CHECKBOX_OVERWRITE_ACTIVITY_TIME_EDIT);
    }

    public WebElement checkboxOverwriteActivityTimeCreate() {
        return waitUntilElementToBeClickable(CHECKBOX_OVERWRITE_ACTIVITY_TIME_CREATE);
    }

    public WebElement checkboxGatewayDetailsTab() {
        return waitUntilPresenceOfElementLocated(CHECKBOX_GATEWAY_DETAILS);
    }

    public WebElement checkboxGatewayPage(String deviceName) {
        return waitUntilPresenceOfElementLocated(String.format(CHECKBOX_GATEWAY_PAGE, deviceName));
    }

    public WebElement checkboxOverwriteActivityTimeDetails() {
        return waitUntilPresenceOfElementLocated(CHECKBOX_OVERWRITE_ACTIVITY_TIME_DETAILS);
    }

    public WebElement clearProfileFieldBtn() {
        return waitUntilElementToBeClickable(CLEAR_PROFILE_FIELD_BTN);
    }

    public WebElement deviceProfileRedirectedBtn() {
        return waitUntilElementToBeClickable(DEVICE_PROFILE_REDIRECTED_BTN);
    }

    public WebElement deviceLabelFieldCreate() {
        return waitUntilElementToBeClickable(DEVICE_LABEL_FIELD_CREATE);
    }

    public WebElement deviceLabelOnPage(String deviceName) {
        return waitUntilVisibilityOfElementLocated(String.format(DEVICE_LABEL_PAGE, deviceName));
    }

    public WebElement customerOptionBtn() {
        return waitUntilElementToBeClickable(CUSTOMER_OPTION_BNT);
    }

    public WebElement assignOnCustomerField() {
        return waitUntilElementToBeClickable(ASSIGN_ON_CUSTOMER_FIELD);
    }

    public WebElement deviceCustomerOnPage(String deviceName) {
        return waitUntilVisibilityOfElementLocated(String.format(DEVICE_CUSTOMER_PAGE, deviceName));
    }

    public WebElement deviceLabelEditField() {
        return waitUntilElementToBeClickable(DEVICE_LABEL_EDIT);
    }

    public WebElement deviceLabelDetailsField() {
        return waitUntilVisibilityOfElementLocated(DEVICE_LABEL_EDIT);
    }
}
