package st.gravel.support.compiler.jvm;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.jvm.PushBoolean;
import st.gravel.support.compiler.jvm.PushBoolean.PushBoolean_Factory;
import st.gravel.support.compiler.jvm.JVMInstructionVisitor;
import st.gravel.support.compiler.jvm.JVMType;

public class PushTrue extends PushBoolean implements Cloneable {

	public static PushTrue_Factory factory = new PushTrue_Factory();

	public static class PushTrue_Factory extends PushBoolean_Factory {

		public PushTrue basicNew() {
			PushTrue newInstance = new PushTrue();
			newInstance.initialize();
			return newInstance;
		}
	}

	@Override
	public <X> X accept_(final JVMInstructionVisitor<X> _visitor) {
		return _visitor.visitPushTrue_(this);
	}

	public PushTrue copy() {
		try {
			PushTrue _temp1 = (PushTrue) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public PushTrue_Factory factory() {
		return factory;
	}

	@Override
	public PushTrue printOn_(final StringBuilder _aStream) {
		final String _title;
		_title = this.factory().toString();
		_aStream.append(st.gravel.support.jvm.CharacterExtensions.isVowel(_title.charAt(0)) ? "an " : "a ");
		_aStream.append(_title);
		_aStream.append('[');
		this.sourceOn_(_aStream);
		_aStream.append(']');
		return this;
	}

	@Override
	public PushTrue sourceOn_(final StringBuilder _aStream) {
		return this;
	}

	@Override
	public boolean value() {
		return true;
	}

	@Override
	public PushTrue withReturnType_(final JVMType _aType) {
		if (st.gravel.support.jvm.ObjectExtensions.equals_(this.type(), _aType)) {
			return PushTrue.this;
		}
		throw new RuntimeException("niy");
	}
}
