package structuralDP.FacedDP;

public class CustomEncryptor {
    public static void main(String[] args) {
        //text which should be encrypted
        String text = "Content";
        //****** Bad Scenario ******

        AESEncryptor aesEncryptor = new AESEncryptor();
        aesEncryptor.encrypt(text);

        MD5Encryptor md5Encryptor = new MD5Encryptor();
        md5Encryptor.encrypt(text, "SecretKey");

        SHAEncryptor shaEncryptor = new SHAEncryptor();
        shaEncryptor.encrypt(text, "SecretKey", true);

        //****** End Bad Scenario ******

        //what is wrong with this ???

        //Using Facade DP
        System.out.println("********* Facade DP ***********");
        EncryptorFacade encryptorFacade = new EncryptorFacade();
        encryptorFacade.encrypt(text, EncryptorFacade.EncryptType.AES);


    }
}
