package structuralDP.proxyDP;

public class RealClass implements ImageGenerator{

    //path of the image
    private String fullPath;

    //create constructor for the path
    public RealClass(String fullPath) {
        this.fullPath = fullPath;
    }

    //this method will be displayed in
    @Override
    public void showImage() {
        System.out.println("Display image path... " +fullPath);

    }

    //** I may have some other methods in this file

    //method to change imamge
    public void changeImage(){
        //many lines of code inside
    }

    //or method to change format of image
    public void changeFormatOfImage(){
        //many lines of code to change format of image
    }


}
