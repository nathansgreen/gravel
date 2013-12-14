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
import org.gravel.support.parser.Node;
import org.gravel.support.parser.SourcePosition;

public class TypeDefNode extends TypeNode implements Cloneable {

	public static TypeDefNode_Factory factory = new TypeDefNode_Factory();

	TypeNode _node;

	public static class TypeDefNode_Factory extends TypeNode_Factory {

		public TypeDefNode basicNew() {
			TypeDefNode newInstance = new TypeDefNode();
			newInstance.initialize();
			return newInstance;
		}

		public TypeDefNode node_(final TypeNode _aTypeVariableNode) {
			return ((TypeDefNode) this.basicNew().initializeNode_(_aTypeVariableNode));
		}
	}

	static public TypeDefNode _node_(Object receiver, final TypeNode _aTypeVariableNode) {
		return factory.node_(_aTypeVariableNode);
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitTypeDefNode_(this);
	}

	@Override
	public TypeDefNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public TypeDefNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return TypeDefNode.this;
			}
		});
		return this;
	}

	public TypeDefNode copy() {
		try {
			TypeDefNode _temp1 = (TypeDefNode) this.clone();
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
		if (this._node == null) {
			if (!(((TypeDefNode) _anObject)._node == null)) {
				return false;
			}
		} else {
			if (!org.gravel.support.jvm.ObjectExtensions.equals_(this._node, ((TypeDefNode) _anObject)._node)) {
				return false;
			}
		}
		return true;
	}

	public TypeDefNode_Factory factory() {
		return factory;
	}

	@Override
	public int hashCode() {
		return (super.hashCode() ^ (_node == null ? 0 : _node.hashCode()));
	}

	public TypeDefNode initializeNode_(final TypeNode _aTypeVariableNode) {
		_node = _aTypeVariableNode;
		this.initialize();
		return this;
	}

	@Override
	public TypeDefNode innerSourceOn_(final StringBuilder _aStream) {
		_node.innerSourceOn_(_aStream);
		_aStream.append(" def");
		return this;
	}

	@Override
	public boolean isTypeDefNode() {
		return true;
	}

	@Override
	public TypeDefNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	public TypeNode node() {
		return _node;
	}

	@Override
	public TypeDefNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public TypeDefNode printOn_(final StringBuilder _aStream) {
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
	public TypeDefNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public TypeDefNode sourceOn_(final StringBuilder _aStream) {
		this.innerSourceOn_(_aStream);
		return this;
	}

	@Override
	public TypeDefNode typeDefsDo_(final org.gravel.support.jvm.Block1<Object, TypeNode> _aBlock) {
		_aBlock.value_(_node);
		return this;
	}

	@Override
	public TypeDefNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public TypeDefNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public TypeDefNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return TypeDefNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
