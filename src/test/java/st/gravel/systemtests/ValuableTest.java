package st.gravel.systemtests;

import org.junit.Before;
import org.junit.Test;

import st.gravel.support.jvm.runtime.ImageBootstrapper;
import st.gravel.support.jvm.runtime.MethodTools;

public class ValuableTest {
	@Before
	public void setUp() {
		st.gravel.support.compiler.testtools.TestBootstrap.getSingleton();
	}
	@Test
	public void test_argumentCount() throws Throwable {
		MethodTools.debugTest("st.gravel.ansitests.ValuableTest", "test_argumentCount");
	}
	@Test
	public void test_valueWithArguments_() throws Throwable {
		MethodTools.debugTest("st.gravel.ansitests.ValuableTest", "test_valueWithArguments_");
	}
}