package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Knjiga;
import model.Oblast;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by androiddevelopment on 16.1.17..
 */
public class Zadatak3IzmenaVrednosti {

        public static void main(String[] args) {

            ConnectionSource connectionSource = null;


            try {
                // create our data-source for the database
                connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

                TableUtils.dropTable(connectionSource, Knjiga.class,true);
                TableUtils.dropTable(connectionSource, Oblast.class,true);


                TableUtils.createTable(connectionSource,Knjiga.class);
                TableUtils.createTable(connectionSource,Oblast.class);


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

