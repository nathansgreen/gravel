package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.Diff;
import org.gravel.support.parser.Diff.Diff_Factory;
import org.gravel.support.parser.Reference;
import org.gravel.support.parser.MethodNode;
import org.gravel.support.parser.UpdateClassDiff;

abstract public class MethodDiff extends Diff implements Cloneable {

	public static MethodDiff_Factory factory = new MethodDiff_Factory();

	MethodNode _methodNode;

	Reference _reference;

	public static class MethodDiff_Factory extends Diff_Factory {

		public MethodDiff basicNew() {
			throw new RuntimeException("MethodDiff is an abstract class");
		}

		public MethodDiff reference_methodNode_(final Reference _anAbsoluteReference, final MethodNode _anUnaryMethodNode) {
			return ((MethodDiff) this.basicNew().initializeReference_methodNode_(_anAbsoluteReference, _anUnaryMethodNode));
		}
	}

	static public MethodDiff _reference_methodNode_(Object receiver, final Reference _anAbsoluteReference, final MethodNode _anUnaryMethodNode) {
		return factory.reference_methodNode_(_anAbsoluteReference, _anUnaryMethodNode);
	}

	public abstract UpdateClassDiff asClassDiff();

	public MethodDiff copy() {
		try {
			MethodDiff _temp1 = (MethodDiff) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public MethodDiff_Factory factory() {
		return factory;
	}

	public MethodDiff initializeReference_methodNode_(final Reference _anAbsoluteReference, final MethodNode _anUnaryMethodNode) {
		_reference = _anAbsoluteReference;
		_methodNode = _anUnaryMethodNode;
		this.initialize();
		return this;
	}

	public MethodNode methodNode() {
		return _methodNode;
	}

	@Override
	public MethodDiff printDescriptionOn_(final StringBuilder _aStream) {
		_aStream.append(_reference.toString());
		return this;
	}

	public Reference reference() {
		return _reference;
	}

	@Override
	public Diff withMethodDiff_(final MethodDiff _aMethodDiff) {
		return this.withDiff_(_aMethodDiff.asClassDiff());
	}
}
