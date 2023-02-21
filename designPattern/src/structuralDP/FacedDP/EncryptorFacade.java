package structuralDP.FacedDP;

public class EncryptorFacade {
    private AESEncryptor aesEncryptor = new AESEncryptor();
    private MD5Encryptor md5Encryptor = new MD5Encryptor();
    private SHAEncryptor shaEncryptor = new SHAEncryptor();

    //for the second parameter, i need select one of above 3... what can i do?
    public void encrypt(String text, EncryptType encryptType){

        switch (encryptType){
            case MD5:md5Encryptor.encrypt(text, "SecretKey");
            break;
            case SHA:shaEncryptor.encrypt(text, "SecretKey", true);
            break;
            case AES:aesEncryptor.encrypt(text);
            break;
            default:throw new IllegalArgumentException(encryptType.toString());
        }

    }
    public enum EncryptType{
        SHA,
        MD5,
        AES
    }
}
