package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.TypeNode;
import org.gravel.support.parser.TypeNode.TypeNode_Factory;
import org.gravel.support.parser.NodeVisitor;
import org.gravel.support.parser.GenericTypeVariableNode;
import org.gravel.support.parser.Node;
import org.gravel.support.parser.SourcePosition;

public class TypeVariableNode extends TypeNode implements Cloneable {

	public static TypeVariableNode_Factory factory = new TypeVariableNode_Factory();

	String _name;

	public static class TypeVariableNode_Factory extends TypeNode_Factory {

		public TypeVariableNode any() {
			return this.name_("Object");
		}

		public TypeVariableNode basicNew() {
			TypeVariableNode newInstance = new TypeVariableNode();
			newInstance.initialize();
			return newInstance;
		}

		public TypeVariableNode error() {
			return this.name_("Error");
		}

		public TypeVariableNode name_(final String _aString) {
			if (org.gravel.support.jvm.ArrayExtensions.includes_(new String[] { "Self", "Instance" }, _aString)) {
				throw ParseError.factory.basicNew();
			}
			return ((TypeVariableNode) this.basicNew().initializeName_(_aString));
		}

		public TypeVariableNode nil() {
			return this.name_("UndefinedObject");
		}

		public TypeVariableNode r_boolean() {
			return this.name_("Boolean");
		}

		public TypeVariableNode r_int() {
			return this.name_("Integer");
		}
	}

	static public TypeVariableNode _any(Object receiver) {
		return factory.any();
	}

	static public TypeVariableNode _error(Object receiver) {
		return factory.error();
	}

	static public TypeVariableNode _name_(Object receiver, final String _aString) {
		return factory.name_(_aString);
	}

	static public TypeVariableNode _nil(Object receiver) {
		return factory.nil();
	}

	static public TypeVariableNode _r_boolean(Object receiver) {
		return factory.r_boolean();
	}

	static public TypeVariableNode _r_int(Object receiver) {
		return factory.r_int();
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitTypeVariableNode_(this);
	}

	@Override
	public TypeVariableNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public TypeVariableNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return TypeVariableNode.this;
			}
		});
		return this;
	}

	public TypeVariableNode copy() {
		try {
			TypeVariableNode _temp1 = (TypeVariableNode) this.clone();
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
		if (this._name == null) {
			if (!(((TypeVariableNode) _anObject)._name == null)) {
				return false;
			}
		} else {
			if (!org.gravel.support.jvm.StringExtensions.equals_(this._name, ((TypeVariableNode) _anObject)._name)) {
				return false;
			}
		}
		return true;
	}

	public TypeVariableNode_Factory factory() {
		return factory;
	}

	@Override
	public int hashCode() {
		return (super.hashCode() ^ _name.hashCode());
	}

	public TypeVariableNode initializeName_(final String _aString) {
		_name = _aString;
		this.initialize();
		return this;
	}

	@Override
	public TypeVariableNode innerSourceOn_(final StringBuilder _aStream) {
		_aStream.append(_name);
		return this;
	}

	public boolean isAnyType() {
		return org.gravel.support.jvm.StringExtensions.equals_(_name, "Object");
	}

	public boolean isBooleanType() {
		return org.gravel.support.jvm.StringExtensions.equals_(_name, "Boolean");
	}

	public boolean isInstanceType() {
		return org.gravel.support.jvm.StringExtensions.equals_(_name, "Instance");
	}

	@Override
	public boolean isNilType() {
		return org.gravel.support.jvm.StringExtensions.equals_(_name, "UndefinedObject");
	}

	@Override
	public boolean isTypeVariableNode() {
		return true;
	}

	@Override
	public TypeVariableNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	public String name() {
		return _name;
	}

	@Override
	public TypeVariableNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public TypeVariableNode printOn_(final StringBuilder _aStream) {
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
	public TypeVariableNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public TypeVariableNode sourceOn_(final StringBuilder _aStream) {
		this.innerSourceOn_(_aStream);
		return this;
	}

	@Override
	public TypeVariableNode typeDefsDo_(final org.gravel.support.jvm.Block1<Object, TypeNode> _aBlock) {
		return this;
	}

	@Override
	public TypeVariableNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public TypeVariableNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public TypeVariableNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return TypeVariableNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}

	public GenericTypeVariableNode withTypeArgs_(final TypeNode[] _typeNodes) {
		return GenericTypeVariableNode.factory.root_arguments_(this, _typeNodes);
	}

	public GenericTypeVariableNode withTypeArg_(final TypeNode _aTypeNode) {
		return GenericTypeVariableNode.factory.root_arguments_(this, org.gravel.support.jvm.ArrayFactory.with_(_aTypeNode));
	}
}
