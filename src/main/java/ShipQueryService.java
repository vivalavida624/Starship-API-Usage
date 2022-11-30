import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import javassist.compiler.ast.NewExpr;

public class ShipQueryService {

	public static void main(String[] args) {

		// ask to input Integer to finish the query URL
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("type in a Interger to query Starship");
		
		int id = input.nextInt();
		
		String queryURL = new String("https://swapi.dev/api/starships/"+id+"/");
		
	
		// query by URL
		
		Client clt = ClientBuilder.newClient();
		
		WebTarget trg = clt.target(queryURL);
		
		// JSON to object 
		Starship response  = trg.request(MediaType.APPLICATION_JSON).get(Starship.class);
		
	
		// Display the attributes
		System.out.println("name:" + response.getName());
		System.out.println("model:" + response.getModel());
		System.out.println("manufacturer:" + response.getManufacturer());
		
	}

}
