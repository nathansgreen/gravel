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

public class ByteArrayLiteralNode extends LiteralNode implements Cloneable {

	public static ByteArrayLiteralNode_Factory factory = new ByteArrayLiteralNode_Factory();

	byte[] _value;

	public static class ByteArrayLiteralNode_Factory extends LiteralNode_Factory {

		public ByteArrayLiteralNode basicNew() {
			ByteArrayLiteralNode newInstance = new ByteArrayLiteralNode();
			newInstance.initialize();
			return newInstance;
		}

		public ByteArrayLiteralNode value_(final byte[] _aByteArray) {
			return ((ByteArrayLiteralNode) this.basicNew().initializeValue_(_aByteArray));
		}
	}

	static public ByteArrayLiteralNode _value_(Object receiver, final byte[] _aByteArray) {
		return factory.value_(_aByteArray);
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitByteArrayLiteralNode_(this);
	}

	@Override
	public ByteArrayLiteralNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public ByteArrayLiteralNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return ByteArrayLiteralNode.this;
			}
		});
		return this;
	}

	public ByteArrayLiteralNode copy() {
		try {
			ByteArrayLiteralNode _temp1 = (ByteArrayLiteralNode) this.clone();
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
			if (!(((ByteArrayLiteralNode) _anObject)._value == null)) {
				return false;
			}
		} else {
			if (!org.gravel.support.jvm.ByteArrayExtensions.equals_(this._value, ((ByteArrayLiteralNode) _anObject)._value)) {
				return false;
			}
		}
		return true;
	}

	public ByteArrayLiteralNode_Factory factory() {
		return factory;
	}

	@Override
	public int hashCode() {
		return (super.hashCode() ^ java.util.Arrays.hashCode(_value));
	}

	public ByteArrayLiteralNode initializeValue_(final byte[] _aByteArray) {
		_value = _aByteArray;
		this.initialize();
		return this;
	}

	@Override
	public ByteArrayLiteralNode innerSourceOn_(final StringBuilder _aStream) {
		_aStream.append("#[");
		boolean _temp1 = true;
		for (final byte _each : _value) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_aStream.append(' ');
			}
			_aStream.append("" + (_each & 255));
		}
		_aStream.append(']');
		return this;
	}

	@Override
	public boolean isByteArrayLiteralNode() {
		return true;
	}

	@Override
	public ByteArrayLiteralNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	@Override
	public ByteArrayLiteralNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public ByteArrayLiteralNode printOn_(final StringBuilder _aStream) {
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
	public ByteArrayLiteralNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public ByteArrayLiteralNode sourceOn_(final StringBuilder _aStream) {
		if (!this.needsBrackets()) {
			return ByteArrayLiteralNode.this.innerSourceOn_(_aStream);
		}
		_aStream.append('(');
		this.innerSourceOn_(_aStream);
		_aStream.append(')');
		return this;
	}

	@Override
	public byte[] value() {
		return _value;
	}

	@Override
	public ByteArrayLiteralNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public ByteArrayLiteralNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public ByteArrayLiteralNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return ByteArrayLiteralNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
