package com.zebrunner.carina.demo;

import java.lang.invoke.MethodHandles;

import com.zebrunner.carina.demo.api.weather.GetWeatherMethods;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;


public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetWeather() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods();
        getWeatherMethods.addUrlParameter("latitude", "52.25");
        getWeatherMethods.addUrlParameter("longitude", "21.0");
        getWeatherMethods.addUrlParameter("current_weather", "true");
        getWeatherMethods.callAPIExpectSuccess();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/weather/_get/rs.schema");
    }

}
