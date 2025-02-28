package cn.hutool.core.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.function.Function;

public class Issue3516Test {

	@Test
	public void getTypeArgumentTest() {
		final Type typeArgument = TypeUtil.getTypeArgument(Demo.class, 0);
		assertEquals(B.class, typeArgument);
	}

	static class Demo implements A2B{
		@Override
		public A apply(B arg0) {
			final A a = new A();
			return a;
		}
	}

	static class A {
		private String name;
	}

	static class B {
		private String name;
	}

	interface A2B extends Function<B, A> {
	}
}
