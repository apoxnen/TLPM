package fi.me.tlpm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomi Panula on 24.3.2017.
 */

public class Item {

    String password;
    String passpassword;

    List<Item> items = new ArrayList<Item>();
    List<String> itemNames = new ArrayList<String>();



    public Item(String itemName, String password, String newpasspassword){
        String name = itemName;
        setPassword(password);
        passpassword = newpasspassword;

    }

    public void setPassword(String newPassword){
        password = newPassword;
    }

    public boolean addItem(String name, String password, String passpassword){
        boolean valid = !itemNames.contains(name) && passwordIsLegit(passpassword);
        if(valid){
            items.add(new Item(name, password, passpassword));
            itemNames.add(name);
        }
        return valid;
    }

    public boolean passwordIsLegit(String password){
        boolean validLength = password.length() >= 8;
        int upperCounter = 0;
        int lowerCounter = 0;
        int specialCounter = 0;
        int upperCounter_whole = 0;
        int lowerCounter_whole = 0;
        int specialCounter_whole = 0;
        boolean validChars = false;
        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                upperCounter ++;
                upperCounter_whole ++;
                lowerCounter = 0;
                specialCounter = 0;
            }else if(Character.isUpperCase(password.charAt(i))){
                lowerCounter ++;
                lowerCounter_whole ++;
                upperCounter = 0;
                specialCounter = 0;
            }else{
                specialCounter ++;
                specialCounter_whole ++;
                upperCounter = 0;
                lowerCounter = 0;
            }
            validChars = (upperCounter < 3) &&
                    (lowerCounter < 3) &&
                    (specialCounter < 3) &&
                    (upperCounter_whole >= password.length()/4) &&
                    (lowerCounter_whole >= password.length()/4) &&
                    (specialCounter_whole >= password.length()/4);
        }
        return validChars && validLength;
    }

}
