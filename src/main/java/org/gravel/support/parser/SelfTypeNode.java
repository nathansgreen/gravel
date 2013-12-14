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

public class SelfTypeNode extends TypeNode implements Cloneable {

	public static SelfTypeNode_Factory factory = new SelfTypeNode_Factory();

	public static class SelfTypeNode_Factory extends TypeNode_Factory {

		public SelfTypeNode basicNew() {
			SelfTypeNode newInstance = new SelfTypeNode();
			newInstance.initialize();
			return newInstance;
		}
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitSelfTypeNode_(this);
	}

	@Override
	public SelfTypeNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public SelfTypeNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return SelfTypeNode.this;
			}
		});
		return this;
	}

	public SelfTypeNode copy() {
		try {
			SelfTypeNode _temp1 = (SelfTypeNode) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public SelfTypeNode_Factory factory() {
		return factory;
	}

	@Override
	public SelfTypeNode innerSourceOn_(final StringBuilder _aStream) {
		_aStream.append("Self");
		return this;
	}

	@Override
	public boolean isSelfTypeNode() {
		return true;
	}

	@Override
	public SelfTypeNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	@Override
	public SelfTypeNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public SelfTypeNode printOn_(final StringBuilder _aStream) {
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
	public SelfTypeNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public boolean referencesSelfOrInstanceType() {
		return true;
	}

	@Override
	public SelfTypeNode sourceOn_(final StringBuilder _aStream) {
		this.innerSourceOn_(_aStream);
		return this;
	}

	@Override
	public SelfTypeNode typeDefsDo_(final org.gravel.support.jvm.Block1<Object, TypeNode> _aBlock) {
		return this;
	}

	@Override
	public SelfTypeNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public SelfTypeNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public SelfTypeNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return SelfTypeNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
