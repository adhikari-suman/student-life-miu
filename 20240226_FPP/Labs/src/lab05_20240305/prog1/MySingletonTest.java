package lab05_20240305.prog1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MySingletonTest {

	@Test
	public void testInstanceSame() {
		// Arrange
		MySingleton m1 = MySingleton.getInstance();
		MySingleton m2 = MySingleton.getInstance();

		// Act
		m1.setA(12);
		m2.setA(13);

		// Assert
		assertEquals(m1.getA(), m2.getA());
		assertEquals(13, m2.getA());	
		assertEquals(13, m1.getA());
	}

}
