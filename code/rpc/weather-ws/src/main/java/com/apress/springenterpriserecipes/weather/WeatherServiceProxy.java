package com.apress.springenterpriserecipes.weather;

import java.util.Date;
import java.util.List;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class WeatherServiceProxy extends WebServiceGatewaySupport
        implements WeatherService {

    public List<TemperatureInfo> getTemperatures(String city, List<Date> dates) {
        GetTemperaturesRequest request = new GetTemperaturesRequest(city, dates);
        GetTemperaturesResponse response = (GetTemperaturesResponse)
            getWebServiceTemplate().marshalSendAndReceive(request);
        return response.getTemperatures();
    }
}
