package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.NumberLiteralNode;
import org.gravel.support.parser.NumberLiteralNode.NumberLiteralNode_Factory;
import org.gravel.support.parser.NodeVisitor;
import org.gravel.support.parser.Node;
import org.gravel.support.parser.SourcePosition;

public class FloatLiteralNode extends NumberLiteralNode implements Cloneable {

	public static FloatLiteralNode_Factory factory = new FloatLiteralNode_Factory();

	String _valueString;

	public static class FloatLiteralNode_Factory extends NumberLiteralNode_Factory {

		public FloatLiteralNode basicNew() {
			FloatLiteralNode newInstance = new FloatLiteralNode();
			newInstance.initialize();
			return newInstance;
		}

		public FloatLiteralNode integer_fractionString_exponent_(final java.math.BigInteger _anInteger, final String _fractionString, final java.math.BigInteger _exp) {
			final StringBuilder _wstr;
			_wstr = org.gravel.support.jvm.WriteStreamFactory.on_(new String());
			_wstr.append(_anInteger.toString());
			if (_fractionString != null) {
				_wstr.append('.');
				_wstr.append(_fractionString);
			}
			if (_exp != null) {
				_wstr.append('e');
				_wstr.append(_exp.toString());
			}
			return ((FloatLiteralNode) this.valueString_(_wstr.toString()));
		}

		public FloatLiteralNode valueString_(final String _aString) {
			return ((FloatLiteralNode) this.basicNew().initializeValueString_(_aString));
		}
	}

	static public FloatLiteralNode _integer_fractionString_exponent_(Object receiver, final java.math.BigInteger _anInteger, final String _fractionString, final java.math.BigInteger _exp) {
		return factory.integer_fractionString_exponent_(_anInteger, _fractionString, _exp);
	}

	static public FloatLiteralNode _valueString_(Object receiver, final String _aString) {
		return factory.valueString_(_aString);
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitFloatLiteralNode_(this);
	}

	@Override
	public FloatLiteralNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public FloatLiteralNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return FloatLiteralNode.this;
			}
		});
		return this;
	}

	public FloatLiteralNode copy() {
		try {
			FloatLiteralNode _temp1 = (FloatLiteralNode) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public FloatLiteralNode_Factory factory() {
		return factory;
	}

	public FloatLiteralNode initializeValueString_(final String _aString) {
		_valueString = _aString;
		this.initialize();
		return this;
	}

	@Override
	public FloatLiteralNode innerSourceOn_(final StringBuilder _aStream) {
		_aStream.append("" + _valueString);
		return this;
	}

	@Override
	public FloatLiteralNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	@Override
	public FloatLiteralNode negated() {
		if (org.gravel.support.jvm.CharacterExtensions.equals_(_valueString.charAt(0), '-')) {
			return FloatLiteralNode.factory.valueString_(_valueString.substring(1));
		}
		return FloatLiteralNode.factory.valueString_("-" + _valueString);
	}

	@Override
	public FloatLiteralNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public FloatLiteralNode printOn_(final StringBuilder _aStream) {
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
	public FloatLiteralNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public FloatLiteralNode sourceOn_(final StringBuilder _aStream) {
		if (!this.needsBrackets()) {
			return FloatLiteralNode.this.innerSourceOn_(_aStream);
		}
		_aStream.append('(');
		this.innerSourceOn_(_aStream);
		_aStream.append(')');
		return this;
	}

	@Override
	public Object value() {
		return org.gravel.support.jvm.StringExtensions.parseFloat(_valueString);
	}

	public String valueString() {
		return _valueString;
	}

	@Override
	public FloatLiteralNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public FloatLiteralNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public FloatLiteralNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return FloatLiteralNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
