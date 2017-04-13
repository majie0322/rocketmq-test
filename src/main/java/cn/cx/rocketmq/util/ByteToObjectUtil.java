package cn.cx.rocketmq.util;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import cn.cx.rocketmq.entity.User;

public class ByteToObjectUtil {
	 
	public static Object ByteToObject(byte[] bytes) {  
		 User user = null;  
		 try {  
		     // bytearray to object  
		     ByteArrayInputStream bi = new ByteArrayInputStream(bytes);  
		     ObjectInputStream oi = new ObjectInputStream(bi);  
		   
		     user =(User) oi.readObject();  
		     bi.close();  
		     oi.close();  
		 } catch (Exception e) {  
		     System.out.println("translation" + e.getMessage());  
		     e.printStackTrace();  
		 }  
		        return user;  
		    }  

}
