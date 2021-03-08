package com.idel.entities;

import lombok.Data;

@Data
public class ShippingRates {
    private Integer ShippingRateId;
    private Integer MaxWeight;
    private Integer CityPrice;
    private Integer RegionPrice;
    private Integer CountryPrice;
}
