import java.time.LocalDate;
public class CursColectiu extends Curs {
    
    private String familianombrosa;

    public CursColectiu(String nom, LocalDate dataInici, double preu, String familianombrosa) {
        super(nom, dataInici, preu);
        this.familianombrosa = familianombrosa;
    }

    public String getFamilianombrosa() {
        return familianombrosa;
    }

    public void setFamilianombrosa(String familianombrosa) {
        this.familianombrosa = familianombrosa;
    }
    
    
 }