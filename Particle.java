/* Particle.java
 *
 * Particle class used by ParticleSwarmOptimization.java
 * Contains the positions of the queens in a solution as well as its conflicts, and velocity. 
 * Found at http://mnemstudio.org/ai/pso/pso_tsp_java_ex1.txt
 *
 * @author: James M. Bayon-on
 * @version: 1.3
 */

public class Particle  implements Comparable<Particle> {
	private int MAX_LENGTH;
    private int data[];
    private double velocity; //fitness
    private int conflicts; //pBest

    /* Instantiate a particle.
     *
     * @param: size of n
     */
    public Particle(int n) {
    	MAX_LENGTH = n;
    	data = new int[MAX_LENGTH];
        this.velocity = 0.0;
        this.conflicts = 0;
        initData();
    }

    /* Compares two particles.
	 *
	 * @param: a particle to compare with
	 */	
    public int compareTo(Particle p) {
    	return this.conflicts - p.getConflicts();
    }

    /* Computes the conflicts in the nxn board.
	 *
	 */
	public void computeConflicts() { //compute the number of conflicts to calculate fitness
		String board[][] = new String[MAX_LENGTH][MAX_LENGTH]; //initialize board
		int x = 0; //row
        int y = 0; //column
        int tempx = 0; //temprow
        int tempy = 0; //temcolumn
        
        int dx[] = new int[] {-1, 1, -1, 1}; //to check for diagonal
        int dy[] = new int[] {-1, 1, 1, -1}; //paired with dx to check for diagonal
        
        boolean done = false; //used to check is checking fo diagonal is out of bounds
        int conflicts = 0; //number of conflicts found
        
        clearBoard(board); //clears the board into empty strings
        plotQueens(board); // plots the Q in the board
 
        // Walk through each of the Queens and compute the number of conflicts.
        for(int i = 0; i < MAX_LENGTH; i++) {
            x = i;
            y = data[i];

            // Check diagonals.
            for(int j = 0; j < 4; j++) { // because of dx and dy where there are 4 directions for diagonal searching for conflicts
                tempx = x;
                tempy = y; // store coordinate in temp
                done = false;
                
                while(!done) {//traverse the diagonals
                    tempx += dx[j];
                    tempy += dy[j];
                    
                    if((tempx < 0 || tempx >= MAX_LENGTH) || (tempy < 0 || tempy >= MAX_LENGTH)) { //if exceeds board
                        done = true;
                    } else {
                        if(board[tempx][tempy].equals("Q")) {
                            conflicts++;
                        }
                    }
                }
            }
        }

        this.conflicts = conflicts; //set conflicts of this particle
        
	}
	
	/* Plots the queens in the board.
	 *
	 * @param: a nxn board
	 */
	public void plotQueens(String[][] board) {
        for(int i = 0; i < MAX_LENGTH; i++) {
            board[i][data[i]] = "Q";
        }
	}
	
	/* Clears the board.
	 *
	 * @param: a nxn board
	 */
	public void clearBoard(String[][] board) {
		for (int i = 0; i < MAX_LENGTH; i++) {
			for (int j = 0; j < MAX_LENGTH; j++) {
				board[i][j] = "";
			}
		}
	}
	

	/* Initializes the particle into diagonal queens.
	 *
	 */
    public void initData() {
    	for(int i = 0; i < MAX_LENGTH; i++) {
    		data[i] = i;
    	}
    }

	/* Gets the data on a specified index.
	 *
	 * @param: index of data
	 * @return: position of queen
	 */
    public int getData(int index)  {
    	return this.data[index];
    }
    
    /* Sets the data on a specified index.
	 *
	 * @param: index of data
	 * @param: new position of queen
	 */
    public void setData(int index, int value) {
        this.data[index] = value;
    }
    
    /* Gets the conflicts of the particle.
	 *
	 * @return: number of conflicts of the particle
	 */
    public int getConflicts() {
    	return this.conflicts;
    }

    /* Sets the conflicts of the particle.
	 *
	 * @param: new number of conflicts
	 */
    public void setConflicts(int conflicts) {
    	this.conflicts = conflicts;
    }

	/* Gets the velocity of the particle.
	 *
	 * @return: velocity of particle
	 */
    public double getVelocity()  {
    	return this.velocity;
    }
    
    /* Sets the velocity of the particle.
	 *
	 * @param: new velocity of particle
	 */
    public void setVelocity(double velocityScore) {
       this.velocity = velocityScore;
    }
    
    /* Gets the max length.
	 *
	 * @return: max length
	 */
    public int getMaxLength() {
    	return MAX_LENGTH;
    }
// end particle
}
