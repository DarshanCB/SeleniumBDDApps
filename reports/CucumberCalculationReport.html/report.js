$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/calculator.feature");
formatter.feature({
  "name": "Calculator",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Adding two numbers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have a calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "CalculationSteps.i_have_a_calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add 1 and 2",
  "keyword": "When "
});
formatter.match({
  "location": "CalculationSteps.i_add_and(Integer,Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 3",
  "keyword": "Then "
});
formatter.match({
  "location": "CalculationSteps.i_should_get(Integer)"
});
formatter.result({
  "status": "passed"
});
});