package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.NodeVisitor;
import org.gravel.support.parser.NodeVisitor.NodeVisitor_Factory;
import org.gravel.support.parser.VariableDeclarationNode;
import org.gravel.support.parser.AssignmentNode;
import org.gravel.support.parser.SequenceNode;
import org.gravel.support.parser.CascadeNode;
import org.gravel.support.parser.Node;
import org.gravel.support.parser.TypeNode;
import org.gravel.support.parser.MessageNode;
import org.gravel.support.parser.Expression;
import org.gravel.support.parser.BlockNode;
import org.gravel.support.parser.PragmaNode;
import org.gravel.support.parser.Statement;
import org.gravel.support.parser.ArrayLiteralNode;
import org.gravel.support.parser.LiteralNode;
import org.gravel.support.parser.BlockTypeNode;
import org.gravel.support.parser.BooleanLiteralNode;
import org.gravel.support.parser.BottomTypeNode;
import org.gravel.support.parser.ByteArrayLiteralNode;
import org.gravel.support.parser.CharacterLiteralNode;
import org.gravel.support.parser.ClassTypeNode;
import org.gravel.support.parser.FixedPointLiteralNode;
import org.gravel.support.parser.FloatLiteralNode;
import org.gravel.support.parser.GenericTypeVariableNode;
import org.gravel.support.parser.InstanceTypeNode;
import org.gravel.support.parser.IntegerLiteralNode;
import org.gravel.support.parser.IntermediateNode;
import org.gravel.support.parser.IntermediateStatement;
import org.gravel.support.parser.MethodNode;
import org.gravel.support.parser.NamespacedTypeVariableNode;
import org.gravel.support.parser.NamespacedVariableNode;
import org.gravel.support.parser.NilLiteralNode;
import org.gravel.support.parser.ReferenceLiteralNode;
import org.gravel.support.parser.ReturnNode;
import org.gravel.support.parser.SelfTypeNode;
import org.gravel.support.parser.StringLiteralNode;
import org.gravel.support.parser.SymbolLiteralNode;
import org.gravel.support.parser.TypeDefNode;
import org.gravel.support.parser.TypeOrNode;
import org.gravel.support.parser.TypeVariableNode;
import org.gravel.support.parser.VariableNode;

public class SourcePrinter<X> extends NodeVisitor<Object> implements Cloneable {

	public static SourcePrinter_Factory factory = new SourcePrinter_Factory();

	org.gravel.core.Symbol _emphasis;

	int _indentation;

	Integer _precedence;

	StringBuilder _stream;

	public static class SourcePrinter_Factory<X> extends NodeVisitor_Factory<Object> {

		public SourcePrinter<X> basicNew() {
			SourcePrinter<X> newInstance = new SourcePrinter<X>();
			newInstance.initialize();
			return newInstance;
		}

		public SourcePrinter<Object> on_(final StringBuilder _aStream) {
			return this.stream_precedence_indentation_emphasis_(_aStream, null, 0, null);
		}

		public SourcePrinter<Object> stream_precedence_indentation_emphasis_(final StringBuilder _aWriteStream, final Integer _anUndefinedObject, final int _anInteger, final org.gravel.core.Symbol _anUndefinedObject2) {
			return this.basicNew().initializeStream_precedence_indentation_emphasis_(_aWriteStream, _anUndefinedObject, _anInteger, _anUndefinedObject2);
		}
	}

	static public SourcePrinter<Object> _on_(Object receiver, final StringBuilder _aStream) {
		return factory.on_(_aStream);
	}

	static public SourcePrinter<Object> _stream_precedence_indentation_emphasis_(Object receiver, final StringBuilder _aWriteStream, final Integer _anUndefinedObject, final int _anInteger, final org.gravel.core.Symbol _anUndefinedObject2) {
		return factory.stream_precedence_indentation_emphasis_(_aWriteStream, _anUndefinedObject, _anInteger, _anUndefinedObject2);
	}

	public SourcePrinter<X> copy() {
		try {
			SourcePrinter<X> _temp1 = (SourcePrinter<X>) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public SourcePrinter crtab_(final int _i) {
		_stream.append('\n');
		for (int _x = 1; _x <= _i; _x++) {
			_stream.append('\t');
		}
		return this;
	}

	public SourcePrinter emphasis_while_(final org.gravel.core.Symbol _anEmphasis, final org.gravel.support.jvm.Block0<Object> _aBlock) {
		final org.gravel.core.Symbol _old;
		_old = _emphasis;
		_emphasis = _anEmphasis;
		_aBlock.value();
		_emphasis = _old;
		return this;
	}

	public SourcePrinter_Factory<X> factory() {
		return factory;
	}

	public SourcePrinter indentDo_(final org.gravel.support.jvm.Block0<Object> _aBlock) {
		this.indent_do_(1, _aBlock);
		return this;
	}

	public SourcePrinter indent_do_(final int _aLevel, final org.gravel.support.jvm.Block0<Object> _aBlock) {
		final int _old;
		_old = _indentation;
		_indentation = _indentation + _aLevel;
		_aBlock.value();
		_indentation = _old;
		return this;
	}

	public SourcePrinter initializeStream_precedence_indentation_emphasis_(final StringBuilder _aWriteStream, final Integer _anUndefinedObject, final int _anInteger, final org.gravel.core.Symbol _anUndefinedObject2) {
		_stream = _aWriteStream;
		_precedence = _anUndefinedObject;
		_indentation = _anInteger;
		_emphasis = _anUndefinedObject2;
		this.initialize();
		return this;
	}

	public boolean printArguments_(final VariableDeclarationNode[] _args) {
		if (_args.length == 0) {
			return false;
		}
		boolean _temp1 = true;
		for (final VariableDeclarationNode _arg : _args) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_stream.append(' ');
			}
			_stream.append(':');
			SourcePrinter.this.visit_(_arg);
		}
		return true;
	}

	public SourcePrinter printAssignmentNode_(final AssignmentNode _aNode) {
		this.visit_(_aNode.variable());
		_stream.append(" := ");
		this.indent_do_(2, new org.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				return SourcePrinter.this.visit_(_aNode.value());
			}
		});
		return this;
	}

	public SourcePrinter printBlockBody_(final SequenceNode _aSequenceNode) {
		boolean _indent;
		_indent = false;
		this.printComment_(_aSequenceNode.comment());
		if (_aSequenceNode.temporaries().length != 0) {
			if (_indent) {
				SourcePrinter.this.crtab_(_indentation);
			}
			SourcePrinter.this.printTemporaries_(_aSequenceNode.temporaries());
			_indent = true;
		}
		this.printStatements_indent_(_aSequenceNode.statements(), _indent);
		return this;
	}

	public SourcePrinter printCascadeNode_(final CascadeNode _aCascadeNode) {
		this.visit_precedence_indentation_(_aCascadeNode.receiver(), 0, _indentation);
		for (int _i = 1; _i <= _aCascadeNode.messages().length; _i++) {
			SourcePrinter.this.printMessage_(_aCascadeNode.messages()[_i - 1]);
			if (_i < _aCascadeNode.messages().length) {
				_stream.append(';');
			}
		}
		return this;
	}

	public SourcePrinter printCommentOf_(final Node _aNode) {
		if (this.printComment_(_aNode.comment())) {
			SourcePrinter.this.crtab_(_indentation);
		}
		return this;
	}

	public boolean printComment_(final String[] _comment) {
		if ((_comment == null) || (_comment.length == 0)) {
			return false;
		}
		for (final String _each : _comment) {
			SourcePrinter.this.crtab_(_indentation);
			_stream.append('\"');
			_stream.append(_each);
			_stream.append('\"');
		}
		return true;
	}

	public boolean printDeclaredReturnType_(final TypeNode _aTypeNode) {
		if (_aTypeNode == null) {
			return false;
		}
		_stream.append(" {^");
		this.visit_(_aTypeNode);
		_stream.append('}');
		return true;
	}

	public SourcePrinter printMessage_(final MessageNode _message) {
		Expression _prev;
		Expression _arg;
		int _indent;
		String _thisKey;
		final String[] _keywords;
		if (org.gravel.support.jvm.IntegerExtensions.equals_(_message.arguments().length, 0)) {
			_stream.append(' ');
			_stream.append(_message.selector());
			return SourcePrinter.this;
		}
		_keywords = _message.keywords();
		_prev = _message.receiver();
		for (int _part = 1; _part <= _message.arguments().length; _part++) {
			_arg = _message.arguments()[_part - 1];
			_thisKey = _keywords[_part - 1];
			if (_prev.isBlockNode() || ((_prev.isMessageNode() && (_prev.precedence() >= 3)) || ((_arg.isBlockNode() && (((BlockNode) _arg).isComplex() && (!org.gravel.support.jvm.StringExtensions.equals_(_thisKey, "do:")))) || ((_message.arguments().length > 2) || org.gravel.support.jvm.ArrayExtensions.includes_(new String[] { "ifTrue:ifFalse:", "ifFalse:ifTrue:" }, _message.selector()))))) {
				SourcePrinter.this.crtab_(_indentation + 1);
				_indent = 1;
			} else {
				_stream.append(' ');
				_indent = 0;
			}
			_stream.append(_thisKey);
			_stream.append(' ');
			SourcePrinter.this.visit_precedence_indentation_(_arg, org.gravel.support.jvm.IntegerExtensions.equals_(_message.precedence(), 2) ? 1 : _message.precedence(), _indentation + _indent);
			_prev = _arg;
		}
		return this;
	}

	public SourcePrinter printPragmas_(final PragmaNode[] _pragmas) {
		for (final PragmaNode _each : _pragmas) {
			SourcePrinter.this.crtab_(_indentation);
			SourcePrinter.this.visit_(_each);
		}
		return this;
	}

	public SourcePrinter printStatements_indent_(final Statement[] _stmts, final boolean _aBoolean) {
		final int _show;
		Statement _thisStatement;
		boolean _indent;
		_indent = _aBoolean;
		_show = _stmts.length;
		for (int _i = 1; _i <= _show; _i++) {
			_thisStatement = _stmts[_i - 1];
			if (_thisStatement.comment().length > 0) {
				if (org.gravel.support.jvm.IntegerExtensions.equals_(_i, 1)) {
					SourcePrinter.this.crtab_(_indentation);
				}
				_stream.append('\t');
			}
			if (_indent) {
				SourcePrinter.this.crtab_(_indentation);
			}
			SourcePrinter.this.visit_(_thisStatement);
			if (_i < _show) {
				_stream.append('.');
			}
			_indent = true;
		}
		return this;
	}

	public SourcePrinter printTemporaries_(final VariableDeclarationNode[] _aCollection) {
		_stream.append("| ");
		for (final VariableDeclarationNode _temp : _aCollection) {
			SourcePrinter.this.visit_(_temp);
			_stream.append(' ');
		}
		_stream.append('|');
		return this;
	}

	public SourcePrinter printTypeCastOf_using_(final Node _aNode, final org.gravel.support.jvm.Block0<Object> _aBlock) {
		_aBlock.value();
		return this;
	}

	public SourcePrinter printTypeNode_(final TypeNode _aNode) {
		_stream.append('{');
		this.visit_(_aNode);
		_stream.append('}');
		return this;
	}

	public SourcePrinter printValueNode_using_parenthesize_(final Node _aNode, final org.gravel.support.jvm.Block0<Object> _aBlock, final boolean _aBool) {
		this.printCommentOf_(_aNode);
		this.printTypeCastOf_using_(_aNode, new org.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				return SourcePrinter.this.when_parenthesize_(_aBool, _aBlock);
			}
		});
		return this;
	}

	public SourcePrinter pvtSetPrecedence_indentation_emphasis_(final Integer _anIntegerOrNil, final int _aLevel, final org.gravel.core.Symbol _anObject) {
		_precedence = _anIntegerOrNil;
		_indentation = _aLevel;
		_emphasis = _anObject;
		return this;
	}

	public SourcePrinter pvtVisit_(final Node _anObject) {
		if (_anObject == null) {
			return SourcePrinter.this;
		}
		_anObject.accept_(this);
		return this;
	}

	@Override
	public SourcePrinter visitArrayLiteralNode_(final ArrayLiteralNode _anObject) {
		_stream.append("#(");
		boolean _temp1 = true;
		for (final LiteralNode _each : _anObject.elements()) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_stream.append(' ');
			}
			SourcePrinter.this.visit_(_each);
		}
		_stream.append(')');
		return this;
	}

	@Override
	public SourcePrinter visitAssignmentNode_(final AssignmentNode _aNode) {
		this.printValueNode_using_parenthesize_(_aNode, new org.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				return SourcePrinter.this.printAssignmentNode_(_aNode);
			}
		}, (_precedence != null) && (_precedence < 4));
		return this;
	}

	@Override
	public SourcePrinter visitBlockNode_(final BlockNode _aNode) {
		this.printValueNode_using_parenthesize_(_aNode, new org.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				final boolean _hasArgs;
				final boolean _hasDeclaredReturnType;
				if (_aNode.isComplex()) {
					SourcePrinter.this.crtab_(_indentation);
				}
				_stream.append('[');
				_hasArgs = SourcePrinter.this.printArguments_(_aNode.arguments());
				_hasDeclaredReturnType = SourcePrinter.this.printDeclaredReturnType_(_aNode.returnType());
				if (_hasArgs || _hasDeclaredReturnType) {
					_stream.append(' ');
					_stream.append("| ");
				}
				if (_aNode.isComplex()) {
					SourcePrinter.this.crtab_(_indentation);
				}
				SourcePrinter.this.visit_(_aNode.body());
				return _stream.append(']');
			}
		}, false);
		return this;
	}

	@Override
	public SourcePrinter visitBlockTypeNode_(final BlockTypeNode _aNode) {
		_stream.append('[');
		boolean _temp1 = true;
		for (final TypeNode _each : _aNode.arguments()) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_stream.append(',');
				_stream.append(' ');
			}
			if (_each == null) {
				_stream.append("Unknown");
			} else {
				SourcePrinter.this.visit_(_each);
			}
		}
		if (_aNode.returnType() != null) {
			if (_aNode.arguments().length != 0) {
				_stream.append(',');
				_stream.append(' ');
			}
			SourcePrinter.this.visit_(_aNode.returnType());
		}
		_stream.append(']');
		return this;
	}

	@Override
	public SourcePrinter visitBooleanLiteralNode_(final BooleanLiteralNode _anObject) {
		if (_anObject.value()) {
			_stream.append("true");
		} else {
			_stream.append("false");
		}
		return this;
	}

	@Override
	public SourcePrinter visitBottomTypeNode_(final BottomTypeNode _anObject) {
		_stream.append("Bottom");
		return this;
	}

	@Override
	public SourcePrinter visitByteArrayLiteralNode_(final ByteArrayLiteralNode _anObject) {
		_stream.append("#[");
		boolean _temp1 = true;
		for (final byte _each : _anObject.value()) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_stream.append(' ');
			}
			_stream.append("" + (_each & 255));
		}
		_stream.append(']');
		return this;
	}

	@Override
	public SourcePrinter visitCascadeNode_(final CascadeNode _aNode) {
		final boolean _parenthesize;
		_parenthesize = (_precedence != null) && (_precedence < 4);
		if (_parenthesize) {
			_stream.append('(');
		}
		this.printCascadeNode_(_aNode);
		if (_parenthesize) {
			_stream.append(')');
		}
		return this;
	}

	@Override
	public SourcePrinter visitCharacterLiteralNode_(final CharacterLiteralNode _aNode) {
		_stream.append('$');
		_stream.append(_aNode.value());
		return this;
	}

	@Override
	public SourcePrinter visitClassTypeNode_(final ClassTypeNode _anObject) {
		this.visit_(_anObject.node());
		_stream.append(" class");
		return this;
	}

	@Override
	public SourcePrinter visitFixedPointLiteralNode_(final FixedPointLiteralNode _anObject) {
		_stream.append("" + _anObject.fixedPoint());
		return this;
	}

	@Override
	public SourcePrinter visitFloatLiteralNode_(final FloatLiteralNode _anObject) {
		_stream.append(_anObject.valueString());
		return this;
	}

	@Override
	public SourcePrinter visitGenericTypeVariableNode_(final GenericTypeVariableNode _aNode) {
		this.visit_(_aNode.root());
		_stream.append('[');
		boolean _temp1 = true;
		for (final TypeNode _each : _aNode.arguments()) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_stream.append(',');
				_stream.append(' ');
			}
			SourcePrinter.this.visit_(_each);
		}
		_stream.append(']');
		return this;
	}

	@Override
	public SourcePrinter visitInstanceTypeNode_(final InstanceTypeNode _anObject) {
		_stream.append("Instance");
		return this;
	}

	@Override
	public SourcePrinter visitIntegerLiteralNode_(final IntegerLiteralNode _anObject) {
		_stream.append("" + _anObject.integer());
		return this;
	}

	@Override
	public SourcePrinter visitIntermediateNode_(final IntermediateNode _anObject) {
		this.visit_(_anObject.unoptimized());
		return this;
	}

	@Override
	public SourcePrinter visitIntermediateStatement_(final IntermediateStatement _anObject) {
		this.visit_(_anObject.unoptimized());
		return this;
	}

	@Override
	public SourcePrinter visitMessageNode_(final MessageNode _aNode) {
		final boolean _parenthesize;
		_parenthesize = (_precedence != null) && ((_aNode.precedence() > _precedence) || (org.gravel.support.jvm.IntegerExtensions.equals_(_precedence, 3) && org.gravel.support.jvm.IntegerExtensions.equals_(_aNode.precedence(), _precedence)));
		this.printValueNode_using_parenthesize_(_aNode, new org.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				SourcePrinter.this.visit_precedence_(_aNode.receiver(), _aNode.precedence());
				return SourcePrinter.this.printMessage_(_aNode);
			}
		}, _parenthesize);
		return this;
	}

	@Override
	public SourcePrinter visitMethodNode_(final MethodNode _aNode) {
		this.emphasis_while_(org.gravel.core.Symbol.value("bold"), new org.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				if (org.gravel.support.jvm.IntegerExtensions.equals_(_aNode.precedence(), 1)) {
					return _stream.append(_aNode.selector());
				} else {
					return org.gravel.support.jvm.ArrayExtensions.with_do_separatedBy_(_aNode.keywords(), _aNode.arguments(), new org.gravel.support.jvm.Block2<Object, String, VariableDeclarationNode>() {

						@Override
						public Object value_value_(final String _s, final VariableDeclarationNode _arg) {
							_stream.append(_s);
							_stream.append(' ');
							return SourcePrinter.this.visit_(_arg);
						}
					}, new org.gravel.support.jvm.Block0<Object>() {

						@Override
						public Object value() {
							return _stream.append(' ');
						}
					});
				}
			}
		});
		this.printDeclaredReturnType_(_aNode.returnType());
		this.indentDo_(new org.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				return SourcePrinter.this.printComment_(_aNode.comment());
			}
		});
		this.indentDo_(new org.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				return SourcePrinter.this.printPragmas_(_aNode.pragmas());
			}
		});
		if (_aNode.body().isEmpty()) {
			return SourcePrinter.this;
		}
		this.indentDo_(new org.gravel.support.jvm.Block0<Object>() {

			@Override
			public Object value() {
				SourcePrinter.this.crtab_(_indentation);
				return SourcePrinter.this.printBlockBody_(_aNode.body());
			}
		});
		return this;
	}

	@Override
	public SourcePrinter visitNamespacedTypeVariableNode_(final NamespacedTypeVariableNode _anObject) {
		boolean _temp1 = true;
		for (final String _each : _anObject.path()) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_stream.append('.');
			}
			_stream.append(_each);
		}
		return this;
	}

	@Override
	public SourcePrinter visitNamespacedVariableNode_(final NamespacedVariableNode _anObject) {
		boolean _temp1 = true;
		for (final String _each : _anObject.path()) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_stream.append('.');
			}
			_stream.append(_each);
		}
		return this;
	}

	@Override
	public SourcePrinter visitNilLiteralNode_(final NilLiteralNode _anObject) {
		_stream.append("nil");
		return this;
	}

	@Override
	public SourcePrinter visitPragmaNode_(final PragmaNode _aPragmaNode) {
		final MessageNode _aNode;
		_stream.append('<');
		_aNode = _aPragmaNode.expression();
		if (org.gravel.support.jvm.IntegerExtensions.equals_(_aNode.arguments().length, 0)) {
			_stream.append(_aNode.selector());
		} else {
			org.gravel.support.jvm.ArrayExtensions.with_do_separatedBy_(_aNode.keywords(), _aNode.arguments(), new org.gravel.support.jvm.Block2<Object, String, Expression>() {

				@Override
				public Object value_value_(final String _key, final Expression _value) {
					_stream.append(_key);
					_stream.append(' ');
					return SourcePrinter.this.visit_(_value);
				}
			}, new org.gravel.support.jvm.Block0<Object>() {

				@Override
				public Object value() {
					return _stream.append(' ');
				}
			});
		}
		_stream.append('>');
		return this;
	}

	@Override
	public SourcePrinter visitReferenceLiteralNode_(final ReferenceLiteralNode _anObject) {
		_stream.append("#{");
		boolean _temp1 = true;
		for (final String _each : _anObject.path()) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_stream.append('.');
			}
			_stream.append(_each);
		}
		_stream.append('}');
		return this;
	}

	@Override
	public SourcePrinter visitReturnNode_(final ReturnNode _aNode) {
		this.printCommentOf_(_aNode);
		_stream.append('^');
		this.visit_(_aNode.value());
		return this;
	}

	@Override
	public SourcePrinter visitSelfTypeNode_(final SelfTypeNode _anObject) {
		_stream.append("Self");
		return this;
	}

	@Override
	public SourcePrinter visitSequenceNode_(final SequenceNode _aNode) {
		this.printBlockBody_(_aNode);
		return this;
	}

	@Override
	public SourcePrinter visitStringLiteralNode_(final StringLiteralNode _anObject) {
		_stream.append('\'');
		int _temp2 = _anObject.value().length();
		for (int _temp1 = 0; _temp1 < _temp2; _temp1++) {
			char _ch = _anObject.value().charAt(_temp1);
			_stream.append(_ch);
			if (_ch == '\'') {
				_stream.append('\'');
			}
		}
		_stream.append('\'');
		return this;
	}

	@Override
	public SourcePrinter visitSymbolLiteralNode_(final SymbolLiteralNode _anObject) {
		_stream.append("" + _anObject.value());
		return this;
	}

	@Override
	public SourcePrinter visitTypeDefNode_(final TypeDefNode _anObject) {
		this.visit_(_anObject.node());
		_stream.append(" def");
		return this;
	}

	@Override
	public SourcePrinter visitTypeOrNode_(final TypeOrNode _anObject) {
		this.visit_(_anObject.left());
		_stream.append(" | ");
		this.visit_(_anObject.right());
		return this;
	}

	@Override
	public SourcePrinter visitTypeVariableNode_(final TypeVariableNode _anObject) {
		_stream.append(_anObject.name());
		return this;
	}

	@Override
	public SourcePrinter visitVariableDeclarationNode_(final VariableDeclarationNode _anObject) {
		_stream.append(_anObject.name());
		if (_anObject.type() != null) {
			_stream.append(' ');
			SourcePrinter.this.printTypeNode_(_anObject.type());
		}
		return this;
	}

	@Override
	public SourcePrinter visitVariableNode_(final VariableNode _anObject) {
		_stream.append(_anObject.name());
		return this;
	}

	@Override
	public SourcePrinter visit_(final Node _aNode) {
		_precedence = null;
		this.pvtVisit_(_aNode);
		return this;
	}

	public SourcePrinter visit_precedence_(final Node _aNode, final Integer _anIntegerOrNil) {
		this.visit_precedence_indentation_(_aNode, _anIntegerOrNil, _indentation);
		return this;
	}

	public SourcePrinter visit_precedence_indentation_(final Node _aNode, final Integer _anIntegerOrNil, final int _aLevel) {
		this.visit_precedence_indentation_emphasis_(_aNode, _anIntegerOrNil, _aLevel, _emphasis);
		return this;
	}

	public SourcePrinter visit_precedence_indentation_emphasis_(final Node _aNode, final Integer _anIntegerOrNil, final int _aLevel, final org.gravel.core.Symbol _anObject) {
		this.copy().pvtSetPrecedence_indentation_emphasis_(_anIntegerOrNil, _aLevel, _anObject).pvtVisit_(_aNode);
		return this;
	}

	public SourcePrinter when_parenthesize_(final boolean _aBoolean, final org.gravel.support.jvm.Block0<Object> _aBlock) {
		if (_aBoolean) {
			_stream.append('(');
			_aBlock.value();
			_stream.append(')');
		} else {
			_aBlock.value();
		}
		return this;
	}
}
