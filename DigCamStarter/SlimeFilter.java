/**
 * This filter averages out all the pixels intensities and sets it to the color green 
 * @author Anish Karumuri
 * @version 11/30/2022
 * 
 */
public class SlimeFilter implements Filter {
    public void filter(Pixel[][] data) {
        for (int row = 0; row < data.length; row++) { //two loop to go through all the pixels in the photo 
            for (int col = 0; col < data[row].length; col++) {
                setColor(row,col,data); //calls to the set color method 
            }
        }  
    }

    public void setColor(int row, int col, Pixel[][]data){ 
        int numValues = 0; // add up all the intensities 
        
        //add the intensities up
        for(int id = Pixel.RED; id <= Pixel.BLUE; id++) {
            numValues += data[row][col].getComponentById(id); //add up all of the color intensities
        }
        //                          RED          GREEEN       BLUE
        data[row][col].setAllColors(numValues/6, numValues/3, numValues/6); // dividing the green value by 3 because there are only three colors 
        // The rest of the colors are getting divided by six so that they kinda get hidden by the green. Any number could work as long as it is greater than 3
    }

   
}
