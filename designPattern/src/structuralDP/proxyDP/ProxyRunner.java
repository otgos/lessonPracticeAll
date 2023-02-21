package structuralDP.proxyDP;

public class ProxyRunner {
    public static void main(String[] args) {
        ImageGenerator proxyClass1 = new ProxyClass("c:\\image1.png");
        ImageGenerator proxyClass2 = new ProxyClass("c:\\image2.png");


        //** i can only see showImage method
        proxyClass1.showImage();
        proxyClass2.showImage();

        //**where can we use??
        // for the security conserns: for admins, for user different task

    }
}
