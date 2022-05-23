import java.time.LocalDate;
public class CursFederat extends Curs {

    private String nivell;

    public CursFederat(String nom, LocalDate dataInici, double preu, String nivell) {
        super(nom, dataInici, preu);
        this.nivell = nivell;
    }

    public String getNivell() {
        return nivell;
    }

    public void setNivell(String nivell) {
        this.nivell = nivell;
    }
  
    
}