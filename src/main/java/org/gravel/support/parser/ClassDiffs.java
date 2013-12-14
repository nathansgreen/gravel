package org.gravel.support.parser;

/*
	This file is automatically generated. See FX.TService.TService class>>generateWorkspaces
	(C) CosmoCows B.V.
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import org.gravel.support.jvm.NonLocalReturn;
import org.gravel.support.parser.AbstractClassDiff;
import org.gravel.support.parser.AbstractClassDiff.AbstractClassDiff_Factory;
import org.gravel.support.parser.Diff;
import org.gravel.support.parser.DiffVisitor;
import org.gravel.support.parser.SystemNode;
import org.gravel.support.parser.BranchDiff;
import org.gravel.support.parser.NewClassDiff;

public class ClassDiffs extends AbstractClassDiff implements Cloneable {

	public static ClassDiffs_Factory factory = new ClassDiffs_Factory();

	AbstractClassDiff[] _classDiffs;

	public static class ClassDiffs_Factory extends AbstractClassDiff_Factory {

		public ClassDiffs basicNew() {
			ClassDiffs newInstance = new ClassDiffs();
			newInstance.initialize();
			return newInstance;
		}

		public Diff classDiffs_(final AbstractClassDiff[] _anArray) {
			if (org.gravel.support.jvm.IntegerExtensions.equals_(_anArray.length, 1)) {
				return _anArray[0];
			}
			return this.basicNew().initializeClassDiffs_(_anArray);
		}

		public Diff empty() {
			return this.classDiffs_(new AbstractClassDiff[] {});
		}

		public Diff with_with_(final AbstractClassDiff _aClassDiff1, final AbstractClassDiff _aClassDiff2) {
			return this.classDiffs_(org.gravel.support.jvm.ArrayFactory.with_with_(_aClassDiff1, _aClassDiff2));
		}
	}

	static public Diff _classDiffs_(Object receiver, final AbstractClassDiff[] _anArray) {
		return factory.classDiffs_(_anArray);
	}

	static public Diff _empty(Object receiver) {
		return factory.empty();
	}

	static public Diff _with_with_(Object receiver, final AbstractClassDiff _aClassDiff1, final AbstractClassDiff _aClassDiff2) {
		return factory.with_with_(_aClassDiff1, _aClassDiff2);
	}

	@Override
	public DiffVisitor accept_(final DiffVisitor _visitor) {
		return _visitor.visitClassDiffs_(this);
	}

	@Override
	public SystemNode applyOnSystemNode_(final SystemNode _aSystemNode) {
		return ((SystemNode) org.gravel.support.jvm.ArrayExtensions.inject_into_(_classDiffs, _aSystemNode, ((org.gravel.support.jvm.Block2<SystemNode, SystemNode, AbstractClassDiff>) (new org.gravel.support.jvm.Block2<SystemNode, SystemNode, AbstractClassDiff>() {

			@Override
			public SystemNode value_value_(final SystemNode _n, final AbstractClassDiff _e) {
				return (SystemNode) _e.applyOnSystemNode_(_n);
			}
		}))));
	}

	@Override
	public ClassDiffs beStatic() {
		return this.copy().pvtSetStatic_(true);
	}

	@Override
	public ClassDiffs beStatic_(final boolean _aBoolean) {
		if (_aBoolean && (!this.isStatic())) {
			return ClassDiffs.this.beStatic();
		}
		return this;
	}

	public AbstractClassDiff[] classDiffs() {
		return _classDiffs;
	}

	@Override
	public Integer classDiffsSize() {
		return ((Integer) org.gravel.support.jvm.ArrayExtensions.inject_into_(_classDiffs, 0, ((org.gravel.support.jvm.Block2<Integer, Integer, AbstractClassDiff>) (new org.gravel.support.jvm.Block2<Integer, Integer, AbstractClassDiff>() {

			@Override
			public Integer value_value_(final Integer _s, final AbstractClassDiff _each) {
				return (Integer) _s + _each.classDiffsSize();
			}
		}))));
	}

	public ClassDiffs copy() {
		try {
			ClassDiffs _temp1 = (ClassDiffs) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public ClassDiffs_Factory factory() {
		return factory;
	}

	@Override
	public ClassDiffs initialize() {
		super.initialize();
		_isStatic = this.isStaticDefault();
		_cache = new java.util.IdentityHashMap<AbstractClassDiff, Boolean>();
		return this;
	}

	public ClassDiffs initializeClassDiffs_(final AbstractClassDiff[] _anArray) {
		_classDiffs = _anArray;
		this.initialize();
		return this;
	}

	@Override
	public boolean isPrereqOrDependent_(final AbstractClassDiff _anAbstractClassDiff) {
		return org.gravel.support.jvm.ArrayExtensions.anySatisfy_(_classDiffs, new org.gravel.support.jvm.Predicate1<AbstractClassDiff>() {

			@Override
			public boolean value_(final AbstractClassDiff _cd) {
				return _cd.isPrereqOrDependent_(_anAbstractClassDiff);
			}
		});
	}

	@Override
	public ClassDiffs printDescriptionOn_(final StringBuilder _aStream) {
		_aStream.append(_classDiffs.toString());
		return this;
	}

	@Override
	public ClassDiffs pvtSetStatic_(final boolean _aBoolean) {
		_isStatic = _aBoolean;
		return this;
	}

	@Override
	public Diff withAbstractClassDiff_(final AbstractClassDiff _anAbstractClassDiff) {
		final AbstractClassDiff[] _pod;
		final Diff _n;
		final AbstractClassDiff[] _nopod;
		_pod = org.gravel.support.jvm.ArrayExtensions.select_(_classDiffs, new org.gravel.support.jvm.Predicate1<AbstractClassDiff>() {

			@Override
			public boolean value_(final AbstractClassDiff _e) {
				return _e.cachedIsPrereqOrDependent_(_anAbstractClassDiff);
			}
		});
		if (_pod.length == 0) {
			return ClassDiffs.this.factory().classDiffs_(org.gravel.support.jvm.ArrayExtensions.copyWith_(_classDiffs, _anAbstractClassDiff));
		}
		_nopod = org.gravel.support.jvm.ArrayExtensions.reject_(_classDiffs, new org.gravel.support.jvm.Predicate1<AbstractClassDiff>() {

			@Override
			public boolean value_(final AbstractClassDiff _e) {
				return _e.cachedIsPrereqOrDependent_(_anAbstractClassDiff);
			}
		});
		org.gravel.support.jvm.ObjectExtensions.assert_(this, org.gravel.support.jvm.IntegerExtensions.equals_(_pod.length + _nopod.length, _classDiffs.length));
		_n = ((Diff) org.gravel.support.jvm.ArrayExtensions.inject_into_(_pod, _anAbstractClassDiff, ((org.gravel.support.jvm.Block2<Diff, Diff, AbstractClassDiff>) (new org.gravel.support.jvm.Block2<Diff, Diff, AbstractClassDiff>() {

			@Override
			public Diff value_value_(final Diff _s, final AbstractClassDiff _e) {
				return (Diff) _s.withDiff_(_e);
			}
		}))));
		return ((Diff) org.gravel.support.jvm.ArrayExtensions.inject_into_(_nopod, _n, ((org.gravel.support.jvm.Block2<Diff, Diff, AbstractClassDiff>) (new org.gravel.support.jvm.Block2<Diff, Diff, AbstractClassDiff>() {

			@Override
			public Diff value_value_(final Diff _s, final AbstractClassDiff _e) {
				return (Diff) _s.withDiff_(_e);
			}
		}))));
	}

	@Override
	public Diff withBranchDiff_(final BranchDiff _aBranchDiff) {
		return ((Diff) org.gravel.support.jvm.ArrayExtensions.inject_into_(_classDiffs, _aBranchDiff, ((org.gravel.support.jvm.Block2<BranchDiff, BranchDiff, AbstractClassDiff>) (new org.gravel.support.jvm.Block2<BranchDiff, BranchDiff, AbstractClassDiff>() {

			@Override
			public BranchDiff value_value_(final BranchDiff _s, final AbstractClassDiff _e) {
				return (BranchDiff) _s.withDiff_(_e);
			}
		}))));
	}

	@Override
	public Diff withDiff_(final Diff _aDiff) {
		return _aDiff.withClassDiffs_(this);
	}

	@Override
	public AbstractClassDiff withNewClassDiff_(final NewClassDiff _aNewClassDiff) {
		return ((AbstractClassDiff) this.withAbstractClassDiff_(_aNewClassDiff));
	}
}
