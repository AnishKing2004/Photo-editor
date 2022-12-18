
/**
 * Grabs the average of the pixel above the current pixel and sets it to the current pixel.
 * This creates a melting effect.
 *
 * @author Anish Karumuri
 * @version 11/30/2022
 */
public class MeltFilter implements Filter
{
    public void filter(Pixel[][] data) {
        for (int row = 1; row < data.length; row++) { //two loop to go through all the pixels in the photo 
            for (int col = 0; col < data[row].length; col++) {
                setColor(Pixel.RED,row,col,data); //calls to the set color method 
                setColor(Pixel.BLUE,row,col,data); 
                setColor(Pixel.GREEN,row,col,data);
            }
        }  
    }

    public void setColor(int id, int row, int col, Pixel[][]data){ // this method gets 3 calls from the main method, one for each color
        int endCol = Math.min(data[row].length - 1, col + 1 ); // lower out of bounds checkers 
        int startCol = Math.max(0, col - 1); // upper out of bounds checker 
        int numValues = 0; // add up all the intensities 
        int numAmount= 0; // the amount of intensities being added up   
        
            for( int j = endCol; j >= startCol; j--){
                    numValues += data[row - 1][j].getComponentById(id); //add the intensities up
                    numAmount++; // increases the amount 
                
            
        }
        data[row][col].setComponentById(id, numValues/numAmount); // sets the value of whatever color is passed through, shoves in the intesity via the average 
    }
}
