
/**
 * Turns the image into a scary blue color 
 * @author Anish Karumuri
 * @version 11/30/2022
 */
public class TheBluesFilter implements Filter
{
    public void filter(Pixel[][] data) {
        for (int row = 0; row < data.length; row++) { //two loop to go through all the pixels in the photo 
            for (int col = 0; col < data[row].length; col++) {
                setBlueColor(row,col,data); //calls to the set color method 
                
            }
        }  
    }

    public void setBlueColor(int row, int col, Pixel[][]data){ 
        int numValues = 0; // contains the intensities 
        
        //add the intensities up
        for(int id = Pixel.RED; id <= Pixel.BLUE; id++) {
            numValues += data[row][col].getComponentById(id); 
        }
        //                          RED           GREEN          BLUE
        data[row][col].setAllColors(numValues/40, numValues/40, numValues); // the values of the other colors are divided by 40 which causes blue to dominate the pixels
        // this results in a scary blue filter which makes any image look creepy
    }
    
    
    

}
