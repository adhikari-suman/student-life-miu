package lesson9_stackqueue.bfssolution;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static lesson9_stackqueue.bfssolution.RandomNumbers.*;

public class Board {
	final static int SIZE = 12;
	final static int ALPHABET_SIZE = 26;
	final static int NUM_LABELS = ALPHABET_SIZE*ALPHABET_SIZE;
	static String[] labels = new String[NUM_LABELS];
	static {
		for(int i = 0; i < ALPHABET_SIZE; ++i){
			for(int j= 0; j < ALPHABET_SIZE; ++j){
				labels[(26*i + j)] =  (char)(((int)'A')+i) + "" + (char)(((int)'A')+j);
			}
		}
		//System.out.println(Arrays.toString(labels));
	}
	private List<Cell> boardCells;
	private List<List<Cell>> connectedComponents;
	/** randomly generate cells as follows
	 *  pick a random number r between SIZE^2/4 and SIZE^2/2
	 *  for each i < r, pick a label at random and pick a position at random,
	 *  without duplication of either
	 * @return
	 */
	void newBoard(){
		List<Cell> theBoard = new ArrayList<Cell>();
		int r = getRandomInt(SIZE*SIZE/4,SIZE*SIZE/2);
		//int r = SIZE*SIZE-20;
		HashMap<Integer,Integer> usedLabels = new HashMap<Integer,Integer>();
		HashMap<Position,Position> usedPositions = new HashMap<Position,Position>();
		String nextLabel = null;
		Position nextPosition = null;
		Cell nextCell = null;
		for(int i = 0; i<r; ++i){
			//get a label index
			int randLabelIndex = -1;
			do {
				randLabelIndex = getRandomInt(0,NUM_LABELS-1);
			}
			while(usedLabels.containsKey(new Integer(randLabelIndex)));
			usedLabels.put(randLabelIndex,randLabelIndex);
		
			//get a free position
			Position nextpos = null;
			do {
				nextpos = new Position(getRandomInt(0,SIZE-1),getRandomInt(0,SIZE-1));
			}
			while(usedPositions.containsKey(nextpos));
			usedPositions.put(nextpos,nextpos);
			nextCell = new Cell(labels[randLabelIndex], nextpos);
			theBoard.add(nextCell);
		}
		boardCells = theBoard;
		
	}
	public List<Cell> getBoardCells() {
		return boardCells;
	}
	/**
	 * The algorithm:
	 * 1. Iterate through the board cells
	 * 2. For each unvisited cell, do the following:
	 *    a. Create a new List<Cell>, representing a new component.
	 *    b. Add the cell to a new cell queue and mark as visited
	 *    c. while the cell queue is not empty, 
	 *       * get next cell from queue
	 *       * add it to the current component
	 *       * obtain all adjacent unvisited elements of the cell, mark
	 *         each as visited, and add them to the cell queue
	 *    d. add this component to the list of connected components
	 *    
	 *
	 */
	public void computeConnectedComponents(){
		connectedComponents = new ArrayList<List<Cell>>();
		List<Cell> nextComponent = null;
		List<Cell> adjacentCells = null;
		Queue<Cell> cellQueue = new LinkedList<Cell>();
		for(Cell cell : boardCells){
			if(!cell.visited){ 
				System.out.println(cell);
				nextComponent = new ArrayList<Cell>();
				cellQueue.add(cell);
				cell.visited=true;
				
				Cell nextCell;
				while(!cellQueue.isEmpty()){
					//System.out.println("state of cell queue: "+ cellQueue);
					nextCell = cellQueue.remove();
					//System.out.println("adding "+nextCell+" to component");
					nextComponent.add(nextCell);				
					adjacentCells = findAdjacentCells(nextCell);
					//System.out.println("cells adjacent to "+nextCell+": "+adjacentCells);
					for(Cell c : adjacentCells){
						if(!c.visited) {
							c.visited=true;
							cellQueue.add(c);					
							//System.out.println("  just added "+c+ " to cell queue");
						}
					}
				}
				connectedComponents.add(nextComponent);
			}
		}
		
	}
	public List<List<Cell>> getConnectedComponents() {
		return this.connectedComponents;
	}
	private List<Cell> findAdjacentCells(Cell cell){
		List<Cell> retVal = new ArrayList<Cell>();
		List<Position> positions = cell.adjacentPositions();
		for(Position pos : positions){
			for(Cell c : boardCells){
				if(c.position.equals(pos)) retVal.add(c);
			}
		}
		return retVal;
	}
	
	public static Board getInstance() {
		if(instance==null) {
			instance = new Board();
		}
		return instance;
	}
	private Board() {}
	private static Board instance;
	public static void main(String[] args){
		
		Board b = Board.getInstance();
		b.newBoard();
		b.computeConnectedComponents();
		List<List<Cell>> comps = b.getConnectedComponents();
		for(List<Cell> l : comps){
			System.out.println(l);
		}
		
	}
}
