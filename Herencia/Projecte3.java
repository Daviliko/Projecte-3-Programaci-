import java.time.LocalDate;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Projecte3 extends Application {

    TextField txtDni;
    TextField txtNom;
    TextField txtCognom1;
    TextField txtCognom2;
    TextField txtNomCurs;
    TextField txtData;
    TextField txtPreu;
    TextField txtFam;
    TextField txtNivell;
    TextField txtDataFi;

    GridPane gpcol = new GridPane();
    GridPane gpfed = new GridPane();
    GridPane gpin = new GridPane();
   

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage escenari) throws Exception {
        // Fem servir un contenidor BorderPane per la nostra aplicació
        // el contingut de cada regió el dibuixem en els diferents mètodes

        BorderPane contenidor = new BorderPane();
        contenidor.setTop(partSuperior());
        contenidor.setBottom(partInferior());
        contenidor.setLeft(lateralEsquerre());
        contenidor.setCenter(formulariCentral());
        contenidor.setRight((lateralDret()));

        //VBox contenidor = new VBox();     //organitza els nodes en vertical
        //HBox contenidor = new HBox();     //organitza els nodes en horitzontal
        //Pane contenidor = new Pane();     //coloca els nodes al cantó superior esquerra
        //StackPane contenidor = new StackPane();  //apila els nodes un al damunt de l'altre
        //FlowPane contenidor = new FlowPane();

        //contenidor.getChildren().addAll(btn1,btn2,btn3);
        //contenidor.setAlignment(Pos.CENTER);
        //contenidor.setSpacing(20);

        Scene escena = new Scene(contenidor);

        escenari.setScene(escena);
        escenari.setMinHeight(300);
        escenari.setMinWidth(300);

        escenari.show();
    }

    private Pane partSuperior(){
        HBox hb = new HBox();
        hb.getChildren().addAll(new Label("Titol"));
        hb.setAlignment(Pos.CENTER);
        return hb;
    }

    private Pane lateralEsquerre(){
        VBox vlateral = new VBox();
        vlateral.getChildren().addAll(new Label("CLIENTS"));
        vlateral.setAlignment(Pos.CENTER);

        TableView<Client> tblClients = new TableView<>();
        TableColumn<Client, String> colDni = new TableColumn<>("DNI");
        TableColumn<Client, String> colNom = new TableColumn<>("Nom");
        TableColumn<Client, String> colCognom1 = new TableColumn<>("Cognom1");
        TableColumn<Client, String> colCognom2 = new TableColumn<>("Cognom2");
        tblClients.getColumns().addAll(colDni,colNom,colCognom1,colCognom2);

        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCognom1.setCellValueFactory(new PropertyValueFactory<>("cognom1"));
        colCognom2.setCellValueFactory(new PropertyValueFactory<>("cognom2"));
        
        Client c1 = new Client("12345678F", "Pep", "Fernandez", "Calatrava");
        Client c2 = new Client("65515615I", "Jordi", "Tras", "Muñoz");
        Client c3 = new Client("01427241E", "Maria", "Gutierrez", "Gaviria");
        Client c4 = new Client("09967065S", "Antonia", "Clars", "Minguet");
        Client c5 = new Client("79509056B", "Carme", "Ruiz", "Calderó");
        Client c6 = new Client("91836731P", "Carles", "Bautista", "Panós");

        tblClients.getItems().addAll(c1,c2,c3,c4,c5,c6);
       
        vlateral.getChildren().add(tblClients);


        // Afegim un listener per detectar canvis de seleccio en la tableview de clients
        tblClients.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
           @Override
           public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               Client client = (Client) newValue;

               if (client != null) {
                // Movem a la pantalla les dades del client seleccionat
                txtNom.setText(client.getNom());
                txtDni.setText(client.getDni());
                txtCognom1.setText(client.getCognom1());
                txtCognom2.setText(client.getCognom2());

               }
           } 
        });

        return vlateral;
    }

    private Pane formulariCentral(){
        VBox vb = new VBox();
        vb.getChildren().addAll(new Label("DADES CLIENTS"));
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(15);
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);

        
        Label lblDni = new Label("Dni");
        Label lblNom = new Label("Nom");
        Label lblCognom1 = new Label("Cognom1");
        Label lblCognom2 = new Label("Cognom2");
        
        txtDni = new TextField();
        txtDni.setEditable(false);
        txtNom = new TextField();
        txtNom.setEditable(false);
        txtCognom1 = new TextField();
        txtCognom1.setEditable(false);
        txtCognom2 = new TextField();
        txtCognom2.setEditable(false);

        gp.add(lblDni, 0, 0);
        gp.add(txtDni, 1, 0);
        gp.add(lblNom, 0, 1);
        gp.add(txtNom, 1, 1);
        gp.add(lblCognom1, 0, 2);
        gp.add(txtCognom1, 1, 2);
        gp.add(lblCognom2, 0, 3);
        gp.add(txtCognom2, 1, 3);


        GridPane gp2 = new GridPane();
        gp2.setAlignment(Pos.CENTER);

        
        Label lblNomCurs = new Label("Nom Curs");
        Label lblData = new Label("Data");
        Label lblPreu = new Label("Preu");
        
        txtNomCurs = new TextField();
        txtNomCurs.setEditable(false);
        txtData = new TextField();
        txtData.setEditable(false);
        txtPreu = new TextField();
        txtPreu.setEditable(false);

        gp2.add(lblNomCurs, 0, 4);
        gp2.add(txtNomCurs, 1, 4);
        gp2.add(lblData, 0, 5);
        gp2.add(txtData, 1, 5);
        gp2.add(lblPreu, 0, 6);
        gp2.add(txtPreu, 1, 6);
        
        
        StackPane sp = new StackPane();
        sp.setAlignment(Pos.CENTER);

       
        gpcol.setAlignment(Pos.CENTER);

        Label lblFam = new Label("Familia Nombrosa");
        txtFam = new TextField();
        txtFam.setEditable(false);

        gpcol.add(lblFam, 0, 0);
        gpcol.add(txtFam, 1, 0);
        gpcol.setVisible(false);
               
      
        gpfed.setAlignment(Pos.CENTER);

        Label lblNivell = new Label("Nivell");
        txtNivell = new TextField();
        txtNivell.setEditable(false);

        gpfed.add(lblNivell, 0, 1);
        gpfed.add(txtNivell, 1, 1);
        gpfed.setVisible(false);
        
        
        gpin.setAlignment(Pos.CENTER);

        Label lblDataFi = new Label("Data Fi");
        txtDataFi = new TextField();
        txtDataFi.setEditable(false);

        gpin.add(lblDataFi, 0, 2);
        gpin.add(txtDataFi, 1, 2);
        gpin.setVisible(false);

        sp.getChildren().addAll(gpcol,gpfed,gpin);

        vb.getChildren().addAll(gp,new Label("DADES CURSOS"),gp2,sp);
        return vb;
        
    }


    private Pane partInferior(){
        Button btnLlogar = new Button("Llogar");
        Button btnNetejar = new Button("Netejar"); 
        Button btnSortir = new Button("Sortir"); 
        HBox hinferior = new HBox();
        hinferior.getChildren().addAll(btnLlogar,btnNetejar,btnSortir);

        hinferior.setAlignment(Pos.CENTER);
        
        btnLlogar.setOnAction(e -> btnLlogar());

        btnNetejar.setOnAction(e -> btnNetejar());

        btnSortir.setOnAction(e ->Platform.exit());
        return hinferior; 
    }

    private void btnLlogar() {
        // Stage nouEscenari = new Stage();
        // nouEscenari.show();
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Llogar");
        alert.setContentText("S'ha llogat l'activitat amb èxit");
        alert.showAndWait();
      
    }

    private void btnNetejar() {
        txtDni.clear();
        txtNom.clear();
        txtCognom1.clear();
        txtCognom2.clear();
        txtNomCurs.clear();
        txtData.clear();
        txtPreu.clear();
        txtFam.clear();
        txtNivell.clear();
        txtDataFi.clear();
        gpcol.setVisible(false);
        gpfed.setVisible(false);
        gpin.setVisible(false);
    }

    // private Object btnSortir() {
    //     Platform.exit();
    //     return null;
    // }

    private Pane lateralDret(){
        VBox vb = new VBox();
        Label lblDret = new Label("Lateral dret");

        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(15);

        TabPane tp = new TabPane();

        Tab tab1 = new Tab("Col·lectius", cursosColectius());
        Tab tab2 = new Tab("Federats", cursosFederats());
        Tab tab3 = new Tab("Individuals", cursosIndividuals());

        tp.getTabs().add(tab1);
        tp.getTabs().add(tab2);
        tp.getTabs().add(tab3);

        vb.getChildren().addAll(lblDret, tp);

        return vb;
    }

    private Pane cursosColectius(){
        VBox vb = new VBox();
        vb.getChildren().addAll(new Label("CURSOS"));
        vb.setAlignment(Pos.CENTER);
        
        TableView<CursColectiu>tblCursCol = new TableView<>();
        TableColumn<CursColectiu, String> colNom = new TableColumn<>("Nom Curs");
        TableColumn<CursColectiu, LocalDate> colDatainici = new TableColumn<>("Data Inici");
        TableColumn<CursColectiu, Double> colPreu = new TableColumn<>("Preu");
        TableColumn<CursColectiu, String> colFam = new TableColumn<>("Familia Nombrosa");
       
        tblCursCol.getColumns().addAll(colNom,colDatainici,colPreu,colFam);

        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDatainici.setCellValueFactory(new PropertyValueFactory<>("dataInici"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));
        colFam.setCellValueFactory(new PropertyValueFactory<>("familianombrosa"));


        CursColectiu c1 = new CursColectiu("Esquí", LocalDate.parse("2022-06-01"), 65, "Sí");
        CursColectiu c2 = new CursColectiu("Passeig", LocalDate.parse("2022-09-22"), 25, "No");
        CursColectiu c3 = new CursColectiu("Alpinisme", LocalDate.parse("2022-07-12"), 43, "No");

        tblCursCol.getItems().addAll(c1,c2,c3);
       
        vb.getChildren().add(tblCursCol);

        // Afegim un listener per detectar canvis de seleccio en la tableview de clients
        tblCursCol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CursColectiu cursColectiu = (CursColectiu) newValue;
 
                if (cursColectiu != null) {
                 // Movem a la pantalla les dades del client seleccionat
                 txtNomCurs.setText(cursColectiu.getNom());
                 txtData.setText(String.valueOf(cursColectiu.getDataInici()));
                 txtPreu.setText(String.valueOf(cursColectiu.getPreu()));
                 txtFam.setText(cursColectiu.getFamilianombrosa());

                 gpcol.setVisible(true);
                 gpfed.setVisible(false);
                 gpin.setVisible(false);
                }
            } 
         });
        
        return vb;
    }

    private Pane cursosFederats(){
        VBox vb = new VBox();
        vb.getChildren().addAll(new Label("CURSOS"));
        vb.setAlignment(Pos.CENTER);
        
        TableView<CursFederat>tblCursFed = new TableView<>();
        TableColumn<CursFederat, String> colNom = new TableColumn<>("Nom Curs");
        TableColumn<CursFederat, LocalDate> colDatainici = new TableColumn<>("Data Inici");
        TableColumn<CursFederat, Double> colPreu = new TableColumn<>("Preu");
        TableColumn<CursFederat, String> colNivell = new TableColumn<>("Nivell");
       
        tblCursFed.getColumns().addAll(colNom,colDatainici,colPreu,colNivell);

       
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDatainici.setCellValueFactory(new PropertyValueFactory<>("dataInici"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));
        colNivell.setCellValueFactory(new PropertyValueFactory<>("nivell"));
    
        CursFederat c1 = new CursFederat("Esquí Alpí", LocalDate.parse("2022-11-10"),125, "Baix");
        CursFederat c2 = new CursFederat("Esquí de Fons", LocalDate.parse("2022-10-14"), 168, "Mig");
        CursFederat c3 = new CursFederat("Biatlón",  LocalDate.parse("2022-12-30"), 215, "Alt");

        tblCursFed.getItems().addAll(c1,c2,c3);
       
        vb.getChildren().add(tblCursFed);

        // Afegim un listener per detectar canvis de seleccio en la tableview de clients
        tblCursFed.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CursFederat cursFederat = (CursFederat) newValue;
 
                if (cursFederat != null) {
                 // Movem a la pantalla les dades del client seleccionat
                 txtNomCurs.setText(cursFederat.getNom());
                 txtData.setText(String.valueOf(cursFederat.getDataInici()));
                 txtPreu.setText(String.valueOf(cursFederat.getPreu()));
                 txtNivell.setText(cursFederat.getNivell());
                    
                 gpcol.setVisible(false);
                 gpfed.setVisible(true);
                 gpin.setVisible(false);
                }
            } 
         });

        return vb;
    }

    private Pane cursosIndividuals(){
        VBox vb = new VBox();
        vb.getChildren().addAll(new Label("CURSOS"));
        vb.setAlignment(Pos.CENTER);
        
        TableView<CursIndividual>tblCursIn = new TableView<>();
        TableColumn<CursIndividual, String> colNom = new TableColumn<>("Nom Curs");
        TableColumn<CursIndividual, LocalDate> colDatainici = new TableColumn<>("Data Inici");
        TableColumn<CursIndividual, Double> colPreu = new TableColumn<>("Preu");
        TableColumn<CursIndividual, LocalDate> colDatafi = new TableColumn<>("Data Fi");
       
        tblCursIn.getColumns().addAll(colNom,colDatainici,colPreu,colDatafi);

        
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDatainici.setCellValueFactory(new PropertyValueFactory<>("dataInici"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));
        colDatafi.setCellValueFactory(new PropertyValueFactory<>("dataFi"));
    
        CursIndividual c1 = new CursIndividual("Snowboard", LocalDate.parse("2022-05-23"),50, LocalDate.parse("2022-05-29"));
        CursIndividual c2 = new CursIndividual("Esquí Bàsic", LocalDate.parse("2022-09-12"), 35, LocalDate.parse("2022-09-15"));
        CursIndividual c3 = new CursIndividual("Alpinisme",  LocalDate.parse("2022-05-25"), 10, LocalDate.parse("2022-05-26"));

        tblCursIn.getItems().addAll(c1,c2,c3);
       
        vb.getChildren().add(tblCursIn);
      
        // Afegim un listener per detectar canvis de seleccio en la tableview de clients
        tblCursIn.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CursIndividual cursIndividual = (CursIndividual) newValue;
 
                if (cursIndividual != null) {
                 // Movem a la pantalla les dades del client seleccionat
                 txtNomCurs.setText(cursIndividual.getNom());
                 txtData.setText(String.valueOf(cursIndividual.getDataInici()));
                 txtPreu.setText(String.valueOf(cursIndividual.getPreu()));
                 txtDataFi.setText(String.valueOf(cursIndividual.getDataFi()));
 
                 gpcol.setVisible(false);
                 gpfed.setVisible(false);
                 gpin.setVisible(true);
                }
            } 
         });

        return vb;
    }
    
}
