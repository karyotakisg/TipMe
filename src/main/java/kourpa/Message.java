<<<<<<< HEAD
package kourpa;

import java.util.HashMap;

public class Message {

    //Save name, category, text to Hashmap//
    public HashMap<String, HashMap<String, String>> storeMessage(String name, String tip, String categ) {
		HashMap<String, HashMap<String, String>> outer = new HashMap<>();
		HashMap<String, String> inner = new HashMap<>();
		inner.put(categ, tip);
		outer.put(name, inner);
		System.out.println(outer);
		return outer;
	}
}
=======
package kourpa;

import java.util.HashMap;

public class Message {

    //Save name, category, text to Hashmap//
    public HashMap<String, HashMap<String, String>> storeMessage(String name, String tip, String categ) {
		HashMap<String, HashMap<String, String>> outer = new HashMap<>();
		HashMap<String, String> inner = new HashMap<>();
		inner.put(categ, tip);
		outer.put(name, inner);
		System.out.println(outer);
		return outer;
	}
}
>>>>>>> c2603f34a6ac4802ccf81076ed4ab7413226a127
