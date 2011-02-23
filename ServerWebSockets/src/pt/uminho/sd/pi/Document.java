package pt.uminho.sd.pi;

import java.util.ArrayList;

public class Document {

	int id;
	String text;
	ArrayList<WebSocket> owners;





	public Document(int id, String text, ArrayList<WebSocket> owners) {
		this.id = id;
		this.text = text;
		this.owners = owners;
	}


	public Document() {
		this.id = 0;
		this.text = "";
		this.owners = new ArrayList<WebSocket>();
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<WebSocket> getOwners() {
		return owners;
	}
	public void setOwners(ArrayList<WebSocket> owners) {
		this.owners = owners;
	}

	public void add(int index, String string ){
		if(index>text.length()){
			
			
		}else{	
		
		String head = text.substring(0, index);
		String tail = text.substring(index+1);
		text = head+string+tail;
		}
		System.out.println("*********new text*********\n"+text);
	}

	public void remove(int index, int length){
		String head = text.substring(0, index);
		String tail = text.substring(index+1+length);
		text = head+tail;
		System.out.println("*********new text*********\n"+text);

	}

	public void replace(int index, int length, String string){
		remove(index,length);
		add(index,string);		
		System.out.println("*********new text*********\n"+text);
	}


}
