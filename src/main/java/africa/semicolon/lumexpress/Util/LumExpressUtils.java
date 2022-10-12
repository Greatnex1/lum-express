package africa.semicolon.lumexpress.Util;

import java.security.SecureRandom;

public class LumExpressUtils {
    public  static  String generateToken(){
        SecureRandom secureRandom = new SecureRandom();
        int number= secureRandom.nextInt(1000,99999);
        return  String.valueOf(number);
    }
}
