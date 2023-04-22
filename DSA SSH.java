package cyber_pracs;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Cyber_prac7 {
    public static void main(String[] args) {
try {
// Generate a 1024-bit Digital Signature Algorithm (DSA) key pair
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
keyGen.initialize(1024);
KeyPair keypair = keyGen.genKeyPair();
PrivateKey privateKey = keypair.getPrivate();
PublicKey publicKey = keypair.getPublic();
System.out.println(privateKey + "n" + publicKey);
// Generate a 576-bit DH key pair
keyGen = KeyPairGenerator.getInstance("DH");
keyGen.initialize(576);
keypair = keyGen.genKeyPair();
privateKey = keypair.getPrivate();
publicKey = keypair.getPublic();
System.out.println(privateKey + "n" + publicKey);
// Generate a 1024-bit RSA key pair
keyGen = KeyPairGenerator.getInstance("RSA");
keyGen.initialize(1024);
keypair = keyGen.genKeyPair();
privateKey = keypair.getPrivate();
publicKey = keypair.getPublic();
System.out.println(privateKey + "n" + publicKey);
} catch (java.security.NoSuchAlgorithmException e) {
}
}
}
    
