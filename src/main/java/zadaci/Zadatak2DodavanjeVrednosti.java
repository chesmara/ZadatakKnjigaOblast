package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Knjiga;
import model.Oblast;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 16.1.17..
 */
public class Zadatak2DodavanjeVrednosti {

    static Dao<Knjiga, Integer> knjigaDao;
    static Dao<Oblast, Integer> oblastDao;



        public static void main(String[] args) throws SQLException {





            ConnectionSource connectionSource = null;


            knjigaDao= DaoManager.createDao(connectionSource, Knjiga.class);
            oblastDao= DaoManager.createDao(connectionSource, Oblast.class);


            try {
                // create our data-source for the database
                connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

                Knjiga javaProgramiranje=new Knjiga("Java programiranje", 650, new Date());
                knjigaDao.create(javaProgramiranje);
                Knjiga androidProgramiranje=new Knjiga("Android programiranje" , 500, new Date());
                knjigaDao.create(androidProgramiranje);


                Oblast uvod = new Oblast("Uvod",2);
                uvod.setKnjiga(javaProgramiranje);
                oblastDao.create(uvod);

                Oblast naredbe= new Oblast("Naredbe",10);
                naredbe.setKnjiga(javaProgramiranje);
                oblastDao.create(naredbe);

                Oblast aritmetickiOperatori=new Oblast("Aritmeticki operatori", 20);
                aritmetickiOperatori.setKnjiga(androidProgramiranje);
                oblastDao.create(aritmetickiOperatori);

                Oblast androidOperativniSistem =new Oblast("Android operativni sistem", 2);
                androidOperativniSistem.setKnjiga(androidProgramiranje);
                oblastDao.create(androidOperativniSistem);

                Oblast activityKlasa =new Oblast("Aktivity kalsa", 30);
                activityKlasa.setKnjiga(androidProgramiranje);
                oblastDao.create(activityKlasa);

                //---------------prikaz iz tabele--------------------------------

                List<Knjiga> knjiga = knjigaDao.queryForAll();
                for(Knjiga k : knjiga) {

                    System.out.println();
                }





            }catch (Exception e) {
                e.printStackTrace();


            }finally {
                if (connectionSource != null) {
                    try {
                        connectionSource.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }

    }

