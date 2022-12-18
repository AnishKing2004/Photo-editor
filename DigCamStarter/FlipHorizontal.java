/**
 * Filter that flips the image horizontally.
 * @author Anish Karumuri
 * @version 11/30/2022
 * 
 */
public class FlipHorizontal implements Filter {
    public void filter(Pixel[][] data) {
        
        for (int row = 0; row < data.length; row++) { //two for loops which run through all of the pixels in the photo
            for (int col = 0; col < data[row].length / 2; col++) {
                // swap values across center line
                Pixel temp = data[row][col]; //storing the current values
                data[row][col] = data[row][ data[row].length - col - 1]; //setting the values next to it as current value
                data[row][ data[row].length - col - 1] = temp; // setting the current value as the value next to it 
                //switch case type of apporach
            }
        }  
        
    }
}