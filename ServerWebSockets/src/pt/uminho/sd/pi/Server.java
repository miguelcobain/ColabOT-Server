package pt.uminho.sd.pi;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Server extends WebSocketServer{

	/**
	 * @param args
	 * 
	 */
	HashMap<Integer, Document> docs;

	public Server(int port){

		super(port);
		System.out.println("Servidor iniciado na porta:"+ port);
		docs = new HashMap<Integer, Document>();
		docs.put(1, new Document());
		start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Server server = new Server(8000);


	}

	@Override
	public void onClientOpen(WebSocket conn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClientClose(WebSocket conn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClientMessage(WebSocket conn, String message) {
		// TODO Auto-generated method stub

		System.out.println("Nova Mensagem:" + message);
		try {
			conn.send(message);
			parser(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void parser(String json){

		try {
			//Get the message
			JSONObject j = new JSONObject(json);
			JSONArray op = j.getJSONArray("msg");
			JSONObject operationsObj = op.getJSONObject(0) ;
			JSONObject stateobj = op.getJSONObject(1);

			JSONArray operations = operationsObj.getJSONArray("operation");
			Document doc = docs.get(1);
			for(int i=0; i<operations.length();i++){
				//Get all operations
				JSONObject operation = operations.getJSONObject(i);
				String opname = operation.getString("_type");
				JSONArray args = operation.getJSONArray("_args");

				if(opname.compareTo("add")==0){
					int index = args.getInt(0);
					String insert = args.getString(1);					
					doc.add(index, insert);
					System.out.println("Operation:"+opname+" Position:"+index+" String:"+insert);

				}else if(opname.compareTo("del")==0){
					int index = args.getInt(0);
					int length = args.getInt(1);
					doc.remove(index, length);
					System.out.println("Operation:"+opname+" Position:"+index+" Length:"+length);

				}else if(opname.compareTo("rep")==0){
					int index = args.getInt(0);
					int length = args.getInt(1);
					String insert = args.getString(2);
					doc.replace(index, length, insert);
					System.out.println("Operation:"+opname+" Position:"+index+" Length:"+length+" String:"+insert);

				}
				else{

					System.out.println("give exception - no operation");
				}


			}

		} catch (JSONException e) {System.out.println("Error on message inside json!! "+ e);} 


	}



}
