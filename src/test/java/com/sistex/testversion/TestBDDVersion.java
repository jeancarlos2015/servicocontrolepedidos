/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.testversion;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author jean
 */

public class TestBDDVersion {

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/main/resources/featureVersion")
    public class CucumberTest {
    }
}
