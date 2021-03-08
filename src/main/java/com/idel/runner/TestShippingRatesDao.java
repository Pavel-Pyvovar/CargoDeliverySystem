//package runner;
//
//import dao.DaoFactory;
//import dao.mdao.MShippingRatesDao;
//import entities.ShippingRates;
//
//public class TestShippingRatesDao {
//    public static void main(String[] args) {
//        ShippingRates shippingRate = new ShippingRates();
//        shippingRate.setMaxWeight(3);
//        shippingRate.setCityPrice(200);
//        shippingRate.setRegionPrice(400);
//        shippingRate.setCountryPrice(500);
//
//        System.out.println(shippingRate.toString());
//
//        MShippingRatesDao shippingRatesDao = DaoFactory.createShippingRatesDao();
//
//        shippingRatesDao.add(shippingRate);
//    }
//}
