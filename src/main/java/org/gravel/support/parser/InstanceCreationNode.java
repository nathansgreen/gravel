package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.IntermediateNode;
import org.gravel.support.parser.IntermediateNode.IntermediateNode_Factory;
import org.gravel.support.parser.AbsoluteReference;
import org.gravel.support.parser.NodeVisitor;
import org.gravel.support.parser.Node;
import org.gravel.support.parser.Expression;
import org.gravel.support.parser.SourcePosition;

public class InstanceCreationNode extends IntermediateNode implements Cloneable {

	public static InstanceCreationNode_Factory factory = new InstanceCreationNode_Factory();

	AbsoluteReference _reference;

	public static class InstanceCreationNode_Factory extends IntermediateNode_Factory {

		public InstanceCreationNode basicNew() {
			InstanceCreationNode newInstance = new InstanceCreationNode();
			newInstance.initialize();
			return newInstance;
		}

		public InstanceCreationNode reference_(final AbsoluteReference _anAbsoluteReference) {
			return this.basicNew().initializeReference_(_anAbsoluteReference);
		}
	}

	static public InstanceCreationNode _reference_(Object receiver, final AbsoluteReference _anAbsoluteReference) {
		return factory.reference_(_anAbsoluteReference);
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitInstanceCreationNode_(this);
	}

	@Override
	public InstanceCreationNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public InstanceCreationNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return InstanceCreationNode.this;
			}
		});
		return this;
	}

	public InstanceCreationNode copy() {
		try {
			InstanceCreationNode _temp1 = (InstanceCreationNode) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public InstanceCreationNode_Factory factory() {
		return factory;
	}

	public InstanceCreationNode initializeReference_(final AbsoluteReference _anAbsoluteReference) {
		_reference = _anAbsoluteReference;
		this.initialize();
		return this;
	}

	@Override
	public InstanceCreationNode innerSourceOn_(final StringBuilder _aStream) {
		_aStream.append("{");
		_aStream.append(_reference.toString());
		_aStream.append(" basicNew}");
		return this;
	}

	@Override
	public InstanceCreationNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	@Override
	public InstanceCreationNode nodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		return this;
	}

	@Override
	public InstanceCreationNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public InstanceCreationNode printOn_(final StringBuilder _aStream) {
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
	public InstanceCreationNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	public AbsoluteReference reference() {
		return _reference;
	}

	@Override
	public InstanceCreationNode sourceOn_(final StringBuilder _aStream) {
		this.innerSourceOn_(_aStream);
		return this;
	}

	@Override
	public Expression unoptimized() {
		return null;
	}

	@Override
	public InstanceCreationNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public InstanceCreationNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	@Override
	public InstanceCreationNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return InstanceCreationNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
