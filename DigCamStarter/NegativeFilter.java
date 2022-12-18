
/**
 * The negative filter inverts the color and brightness of an image 
 *
 * @author (Anish Karumuri)
 * @version (11/30/2022)
 */
public class NegativeFilter implements Filter
{
    public void filter(Pixel[][] data) {
        for (int row = 0; row < data.length; row++) { //two loop to go through all the pixels in the photo 
            for (int col = 0; col < data[row].length; col++) {
                setNegative(row,col,data); //calls to the set negative method 
                
            }
        }  
    }

    public void setNegative(int row, int col, Pixel[][]data){ // this method turns the pixels negative 
        int numValues = 0; // add up all the intensities 
        for(int id = Pixel.RED; id <= Pixel.BLUE; id++) { // gets the intensitys of the color at the pixel
            numValues += data[row][col].getComponentById(id); //adds up all of the intensities 
        }
        
        data[row][col].setAllColors(255 - numValues, 255 - numValues,255 - numValues); // Takes the intensity and substracts from the max number to get the negativity
    }
}
