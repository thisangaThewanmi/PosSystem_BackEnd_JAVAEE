package lk.ijse.dao;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {

    }

    public static DaoFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoTypes{
        CUSTOMER,ITEM
    }

    public SuperDao getDao(DaoTypes Daotype) {
        switch (Daotype) {
            case CUSTOMER:
                return new CustomerDaoImpl();
                case ITEM:
                    return new ItemDaoImpl();
            default:
                return null;
        }
    }
}
