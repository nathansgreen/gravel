(reader defineClass: 'JVMMethod' superclass: 'st.gravel.support.compiler.jvm.JVMNode')
!
(reader addInstVar: 'locals' type: 'Array[JVMLocalDeclaration]')
!
(reader addInstVar: 'instructions' type: 'Array[JVMInstruction]')
!
(reader addInstVar: 'isStatic' type: 'Boolean')
!
(reader addInstVar: 'signature' type: 'JVMMethodType')
!
(reader addInstVar: 'name' type: 'String')
!
(reader addMethod: 'visitor')
!
accept: visitor {JVMNodeVisitor[X def]} {^X}
	^visitor visitJVMMethod: self
!
(reader addMethod: 'initialize-release')
!
initializeName: anObject {Str} locals: anArray {Arr[JVMLocalDeclaration]} instructions: anArray2 {Arr[JVMInstruction]} isStatic: aBoolean {Bool} signature: aJVMMethodType {JVMMethodType} {^Self}
	name := anObject.
	locals := anArray.
	instructions := anArray2.
	isStatic := aBoolean.
	signature := aJVMMethodType.
	self initialize
!
(reader addMethod: 'accessing')
!
instructions {^Arr[JVMInstruction]}
	^instructions
!
(reader addMethod: 'As yet unclassified')
!
isPrimitive {^Bool}
	^false
!
(reader addMethod: 'accessing')
!
isStatic {^Bool}
	^isStatic
!
(reader addMethod: 'accessing')
!
locals {^Arr[JVMLocalDeclaration]}
	^locals
!
(reader addMethod: 'accessing')
!
name {^Str}
	^name
!
(reader addMethod: 'accessing')
!
signature {^JVMMethodType}
	^signature
!
(reader addMethod: 'printing')
!
sourceOn: aStream {WStream[Char]} {^Self}
	isStatic ifTrue: [aStream nextPutAll: 'static '].
	aStream nextPutAll: name.
	aStream nextPutAll: signature printString
!
(reader addClassMethod: 'instance creation')
!
name: aString {Str} locals: anArray {Arr[JVMLocalDeclaration]} instructions: anArray2 {Arr[JVMInstruction]} isStatic: isStatic {Bool} signature: aJVMMethodType {JVMMethodType} {^JVMMethod}
	^self new
		initializeName: aString
		locals: anArray
		instructions: anArray2
		isStatic: isStatic
		signature: aJVMMethodType
!
