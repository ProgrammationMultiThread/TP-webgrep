/*
 * SPDX-License-Identifier: MIT
 * Author: Matthieu Perrin
 */

package webgrep;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Main class for the WebGrep project.
 * 
 * <p>This program recursively explores web pages starting from one or more URLs,
 * searching for keywords specified in the command line arguments. Each page is parsed
 * to extract matching text and hyperlinks, which are then explored in turn.</p>
 * 
 * <p>The sequential version is provided as a baseline. Students are asked to
 * parallelize the exploration while ensuring thread safety and correctness.</p>
 */
public class WebGrep {

	private final static LinkedList<String> explored = new LinkedList<String>();

	/*
	 *  TODO : the search must be parallelized between the given number of threads
	 */
    /**
     * Explores a given web page.
     * @param url the URL to explore
     */
	private static void explore(String url) {
		try {
			/*
			 * Check that the page was not already explored and adds it
			 * TODO : the check and insertion must be atomic. Explain why. How to do it?
			 */
			if(!explored.contains(url)) {
				explored.add(url);
				// Parse the page to find matches and hypertext links
				ParsedPage page = Tools.parsePage(url);
				if(!page.matches().isEmpty()) {
					/* 
					 * TODO: Tools.print(page) is not thread safe...
					 */
					Tools.print(page);
					// Recursively explore other pages
					for(String href : page.hrefs()) explore(href);
				}
			}
		} catch (Exception e) {/*We could retry later...*/}
	}


	public static void main(String[] args) throws InterruptedException, IOException {
		// Initialize the program using the options given in argument, or default
		if(args.length == 0) 
			args = new String[]{"-cetO", "--threads=1000", "Nantes", "https://fr.wikipedia.org/wiki/Nantes"};
		Tools.initialize(args);

		// TODO Just do it!
		System.err.println("You must parallelize the application between " + Tools.numberThreads() + " threads!\n");

		// Get the starting URL given in argument
		for(String address : Tools.startingURL()) 
			explore(address);
	}
}
