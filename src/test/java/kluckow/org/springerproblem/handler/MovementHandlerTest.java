package kluckow.org.springerproblem.handler;

import org.junit.Before;
import org.junit.Test;

import kluckow.org.springerproblem.view.components.Knight;

public class MovementHandlerTest<T> {

	MovementHandler<?> movementHandler;

	@Before
	public void setup() {
		this.movementHandler = new MovementHandler<T>((T) new Knight());
	}

	@Test
	public void testValidate() {

	}
}