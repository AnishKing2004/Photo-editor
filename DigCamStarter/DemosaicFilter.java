/**
 * Filter that copies image to the right; demosaic
 * @author Anish Karumuri
 * modified 11/23/2022
 */
public class DemosaicFilter implements Filter {
    // no instance variables -- no state of objects
    /** 
     * filter
     * 
     * @param data The Pixel array object to modify
     */
    public void filter(Pixel[][] data) {
        for (int row = 0; row < data.length; row++) { //two loop to go through all the pixels in the photo 
            for (int col = 0; col < data[row].length; col++) {
                setColor(Pixel.RED,row,col,data); //calls to the set color method 
                setColor(Pixel.BLUE,row,col,data); 
                setColor(Pixel.GREEN,row,col,data);
            }
        }  
    }

    public void setColor(int id, int row, int col, Pixel[][]data){ // this method gets 3 calls from the main method, one for each color
        int endCol = Math.min(data[row].length - 1, col + 1 ); // lower out of bounds checkers 
        int endRow = Math.min(data.length - 1, row + 1); //lower out of bounds checker
        int startRow = Math.max(0,row -1); //upper out of bounds checker 
        int startCol = Math.max(0, col - 1); // upper out of bounds checker 
        int numValues = 0; // add up all the intensities 
        int numAmount= 0; // the amount of intensities being added up   
        int natural = data[row][col].getDigCamColor(); // checks the natural the color (the color that doesn't need to be changed)
        if(natural == id){ //if the color given is the natural color than don't do anything
            return;
        }
        for( int i = startRow; i <= endRow; i++){ //loops to see the 3 by 3 pixels surrounding the main pixel that needs to be fixed
            for( int j = startCol; j <= endCol; j++){
                natural = data[i][j].getDigCamColor(); 
                if (id == natural){ //checks if the color is equal to the color found in the digcam 
                    numValues += data[i][j].getComponentById(id); //add the intensities up
                    numAmount++; // increases the amount 
                }
            }
        }
        data[row][col].setComponentById(id, numValues/numAmount); // sets the value of whatever color is passed through, shoves in the intesity via the average 
    }
}





