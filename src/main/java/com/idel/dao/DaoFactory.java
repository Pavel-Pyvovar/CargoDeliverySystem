package com.idel.dao;

import com.idel.dao.mdao.MDaoFactory;

public abstract class DaoFactory {
    public abstract IUsersDao createUsersDao();
    public abstract IOrdersDao createOrdersDao();
    public abstract IShippingRatesDao createShippingRatesDao();

    public static MDaoFactory getDaoFactory() {
        return new MDaoFactory();
    }
}
