(reader defineClass: 'BooleanTest' superclass: 'st.gravel.ansitests.ANSITest')
!
(reader propertyAt: 'isSystemTest' put: 'Ja')
!
(reader addMethod: 'parameters')
!
parameterNilaryBlockOperand
	^[#fromage]
!
(reader addMethod: 'parameters')
!
parameterNilaryBooleanBlockOperand
	^[2 = 3]
!
(reader addMethod: 'parameters')
!
parameterOperand
	^true
!
(reader addMethod: 'tests')
!
test_and
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue & self parameterOperand.
			self assert: (self valueIsKindOfBoolean: res)]
!
(reader addMethod: 'tests')
!
test_and_
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue and: self parameterNilaryBooleanBlockOperand.
			self assert: (self valueIsKindOfBoolean: res)].
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue and: [1 = 2].
			self assert: (self valueIsKindOfBoolean: res)]
!
(reader addMethod: 'tests')
!
test_eqv_
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue eqv: self parameterOperand.
			self assert: (self valueIsKindOfBoolean: res)]
!
(reader addMethod: 'tests')
!
test_ifFalse_
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue ifFalse: self parameterNilaryBlockOperand.
			self assert: (self valueIsKindOfANY: res)].
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue ifFalse: [#f].
			self assert: (self valueIsKindOfANY: res)]
!
(reader addMethod: 'tests')
!
test_ifFalse_ifTrue_
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue
						ifFalse: self parameterNilaryBlockOperand
						ifTrue: self parameterNilaryBlockOperand.
			self assert: (self valueIsKindOfANY: res)].
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue ifFalse: [#f] ifTrue: [#t].
			self assert: (self valueIsKindOfANY: res)]
!
(reader addMethod: 'tests')
!
test_ifTrue_
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue ifTrue: self parameterNilaryBlockOperand.
			self assert: (self valueIsKindOfANY: res)].
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue ifTrue: [#t].
			self assert: (self valueIsKindOfANY: res)]
!
(reader addMethod: 'tests')
!
test_ifTrue_ifFalse_
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue
						ifTrue: self parameterNilaryBlockOperand
						ifFalse: self parameterNilaryBlockOperand.
			self assert: (self valueIsKindOfANY: res)].
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue ifTrue: [#t] ifFalse: [#f].
			self assert: (self valueIsKindOfANY: res)]
!
(reader addMethod: 'tests')
!
test_not
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue not.
			self assert: (self valueIsKindOfBoolean: res)]
!
(reader addMethod: 'tests')
!
test_or_
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue or: self parameterNilaryBooleanBlockOperand.
			self assert: (self valueIsKindOfBoolean: res)].
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue or: [1 = 2].
			self assert: (self valueIsKindOfBoolean: res)]
!
(reader addMethod: 'tests')
!
test_pipe
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue | self parameterOperand.
			self assert: (self valueIsKindOfBoolean: res)]
!
(reader addMethod: 'tests')
!
test_printString
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue printString.
			self assert: (self valueIsKindOfReadableString: res)]
!
(reader addMethod: 'tests')
!
test_xor_
	self valuesDo: 
			[:testValue |
			| res |
			res := testValue xor: self parameterOperand.
			self assert: (self valueIsKindOfBoolean: res)]
!
(reader addMethod: 'As yet unclassified')
!
valuesDo: aBlock
	aBlock value: true.
	aBlock value: false
!
