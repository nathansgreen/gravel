package st.gravel.support.compiler.ast;

/*
	This file is automatically generated from typed smalltalk source. Do not edit by hand.
	(C) AG5.com
*/

import java.math.BigInteger;
import st.gravel.support.jvm.NonLocalReturn;
import st.gravel.support.compiler.ast.DiffVisitor;
import st.gravel.support.compiler.ast.DiffVisitor.DiffVisitor_Factory;
import st.gravel.support.compiler.ast.SystemMapping;
import st.gravel.support.compiler.ast.SystemMappingCompilerTools;
import st.gravel.support.compiler.ast.SelectorConverter;
import java.util.List;
import st.gravel.support.compiler.ast.Reference;
import st.gravel.support.compiler.ast.BoundVariableDeclarationNode;
import st.gravel.support.compiler.ast.ClassDescriptionNode;
import st.gravel.support.compiler.jvm.JVMClassCompiler;
import st.gravel.support.compiler.jvm.JVMClass;
import st.gravel.support.compiler.jvm.JVMNonPrimitiveType;
import st.gravel.support.compiler.ast.IdentityClassPartMapping;
import st.gravel.support.compiler.ast.MethodNode;
import st.gravel.support.compiler.ast.ClassMapping;
import st.gravel.support.compiler.ast.ExtensionClassPartMapping;
import java.util.HashMap;
import st.gravel.support.compiler.ast.InstVarMapping;
import java.util.Set;
import st.gravel.support.compiler.ast.AbstractMethodMapping;
import st.gravel.support.compiler.ast.SourceFile;
import st.gravel.support.compiler.ast.UpdateClassDescriptorDiff;
import st.gravel.support.compiler.ast.ClassNode;
import st.gravel.support.compiler.ast.MetaclassNode;
import st.gravel.support.compiler.ast.UnaryMethodNode;
import st.gravel.support.compiler.ast.SequenceNode;
import st.gravel.support.compiler.ast.ReturnNode;
import st.gravel.support.compiler.ast.VariableNode;
import st.gravel.support.compiler.ast.PragmaNode;
import st.gravel.support.compiler.ast.InstanceCreationNode;
import java.util.ArrayList;
import st.gravel.support.compiler.ast.SharedDeclarationNode;
import st.gravel.support.compiler.ast.AbsoluteReference;
import st.gravel.support.compiler.ast.AbstractClassMapping;
import st.gravel.support.compiler.ast.ClassPartMapping;
import st.gravel.support.compiler.ast.MethodMapping;
import st.gravel.support.compiler.ast.Node;
import st.gravel.support.compiler.ast.Expression;
import st.gravel.support.compiler.ast.IntermediateNodeRewriter;
import st.gravel.support.compiler.ast.NonLocalReturnRewriter;
import st.gravel.support.compiler.ast.NonLocalTempWritesToHolderConverter;
import st.gravel.support.compiler.ast.VariableAccessToFieldAccessConverter;
import st.gravel.support.compiler.ast.SelfNode;
import java.util.HashSet;
import java.util.Map;
import st.gravel.support.compiler.ast.NamespaceNode;
import st.gravel.support.compiler.ast.AddClassDiff;
import st.gravel.support.compiler.ast.RemoveClassDiff;
import st.gravel.support.compiler.ast.UpdateClassDiff;
import st.gravel.support.compiler.ast.WrapJavaclassDiff;
import st.gravel.support.compiler.ast.ClassDiff;
import st.gravel.support.compiler.ast.NodeVisitorError;
import st.gravel.support.compiler.ast.NewClassDiff;

public class SystemMappingUpdater extends DiffVisitor implements Cloneable {

	public static SystemMappingUpdater_Factory factory = new SystemMappingUpdater_Factory();

	SystemMappingCompilerTools _compilerTools;

	boolean _isStaticOverride;

	SelectorConverter _selectorConverter;

	SystemMapping _systemMapping;

	List<Reference> _toInitialize;

	public static class SystemMappingUpdater_Factory extends DiffVisitor_Factory {

		public SystemMappingUpdater basicNew() {
			SystemMappingUpdater newInstance = new SystemMappingUpdater();
			newInstance.initialize();
			return newInstance;
		}

		public SystemMappingUpdater systemMapping_compilerTools_(final SystemMapping _aSystemMapping, final SystemMappingCompilerTools _aSystemMappingCompilerTools) {
			return this.basicNew().initializeSystemMapping_compilerTools_(_aSystemMapping, _aSystemMappingCompilerTools);
		}
	}

	static public SystemMappingUpdater _systemMapping_compilerTools_(Object receiver, final SystemMapping _aSystemMapping, final SystemMappingCompilerTools _aSystemMappingCompilerTools) {
		return factory.systemMapping_compilerTools_(_aSystemMapping, _aSystemMappingCompilerTools);
	}

	public BoundVariableDeclarationNode[] allInstVarsForReference_(final Reference _aReference) {
		if (_aReference == null) {
			return new BoundVariableDeclarationNode[] {};
		}
		return _systemMapping.classMappingAtReference_(_aReference).allInstVarsIn_(_systemMapping);
	}

	public SystemMappingUpdater compileClassDescriptionNodeNonStatic_(final ClassDescriptionNode _aClassDescriptionNode) {
		final Class _identityClass;
		final IdentityClassPartMapping _identityMapping;
		final MethodNode[] _allMethods;
		final MethodNode[] _extraMethods;
		final ClassDescriptionNode _ecdn;
		_extraMethods = this.extraMethodsFor_(_aClassDescriptionNode);
		_ecdn = _aClassDescriptionNode.withExtraMethods_(_extraMethods);
		_identityClass = this.compileClass_isStatic_(_ecdn, false);
		_allMethods = this.methods_withExtraMethods_(_aClassDescriptionNode.methods(), _extraMethods);
		_identityMapping = ((IdentityClassPartMapping) this.linkMethods_in_identityClass_to_isStatic_(_allMethods, _identityClass, _identityClass, IdentityClassPartMapping.factory.javaClass_isGenerated_(_identityClass, true), false));
		_systemMapping.addClassMapping_(ClassMapping.factory.identityMapping_extensions_instVarMappings_classNode_(_identityMapping, new ExtensionClassPartMapping[] {}, new java.util.HashMap<String, InstVarMapping>(), _aClassDescriptionNode));
		return this;
	}

	public SystemMappingUpdater compileClassDescriptionNodeStatic_(final ClassDescriptionNode _aClassDescriptionNode) {
		final Class _extensionClass;
		IdentityClassPartMapping _identityMapping;
		final MethodNode[] _allMethods;
		final MethodNode[] _extraMethods;
		final ClassDescriptionNode _ecdn;
		_extraMethods = this.extraMethodsFor_(_aClassDescriptionNode);
		_allMethods = this.methods_withExtraMethods_(_aClassDescriptionNode.methods(), _extraMethods);
		_ecdn = _aClassDescriptionNode.withExtraMethods_(_extraMethods);
		_extensionClass = this.compileClass_isStatic_(_ecdn, true);
		_identityMapping = IdentityClassPartMapping.factory.javaClass_isGenerated_(_aClassDescriptionNode.isNilClass() ? null : _extensionClass, true);
		_identityMapping = ((IdentityClassPartMapping) this.linkMethods_in_identityClass_to_isStatic_(_allMethods, _extensionClass, _extensionClass, _identityMapping, true));
		_systemMapping.addClassMapping_(ClassMapping.factory.identityMapping_extensions_instVarMappings_classNode_(_identityMapping, new ExtensionClassPartMapping[] {}, new java.util.HashMap<String, InstVarMapping>(), _aClassDescriptionNode));
		return this;
	}

	public SystemMappingUpdater compileClassDescriptionNode_(final ClassDescriptionNode _aClassDescriptionNode) {
		return this.compileClassDescriptionNode_isStatic_(_aClassDescriptionNode, false);
	}

	public SystemMappingUpdater compileClassDescriptionNode_isStatic_(final ClassDescriptionNode _aClassDescriptionNode, final boolean _isStatic) {
		if (_isStatic) {
			SystemMappingUpdater.this.compileClassDescriptionNodeStatic_(_aClassDescriptionNode);
		} else {
			SystemMappingUpdater.this.compileClassDescriptionNodeNonStatic_(_aClassDescriptionNode);
		}
		return this;
	}

	public Class compileClass_extensionPostfix_isStatic_identityClass_(final ClassDescriptionNode _aClassDescriptionNode, final String _extensionPostfix, final boolean _isStatic, final Class _identityClass) {
		final JVMClassCompiler _compiler;
		final Class _extensionClass;
		final JVMClass _jvmClass;
		_compiler = JVMClassCompiler.factory.classDescriptionNode_systemNode_systemMappingUpdater_isStatic_(_aClassDescriptionNode, _systemMapping.systemNode(), this, _isStatic);
		if (_extensionPostfix != null) {
			_compiler.extensionPostfix_(_extensionPostfix);
		}
		if (_identityClass != null) {
			_compiler.selfType_(((JVMNonPrimitiveType) _compilerTools.jvmTypeForClass_(_identityClass)));
		}
		_jvmClass = _compiler.compileClassNode();
		_extensionClass = _compilerTools.writeClass_(_jvmClass);
		_compiler.extraClassesDo_(new st.gravel.support.jvm.Block1<Object, JVMClass>() {

			@Override
			public Object value_(final JVMClass _each) {
				return _compilerTools.writeClass_(_each);
			}
		});
		_compilerTools.runAstInit_(_jvmClass);
		_compiler.extraClassesDo_(new st.gravel.support.jvm.Block1<Object, JVMClass>() {

			@Override
			public Object value_(final JVMClass _each) {
				return _compilerTools.runAstInit_(_each);
			}
		});
		return _extensionClass;
	}

	public Class compileClass_isStatic_(final ClassDescriptionNode _aClassDescriptionNode, final boolean _isStatic) {
		return this.compileClass_extensionPostfix_isStatic_identityClass_(_aClassDescriptionNode, null, _isStatic, null);
	}

	public SystemMappingUpdater compiledMethodNodesIn_do_(final Reference _superclassReference, final st.gravel.support.jvm.Block1<Object, MethodNode> _aBlock) {
		final ClassMapping[] _superMapping;
		final Class _sc;
		final java.util.Set<st.gravel.core.Symbol>[] _allSelectors;
		_allSelectors = new java.util.Set[1];
		_superMapping = new ClassMapping[1];
		if (_superclassReference == null) {
			return SystemMappingUpdater.this;
		}
		_superMapping[0] = ((ClassMapping) _systemMapping.classMappingAtReference_(_superclassReference));
		_allSelectors[0] = _superMapping[0].allSelectorsIn_(_systemMapping);
		_sc = _superMapping[0].identityClass();
		_compilerTools.methodNamesIn_do_(_sc, new st.gravel.support.jvm.Block2<Object, String, Integer>() {

			@Override
			public Object value_value_(final String _methodName, final Integer _numArgs) {
				final st.gravel.core.Symbol _sel;
				_sel = _selectorConverter.functionNameAsSelector_(_methodName);
				if (_allSelectors[0].contains(_sel)) {
					final AbstractMethodMapping _methodMapping;
					_methodMapping = _systemMapping.methodMappingFrom_selector_(_superMapping[0], _sel);
					if ((_methodMapping != null) && (_methodMapping.methodNode() != null)) {
						return _aBlock.value_(_methodMapping.methodNode());
					}
				}
				return SystemMappingUpdater.this;
			}
		});
		return this;
	}

	public ExtensionClassPartMapping compileExtensionClassPartMapping_methods_identityClass_instVars_sourceFile_(final ClassDescriptionNode _aClassDescriptionNode, final MethodNode[] _extensionMethods, final Class _identityClass, final BoundVariableDeclarationNode[] _boundInstVars, final SourceFile _sourceFile) {
		final Class _extensionClass;
		_extensionClass = this.compileClass_extensionPostfix_isStatic_identityClass_(_aClassDescriptionNode, _compilerTools.nextExtensionPostfix(), true, _identityClass);
		return ((ExtensionClassPartMapping) this.linkMethods_in_identityClass_to_isStatic_(_extensionMethods, _extensionClass, _identityClass, ExtensionClassPartMapping.factory.javaClass_isGenerated_(_extensionClass, true), true));
	}

	public SystemMappingCompilerTools compilerTools() {
		return _compilerTools;
	}

	public SystemMappingUpdater copy() {
		try {
			SystemMappingUpdater _temp1 = (SystemMappingUpdater) this.clone();
			_temp1.postCopy();
			return _temp1;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public SystemMappingUpdater executeUpdateClassDescriptorDiff_reference_(final UpdateClassDescriptorDiff _anUpdateClassDescriptorDiff, final Reference _aReference) {
		final ExtensionClassPartMapping _ecm;
		ClassMapping _cm;
		final ClassDescriptionNode _ncn;
		final MethodNode[] _methods;
		_cm = ((ClassMapping) _systemMapping.classMappingAtReference_(_aReference));
		_cm = ((ClassMapping) st.gravel.support.jvm.ArrayExtensions.inject_into_(_anUpdateClassDescriptorDiff.updatedMethodNodes(), _cm, ((st.gravel.support.jvm.Block2<ClassMapping, ClassMapping, MethodNode>) (new st.gravel.support.jvm.Block2<ClassMapping, ClassMapping, MethodNode>() {

			@Override
			public ClassMapping value_value_(final ClassMapping _classMapping, final MethodNode _methodNode) {
				return (ClassMapping) _classMapping.withoutMethodMapping_(_methodNode.selector());
			}
		}))));
		_cm = ((ClassMapping) st.gravel.support.jvm.ArrayExtensions.inject_into_(_anUpdateClassDescriptorDiff.deletedSelectors(), _cm, ((st.gravel.support.jvm.Block2<ClassMapping, ClassMapping, String>) (new st.gravel.support.jvm.Block2<ClassMapping, ClassMapping, String>() {

			@Override
			public ClassMapping value_value_(final ClassMapping _classMapping, final String _selector) {
				return (ClassMapping) _classMapping.withoutMethodMapping_(_selector);
			}
		}))));
		_ncn = _anUpdateClassDescriptorDiff.applyOnClassNode_(_cm.classNode());
		_methods = st.gravel.support.jvm.ArrayExtensions.copyWithAll_(_anUpdateClassDescriptorDiff.methodNodes(), _anUpdateClassDescriptorDiff.updatedMethodNodes());
		_ecm = this.compileExtensionClassPartMapping_methods_identityClass_instVars_sourceFile_(_ncn, _methods, _cm.identityClass(), _cm.classNode().boundInstVars(), this.findSourceFile_(_anUpdateClassDescriptorDiff.methodNodes()));
		_systemMapping.addClassMapping_(_cm.withClassNode_(_ncn).withExtension_(_ecm));
		return this;
	}

	public MethodNode[] extraMethodsForClassNode_(final ClassNode _aClassNode) {
		return st.gravel.support.jvm.ArrayFactory.with_(UnaryMethodNode.factory.selector_body_returnType_pragmas_protocol_("class", SequenceNode.factory.statement_(ReturnNode.factory.value_(VariableNode.factory.name_(_aClassNode.name().asString()))), null, new PragmaNode[] {}, "extra"));
	}

	public MethodNode[] extraMethodsForMetaclassNode_(final MetaclassNode _aMetaclassNode) {
		return st.gravel.support.jvm.ArrayFactory.with_(UnaryMethodNode.factory.selector_body_returnType_pragmas_protocol_("basicNew", SequenceNode.factory.statement_(ReturnNode.factory.value_(InstanceCreationNode.factory.reference_(_aMetaclassNode.reference().nonmeta()))), null, new PragmaNode[] {}, "extra"));
	}

	public MethodNode[] extraMethodsFor_(final ClassDescriptionNode _aClassDescriptionNode) {
		if (_aClassDescriptionNode.isClassNode()) {
			return SystemMappingUpdater.this.extraMethodsForClassNode_(((ClassNode) _aClassDescriptionNode));
		} else {
			return SystemMappingUpdater.this.extraMethodsForMetaclassNode_(((MetaclassNode) _aClassDescriptionNode));
		}
	}

	public SystemMappingUpdater_Factory factory() {
		return factory;
	}

	public SourceFile findSourceFile_(final MethodNode[] _methodNodes) {
		for (final MethodNode _each : _methodNodes) {
			if (_each.sourcePosition() != null) {
				return _each.sourcePosition().sourceFile();
			}
		}
		return null;
	}

	@Override
	public SystemMappingUpdater initialize() {
		_selectorConverter = SelectorConverter.factory.basicNew();
		_toInitialize = new java.util.ArrayList();
		_isStaticOverride = false;
		return this;
	}

	public SystemMappingUpdater initializeClassShareds_(final MetaclassNode _aMetaclassNode) {
		for (final SharedDeclarationNode _sharedVariable : _aMetaclassNode.sharedVariables()) {
			final AbsoluteReference _reference;
			_reference = _aMetaclassNode.reference().nonmeta().$slash$(st.gravel.core.Symbol.value(_sharedVariable.name()));
			_systemMapping.singletonAtReference_initialize_(_reference, _sharedVariable);
		}
		return this;
	}

	public SystemMappingUpdater initializeSystemMapping_compilerTools_(final SystemMapping _aSystemMapping, final SystemMappingCompilerTools _aSystemMappingCompilerTools) {
		_systemMapping = _aSystemMapping;
		_compilerTools = _aSystemMappingCompilerTools;
		this.initialize();
		return this;
	}

	public SystemMappingUpdater link() {
		_systemMapping.classMappingsDo_(new st.gravel.support.jvm.Block1<Object, AbstractClassMapping>() {

			@Override
			public Object value_(final AbstractClassMapping _acm) {
				if (_acm.classNode().isMeta()) {
					SystemMappingUpdater.this.initializeClassShareds_(((MetaclassNode) _acm.classNode()));
					return _systemMapping.singletonAtReference_ifAbsentPut_(_acm.reference().nonmeta(), new st.gravel.support.jvm.Block0<Object>() {

						@Override
						public Object value() {
							return _compilerTools.createSingletonForClass_(_acm.identityClass());
						}
					});
				}
				return SystemMappingUpdater.this;
			}
		});
		_compilerTools.resetCallsites();
		_systemMapping.namespaceGlobalsAndInitializersDo_(new st.gravel.support.jvm.Block2<Object, AbsoluteReference, SharedDeclarationNode>() {

			@Override
			public Object value_value_(final AbsoluteReference _reference, final SharedDeclarationNode _sharedVariable) {
				return _systemMapping.singletonAtReference_initialize_(_reference, _sharedVariable);
			}
		});
		for (final Reference _ref : _toInitialize) {
			_compilerTools.initializeClass_systemMapping_(((ClassMapping) _systemMapping.classMappingAtReference_(_ref)), _systemMapping);
		}
		_toInitialize = new java.util.ArrayList();
		return this;
	}

	public ClassPartMapping linkMethods_in_identityClass_to_isStatic_(final MethodNode[] _methods, final Class _javaClass, final Class _identityClass, final ClassPartMapping _cpm, final boolean _isStatic) {
		final ClassPartMapping[] _ecm;
		_ecm = new ClassPartMapping[1];
		_ecm[0] = _cpm;
		for (final MethodNode _m : _methods) {
			final String _fn;
			final java.lang.invoke.MethodHandle _methodHandle;
			final st.gravel.core.Symbol _selector;
			_selector = st.gravel.core.Symbol.value(_m.selector());
			_fn = _selectorConverter.selectorAsFunctionName_(_selector);
			_methodHandle = _compilerTools.methodHandleAt_numArgs_in_identityClass_isStatic_(_fn, _selector.numArgs(), _javaClass, _identityClass, _isStatic);
			_ecm[0] = _ecm[0].withMethodMapping_(((MethodMapping) MethodMapping.factory.methodNode_methodHandle_definingClass_(_m, _methodHandle, _javaClass)));
		}
		return _ecm[0];
	}

	public MethodNode[] localLinkMethods_instVars_ownerReference_(final MethodNode[] _methods, final BoundVariableDeclarationNode[] _instVars, final Reference _ownerReference) {
		final SelfNode[] _owner;
		_owner = new SelfNode[1];
		_owner[0] = SelfNode.factory.basicNew();
		return st.gravel.support.jvm.ArrayExtensions.collect_(_methods, ((st.gravel.support.jvm.Block1<MethodNode, MethodNode>) (new st.gravel.support.jvm.Block1<MethodNode, MethodNode>() {

			@Override
			public MethodNode value_(final MethodNode _m) {
				final MethodNode _fieldAccessed;
				_fieldAccessed = ((MethodNode) SystemMappingUpdater.this.localLink_instVars_ownerReference_owner_(_m, _instVars, _ownerReference, _owner[0]));
				return (MethodNode) _fieldAccessed;
			}
		})));
	}

	public Node localLink_instVars_ownerReference_owner_(final Node _node, final BoundVariableDeclarationNode[] _instVars, final Reference _ownerReference, final Expression _owner) {
		final Node _intermediate;
		final Node _nonLocal;
		final Node _holderized;
		final Node _fieldAccessed;
		_intermediate = IntermediateNodeRewriter.factory.visit_(_node);
		_nonLocal = NonLocalReturnRewriter.factory.nlrMarker_(_compilerTools.nextNlrMarker()).visit_(_intermediate);
		_holderized = NonLocalTempWritesToHolderConverter.factory.visit_(_nonLocal);
		_fieldAccessed = VariableAccessToFieldAccessConverter.factory.instVars_owner_ownerReference_(_instVars, _owner, _ownerReference).visit_(_holderized);
		return _fieldAccessed;
	}

	public MethodNode[] methods_withExtraMethods_(final MethodNode[] _methods, final MethodNode[] _extraMethods) {
		final java.util.Set<String>[] _selectors;
		final List<MethodNode>[] _n;
		_n = new List[1];
		_selectors = new java.util.Set[1];
		_selectors[0] = new java.util.HashSet();
		_n[0] = new java.util.ArrayList();
		for (final MethodNode _each : _methods) {
			if (!_selectors[0].contains(_each.selector())) {
				_selectors[0].add(_each.selector());
				_n[0].add(_each);
			}
		}
		for (final MethodNode _each : _extraMethods) {
			if (!_selectors[0].contains(_each.selector())) {
				_selectors[0].add(_each.selector());
				_n[0].add(_each);
			}
		}
		return _n[0].toArray(new MethodNode[_n[0].size()]);
	}

	public SystemMappingUpdater setNamespaceNodes_(final Map<Reference, NamespaceNode> _aDictionary) {
		_systemMapping.setNamespaceNodes_(_aDictionary);
		return this;
	}

	public SystemMapping systemMapping() {
		return _systemMapping;
	}

	@Override
	public SystemMappingUpdater visitAddClassDiff_(final AddClassDiff _anAddClassDiff) {
		this.compileClassDescriptionNode_isStatic_(_anAddClassDiff.classNode(), (_anAddClassDiff.isStatic() || _isStaticOverride));
		this.compileClassDescriptionNode_(_anAddClassDiff.classNode().metaclassNode());
		_toInitialize.add(_anAddClassDiff.classNode().metaclassNode().reference());
		return this;
	}

	@Override
	public SystemMappingUpdater visitClassDiff_(final ClassDiff _anObject) {
		throw NodeVisitorError.factory.basicNew();
	}

	@Override
	public SystemMappingUpdater visitNewClassDiff_(final NewClassDiff _anObject) {
		return this.visitClassDiff_(_anObject);
	}

	@Override
	public SystemMappingUpdater visitRemoveClassDiff_(final RemoveClassDiff _anObject) {
		return this;
	}

	@Override
	public SystemMappingUpdater visitUpdateClassDiff_(final UpdateClassDiff _anUpdateClassDiff) {
		this.executeUpdateClassDescriptorDiff_reference_(_anUpdateClassDiff.thisDiff(), _anUpdateClassDiff.reference());
		this.executeUpdateClassDescriptorDiff_reference_(_anUpdateClassDiff.metaDiff(), _anUpdateClassDiff.reference().meta());
		return this;
	}

	@Override
	public SystemMappingUpdater visitWrapJavaclassDiff_(final WrapJavaclassDiff _aWrapJavaclassDiff) {
		final IdentityClassPartMapping _identityMapping;
		final ExtensionClassPartMapping _ecm;
		final MethodNode[] _allMethods;
		final MethodNode[] _extraMethods;
		final ClassDescriptionNode _ecdn;
		_identityMapping = IdentityClassPartMapping.factory.javaClass_isGenerated_(_compilerTools.findJavaClass_(_aWrapJavaclassDiff.classNode().javaClassPath()), false);
		_extraMethods = this.extraMethodsFor_(_aWrapJavaclassDiff.classNode());
		_ecdn = _aWrapJavaclassDiff.classNode().withExtraMethods_(_extraMethods);
		_allMethods = this.methods_withExtraMethods_(_aWrapJavaclassDiff.classNode().methods(), _extraMethods);
		_ecm = this.compileExtensionClassPartMapping_methods_identityClass_instVars_sourceFile_(_ecdn, _allMethods, _identityMapping.javaClass(), new BoundVariableDeclarationNode[] {}, _aWrapJavaclassDiff.classNode().findSourceFile());
		_systemMapping.addClassMapping_(ClassMapping.factory.identityMapping_extensions_instVarMappings_classNode_(_identityMapping, st.gravel.support.jvm.ArrayFactory.with_(_ecm), new java.util.HashMap<String, InstVarMapping>(), _aWrapJavaclassDiff.classNode()));
		this.compileClassDescriptionNode_(_aWrapJavaclassDiff.classNode().metaclassNode());
		_toInitialize.add(_aWrapJavaclassDiff.classNode().metaclassNode().reference());
		return this;
	}

	@Override
	public SystemMappingUpdater visit_(final ClassDiff _anObject) {
		_anObject.accept_(this);
		return this;
	}
}
