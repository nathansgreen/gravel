package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.Node;
import org.gravel.support.parser.Node.Node_Factory;
import org.gravel.support.parser.MessageNode;
import org.gravel.support.parser.NodeVisitor;
import org.gravel.support.parser.SymbolLiteralNode;
import org.gravel.support.parser.Expression;
import org.gravel.support.parser.SourcePosition;

public class PragmaNode extends Node implements Cloneable {

	public static PragmaNode_Factory factory = new PragmaNode_Factory();

	MessageNode _expression;

	public static class PragmaNode_Factory extends Node_Factory {

		public PragmaNode basicNew() {
			PragmaNode newInstance = new PragmaNode();
			newInstance.initialize();
			return newInstance;
		}

		public PragmaNode expression_(final MessageNode _aMessageNode) {
			return ((PragmaNode) this.basicNew().initializeExpression_(_aMessageNode));
		}
	}

	static public PragmaNode _expression_(Object receiver, final MessageNode _aMessageNode) {
		return factory.expression_(_aMessageNode);
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitPragmaNode_(this);
	}

	@Override
	public PragmaNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public PragmaNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return PragmaNode.this;
			}
		});
		return this;
	}

	public PragmaNode copy() {
		try {
			PragmaNode _temp1 = (PragmaNode) this.clone();
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
		if (this._expression == null) {
			if (!(((PragmaNode) _anObject)._expression == null)) {
				return false;
			}
		} else {
			if (!org.gravel.support.jvm.ObjectExtensions.equals_(this._expression, ((PragmaNode) _anObject)._expression)) {
				return false;
			}
		}
		return true;
	}

	public MessageNode expression() {
		return _expression;
	}

	public PragmaNode_Factory factory() {
		return factory;
	}

	@Override
	public int hashCode() {
		return (super.hashCode() ^ (_expression == null ? 0 : _expression.hashCode()));
	}

	public PragmaNode initializeExpression_(final MessageNode _aKeywordMessageNode) {
		_expression = _aKeywordMessageNode;
		this.initialize();
		return this;
	}

	public boolean isPropertyPragmaAt_(final org.gravel.core.Symbol _aKey) {
		return org.gravel.support.jvm.StringExtensions.equals_(_expression.selector(), "propertyAt:put:") && (_expression.arguments()[0].isSymbolLiteralNode() && org.gravel.support.jvm.ObjectExtensions.equals_(((SymbolLiteralNode) _expression.arguments()[0]).value(), _aKey));
	}

	@Override
	public PragmaNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	@Override
	public PragmaNode nodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		return this;
	}

	@Override
	public PragmaNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public PragmaNode printOn_(final StringBuilder _aStream) {
		final String _title;
		_title = this.factory().toString();
		_aStream.append(org.gravel.support.jvm.CharacterExtensions.isVowel(_title.charAt(0)) ? "an " : "a ");
		_aStream.append(_title);
		_aStream.append('[');
		this.sourceOn_(_aStream);
		_aStream.append(']');
		return this;
	}

	public PragmaNode pvtSetExpression_(final MessageNode _aMessageNode) {
		_expression = _aMessageNode;
		return this;
	}

	@Override
	public PragmaNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	public String selector() {
		return _expression.selector();
	}

	@Override
	public PragmaNode sourceOn_(final StringBuilder _aStream) {
		_aStream.append('<');
		_expression.innerSourceSendOn_(_aStream);
		_aStream.append('>');
		return this;
	}

	@Override
	public PragmaNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public PragmaNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	public PragmaNode withArguments_(final Expression[] _anArray) {
		return this.withExpression_(_expression.withArguments_(_anArray));
	}

	public PragmaNode withExpression_(final MessageNode _aMessageNode) {
		return this.copy().pvtSetExpression_(_aMessageNode);
	}

	@Override
	public PragmaNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return PragmaNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
