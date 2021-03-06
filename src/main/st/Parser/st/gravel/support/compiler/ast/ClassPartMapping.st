(reader defineClass: 'ClassPartMapping' superclass: 'st.gravel.support.compiler.ast.AbstractMapping')
!
(reader addInstVar: 'methodMappings' type: 'Dictionary[Symbol, AbstractMethodMapping]')
!
(reader addInstVar: 'javaClass' type: 'JavaClass')
!
(reader addInstVar: 'isGenerated' type: 'Boolean')
!
(reader addMethod: 'initialize-release')
!
initializeJavaClass: aJavaClass {JavaClass} methodMappings: aDictionary {Dict[Sym, AbstractMethodMapping]} isGenerated: aBoolean {Bool} {^Self}
	javaClass := aJavaClass.
	methodMappings := aDictionary.
	isGenerated := aBoolean.
	self initialize
!
(reader addMethod: 'accessing')
!
isGenerated {^Bool}
	^isGenerated
!
(reader addMethod: 'accessing')
!
javaClass {^JavaClass}
	^javaClass
!
(reader addMethod: 'As yet unclassified')
!
methodMappingAt: aSymbol {Sym} ifAbsent: aBlock {[^AbstractMethodMapping]} {^AbstractMethodMapping}
	^methodMappings at: aSymbol ifAbsent: aBlock
!
(reader addMethod: 'accessing')
!
methodMappings {^Dict[Sym, AbstractMethodMapping]}
	^methodMappings
!
(reader addMethod: 'As yet unclassified')
!
pvtSetMethodMappings: aDictionary {Dict[Sym, AbstractMethodMapping]} {^Self}
	methodMappings := aDictionary
!
(reader addMethod: 'As yet unclassified')
!
withMethodMapping: aMethodMapping {MethodMapping} {^Self}
	^self withMethodMappings: (methodMappings copyAt: aMethodMapping selector asSymbol
				put: aMethodMapping)
!
(reader addMethod: 'As yet unclassified')
!
withMethodMappings: aDictionary {Dict[Sym, AbstractMethodMapping]} {^Self}
	^self copy pvtSetMethodMappings: aDictionary
!
(reader addMethod: 'As yet unclassified')
!
withoutMethodMapping: aSelector {Str} {^Self}
	^self withMethodMappings: (methodMappings copyRemoveKey: aSelector asSymbol ifAbsent: [])
!
(reader addClassMethod: 'instance creation')
!
javaClass: aJavaClass {JavaClass} isGenerated: isGenerated {Bool} {^Instance}
	^self
		javaClass: aJavaClass
		methodMappings: Dictionary new
		isGenerated: isGenerated
!
(reader addClassMethod: 'instance creation')
!
javaClass: aJavaClass {JavaClass} methodMappings: aDictionary {Dict[Sym, AbstractMethodMapping]} isGenerated: aBoolean {Bool} {^Instance}
	^self new initializeJavaClass: aJavaClass methodMappings: aDictionary isGenerated: aBoolean
!
