package lk.ijse.dao;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {

    }

    public static DaoFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoTypes{
        CUSTOMER,ITEM,ORDER,ITEMCART
    }

    public SuperDao getDao(DaoTypes Daotype) {
        switch (Daotype) {
            case CUSTOMER:
                return new CustomerDaoImpl();
                case ITEM:
                    return new ItemDaoImpl();
                case ORDER:
                return new OrderDaoImpl();
            case ITEMCART:
                return new ItemCartDaoImpl();
            default:
                return null;
        }
    }
}
