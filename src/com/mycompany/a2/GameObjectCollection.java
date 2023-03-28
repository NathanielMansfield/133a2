package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements IIterator {

	Vector<GameObject> theWorldVector;
	
	public GameObjectCollection() {
		theWorldVector = new Vector<GameObject>();
	}
	
	public void add(GameObject obj) {
		theWorldVector.add(obj);
	}
	
	@Override
	public boolean hasNext() {
		
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameObject getNext() {
		return null;
		// TODO Auto-generated method stub
		
	}

}
