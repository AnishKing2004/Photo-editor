/**
 * SnapShopConfiguration
 * A class to configure the SnapShop application
 * 
 * @author !!! PUT YOUR NAME HERE !!! 
 * @version  !!! PUT DATE HERE !!!
 * 
 */
public class SnapShopConfiguration {
    /**
     * configure
     * Method to configure the SnapShop.  
     * Call methods like addFilter
     * and setDefaultFilename in this method.
     * @param theShop   The SnapShop application
     */
    public static void configure(SnapShop theShop) {
        // set default directory
        theShop.setDefaultDirectory("./Images/");
     
        theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
        theShop.addFilter(new OneColorImage(), "Change Image to the color red");
        theShop.addFilter(new DemosaicFilter(), "Demosaic");
        theShop.addFilter(new FlipHorizontal(), "FlipHorizontalFilter");
        theShop.addFilter(new SlimeFilter(), "Slime Filter");
        theShop.addFilter(new ShiftLeftFilter(), "Left Filter");
        theShop.addFilter(new MeltFilter(), "Melt Filter");
        theShop.addFilter(new TheBluesFilter(), "Scary Blue Filter");
        theShop.addFilter(new NegativeFilter(), "Negative Filter");


        // add other filters you write here:
        // the arguments to addFilter are a Filter object, followed by the 
        // text you want shown on the button
    }
    
    /** 
     * main
     * creates a new SnapShop object
     */
    public static void main(String args[]) {
      SnapShop theShop = new SnapShop();
    }  
}
