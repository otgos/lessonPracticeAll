package structuralDP.proxyDP;

public class ProxyClass implements ImageGenerator{

    private RealClass realClass;

    private String fullPath;

    //constructor for fullPath
    public ProxyClass(String fullPath) {
        this.fullPath = fullPath;
    }

    //** if i want to change show image path from real class
    @Override
    public void showImage() {

        //first check if real class exist or not
        //**since we did not create obj it will be null
        if(realClass==null){
            realClass = new RealClass(fullPath);
            realClass.showImage();
        }

    }
}
