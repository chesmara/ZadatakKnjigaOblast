package model;

/**
 * Created by androiddevelopment on 16.1.17..
 */

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;


@DatabaseTable(tableName = "Knjiga")
public class Knjiga {

    private static final String POLJE_NASLOV = "naslov";
    private static final String POLJE_BROJ_STRANA = "broj_strana";
    private static final String POLJE_DATUM_IZDAVANJA = "datum_izdavanja";


    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_NASLOV,canBeNull = false, unique=false)
    private  String naslov;
    @DatabaseField(columnName = POLJE_BROJ_STRANA,canBeNull = false, unique=false)
    private int brojStrana;
    @DatabaseField(columnName = POLJE_DATUM_IZDAVANJA,canBeNull = false, unique=false)
    private Date datumIzdavanja;

    @ForeignCollectionField (foreignFieldName = "knjigaref"  , eager = true)
    private ForeignCollection<Oblast> oblasti;

    private  boolean prisutna;

    //-----------------------------------konstruktori--------------------

    public Knjiga (){
            }

    public Knjiga(String naslov, int brojStrana, Date datumIzdavanja) {

        this.naslov=naslov;
        this.brojStrana=brojStrana;
        this.datumIzdavanja=datumIzdavanja;


    }


    //--------------get i set metode---------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }


    public void setDatumIzdavanja(Date datumIzdavanja) {

        this.datumIzdavanja = datumIzdavanja;
    }


    //-------------------------------to string-------------------------------

    @Override
    public String toString() {
        return "Knjiga{" +
                "id=" + id +
                ", naslov='" + naslov + '\'' +
                ", brojStrana=" + brojStrana +
                ", datumIzdavanja=" + datumIzdavanja +
                '}';
    }


}
