$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com.vytrack.features/Vehicles.feature");
formatter.feature({
  "name": "Vehicles",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I login as a \"sales manager\"",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefs.i_login_as_a(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to \"Fleet\" \"Vehicles\"",
  "keyword": "When "
});
formatter.match({
  "location": "Navigation.i_go_to(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify default order",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I click on header \"LICENSE PLATE\"",
  "keyword": "When "
});
formatter.match({
  "location": "VehiclesStepDefs.i_click_on_header(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "All records are displayed by \"LICENSE PLATE\" in \"ascending\" order",
  "keyword": "Then "
});
formatter.match({
  "location": "VehiclesStepDefs.all_records_are_displayed_by_in(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on header \"LICENSE PLATE\"",
  "keyword": "When "
});
formatter.match({
  "location": "VehiclesStepDefs.i_click_on_header(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "All records are displayed by \"LICENSE PLATE\" in \"descending\" order",
  "keyword": "Then "
});
formatter.match({
  "location": "VehiclesStepDefs.all_records_are_displayed_by_in(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I login as a \"sales manager\"",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefs.i_login_as_a(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to \"Fleet\" \"Vehicles\"",
  "keyword": "When "
});
formatter.match({
  "location": "Navigation.i_go_to(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that all records that are displayed can be sorted by DRIVER column",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I click on header \"DRIVER\"",
  "keyword": "When "
});
formatter.match({
  "location": "VehiclesStepDefs.i_click_on_header(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "All records are displayed by \"DRIVER\" in \"ascending\" order",
  "keyword": "Then "
});
formatter.match({
  "location": "VehiclesStepDefs.all_records_are_displayed_by_in(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on header \"DRIVER\"",
  "keyword": "When "
});
formatter.match({
  "location": "VehiclesStepDefs.i_click_on_header(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "All records are displayed by \"DRIVER\" in \"descending\" order",
  "keyword": "Then "
});
formatter.match({
  "location": "VehiclesStepDefs.all_records_are_displayed_by_in(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I login as a \"sales manager\"",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefs.i_login_as_a(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to \"Fleet\" \"Vehicles\"",
  "keyword": "When "
});
formatter.match({
  "location": "Navigation.i_go_to(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Select All checkbox",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "None of the checkboxes are selected",
  "keyword": "Then "
});
formatter.match({
  "location": "VehiclesStepDefs.none_of_the_checkboxes_are_selected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the checkbox in the headers row",
  "keyword": "When "
});
formatter.match({
  "location": "VehiclesStepDefs.i_click_on_the_checkbox_in_the_headers_row()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "All of the checkboxes are selected",
  "keyword": "Then "
});
formatter.match({
  "location": "VehiclesStepDefs.all_of_the_checkboxes_are_now_selected()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});