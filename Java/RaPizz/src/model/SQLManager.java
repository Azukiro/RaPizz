package model;

import com.mysql.cj.jdbc.MysqlDataSource;



import javax.naming.Context;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class SQLManager{

    
    private static final String username = "root";
    private static final String password = ""; // le mien c'était le mot de passe de mon compte windows
    private static final String serverName = "localhost";
    private static final String database = "tp5";
    private static final int port = 3306;

    Context context;
    MysqlDataSource dataSource;
    Connection con;
    
    // singleton pattern
    private SQLManager() {
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setServerName(serverName);
            dataSource.setDatabaseName(database);
            dataSource.setPort(port);
            dataSource.setServerTimezone("UTC");
            System.out.println("Tentative de connexion...");
            con = dataSource.getConnection();
            Statement stmt = con.createStatement(); // C'est mieux les PreparedStatement
            stmt.close();
            System.out.println("Connection = " + con);

        } catch (SQLException e) {
            System.err.println("[ERROR]");
            System.err.println("MySQL Connexion exception: " + e);

            //throw new IllegalStateException();
        }
    }
    
    private Connection getCon() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SQLManager INSTANCE;

    public static SQLManager getInstance() throws SQLException {
        if (INSTANCE == null) {
            INSTANCE = new SQLManager();
        }
        return INSTANCE;
    }

    
    public void testSelect() throws SQLException {
        final String getPasswordString = "select * from produits Where CodeProduit=?;";

        PreparedStatement pStatement = getCon().prepareStatement(getPasswordString);
        pStatement.setInt(1, 1);

        ResultSet rSet = pStatement.executeQuery();
        String libe = "";
        while(rSet.next()) {
        	libe = rSet.getNString(2);
        	int prix = rSet.getInt("Prix");
        	System.out.println(libe+ "  "+ prix);
        }

       
    } 
    /*Acte*/
    private boolean testInsert(int staffId, int patientId, String title, int type, String description, String file, boolean isDraft) throws SQLException {
        //String link=CreateDynamicLink(file,patientId,title);
        final String searchNewID = 
        	"INSERT INTO acte (MedicalFolder_idFolder, Nom, DateDebut, DateFin, Responsable, Prix, DocumentLink, IsADraft, DocumentType_idDocumentType, Description, idActe)\r\n" +
            "VALUES (?, ?, ?, NULL, ?, NULL, ?, ?, ?, ?, NULL);";
        PreparedStatement s = getCon().prepareStatement(searchNewID);
        s.setInt(1, patientId);
        s.setString(2, title);


        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());


        s.setDate(3, date);
        s.setInt(4, staffId);
        s.setString(5, file);
        s.setInt(6, isDraft ? 1 : 0);
        s.setInt(7, type);
        s.setString(8, description);
        System.out.println(s);
        return !s.execute();
    }

    
    public boolean testUpdate(int patientId, int draftId, String title, String description, String file) throws SQLException, IOException {
        final String update = "UPDATE acte SET IsADraft=0 WHERE acte.idActe = ?;";

        PreparedStatement pStatement = getCon().prepareStatement(update);

        pStatement.setInt(1, draftId);

        return !pStatement.execute();
    }




    public void testDelete(int draftId) throws SQLException {
        
         final String delString = "DELETE FROM acte WHERE idActe=? AND IsADraft=1;";
         PreparedStatement pStatement = getCon().prepareStatement(delString);
         pStatement.setInt(1, draftId);
         int i = pStatement.executeUpdate();
        
    }

	public ArrayList<Vehicle> getVehicles() {
		// TODO Auto-generated method stub
		var result = new ArrayList<Vehicle>() ;
		result.add(new Vehicle(0, "Clio", "Voiture"));
		result.add(new Vehicle(0, "T-Max", "Scooter"));
		result.add(new Vehicle(0, "Clio", "Voiture"));
		result.add(new Vehicle(0, "T-Max", "Scooter"));
		result.add(new Vehicle(0, "Clio", "Voiture"));
		result.add(new Vehicle(0, "T-Max", "Scooter"));
		return result;
	}
	
	public ArrayList<Client> getClients() {
		// TODO Auto-generated method stub
		var result = new ArrayList<Client>() ;
		result.add(new Client(0, "Clio", "Voiture", "0651096591","128 avenue du caca"));
		result.add(new Client(1, "Clio2", "Voiture3", "0651096591","128 avenue du caca"));
		return result;
	}

	public ArrayList<DeliveryGuy> getDeliveryGuys() {
		// TODO Auto-generated method stub
		var result = new ArrayList<DeliveryGuy>() ;
		result.add(new DeliveryGuy(0, "Mustang", "Ford", "0651096591"));
		result.add(new DeliveryGuy(1, "Citroen", "Mercedes", "0651096591"));
		return result;
	}
	
	public ArrayList<Pizza> getPizzas() {
		// TODO Auto-generated method stub
		var result = new ArrayList<Pizza>() ;
		var ingre = new ArrayList<Ingredient>() ;
		ingre.add(new Ingredient(0, "Saucisse"));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));result.add(new Pizza(0, "Mustang", ingre, 2));result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));result.add(new Pizza(0, "Mustang", ingre, 2));result.add(new Pizza(0, "Mustang", ingre, 2));result.add(new Pizza(0, "Mustang", ingre, 2));result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		result.add(new Pizza(0, "Mustang", ingre, 2));
		return result;
	}

	public void insertOrder(Pizza pizza, Client client, Vehicle vehicle, DeliveryGuy deliveryGuy) {
		System.out.println("Test");
		
	}


}
