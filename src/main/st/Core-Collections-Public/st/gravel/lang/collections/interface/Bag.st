(reader defineTrait: 'Bag' superclass: nil)
!
(reader addSimpleTrait: 'st.gravel.lang.collections.interface.Addable')
!
(reader addSimpleClassTrait: 'st.gravel.lang.collections.interface.Addable class')
!
(reader addMethod: 'testing')
!
isBag
	^true
!
(reader addClassMethod: 'As yet unclassified')
!
defaultImplementation
	^BagImpl
!