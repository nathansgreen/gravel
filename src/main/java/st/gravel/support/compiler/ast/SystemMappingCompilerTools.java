package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.jvm.JVMDefinedObjectType;
import st.gravel.support.compiler.jvm.Invoke;
import st.gravel.support.compiler.ast.ClassMapping;
import st.gravel.support.compiler.ast.SystemMapping;
import st.gravel.support.compiler.jvm.JVMClass;
import st.gravel.support.compiler.jvm.JVMType;
import st.gravel.support.compiler.ast.AbsoluteReference;
import st.gravel.support.compiler.ast.Reference;

abstract public class SystemMappingCompilerTools extends Object implements Cloneable {

	public static SystemMappingCompilerTools_Factory factory = new SystemMappingCompilerTools_Factory();

	public static class SystemMappingCompilerTools_Factory extends st.gravel.support.jvm.SmalltalkFactory {

		public SystemMappingCompilerTools basicNew() {
			throw new RuntimeException("SystemMappingCompilerTools is an abstract class");
		}
	}

	public abstract Class classForName_(final String _aString);

	public SystemMappingCompilerTools copy() {
		try {
			SystemMappingCompilerTools _temp1 = (SystemMappingCompilerTools) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public abstract Invoke createInvokeInstruction_name_numArgs_(final JVMDefinedObjectType _type, final String _name, final int _numArgs);

	public abstract Object createSingletonForClass_(final Class _aJavaClass);

	public abstract Object evaluateBlock0Class_(final Class _aClass);

	public SystemMappingCompilerTools_Factory factory() {
		return factory;
	}

	public abstract Class findJavaClass_(final st.gravel.core.Symbol[] _anArray);

	public SystemMappingCompilerTools initialize() {
		return this;
	}

	public abstract SystemMappingCompilerTools initializeClass_systemMapping_(final ClassMapping _aClassMapping, final SystemMapping _systemMapping);

	public abstract boolean isAssignable_from_(final Class _aClass, final Class _bClass);

	public abstract JVMClass jvmClassForType_ifAbsent_(final JVMDefinedObjectType _aJVMDefinedObjectType, final st.gravel.support.jvm.Block0<JVMClass> _aBlock);

	public abstract JVMType jvmTypeForClass_(final Class _aClass);

	public abstract java.lang.invoke.MethodHandle methodHandleAt_numArgs_in_identityClass_isStatic_(final String _aString, final int _numArgs, final Class _aJavaClass, final Class _identityClass, final boolean _aBoolean);

	public abstract SystemMappingCompilerTools methodNamesIn_do_(final Class _receiverClass, final st.gravel.support.jvm.Block2<Object, String, Integer> _aBlock);

	public abstract st.gravel.support.jvm.runtime.AlmostFinalValue newSingletonHolder_initializer_(final AbsoluteReference _reference, final st.gravel.support.jvm.Block0<Object> _block);

	public abstract st.gravel.support.jvm.runtime.AlmostFinalValue newSingletonHolder_value_(final AbsoluteReference _reference, final Object _value);

	public abstract String nextExtensionPostfix();

	public abstract String nextNlrMarker();

	public SystemMappingCompilerTools postCopy() {
		return this;
	}

	public abstract String referenceAsClassName_(final Reference _aReference);

	public abstract SystemMappingCompilerTools resetCallsites();

	public abstract SystemMappingCompilerTools runAstInit_(final JVMClass _aJVMClass);

	public abstract Object valueOfSingletonHolder_(final st.gravel.support.jvm.runtime.AlmostFinalValue _holder);

	public abstract Class writeClass_(final JVMClass _aJVMClass);
}
