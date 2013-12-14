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

public class BlockTypeNode extends TypeNode implements Cloneable {

	public static BlockTypeNode_Factory factory = new BlockTypeNode_Factory();

	TypeNode[] _arguments;

	TypeNode _returnType;

	public static class BlockTypeNode_Factory extends TypeNode_Factory {

		public BlockTypeNode arguments_returnType_(final TypeNode[] _anArray, final TypeNode _anUndefinedObject) {
			return ((BlockTypeNode) this.basicNew().initializeArguments_returnType_(_anArray, _anUndefinedObject));
		}

		public BlockTypeNode basicNew() {
			BlockTypeNode newInstance = new BlockTypeNode();
			newInstance.initialize();
			return newInstance;
		}
	}

	static public BlockTypeNode _arguments_returnType_(Object receiver, final TypeNode[] _anArray, final TypeNode _anUndefinedObject) {
		return factory.arguments_returnType_(_anArray, _anUndefinedObject);
	}

	@Override
	public <X> X accept_(final NodeVisitor<X> _visitor) {
		return _visitor.visitBlockTypeNode_(this);
	}

	@Override
	public BlockTypeNode allNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				return _each.withAllNodesDo_(_aBlock);
			}
		});
		return this;
	}

	@Override
	public BlockTypeNode allNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		this.nodesDo_(new org.gravel.support.jvm.Block1<Object, Node>() {

			@Override
			public Object value_(final Node _each) {
				if (!_pruneBlock.value_(_each)) {
					return _each.withAllNodesDo_pruneWhere_(_aBlock, _pruneBlock);
				}
				return BlockTypeNode.this;
			}
		});
		return this;
	}

	public TypeNode[] arguments() {
		return _arguments;
	}

	public BlockTypeNode copy() {
		try {
			BlockTypeNode _temp1 = (BlockTypeNode) this.clone();
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
		if (this._arguments == null) {
			if (!(((BlockTypeNode) _anObject)._arguments == null)) {
				return false;
			}
		} else {
			if (!org.gravel.support.jvm.ArrayExtensions.equals_(this._arguments, ((BlockTypeNode) _anObject)._arguments)) {
				return false;
			}
		}
		if (this._returnType == null) {
			if (!(((BlockTypeNode) _anObject)._returnType == null)) {
				return false;
			}
		} else {
			if (!org.gravel.support.jvm.ObjectExtensions.equals_(this._returnType, ((BlockTypeNode) _anObject)._returnType)) {
				return false;
			}
		}
		return true;
	}

	public BlockTypeNode_Factory factory() {
		return factory;
	}

	@Override
	public int hashCode() {
		return ((super.hashCode() ^ java.util.Arrays.hashCode(_arguments)) ^ (_returnType == null ? 0 : _returnType.hashCode()));
	}

	public BlockTypeNode initializeArguments_returnType_(final TypeNode[] _anArray, final TypeNode _anUndefinedObject) {
		_arguments = _anArray;
		_returnType = _anUndefinedObject;
		this.initialize();
		return this;
	}

	@Override
	public BlockTypeNode innerSourceOn_(final StringBuilder _aStream) {
		_aStream.append('[');
		boolean _temp1 = true;
		for (final TypeNode _arg : _arguments) {
			if (_temp1) {
				_temp1 = false;
			} else {
				_aStream.append(", ");
			}
			_arg.sourceOn_(_aStream);
		}
		if (_returnType != null) {
			if (_arguments.length != 0) {
				_aStream.append(", ");
			}
			_aStream.append('^');
			_returnType.sourceOn_(_aStream);
		}
		_aStream.append(']');
		return this;
	}

	@Override
	public boolean isBlockTypeNode() {
		return true;
	}

	@Override
	public BlockTypeNode localVarNamesDo_(final org.gravel.support.jvm.Block1<Object, String> _aBlock) {
		return this;
	}

	public int numArgs() {
		return _arguments.length;
	}

	@Override
	public BlockTypeNode prettySourceOn_(final StringBuilder _aStream) {
		SourcePrinter.factory.on_(_aStream).visit_(this);
		return this;
	}

	@Override
	public BlockTypeNode printOn_(final StringBuilder _aStream) {
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
	public BlockTypeNode pvtSetSourcePosition_(final SourcePosition _aSourcePosition) {
		_sourcePosition = _aSourcePosition;
		return this;
	}

	@Override
	public boolean referencesSelfOrInstanceType() {
		return _returnType.referencesSelfOrInstanceType() || org.gravel.support.jvm.ArrayExtensions.anySatisfy_(_arguments, new org.gravel.support.jvm.Predicate1<TypeNode>() {

			@Override
			public boolean value_(final TypeNode _type) {
				return _type.referencesSelfOrInstanceType();
			}
		});
	}

	public TypeNode returnType() {
		return _returnType;
	}

	@Override
	public BlockTypeNode sourceOn_(final StringBuilder _aStream) {
		this.innerSourceOn_(_aStream);
		return this;
	}

	@Override
	public BlockTypeNode typeDefsDo_(final org.gravel.support.jvm.Block1<Object, TypeNode> _aBlock) {
		for (final TypeNode _each : _arguments) {
			_each.typeDefsDo_(_aBlock);
		}
		if (_returnType != null) {
			_returnType.typeDefsDo_(_aBlock);
		}
		return this;
	}

	@Override
	public BlockTypeNode withAllNodesDo_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock) {
		_aBlock.value_(this);
		this.allNodesDo_(_aBlock);
		return this;
	}

	@Override
	public BlockTypeNode withAllNodesDo_pruneWhere_(final org.gravel.support.jvm.Block1<Object, Node> _aBlock, final org.gravel.support.jvm.Block1<Boolean, Node> _pruneBlock) {
		_aBlock.value_(this);
		this.allNodesDo_pruneWhere_(_aBlock, _pruneBlock);
		return this;
	}

	public BlockTypeNode withReturnType_(final TypeNode _aTypeNode) {
		return this.factory().arguments_returnType_(_arguments, _aTypeNode);
	}

	@Override
	public BlockTypeNode withSourcePosition_(final SourcePosition _aSourcePosition) {
		if (_sourcePosition == _aSourcePosition) {
			return BlockTypeNode.this;
		}
		return this.copy().pvtSetSourcePosition_(_aSourcePosition);
	}
}
