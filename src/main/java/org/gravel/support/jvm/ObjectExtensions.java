package org.gravel.support.jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.gravel.core.Symbol;
import org.gravel.support.jvm.runtime.ImageBootstrapper;
import org.gravel.support.jvm.runtime.MethodTools;
import org.gravel.support.parser.ClassMapping;

public class ObjectExtensions {
	public static Method getCloneMethod(Class clazz) {
		try {
			return clazz.getMethod("clone");
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	public static <X> X assert_(X receiver, boolean test) {
		if (!test) {
			throw new AssertionFailed();
		}
		return receiver;
	}

	public static <X> X deny_(X receiver, boolean test) {
		if (test) {
			throw new AssertionFailed();
		}
		return receiver;
	}

	public static boolean inheritsFrom_(ObjectClass receiver, Object arg) {
		ClassMapping cm = ImageBootstrapper.systemMapping
				.classMappingForJavaClass_(receiver.getClass());
		ClassMapping other = ImageBootstrapper.systemMapping
				.classMappingForJavaClass_(arg.getClass());
		ClassMapping sm = cm;
		while (sm != null) {
			sm = sm.superclassMappingIn_(ImageBootstrapper.systemMapping);
			if (sm == other)
				return true;
		}
		return false;
	}

	public static boolean includesBehavior_(ObjectClass receiver, Object arg) {
		if (receiver == arg)
			return true;
		return inheritsFrom_(receiver, arg);
	}

	public static <X extends Object> X copy(X object) {
		try {
			return (X) getCloneMethod(object.getClass()).invoke(object);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	public static <X> X halt(X receiver) {
		throw new RuntimeException("Halt encountered on: "
				+ receiver.toString());
	}

	public static boolean equals_(Object receiver, Object other) {
		return (receiver == null && other == null)
				|| (receiver != null && other != null && receiver.equals(other));
	}

	public static boolean identityEquals_(Object receiver, Object other) {
		return (receiver == null && other == null) || (receiver == other);
	}

	public static String classTitle(ObjectClass receiver) {
		ClassMapping cm = ImageBootstrapper.systemMapping
				.classMappingForJavaClass_(receiver.getClass());
		return cm.reference().nonmeta().toString();
	}

	public static Object perform_(Object receiver, Symbol selector)
			throws Throwable {
		return MethodTools.perform(receiver, selector);
	}

	public static Object perform_with_(Object receiver, Symbol selector,
			Object arg1) throws Throwable {
		return MethodTools.perform(receiver, selector, arg1);
	}

	public static Object perform_with_with_(Object receiver, Symbol selector,
			Object arg1, Object arg2) throws Throwable {
		return MethodTools.perform(receiver, selector, arg1, arg2);
	}

	public static Object perform_with_with_with_(Object receiver,
			Symbol selector, Object arg1, Object arg2, Object arg3)
			throws Throwable {
		return MethodTools.perform(receiver, selector, arg1, arg2, arg3);
	}

	public static Object perform_with_with_with_with_(Object receiver,
			Symbol selector, Object arg1, Object arg2, Object arg3, Object arg4)
			throws Throwable {
		return MethodTools.perform(receiver, selector, arg1, arg2, arg3, arg4);
	}

	public static Object perform_withArguments_(Object receiver,
			Symbol selector, Object[] args)
			throws Throwable {
		return MethodTools.perform_withArguments_(receiver, selector, args);
	}

	public static Object shallowCopy(Object receiver) {
		try {
			return getCloneMethod(receiver.getClass()).invoke(receiver);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
