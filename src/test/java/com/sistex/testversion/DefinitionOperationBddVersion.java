///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sistex.testversion;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import static org.hamcrest.CoreMatchers.is;
//import org.springframework.http.HttpStatus;
//
///**
// *
// * @author jean
// */
//public class DefinitionOperationBddVersion {
//
//    @When("^the client calls /version$")
//    public void the_client_issues_GET_version() throws Throwable {
//        executeGet("http://localhost:8080/version");
//    }
//
//    @Then("^the client receives status code of (\\d+)$")
//    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
//        HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
//        assertThat("status code is incorrect : "
//                + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
//    }
//
//    @And("^the client receives server version (.+)$")
//    public void the_client_receives_server_version_body(String version) throws Throwable {
//        assertThat(latestResponse.getBody(), is(version));
//    }
//}
