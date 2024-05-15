package utils;

/*
 * これはDAO
 * DAO(Data Access Object)パターンとはデータベースへのアクセスを行う
 * クラスを作り、そのクラスを通してデータベースへアクセスする
 * デザインパターンです。
 *  メインロジックのなかに記述されていたアクセス部分の処理を1つの
 *  クラスに集約し、データベースアクセスの窓口の役割を持たせます。
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


// privateでfinal→そのクラスでしかアクセスできない定数
public class DBUtil {
    private static final String PERSISTENCE_UNIT_NAME = "tasklist";
    private static EntityManagerFactory emf;

    public static EntityManager createEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        return emf;
    }
}