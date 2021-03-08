package com.idel.dao.mdao;

import com.idel.dao.DaoFactory;

public class MDaoFactory extends DaoFactory {
    @Override
    public MUsersDao createUsersDao() {
        return new MUsersDao();
    }

    @Override
    public MOrdersDao createOrdersDao() {
        return new MOrdersDao();
    }

    @Override
    public MShippingRatesDao createShippingRatesDao() {
        return new MShippingRatesDao();
    }
}
