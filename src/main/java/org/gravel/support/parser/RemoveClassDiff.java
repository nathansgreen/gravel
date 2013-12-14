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
import org.gravel.support.parser.ClassNode;
import org.gravel.support.parser.DiffVisitor;
import org.gravel.support.parser.SystemNode;

public class RemoveClassDiff extends Diff implements Cloneable {

	public static RemoveClassDiff_Factory factory = new RemoveClassDiff_Factory();

	ClassNode _classNode;

	public static class RemoveClassDiff_Factory extends Diff_Factory {

		public RemoveClassDiff basicNew() {
			RemoveClassDiff newInstance = new RemoveClassDiff();
			newInstance.initialize();
			return newInstance;
		}

		public RemoveClassDiff classNode_(final ClassNode _aClassNode) {
			return ((RemoveClassDiff) this.basicNew().initializeClassNode_(_aClassNode));
		}
	}

	static public RemoveClassDiff _classNode_(Object receiver, final ClassNode _aClassNode) {
		return factory.classNode_(_aClassNode);
	}

	@Override
	public DiffVisitor accept_(final DiffVisitor _visitor) {
		return _visitor.visitRemoveClassDiff_(this);
	}

	@Override
	public SystemNode applyOnSystemNode_(final SystemNode _aSystemNode) {
		return _aSystemNode;
	}

	public ClassNode classNode() {
		return _classNode;
	}

	public RemoveClassDiff copy() {
		try {
			RemoveClassDiff _temp1 = (RemoveClassDiff) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public RemoveClassDiff_Factory factory() {
		return factory;
	}

	public RemoveClassDiff initializeClassNode_(final ClassNode _aClassNode) {
		_classNode = _aClassNode;
		this.initialize();
		return this;
	}

	@Override
	public RemoveClassDiff printDescriptionOn_(final StringBuilder _aStream) {
		_aStream.append(_classNode.reference().toString());
		return this;
	}

	@Override
	public Diff withDiff_(final Diff _aDiff) {
		return _aDiff;
	}
}
