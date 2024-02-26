//source code from the jdk
package lesson3.label2.constants;

public class Label  {
    
    String text;
    int alignment = LabelConstants.LEFT;
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
	  			case LabelConstants.LEFT:
	  			case LabelConstants.CENTER:
	  			case LabelConstants.RIGHT:
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
    	Label label = new Label("Hi", 5);
//    	Label label = new Label("Hi there!", LabelConstants.LEFT);
//    	//Label label2 = new Label("text", 17);
//    	
//    	
//    	label.setAlignment(LabelConstants.RIGHT);
//    	//Can access instance variables that 
//    	//are visible with "dot" notation
//    	System.out.println("Alignment: " + label.alignment);
//    	//Better to access data using getters
//    	System.out.println("Alignment: " + label.getAlignment());
//    	System.out.println("Text: " + label.getText()); 
    	
    	//try creating a second label to see object reference effect
//    	Label l = new Label("Hello", LEFT);
//    	Label another = l;
//    	another.setText("Goodbye");
//    	System.out.println(another.getText());
//    	System.out.println(l.getText());
//    	
    	
    }
}
