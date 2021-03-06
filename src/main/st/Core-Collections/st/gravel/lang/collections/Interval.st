(reader defineTrait: 'Interval' superclass: nil)
!
(reader addSimpleTrait: 'st.gravel.lang.collections.SequenceableCollection')
!
(reader addSimpleClassTrait: 'st.gravel.lang.collections.SequenceableCollection class')
!
(reader addMethod: 'testing')
!
isInterval
	^true
!
(reader addMethod: 'gravel')
!
start
	^self traitRequirement
!
(reader addMethod: 'gravel')
!
step
	^self traitRequirement
!
(reader addMethod: 'gravel')
!
stop
	^self traitRequirement
!
(reader addClassMethod: 'As yet unclassified')
!
defaultImplementation
	^IntervalImpl
!
(reader addClassMethod: 'instance creation')
!
from: start to: stop
	^self from: start to: stop by: 1
!
(reader addClassMethod: 'instance creation')
!
from: start to: stop by: step
	^self defaultImplementation from: start to: stop by: step
!
