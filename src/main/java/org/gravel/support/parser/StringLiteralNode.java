package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.LiteralNode;
import org.gravel.support.parser.LiteralNode.LiteralNode_Factory;
import org.gravel.support.parser.NodeVisitor;
import org.gravel.support.parser.Node;
import org.gravel.support.parser.SourcePosition;

public class StringLiteralNode extends LiteralNode implements Cloneable {

	public static StringLiteralNode_Factory factory = new StringLiteralNode_Factory();

	String _value;

	public static class StringLiteralNode_Factory extends LiteralNode_Factory {

		public StringLiteralNode basicNew() {
			StringLiteralNode newInstance = new StringLiteralNode();
			newInstance.initialize();
			return newInstance;
		}

		public StringLiteralNode value_(final String _aString) {
			return ((StringLiteralNode) this.basicNew().initializeValue_(_aString));
		}
	}

	static public StringLiteralNode _value_(Object receiver, final String _aString) {
		return factory.value_(_aString);
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitStringLiteralNode_(this);
	}

	@Override
	public StringLiteralNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public StringLiteralNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return StringLiteralNode.this;
			}
		});
		return this;
	}

	public StringLiteralNode copy() {
		try {
			StringLiteralNode _temp1 = (StringLiteralNode) this.clone();
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
		if (this._value == null) {
			if (!(((StringLiteralNode) _anObject)._value == null)) {
				return false;
			}
		} else {
			if (!org.gravel.support.jvm.StringExtensions.equals_(this._value, ((StringLiteralNode) _anObject)._value)) {
				return false;
			}
		}
		return true;
	}

	public StringLiteralNode_Factory factory() {
		return factory;
	}

	@Override
	public int hashCode() {
		return (super.hashCode() ^ _value.hashCode());
	}

	public StringLiteralNode initializeValue_(final String _aString) {
		_value = _aString;
		this.initialize();
		return this;
	}

	@Override
	public StringLiteralNode innerSourceOn_(final StringBuilder _aStream) {
		_aStream.append('\'');
		int _temp2 = _value.length();
		for (int _temp1 = 0; _temp1 < _temp2; _temp1++) {
			char _ch = _value.charAt(_temp1);
			_aStream.append(_ch);
			if (_ch == '\'') {
				_aStream.append('\'');
			}
		}
		_aStream.append('\'');
		return this;
	}

	@Override
	public boolean isStringLiteralNode() {
		return true;
	}

	@Override
	public StringLiteralNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	@Override
	public StringLiteralNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public StringLiteralNode printOn_(final StringBuilder _aStream) {
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
	public StringLiteralNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public StringLiteralNode sourceOn_(final StringBuilder _aStream) {
		if (!this.needsBrackets()) {
			return StringLiteralNode.this.innerSourceOn_(_aStream);
		}
		_aStream.append('(');
		this.innerSourceOn_(_aStream);
		_aStream.append(')');
		return this;
	}

	@Override
	public String value() {
		return _value;
	}

	@Override
	public StringLiteralNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public StringLiteralNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public StringLiteralNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return StringLiteralNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
