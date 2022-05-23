public class Client {
    // variables classe
    private static int idClient;
    private String dni;
    private String nom;

    private String cognom1;
    private String cognom2;

    public Client(){
        idClient++;
    }

    public Client(String dni, String nom, String cognom1, String cognom2) {
        idClient++;

        this.idClient = idClient;
        this.dni = dni;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
    }

    public static int getIdClient() {
        return idClient;
    }

    public static void setIdClient(int idClient) {
        Client.idClient = idClient;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    
}
