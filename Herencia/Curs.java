import java.time.LocalDate;

public class Curs {
    
    private static int idCurs;
    private String nom;
    private LocalDate dataInici;
    private double preu;


    public Curs(String nom, LocalDate dataInici, double preu) {
        this.nom = nom;
        this.dataInici = dataInici;
        this.preu = preu;
    }


    public static int getIdCurs() {
        return idCurs;
    }


    public static void setIdCurs(int idCurs) {
        Curs.idCurs = idCurs;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public LocalDate getDataInici() {
        return dataInici;
    }


    public void setDataInici(LocalDate dataInici) {
        this.dataInici = dataInici;
    }


    public double getPreu() {
        return preu;
    }


    public void setPreu(double preu) {
        this.preu = preu;
    }

    
}
