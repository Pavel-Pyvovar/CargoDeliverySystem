package com.idel.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    public Integer OrderId;
    public Integer UserId;
    public String CarriageType;
    public Integer CarriageWeight;
    public Date ShippingDate;
    public Integer ShippingRateId;
}
