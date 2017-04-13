package cn.cx.rocketmq.util;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import cn.cx.rocketmq.entity.User;

public class ObjectToByteUtil {
	
	public static byte[] ObjectToByte(String name,Integer age,String job) {  
		User user = new User(name, age, job);
	    byte[] bytes = null;  
	    try {  
	        // object to bytearray  
	        ByteArrayOutputStream bo = new ByteArrayOutputStream();  
	        ObjectOutputStream oo = new ObjectOutputStream(bo);  
	        oo.writeObject(user);  
	  
	        bytes = bo.toByteArray();  
	  
	        bo.close();  
	        oo.close();  
	    } catch (Exception e) {  
	        System.out.println("translation" + e.getMessage());  
	        e.printStackTrace();  
	    }  
	    return bytes;  
	}  

}
