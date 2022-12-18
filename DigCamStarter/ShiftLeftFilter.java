
/**
 * Shifts the whole image to the left
 *
 * @author (Anish Karumuri)
 * @version (11/29/2022)
 */
public class ShiftLeftFilter implements Filter
{
  public void filter(Pixel[][] data) {
        // goes through all of the pixels 
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length - 1; col++) {
                Pixel temp = data[row][col]; //stores the current color values at the current pixel
                data[row][col] = data[row][col + 1]; //the current value becomes the value of the next pixel 
                data[row][col + 1] = temp; // the next pixel becomes the value of the current pixel
            }
        }  
    }
}
