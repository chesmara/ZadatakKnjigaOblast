package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 16.1.17..
 */

@DatabaseTable(tableName = "oblast")
public class Oblast {

        private static final String POLJE_NAZIV = "naziv";
        private static final String POLJE_POCETNA_STRANA = "pocetna_strana";




    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NAZIV , canBeNull = false)
    private String naziv;
    @DatabaseField(columnName = POLJE_POCETNA_STRANA, canBeNull = false)
    private int pocetnaStrana;
    @DatabaseField(foreign = true, foreignAutoRefresh = false)
    private Knjiga knjiga;

    //----------------------------konstruktori----------------------------
    public Oblast(){}

    public Oblast(int id, String naziv, int pocetnaStrana, Knjiga knjiga) {
        this.naziv = naziv;
        this.pocetnaStrana = pocetnaStrana;

    }

    //--------------------------get i set metode-----------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPocetnaStrana() {
        return pocetnaStrana;
    }

    public void setPocetnaStrana(int pocetnaStrana) {
        this.pocetnaStrana = pocetnaStrana;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    //---------------------------------To String metoda----------


    @Override
    public String toString() {
        return "Oblast{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", pocetnaStrana=" + pocetnaStrana +
                ", knjiga=" + knjiga +
                '}';
    }
}
