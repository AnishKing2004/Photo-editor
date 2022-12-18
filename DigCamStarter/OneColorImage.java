/**
 * This filter was my first filter it just turns the whole image red.
 * The point of this filter is to make sure I actually understood what I was doing 
 * @author Anish Karumuri 
 * @version 11/30/2022
 * 
 */
public class OneColorImage implements Filter {
    public void filter(Pixel[][] data) {
        
        for (int row = 0; row < data.length; row++) { // goes through all the pixels
            for (int col = 0; col < data[row].length; col++) {
                data[row][col].keepSingleColor(Pixel.RED); //changes all the pixels to the color red 
            }
        }  
    }
}