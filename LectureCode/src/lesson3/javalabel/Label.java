//source code from the jdk
package lesson3.javalabel;

public class Label  {
    public static final int LEFT 	= 0;
    public static final int CENTER 	= 1;
    public static final int RIGHT 	= 2;

    String text;
    int alignment = LEFT;
    public Label(String text, int alignment)  {
			this.text = text;
			setAlignment(alignment);
    }
    public int getAlignment() {
			return alignment;
    }
    public String getText() {
		return text;
    }

    public synchronized void setAlignment(int alignment) {
			switch (alignment) {
	  			case LEFT:
	  			case CENTER:
	  			case RIGHT:
	    			this.alignment = alignment;
 	    			return;
			}
			throw new IllegalArgumentException("improper alignment: " +
                                               alignment);
    }
    
    public void setText(String text) {
	  		synchronized (this) {
	    	if (text != this.text && (this.text == null ||
				      !this.text.equals(text))) {

	        		this.text = text;
	    }
	  }
    }  
    
    //Label class
    public static void main(String[] args)  {

    	Label label = new Label("Hi there!", LEFT);
    	Label label2 = label;
    	//shows that both variables contain the same reference
    	System.out.println(label + " and " + label2);
    	
//    	label.setAlignment(RIGHT);
//    	//Can access instance variables that 
//    	//are visible with "dot" notation
//    	System.out.println("Alignment: " + label.alignment);
//    	//Better to access data using getters
//    	System.out.println("Alignment: " + label.getAlignment());
//    	System.out.println("Text: " + label.getText()); 
    	
    	//try creating a second label to see object reference effect
    	Label l = new Label("Hello", LEFT);
    	Label copy = new Label("hi", CENTER);
    	copy.setText("Hello");
    	copy.setAlignment(LEFT);
    	Label another = l;
    	another.setText("Goodbye");
    	System.out.println(another.getText());
    	System.out.println(l.getText());
//    	
    	
    }
}
