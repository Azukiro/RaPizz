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
	
	public Collection<Pizza> getPizzas() throws SQLException {
		return new ArrayList<Pizza>();
		/*String requestString = "SELECT \r\n"
				+ "            pizz.id_pizza,\r\n"
				+ "            pizz.label,\r\n"
				+ "            pizz.price,\r\n"
				+ "            ingr.id_ingredient,\r\n"
				+ "            ingr.label\r\n"
				+ "        FROM pizzas         AS pizz\r\n"
				+ "        JOIN composing      AS comp     ON comp.id_pizza       = pizz.id_pizza\r\n"
				+ "        JOIN ingredients    AS ingr     ON comp.id_ingredient  = ingr.id_ingredient;\r\n";
		
		PreparedStatement pStatement = getCon().prepareStatement(requestString);
        

        ResultSet rSet = pStatement.executeQuery();
        Map<Integer, Pizza> mapPizzas = new HashMap<Integer, Pizza> ();
        Map<Integer, Ingredient> mapiIngredients = new HashMap<Integer, Ingredient> ();
        
        while(rSet.next()) {
        	int id_pizza = rSet.getInt(1);
        	String labelPizza = rSet.getNString(2);
        	double prix = rSet.getDouble(3);
        	int id_ingredient = rSet.getInt(4);
        	String labelIngredient = rSet.getNString(5);
        	if(!mapiIngredients.containsKey(id_pizza)) {
        		mapiIngredients.put(id_ingredient, new Ingredient(id_ingredient, labelIngredient));
        	}
        	if(!mapPizzas.containsKey(id_pizza)) {
        		mapPizzas.put(id_ingredient, new Pizza(id_pizza, labelPizza,prix));
        	}
        	mapPizzas.get(id_pizza).addIngredient(mapiIngredients.get(id_ingredient));
        	
        }

        
		return mapPizzas.values();*/
	}

	public ArrayList<Vehicle> uselessVehicles() throws SQLException{
		String requestString = "SELECT \r\n"
				+ "            DISTINCT(vehi.id_vehicle),\r\n"
				+ "            vehi.label\r\n"
				+ "        FROM vehicles           AS vehi     \r\n"
				+ "        LEFT JOIN orders        AS orde     ON orde.id_vehicle = vehi.id_vehicle\r\n"
				+ "        WHERE orde.id_vehicle IS NULL\r\n"
				+ "        GROUP BY vehi.id_vehicle;";

		PreparedStatement pStatement = getCon().prepareStatement(requestString);

        ResultSet rSet = pStatement.executeQuery();
        var result = new ArrayList<Vehicle>();
        
        while(rSet.next()) {
        	int id = rSet.getInt(1);
        	String label = rSet.getNString(2);
        	result.add(new Vehicle(id, label));
        }
        
        return result;
        
	}
	
	public Map<Client, Integer> nbCommandPerClient() throws SQLException{
		String requestString = "SELECT \r\n"
				+ "            clien.id_client,\r\n"
				+ "            clien.firstname,\r\n"
				+ "            clien.lastname,\r\n"
				+ "            COUNT(orde.id_order) AS `orders_nb`\r\n"
				+ "        FROM clients            AS clien     \r\n"
				+ "        JOIN orders             AS orde     ON orde.id_client = clien.id_client\r\n"
				+ "        GROUP BY clien.id_client;";
		
		PreparedStatement pStatement = getCon().prepareStatement(requestString);

        ResultSet rSet = pStatement.executeQuery();
        var result = new HashMap<Client, Integer>();
        
        while(rSet.next()) {
        	int id = rSet.getInt(1);
        	String firstname = rSet.getNString(2);
        	String lastname = rSet.getNString(3);
        	int count = rSet.getInt(4);
        	result.put(new Client(id, firstname, lastname), count);
        }
        return result;
        
	}
	
	public double getAvgCommand() throws SQLException {
		String requestString = "  SELECT\r\n"
				+ "            AVG(pizz.price * size.multiplicator)\r\n"
				+ "        FROM orders             AS orde\r\n"
				+ "        JOIN pizzas             AS pizz     ON orde.id_pizza = pizz.id_pizza\r\n"
				+ "        JOIN pizzasizes              AS size     ON orde.id_size  = size.id_size;";
		
		PreparedStatement pStatement = getCon().prepareStatement(requestString);

        ResultSet rSet = pStatement.executeQuery();
        double result = 0;
        if(rSet.next()) {
        	result = rSet.getDouble(1);
        	
        }
        return result;
	}
	
	public ArrayList<Client> clientsCommandMoreThanAvg() throws SQLException{
		String requestString = "SELECT\r\n"
				+ "            r1_clien.id_client,\r\n"
				+ "            r1_clien.firstname,\r\n"
				+ "            r1_clien.lastname\r\n"
				+ "        FROM clients            AS r1_clien\r\n"
				+ "        WHERE \r\n"
				+ "            EXISTS (\r\n"
				+ "                SELECT r2_orde.id_order\r\n"
				+ "                    FROM orders         AS r2_orde\r\n"
				+ "                JOIN pizzas             AS r2_pizz     ON r2_orde.id_pizza   = r2_pizz.id_pizza\r\n"
				+ "                JOIN pizzasizes              AS r2_size     ON r2_orde.id_size    = r2_size.id_size\r\n"
				+ "                WHERE \r\n"
				+ "                    r2_orde.id_client = r1_clien.id_client\r\n"
				+ "                        AND\r\n"
				+ "                    r2_pizz.price * r2_size.multiplicator > (\r\n"
				+ "                        SELECT\r\n"
				+ "                            AVG(r3_pizz.price * r3_size.multiplicator)\r\n"
				+ "                        FROM orders             AS r3_orde\r\n"
				+ "                        JOIN pizzas             AS r3_pizz     ON r3_orde.id_pizza = r3_pizz.id_pizza\r\n"
				+ "                        JOIN pizzasizes         AS r3_size     ON r3_orde.id_size  = r3_size.id_size\r\n"
				+ "                    )\r\n"
				+ "            )";
		
		PreparedStatement pStatement = getCon().prepareStatement(requestString);

        ResultSet rSet = pStatement.executeQuery();
        var result = new ArrayList<Client>();
        
        while(rSet.next()) {
        	int id = rSet.getInt(1);
        	String firstname = rSet.getNString(2);
        	String lastname = rSet.getNString(3);
        	result.add(new Client(id, firstname, lastname));
        }
        return result;
        
	}
	
	public Map<String,Double> getTurnoverByMonth() throws SQLException{
		String requestString = "SELECT\r\n"
				+ "        DATE_FORMAT(orde.delivry_timestamp, \"%Y/%d\"),\r\n"
				+ "        SUM(pizz.price * pisi.multiplicator) AS turnover \r\n"
				+ "    FROM orders         AS orde\r\n"
				+ "    JOIN pizzas         AS pizz     ON pizz.id_pizza = orde.id_pizza\r\n"
				+ "    JOIN pizzasizes     AS pisi     ON pisi.id_size  = orde.id_size\r\n"
				+ "    GROUP BY DATE_FORMAT(orde.delivry_timestamp, \"%Y/%d\");";
		
		PreparedStatement pStatement = getCon().prepareStatement(requestString);

        ResultSet rSet = pStatement.executeQuery();
        var result = new HashMap<String, Double>();
        while(rSet.next()) {
        	String month = rSet.getNString(1);
        	double price  = rSet.getDouble(2);
        	result.put(month,price);
        	
        }
        return result;
	}
	
	public boolean canPay(int orderId, int accountId) throws SQLException {
		String requestString = " SELECT \r\n"
				+ "        0 <= (\r\n"
				+ "            (\r\n"
				+ "                -- Client account\r\n"
				+ "                SELECT\r\n"
				+ "                    acco.account_balance\r\n"
				+ "                FROM account AS acco\r\n"
				+ "                WHERE  \r\n"
				+ "                    acco.id_client = ?\r\n"
				+ "            )\r\n"
				+ "                -\r\n"
				+ "            (\r\n"
				+ "                -- Order price\r\n"
				+ "                SELECT\r\n"
				+ "                    pizz.price * pisi.multiplicator AS price\r\n"
				+ "                FROM orders         AS orde\r\n"
				+ "                JOIN pizzas         AS pizz     ON pizz.id_pizza = orde.id_pizza\r\n"
				+ "                JOIN pizzasizes     AS pisi     ON pisi.id_size  = orde.id_size\r\n"
				+ "                WHERE  \r\n"
				+ "                    orde.id_order = ?\r\n"
				+ "            )\r\n"
				+ "        ) AS can_buy;";
		
		PreparedStatement pStatement = getCon().prepareStatement(requestString);
		pStatement.setInt(1, accountId);
		pStatement.setInt(2, orderId);
        ResultSet rSet = pStatement.executeQuery();
        boolean result = false;
        if(rSet.next()) {
        
        	result = rSet.getBoolean(1);
        	
        }
        return result;
	}
	
	public boolean isFreePizza(int orderId, int clientId) throws SQLException {
		String requestString = "  SELECT\r\n"
				+ "        (\r\n"
				+ "            (\r\n"
				+ "                -- Free 10 pizza\r\n"
				+ "                SELECT\r\n"
				+ "                    (\r\n"
				+ "                        COUNT(r2_orde.id_order) % 10\r\n"
				+ "                    ) = 0 AS free_10_pizza\r\n"
				+ "                FROM orders             AS r2_orde\r\n"
				+ "                WHERE \r\n"
				+ "                    r2_orde.id_client = ?\r\n"
				+ "            )\r\n"
				+ "                OR\r\n"
				+ "            (\r\n"
				+ "                -- Free late pizza\r\n"
				+ "                SELECT\r\n"
				+ "                    (\r\n"
				+ "                        DATEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) >= 1\r\n"
				+ "                            OR\r\n"
				+ "                        (\r\n"
				+ "                            DATEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) = 0\r\n"
				+ "                                AND\r\n"
				+ "                            TIMEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) >= \"00:30:00\"\r\n"
				+ "                        )\r\n"
				+ "                    ) AS late_order\r\n"
				+ "                FROM orders             AS r2_orde\r\n"
				+ "                WHERE \r\n"
				+ "                    r2_orde.id_order = ?\r\n"
				+ "            )\r\n"
				+ "        ) AS is_pizza_free;";
		
		PreparedStatement pStatement = getCon().prepareStatement(requestString);
		pStatement.setInt(1, clientId);
		pStatement.setInt(2, orderId);
        ResultSet rSet = pStatement.executeQuery();
        boolean result = false;
        if(rSet.next()) {
        
        	result = rSet.getBoolean(1);
        	
        }
        return result;
	}
	
	public Map<DeliveryGuy,Vehicle> worthDeliveryGuy() throws SQLException {
		String requestString = " SELECT \r\n"
				+ "            r2_degu.id_delivery_guy, \r\n"
				+ "            r2_degu.firstname,\r\n"
				+ "            r2_degu.lastname,\r\n"
				+ "            r2_vehi.id_vehicle,\r\n"
				+ "            r2_vehi.label,\r\n"
				+ "            r2_vehi.licence_plate,\r\n"
				+ "            COUNT(*) AS late_orders_nb\r\n"
				+ "        FROM deliveryguys 	AS r2_degu \r\n"
				+ "        JOIN orders 		AS r2_orde		ON r2_orde.id_delivery_guy = r2_degu.id_delivery_guy 	\r\n"
				+ "        JOIN vehicles 		AS r2_vehi      ON r2_orde.id_vehicle      = r2_vehi.id_vehicle\r\n"
				+ "        WHERE\r\n"
				+ "            DATEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) >= 1\r\n"
				+ "                OR\r\n"
				+ "            (\r\n"
				+ "                DATEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) = 0\r\n"
				+ "                    AND\r\n"
				+ "                TIMEDIFF(r2_orde.delivry_timestamp, r2_orde.order_timestamp) >= \"00:30:00\"\r\n"
				+ "            )\r\n"
				+ "        GROUP BY r2_degu.id_delivery_guy\r\n"
				+ "    	ORDER BY COUNT(*) DESC\r\n"
				+ "        LIMIT 1;";
		
		PreparedStatement pStatement = getCon().prepareStatement(requestString);
        ResultSet rSet = pStatement.executeQuery();
        var result = new HashMap<DeliveryGuy,Vehicle>();
        if(rSet.next()) {
        
        	DeliveryGuy guy = new DeliveryGuy(rSet.getInt(1),rSet.getNString(2),rSet.getNString(3));
        	Vehicle vehicle = new Vehicle(rSet.getInt(1),rSet.getNString(2),rSet.getNString(3));
        	result.put(guy,vehicle);
        	
        }
        return result;
	}
	
	public Ingredient favoriteIngredient() throws SQLException {
		String requestString = " SELECT \r\n"
				+ "        *,\r\n"
				+ "        COUNT(*) AS order_nb\r\n"
				+ "    FROM ingredients 	AS ingr \r\n"
				+ "    JOIN composing 		AS comp 	ON comp.id_ingredient = ingr.id_ingredient\r\n"
				+ "    JOIN pizzas			AS pizz  	ON pizz.id_pizza      = comp.id_pizza\r\n"
				+ "    JOIN orders			AS orde		ON orde.id_pizza      = pizz.id_pizza\r\n"
				+ "    GROUP BY ingr.id_ingredient\r\n"
				+ "    ORDER BY COUNT(*) DESC\r\n"
				+ "    LIMIT 1;";
		
		PreparedStatement pStatement = getCon().prepareStatement(requestString);
        ResultSet rSet = pStatement.executeQuery();
        Ingredient result = null;
        if(rSet.next()) {
        
        	result = new Ingredient(rSet.getInt(1),rSet.getNString(2));
        	
        }
        return result;
	}
	
	
	public boolean insertOrder(Pizza pizza, Client client, Vehicle vehicle, DeliveryGuy deliveryGuy,PizzaSize size) throws SQLException {
		final String request =  "INSERT INTO `orders`(\r\n"
				+ "    `id_order`,\r\n"
				+ "    `order_timestamp`,\r\n"
				+ "    `delivry_timestamp`,\r\n"
				+ "    `id_size`,\r\n"
				+ "    `id_vehicle`,\r\n"
				+ "    `id_client`,\r\n"
				+ "    `id_delivery_guy`,\r\n"
				+ "    `id_pizza`\r\n"
				+ ")\r\n"
				+ "VALUES(\r\n"
				+ "    NULL,\r\n"
				+ "    NOW(), \r\n"
				+ "    NULL, \r\n"
				+ "    ?, \r\n"
				+ "    ?, \r\n"
				+ "    ?, \r\n"
				+ "    ?,\r\n"
				+ "    ?\r\n"
				+ ");";
	        	
	        PreparedStatement s = getCon().prepareStatement(request);
	        s.setInt(1, size.getId());
	        s.setInt(2, vehicle.getId());
	        s.setInt(3, client.getId());
	        s.setInt(4, deliveryGuy.getId());
	        s.setInt(5, pizza.getId());
	        return !s.execute();
		
	}


}
