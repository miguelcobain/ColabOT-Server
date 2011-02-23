package pt.uminho.sd.pi;

import java.util.ArrayList;

public class Document {

	int id;
	String text;
	ArrayList<WebSocket> owners;
	int myState, othersState;




	public Document(int id, String text, ArrayList<WebSocket> owners) {
		this.id = id;
		this.text = text;
		this.owners = owners;
		this.myState = 0;
		this.othersState = 0;
	}


	public Document() {
		this.id = 0;
		this.text = "";
		this.owners = new ArrayList<WebSocket>();
		this.myState = 0;
		this.othersState = 0;
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


	public int getMyState() {
		return myState;
	}


	public void setMyState(int myState) {
		this.myState = myState;
	}


	public int getOthersState() {
		return othersState;
	}


	public void setOthersState(int othersState) {
		this.othersState = othersState;
	}


	public void add(int index, String string ){
		String head = text.substring(0, index-1);
		String tail = text.substring(index-1);
		text = head+string+tail;
		myState++;
		System.out.println("*********new text*********\n"+text);
	}

	public void remove(int index, int length){
		String head = text.substring(0, index-1);
		String tail = text.substring(index-1+length);
		text = head+tail;
		myState++;
		System.out.println("*********new text*********\n"+text);

	}

	public void replace(int index, int length, String string){
		remove(index-1,length-1);
		add(index-1,string);	
		myState++;
		System.out.println("*********new text*********\n"+text);
	}


}
