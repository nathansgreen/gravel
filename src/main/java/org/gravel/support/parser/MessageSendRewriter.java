package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.NodeCopier;
import org.gravel.support.parser.NodeCopier.NodeCopier_Factory;
import java.util.Map;
import org.gravel.support.parser.Statement;
import org.gravel.support.parser.MessageNode;
import org.gravel.support.parser.BinaryMessageNode;
import org.gravel.support.parser.CascadeNode;
import org.gravel.support.parser.Expression;
import org.gravel.support.parser.KeywordMessageNode;
import org.gravel.support.parser.UnaryMessageNode;

abstract public class MessageSendRewriter extends NodeCopier implements Cloneable {

	public static MessageSendRewriter_Factory factory = new MessageSendRewriter_Factory();

	Map<org.gravel.core.Symbol, org.gravel.support.jvm.Block1<Statement, MessageNode>> _specialSelectors;

	public static class MessageSendRewriter_Factory extends NodeCopier_Factory {

		public MessageSendRewriter basicNew() {
			throw new RuntimeException("MessageSendRewriter is an abstract class");
		}
	}

	public MessageSendRewriter copy() {
		try {
			MessageSendRewriter _temp1 = (MessageSendRewriter) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public MessageSendRewriter_Factory factory() {
		return factory;
	}

	@Override
	public MessageSendRewriter initialize() {
		super.initialize();
		this.initializeSpecialSelectors();
		return this;
	}

	public abstract MessageSendRewriter initializeSpecialSelectors();

	@Override
	public Statement visitBinaryMessageNode_(final BinaryMessageNode _anObject) {
		final org.gravel.core.Symbol _selector;
		final org.gravel.support.jvm.Block1<Statement, MessageNode> _res;
		_selector = org.gravel.core.Symbol.value(_anObject.selector());
		org.gravel.support.jvm.Block1<Statement, MessageNode> _temp1 = _specialSelectors.get(_selector);
		_res = ((org.gravel.support.jvm.Block1<Statement, MessageNode>) _temp1);
		if (_res != null) {
			return _res.value_(_anObject);
		}
		return super.visitBinaryMessageNode_(_anObject);
	}

	@Override
	public Expression visitCascadeNode_(final CascadeNode _anObject) {
		final Expression[] _expressions;
		_expressions = org.gravel.support.jvm.ArrayExtensions.collect_(_anObject.messages(), ((org.gravel.support.jvm.Block1<Expression, MessageNode>) (new org.gravel.support.jvm.Block1<Expression, MessageNode>() {

			@Override
			public Expression value_(final MessageNode _each) {
				return (Expression) MessageSendRewriter.this.visit_(_each);
			}
		})));
		if (org.gravel.support.jvm.ArrayExtensions.anySatisfy_(_expressions, new org.gravel.support.jvm.Predicate1<Expression>() {

			@Override
			public boolean value_(final Expression _each) {
				return !_each.isMessageNode();
			}
		})) {
			return InlineExpressionCollection.factory.expressions_(_expressions);
		}
		return CascadeNode.factory.messages_(org.gravel.support.jvm.ArrayExtensions.collect_(_expressions, ((org.gravel.support.jvm.Block1<MessageNode, Expression>) (new org.gravel.support.jvm.Block1<MessageNode, Expression>() {

			@Override
			public MessageNode value_(final Expression _each) {
				return (MessageNode) _each;
			}
		}))));
	}

	@Override
	public Statement visitKeywordMessageNode_(final KeywordMessageNode _anObject) {
		final org.gravel.core.Symbol _selector;
		final org.gravel.support.jvm.Block1<Statement, MessageNode> _res;
		_selector = org.gravel.core.Symbol.value(_anObject.selector());
		org.gravel.support.jvm.Block1<Statement, MessageNode> _temp1 = _specialSelectors.get(_selector);
		_res = ((org.gravel.support.jvm.Block1<Statement, MessageNode>) _temp1);
		if (_res != null) {
			return _res.value_(_anObject);
		}
		return super.visitKeywordMessageNode_(_anObject);
	}

	@Override
	public Statement visitUnaryMessageNode_(final UnaryMessageNode _anObject) {
		final org.gravel.core.Symbol _selector;
		final org.gravel.support.jvm.Block1<Statement, MessageNode> _res;
		_selector = org.gravel.core.Symbol.value(_anObject.selector());
		org.gravel.support.jvm.Block1<Statement, MessageNode> _temp1 = _specialSelectors.get(_selector);
		_res = ((org.gravel.support.jvm.Block1<Statement, MessageNode>) _temp1);
		if (_res != null) {
			return _res.value_(_anObject);
		}
		return super.visitUnaryMessageNode_(_anObject);
	}
}
