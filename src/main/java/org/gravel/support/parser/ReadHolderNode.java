package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.StateAccessNode;
import org.gravel.support.parser.StateAccessNode.StateAccessNode_Factory;
import org.gravel.support.parser.NodeVisitor;
import org.gravel.support.parser.Node;
import org.gravel.support.parser.SourcePosition;

public class ReadHolderNode extends StateAccessNode implements Cloneable {

	public static ReadHolderNode_Factory factory = new ReadHolderNode_Factory();

	String _varName;

	public static class ReadHolderNode_Factory extends StateAccessNode_Factory {

		public ReadHolderNode basicNew() {
			ReadHolderNode newInstance = new ReadHolderNode();
			newInstance.initialize();
			return newInstance;
		}

		public ReadHolderNode varName_(final String _aString) {
			return ((ReadHolderNode) this.basicNew().initializeVarName_(_aString));
		}
	}

	static public ReadHolderNode _varName_(Object receiver, final String _aString) {
		return factory.varName_(_aString);
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitReadHolderNode_(this);
	}

	@Override
	public ReadHolderNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public ReadHolderNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return ReadHolderNode.this;
			}
		});
		return this;
	}

	public ReadHolderNode copy() {
		try {
			ReadHolderNode _temp1 = (ReadHolderNode) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean equals(final Object _anObject) {
		if (!super.equals(_anObject)) {
			return false;
		}
		if (this._varName == null) {
			if (!(((ReadHolderNode) _anObject)._varName == null)) {
				return false;
			}
		} else {
			if (!org.gravel.support.jvm.StringExtensions.equals_(this._varName, ((ReadHolderNode) _anObject)._varName)) {
				return false;
			}
		}
		return true;
	}

	public ReadHolderNode_Factory factory() {
		return factory;
	}

	@Override
	public int hashCode() {
		return (super.hashCode() ^ _varName.hashCode());
	}

	public ReadHolderNode initializeVarName_(final String _aString) {
		_varName = _aString;
		this.initialize();
		return this;
	}

	@Override
	public ReadHolderNode innerSourceOn_(final StringBuilder _aStream) {
		_aStream.append("{");
		_aStream.append(_varName);
		_aStream.append(" value}");
		return this;
	}

	@Override
	public boolean isVariableNode() {
		return true;
	}

	@Override
	public ReadHolderNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		_aBlock.value_(_varName);
		return this;
	}

	@Override
	public String name() {
		return _varName;
	}

	@Override
	public ReadHolderNode nodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		return this;
	}

	@Override
	public ReadHolderNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public ReadHolderNode printOn_(final StringBuilder _aStream) {
		final String _title;
		_title = this.factory().toString();
		_aStream.append(org.gravel.support.jvm.CharacterExtensions.isVowel(_title.charAt(0)) ? "an " : "a ");
		_aStream.append(_title);
		_aStream.append('[');
		this.sourceOn_(_aStream);
		_aStream.append(']');
		return this;
	}

	@Override
	public ReadHolderNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public boolean referencesVariable_(final String _aString) {
		return org.gravel.support.jvm.StringExtensions.equals_(_varName, _aString);
	}

	@Override
	public ReadHolderNode sourceOn_(final StringBuilder _aStream) {
		this.innerSourceOn_(_aStream);
		return this;
	}

	public String varName() {
		return _varName;
	}

	@Override
	public ReadHolderNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public ReadHolderNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public ReadHolderNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return ReadHolderNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
