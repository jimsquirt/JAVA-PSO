/* TesterPSO.java
 *
 * Runs ParticleSwarmOptimization.java and logs the results into a file using Writer.java.
 * PSO testing setup is according to pass/fail criteria
 * Pass criteria - 50 success
 * Fail criteria - 100 failures
 *
 * @author: James M. Bayon-on
 * @version: 1.3
 */

public class TesterPSO {
	Writer logWriter;
	ParticleSwarmOptimization pso;
	int MAX_RUN;
	int MAX_LENGTH;
	long[] runtimes;

	/* Instantiates the TesterPSO class
	 *
	 */
	public TesterPSO() {
		logWriter = new Writer();
		MAX_RUN = 50;
		runtimes = new long[MAX_RUN];
	}

	/* Test method accepts the N/max length, and parameters mutation rate and max epoch to set for the PSO accordingly.
	 *
	 * @param: max length/n
	 * @param: max velocity for PSO
	 * @param: max epoch for PSO
	 */
	public void test(int maxLength, double maxVelocity, int maxEpoch) {
		MAX_LENGTH = maxLength;
		pso = new ParticleSwarmOptimization(MAX_LENGTH);		//instantiate and define params for PSO here
		pso.setVMax(maxVelocity);
		pso.setMaxEpoch(maxEpoch);
		long testStart = System.nanoTime();
		String filepath = "PSO-N"+MAX_LENGTH+"-"+maxVelocity+"-"+maxEpoch+".txt";
		long startTime = 0;
        long endTime = 0;
        long totalTime = 0;
        int fail = 0;
        int success = 0;
        
		logParameters();
        
        for(int i = 0; i < MAX_RUN; ) {												//run 50 sucess to pass passing criteria
        	startTime = System.nanoTime();
        	if(pso.algorithm()) {
        		endTime = System.nanoTime();
        		totalTime = endTime - startTime;
        		
        		System.out.println("Done");
        		System.out.println("run "+(i+1));
            	System.out.println("time in nanoseconds: "+totalTime);
            	System.out.println("Success!");
            	
            	runtimes[i] = totalTime;
            	i++;
            	success++;
            	
            	//write to log
            	logWriter.add((String)("Run: "+i));
            	logWriter.add((String)("Runtime in nanoseconds: "+totalTime));
            	logWriter.add((String)("Found at epoch: "+pso.getEpoch()));
            	logWriter.add((String)("Population size: "+pso.getPopSize()));
            	logWriter.add("");
            	
            	for(Particle p: pso.getSolutions()) {								//write solutions to log file
					logWriter.add(p);
					logWriter.add("");
    			}
        	} else {																//count failures for failing criteria
        		fail++;
        		System.out.println("Fail!");
        	}
        	
        	if(fail >= 100) {
        		System.out.println("Cannot find solution with these params");
        		break;
        	}
        	startTime = 0;															//reset time
        	endTime = 0;
        	totalTime = 0;
        }
	
        System.out.println("Number of Success: " +success);
        System.out.println("Number of failures: "+fail);
        logWriter.add("Runtime summary");
        logWriter.add("");
        
		for(int x = 0; x < runtimes.length; x++){									//print runtime summary
			logWriter.add(Long.toString(runtimes[x]));
		}
		
		long testEnd = System.nanoTime();
		logWriter.add(Long.toString(testStart));
		logWriter.add(Long.toString(testEnd));
		logWriter.add(Long.toString(testEnd - testStart));
		
      
       	logWriter.writeFile(filepath);
       	printRuntimes();
	}

	/* Converts the parameters of PSO to string and adds it to the string list in the writer class
	 *
	 */
	public void logParameters() {
        logWriter.add("Particle Swarm Optimization Algorithm");
        logWriter.add("Parameters");
        logWriter.add((String)("MAX_LENGTH/N: "+MAX_LENGTH));
        logWriter.add((String)("STARTING_POPULATION: "+pso.getParticleCount()));
        logWriter.add((String)("MAX_EPOCHS: "+pso.getMaxEpoch()));
        logWriter.add((String)("MAX_VELOCITY: "+pso.getVmax()));
        logWriter.add((String)("MINIMUM_SHUFFLES: "+pso.getShuffleMin()));
        logWriter.add((String)("MAXIMUM_SHUFFLES: "+pso.getShuffleMax()));
        logWriter.add("");
	}

	/* Prints the runtime summary in the console
	 *
	 */
	public void printRuntimes() {
		for(long x: runtimes){
			System.out.println("run with time "+x+" nanoseconds");
		}	
	}

	public static void main(String args[]) {
		TesterPSO tester = new TesterPSO();

		tester.test(4, 4, 1000);
/*		tester.test(8, 4, 1000);
		tester.test(12, 4, 1000);
		tester.test(16, 4, 1000);
		tester.test(20, 4, 1000);
	
		tester.test(16, 4, 1000);
		tester.test(16, 8, 1000);
		tester.test(16, 12, 1000);
		tester.test(16, 16, 1000);
		tester.test(16, 20, 1000);
		
		tester.test(16, 4, 5000);
		tester.test(16, 8, 5000);
		tester.test(16, 12, 5000);
		tester.test(16, 16, 5000);
		tester.test(16, 20, 5000);
		
		tester.test(16, 4, 10000);
		tester.test(16, 8, 10000);
		tester.test(16, 12, 10000);
		tester.test(16, 16, 10000);
		tester.test(16, 20, 10000);

		tester.test(16, 4, 50000);
		tester.test(16, 8, 50000);
		tester.test(16, 12, 50000);
		tester.test(16, 16, 50000);
		tester.test(16, 20, 50000);
		
		tester.test(16, 4, 100000);
		tester.test(16, 8, 100000);
		tester.test(16, 12, 100000);
		tester.test(16, 16, 100000);
		tester.test(16, 20, 100000);
		
		tester.test(20, 4, 1000);
		tester.test(20, 8, 1000);
		tester.test(20, 12, 1000);
		tester.test(20, 16, 1000);
		tester.test(20, 20, 1000);
		
		tester.test(20, 4, 5000);
		tester.test(20, 8, 5000);
		tester.test(20, 12, 5000);
		tester.test(20, 16, 5000);
		tester.test(20, 20, 5000);
		
		tester.test(20, 4, 10000);
		tester.test(20, 8, 10000);
		tester.test(20, 12, 10000);
		tester.test(20, 16, 10000);
		tester.test(20, 20, 10000);
		
		tester.test(20, 4, 50000);
		tester.test(20, 8, 50000);
		tester.test(20, 12, 50000);
		tester.test(20, 16, 50000);
		tester.test(20, 20, 50000);
		
		tester.test(20, 4, 100000);
		tester.test(20, 8, 100000);
		tester.test(20, 12, 100000);
		tester.test(20, 16, 100000);
		tester.test(20, 20, 100000);

		tester.test(20, 4, 500000);
		tester.test(20, 8, 500000);
		tester.test(20, 12, 500000);
		tester.test(20, 16, 500000);
		tester.test(20, 20, 500000);
*/
	}
}
