package com.mycompany.medistock.dao;
import com.mycompany.medistock.entity.User;

/**
 *
 * @author ADMINZ
 */
public class UserDao {
    
    //phương thức kiểm tra mật khẩu
    public boolean checkUser(User user){
        if(user == null) return false;
        
        if(user.getUserName().equals("admin") 
                && user.getPassword().equals("admin")){
            return true;
        }
        return false;
    }
}
