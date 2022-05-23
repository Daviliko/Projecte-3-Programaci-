import java.time.LocalDate;
public class CursIndividual extends Curs {
    
    private LocalDate dataFi;

    public CursIndividual(String nom, LocalDate dataInici, double preu, LocalDate dataFi) {
        super(nom, dataInici, preu);
        this.dataFi = dataFi;
    }

    public LocalDate getDataFi() {
        return dataFi;
    }

    public void setDataFi(LocalDate dataFi) {
        this.dataFi = dataFi;
    }

    
}