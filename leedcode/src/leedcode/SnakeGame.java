package leedcode;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	int[][] food;
	int pos[]=new int[2];
	int len=1;
	int foodIndex=0;
	int height;
	int width;
	Queue<int[]> snack=new LinkedList<int[]>();
    public SnakeGame(int width, int height, int[][] food) {
    	int tem[]=new int[2];
    	snack.add(tem);
        this.food=food;
        this.height=height;
        this.width=width;
        
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
		int tem[]=pos.clone();
    	switch(direction){
    	case "U":tem[0]--;break;
    	case "D":tem[0]++;break;
    	case "L":tem[1]--;break;
    	case "R":tem[1]++;break;
    	}
    	pos=tem;
    	for(int[] each:snack){
    		if(tem[0]==each[0]&&tem[1]==each[1]&&!each.equals(snack.peek()))//ok to hit the last tail
    			return -1;
    	}
    	if(tem[0]>height-1||tem[0]<0|tem[1]>width-1||tem[1]<0)
    		return -1;
    	else if(foodIndex>=food.length){//when last food is over 
    		snack.add(tem);
    		snack.poll();
    		return foodIndex;
    	}
    	else if(tem[0]==food[foodIndex][0]&&tem[1]==food[foodIndex][1]){
    		foodIndex++;
    		snack.add(tem);
    		return foodIndex;
    	}
    	else{
    		snack.add(tem);
    		snack.poll();
    		return foodIndex;
    	}
    }
}
