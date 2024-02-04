package crud;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Encrypt {

    public static String getmd5Java(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            
//            Merubah byte array kedalam string hexa
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for(byte b : hash) {
                sb.append(String.format("%02x", b&0xff));
            }
            digest = sb.toString();
        } catch(UnsupportedEncodingException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NoSuchAlgorithmException ex) {
            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
        }
        return digest;
    }
    
}
