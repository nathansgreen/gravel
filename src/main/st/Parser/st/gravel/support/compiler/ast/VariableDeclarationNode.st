(reader defineClass: 'VariableDeclarationNode' superclass: 'st.gravel.support.compiler.ast.Node')
!
(reader addInstVar: 'name' type: 'String')
!
(reader addInstVar: 'type' type: 'TypeNode')
!
(reader addMethod: 'comparing')
!
= anObject {Object} {^Bool}
	^super = anObject and: [name = anObject name and: [type = anObject type]]
!
(reader addMethod: 'visitor')
!
accept: visitor {NodeVisitor[X def]} {^X}
	^visitor visitVariableDeclarationNode: self
!
(reader addMethod: 'As yet unclassified')
!
asVariableNode {^Expression}
	^LocalReadNode name: name
!
(reader addMethod: 'comparing')
!
hash {^Int}
	^(super hash bitXor: name hash) bitXor: type hash
!
(reader addMethod: 'initialize-release')
!
initializeName: aString {String} type: aVariableNode {TypeNode} {^Self}
	name := aString.
	type := aVariableNode.
	self initialize
!
(reader addMethod: 'testing')
!
isHolderDeclarationNode {^Bool}
	^false
!
(reader addMethod: 'As yet unclassified')
!
localVarNamesDo: aBlock {[Str, ^Object]} {^Self}
	aBlock value: name
!
(reader addMethod: 'accessing')
!
name {^String}
	^name
!
(reader addMethod: 'As yet unclassified')
!
nodesDo: aBlock {[Node, ^Object]}
	
!
(reader addMethod: 'As yet unclassified')
!
sourceOn: aStream {WStream[Char]} {^Self}
	aStream nextPutAll: name.
	type isNil
		ifFalse: 
			[aStream
				space;
				nextPutAll: '{'.
			type innerSourceOn: aStream.
			aStream nextPut: $}]
!
(reader addMethod: 'accessing')
!
type {^TypeNode}
	^type
!
(reader addMethod: 'As yet unclassified')
!
typeDefsDo: aBlock {[TypeNode, ^Any]} {^Self}
	type isNil ifFalse: [type typeDefsDo: aBlock]
!
(reader addMethod: 'As yet unclassified')
!
withOwnerType: aReference {Reference} {^BoundVariableDeclarationNode}
	^BoundVariableDeclarationNode name: name type: type ownerType: aReference
!
(reader addClassMethod: 'instance creation')
!
name: aString {Str} {^VariableDeclarationNode}
	^self name: aString type: nil
!
(reader addClassMethod: 'instance creation')
!
name: aString {String} type: aVariableNode {TypeNode} {^Instance}
	^self new initializeName: aString type: aVariableNode
!
